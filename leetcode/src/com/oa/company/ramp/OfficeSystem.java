package com.oa.company.ramp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OfficeSystem {
    private static class Worker {
        private String workerId;
        private String position;
        private String compensation;
        private Long currentEntry;
        private long totalWorkedTime;
        private List<Promotion> promotions;

        public Worker(String workerId, String position, String compensation) {
            this.workerId = workerId;
            this.position = position;
            this.compensation = compensation;
            this.currentEntry = null;
            this.totalWorkedTime = 0;
            this.promotions = new ArrayList<>();
        }

        public void registerEntry(long timestamp) {
            if (this.currentEntry == null) {
                this.currentEntry = timestamp;
            } else {
                this.totalWorkedTime += (timestamp - this.currentEntry);
                this.currentEntry = null;
            }
        }

        public long getTotalWorkedTime() {
            return this.totalWorkedTime;
        }

        public String getPosition() {
            return this.position;
        }

        public String getWorkerId() {
            return this.workerId;
        }

        public String getCompensation() {
            return this.compensation;
        }

        public List<Promotion> getPromotions() {
            return promotions;
        }

        public void promote(String newPosition, String newCompensation, long startTimestamp) {
            promotions.add(new Promotion(newPosition, newCompensation, startTimestamp));
        }
    }

    // for promotions
    private static class Promotion {
        private String newPosition;
        private String newCompensation;
        private long startTimestamp;

        public Promotion(String newPosition, String newCompensation, long startTimestamp) {
            this.newCompensation = newCompensation;
            this.newPosition = newPosition;
            this.startTimestamp = startTimestamp;
        }

        public String getNewPosition() {
            return newPosition;
        }

        public String getNewCompensation() {
            return newCompensation;
        }

        public long getStartTimestamp() {
            return startTimestamp;
        }
    }

    private Map<String, Worker> workers;

    public OfficeSystem() {
        workers = new HashMap<>();
    }

    public String addWorker(String workerId, String position, String compensation) {
        if (workers.containsKey(workerId)) {
            return "false";
        }
        workers.put(workerId, new Worker(workerId, position, compensation));
        return "true";
    }

    public String register(String workerId, long timestamp) {
        Worker worker = this.workers.get(workerId);
        if (worker == null) {
            return "invalid_request";
        }
        worker.registerEntry(timestamp);

        // check for promotions
        for (Promotion promotion : worker.getPromotions()) {
            if (promotion.getStartTimestamp() <= timestamp) {
                worker.promote(promotion.getNewPosition(), promotion.getNewCompensation(),
                        promotion.getStartTimestamp());
                worker.getPromotions().remove(promotion);
                break;
            }
        }
        return "registered";
    }

    public String get(String workerId) {
        Worker worker = this.workers.get(workerId);
        if (worker == null) {
            return "";
        }
        return String.valueOf(worker.getTotalWorkedTime());
    }

    public String topNWorkers(int n, String position) {
        List<Worker> filteredWorkers = workers.values().stream()
                .filter(worker -> worker.getPosition().equals(position))
                .sorted(Comparator.comparingLong(Worker::getTotalWorkedTime).reversed()
                        .thenComparing(Worker::getWorkerId))
                .limit(n)
                .collect(Collectors.toList());

        if (filteredWorkers.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (Worker worker : filteredWorkers) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(worker.getWorkerId())
                    .append("(")
                    .append(worker.getTotalWorkedTime())
                    .append(")");
        }
        return result.toString();
    }

    public String promote(String workerId, String newPosition, String newCompensation, long startTimestamp) {
        Worker worker = this.workers.get(workerId);
        if (worker == null) {
            return "invalid_request";
        }
        if (worker.getPromotions().stream().anyMatch(promotion -> promotion.getNewPosition().equals(newPosition))) {
            return "success";
        }
        worker.promote(newPosition, newCompensation, startTimestamp);
        return "success";
    }

    public String calcSalary(String workerId, long startTimestamp, long endTimestamp) {
        Worker worker = this.workers.get(workerId);
        if (worker == null) {
            return "";
        }

        long totalSalary = 0;
        long currentCompensation = Long.parseLong(worker.getCompensation());
        long currentStart = 0;

        for (Promotion promotion : worker.getPromotions()) {
            if (promotion.getStartTimestamp() > endTimestamp) {
                break;
            }

            long periodStart = Math.max(startTimestamp, currentStart);
            long periodEnd = Math.min(endTimestamp, promotion.getStartTimestamp());

            if (periodEnd > periodStart) {
                totalSalary += (periodEnd - periodStart) * currentCompensation;
            }

            currentCompensation = Long.parseLong(promotion.getNewCompensation());
            currentStart = promotion.getStartTimestamp();
        }

        long periodStart = Math.max(startTimestamp, currentStart);
        long periodEnd = endTimestamp;

        if (periodEnd > periodStart) {
            totalSalary += (periodEnd - periodStart) * currentCompensation;
        }

        return String.valueOf(totalSalary);
    }

    public static void main(String[] args) {
        OfficeSystem officeSystem = new OfficeSystem();
        System.out.println(officeSystem.addWorker("Ashley", "Middle Developer", "150"));
        System.out.println(officeSystem.addWorker("Ashley", "Junior Developer", "100"));
        System.out.println(officeSystem.register("Ashley", 10));
        System.out.println(officeSystem.register("Ashley", 25));
        System.out.println(officeSystem.get("Ashley"));
        System.out.println(officeSystem.register("Ashley", 40));
        System.out.println(officeSystem.register("Ashley", 67));
        System.out.println(officeSystem.register("Ashley", 100));
        System.out.println(officeSystem.get("Ashley"));
        System.out.println(officeSystem.get("Walter"));
        System.out.println(officeSystem.register("Walter", 120));
    }
}

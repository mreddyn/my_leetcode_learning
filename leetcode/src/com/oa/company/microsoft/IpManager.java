package com.oa.company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IpManager {
    static class Vlan {
        String startIp;
        String endIp;

        public Vlan(String startIp, String endIp) {
            this.startIp = startIp;
            this.endIp = endIp;
        }
    }

    public static void assignIps(Set<String> unassigned, List<Vlan> vlans, Set<String> assigned) {
        Iterator<String> unassignedIterator = unassigned.iterator();

        for (Vlan vlan : vlans) {
            long startIpLong = ipToLong(vlan.startIp);
            long endIpLong = ipToLong(vlan.endIp);

            while (startIpLong <= endIpLong && unassignedIterator.hasNext()) {
                String ip = longToIp(startIpLong);
                if (!assigned.contains(ip)) {
                    System.out.println("Assigning IP " + ip + " to machine " + unassignedIterator.next());
                    assigned.add(ip);
                    unassignedIterator.remove();
                }
                startIpLong++;
            }
        }

        if (unassignedIterator.hasNext()) {
            System.out.println("Not enough IPs available to assign to all machines.");
        }
    }

    // Utility function to convert IP address to long for easy comparison
    private static long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }

    // Utility function to convert long back to IP address
    private static String longToIp(long ipLong) {
        return ((ipLong >> 24) & 0xFF) + "." + ((ipLong >> 16) & 0xFF) + "." + ((ipLong >> 8) & 0xFF) + "."
                + (ipLong & 0xFF);
    }

    public static void main(String[] args) {
        // Example usage
        Set<String> unassignedMachines = new HashSet<>(Arrays.asList("M1", "M2", "M3"));
        List<Vlan> vlans = new ArrayList<>();
        vlans.add(new Vlan("192.168.1.2", "192.168.1.5"));
        Set<String> assignedIps = new HashSet<>(Arrays.asList("192.168.1.2"));

        assignIps(unassignedMachines, vlans, assignedIps);
    }

}

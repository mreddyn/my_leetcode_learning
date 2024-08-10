package com.objectOrientedDesign.parkingLot;

public class ParkingLot {

}

enum PaymentStatus {
    COMPLETED,
    FAILED,
    PENDING,
    UNPAID,
    REFUNDED
}

enum AccountStatus {
    ACTIVE,
    CLOSED,
    CANCELLED,
    BLACKLISTED,
    NONE
}

class Person {
    private String name;
    private String phone;
    private String address;
    private String email;
}

class ParkingTicket {
    private int ticketNnumber;
    private String timestamp;
    private String exitTime;
    private double amount;
}

abstract class Vehicle {
    private String licenseNumber;
    public abstract void assignParkingTicket(ParkingTicket ticket);
}

class Car extends Vehicle {
    public void assignParkingTicket(ParkingTicket ticket) {
    }
}

class Truck extends Vehicle {
    public void assignParkingTicket(ParkingTicket ticket) {
    }
}
 
abstract class ParkingSpot {
    private int id;
    private boolean isFree;
    public boolean getIsFree(){return true;};
    public abstract boolean assignVehicle(Vehicle vehicle);
    public void removeVehicle(){};
}

class Large extends ParkingSpot {
    public boolean assignVehicle(Vehicle vehicle) {
        return true;
    }
}
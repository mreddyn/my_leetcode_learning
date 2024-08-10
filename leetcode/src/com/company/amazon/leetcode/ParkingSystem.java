package com.company.amazon.leetcode;

public class ParkingSystem {
    private int count[];
    public ParkingSystem(int big, int medium, int small){
        this.count = new int[]{big, medium, small};
    }
    public boolean addCar(int carType){
        return count[carType - 1]-- > 0;
    }
}

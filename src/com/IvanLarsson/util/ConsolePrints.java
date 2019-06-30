package com.IvanLarsson.util;

import com.IvanLarsson.models.Car;
import com.IvanLarsson.models.Room;

/***
 * Simple class for Console prints
 *
 */
public class ConsolePrints {

    /**
     * Prints current game status
     */
    public static void printCurrentInfo(Car car, Room room){
        System.out.println("    Room dimension: " + room.getDimension());

        if(car.isAlive()){
            System.out.println("    The car current position:  " + car.getPosition());
            System.out.println("    The car is still alive :)");
            System.out.println("    The car current direction:  " + car.getDirection());
        } else {
            System.out.println("    The car has crashed :(");
            System.out.println("    The car last known position:  " + car.getPosition());
            System.out.println("    The car last known direction:  " + car.getDirection());
            System.out.println("    Press Z to restart or X to quit simulation");
        }

    }

    public static void printCommands(){
        System.out.println("********************************** Commands **********************************");
        System.out.println("    F: Move forward one step");
        System.out.println("    B: Move backwards one step");
        System.out.println("    R: Turn right");
        System.out.println("    L: Turn left\n");

        System.out.println("    I: Get current info");
        System.out.println("    C: Print commands again");
        System.out.println("    Z: Restart simulation");
        System.out.println("    X: Quits simulation and prints results");
        System.out.println("******************************************************************************");
    }

    public static void printStartInfo(Car c, Room r){
        System.out.println("******************************** Start Info ********************************");
        printCurrentInfo(c, r);
        printCommands();
        System.out.println("Enter command:");
    }
}

package com.IvanLarsson.controllers;

import com.IvanLarsson.models.Car;
import com.IvanLarsson.models.Room;
import com.IvanLarsson.util.Structs;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.IvanLarsson.util.ConsolePrints.*;

public class MainController {
    private Scanner scanner = new Scanner(System.in);
    private Car car;
    private Room room;

    public MainController() {
        initialize();
        run();
    }

    /***
     * Initializes the simulation
     * Enters the size of the room and the start position for the car
     */
    private void initialize() {
        int roomWidth = 0;
        int roomHeight = 0;
        int xPos = 0;
        int yPos = 0;
        String dir = "";
        Structs.Orientation startDir = null;

        System.out.println("Enter size of room " +
                "( X Y,  separate by space) eg. 5 5");

        try {
            roomWidth = scanner.nextInt();
            roomHeight = scanner.nextInt();
        }
        catch(InputMismatchException e) {
           // e.printStackTrace();
            System.out.println("Bad input type, try again");
            scanner.nextLine(); // Skips to the next input
            initialize();

        }

        System.out.println("Enter X position, y position and start direction " +
                "( X Y D,  separate by space) eg. 2 4 N");

        try {
            xPos = scanner.nextInt();
            yPos = scanner.nextInt();
            dir = scanner.nextLine()
                    .replaceAll("\\W","")
                    .toUpperCase();
        }
        catch(InputMismatchException e) {
            //e.printStackTrace();
            System.out.println("Bad input type, try again");
            scanner.nextLine(); // Skips to the next input
            initialize();
        }

        switch (dir){
            case "N":
                startDir = Structs.Orientation.NORTH;
                break;
            case "S":
                startDir = Structs.Orientation.SOUTH;
                break;
            case "W":
                startDir = Structs.Orientation.WEST;
                break;
            case "E":
                startDir = Structs.Orientation.EAST;
                break;
            default:
                break;
        }

        room = new Room(roomWidth, roomHeight);
        car = new Car(xPos, yPos, room, startDir);


        if (!car.isAlive() || startDir == null){
            System.out.println("    Bad starting position");
            System.out.println("    Reinitializing simulation ");
            initialize();
        }

    }

    private void run(){
        boolean running = true;

        printStartInfo(car, room);

        while (true){
            if(!running){
                scanner.close();
                System.out.println("********************************** End Results **********************************");
                printCurrentInfo(car, room);
                break;
            }

            char[] inc = scanner.nextLine()
                    .replaceAll("\\W","")
                    .toUpperCase()
                    .toCharArray();

            for(char cmd : inc){
                switch (cmd){
                    case 'X':
                        running = false;
                        break;
                    case 'F':
                        car.move(Structs.Move.FORWARD);
                        break;
                    case 'B':
                        car.move(Structs.Move.BACKWARD);
                        break;
                    case 'L':
                        car.turn(Structs.Turn.LEFT);
                        break;
                    case 'R':
                        car.turn(Structs.Turn.RIGHT);
                        break;
                    case 'I':
                        printCurrentInfo(car, room);
                        break;
                    case 'C':
                        printCommands();
                        break;
                    case 'Z':
                        initialize();
                        printStartInfo(car, room);
                        break;
                    default:
                        System.out.println("A bad command was made: " + cmd + " , try again");
                        break;
                }
            }
        }
    }
}

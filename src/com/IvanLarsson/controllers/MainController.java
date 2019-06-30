package com.IvanLarsson.controllers;

import com.IvanLarsson.models.Car;
import com.IvanLarsson.models.Room;
import com.IvanLarsson.util.Structs;

import java.util.Scanner;

import static com.IvanLarsson.util.ConsolePrints.printCommands;
import static com.IvanLarsson.util.ConsolePrints.printCurrentInfo;

public class MainController {
    private Scanner scanner = new Scanner(System.in);
    private Car car;
    private Room room;

    public MainController() {
        initialize();
        run();
    }

    private void initialize() {
        System.out.println("Enter size of room " +
                "( X Y,  separate by space) eg. 5 5");
        int roomWidth = scanner.nextInt();
        int roomHeight = scanner.nextInt();

        System.out.println("Enter X position, y position and start direction " +
                "( X Y D,  separate by space) eg. 2 4 N");

        int xPos = scanner.nextInt();
        int yPos = scanner.nextInt();
        char dir = scanner.next().charAt(0);
        Structs.Orientation startDir = null;


        switch (dir){
            case 'N':
            case 'n':
                startDir = Structs.Orientation.NORTH;
                break;
            case 'S':
            case 's':
                startDir = Structs.Orientation.SOUTH;
                break;
            case 'W':
            case 'w':
                startDir = Structs.Orientation.WEST;
                break;
            case 'E':
            case 'e':
                startDir = Structs.Orientation.EAST;
                break;
            default:
                break;
        }

        room = new Room(roomWidth, roomHeight);
        car = new Car(xPos, yPos, room, startDir);

        if (!car.isAlive() || startDir == null){
            System.out.println("    Bad starting position!!! ");
            System.out.println("    Reinitializing simulation ");
            initialize();
        }

    }

    private void run(){
        boolean running = true;

        System.out.println("******************************** Start Info ********************************");
        printCurrentInfo(car, room);
        printCommands();
        System.out.println("Enter command:");

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
                        break;
                    default:
                        System.out.println("Bad command, try again");
                        break;
                }
            }
        }
    }
}

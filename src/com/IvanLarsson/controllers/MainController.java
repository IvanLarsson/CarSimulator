package com.IvanLarsson.controllers;

import java.util.Arrays;
import java.util.Scanner;

public class MainController {
    private Scanner scanner = new Scanner(System.in);

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
        char direction = scanner.next().charAt(0);

        System.out.println("Size of room: [" + roomWidth + ", " + roomHeight +"]" );
        System.out.println("Start pos: [" + xPos + ", " + yPos +"]" );
        System.out.println("Start direction: " + direction );
    }

    private void run(){
        boolean running = true;

        while (true){
            if(!running){
                scanner.close();
                break;
            }

            char[] inc = scanner.nextLine()
                    .replaceAll("\\W","")
                    .toLowerCase()
                    .toCharArray();

            System.out.println("vad e inc: " + Arrays.toString(inc));


            for(char cmd : inc){
                System.out.println("vad e cmd: " + cmd);

                switch (cmd){
                    case '0':
                        System.out.println("Stop");
                        running = false;
                        break;
                    case 'f':
                        break;
                    case 'b':
                        break;
                    case 'l':
                        break;
                    case 'r':
                        break;
                    default:
                        break;


                }
            }
        }
    }
}

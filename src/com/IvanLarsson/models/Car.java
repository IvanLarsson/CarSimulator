package com.IvanLarsson.models;

import com.IvanLarsson.util.Structs;

import java.util.Arrays;

public class Car {
    private Structs.Orientation direction;
    private Room room;
    private int[] playerPos = new int[2];

    private boolean isAlive;

    /***
     * Constructor for Car object
     * @param xPos Starting position for X
     * @param yPos Starting position for Y
     * @param room
     * @param direction Starting direction
     */
    public Car(int xPos, int yPos, Room room, Structs.Orientation direction) {
        playerPos[0] = xPos;
        playerPos[1] = yPos;

        this.direction = direction;
        this.room = room;

        // Check if starting pos a possible
        if (room.isMovePossible(playerPos)) isAlive = true;
        else isAlive = false;

    }

    /**
     * Moves player forward or backwards depending on direction
     *
     * Formula for counting how to move:
     * N = North, S = South, W = West, E = East
     * F = Forward, B = Backward
     *
     * N: F = yPos + 1, B = yPos - 1
     * S: F = yPos - 1, B = yPos + 1
     * W: F = xPos - 1, B = xPos + 1
     * E: F = xPos + 1, B = xPos - 1
     *
     * @param m, if forward or backward
     */
    public void move(Structs.Move m){
        if (!isAlive) return; // No need to move the car if the car has crashed
        int[] newPos = {playerPos[0], playerPos[1]};

        switch (direction){
            case NORTH:
                if (m == Structs.Move.FORWARD)
                    newPos[1] += 1;
                else
                    newPos[1] -= 1;
                break;
            case SOUTH:
                if (m == Structs.Move.FORWARD)
                    newPos[1] -= 1;
                else
                    newPos[1] += 1;
                break;
            case WEST:
                if (m == Structs.Move.FORWARD)
                    newPos[0] -= 1;
                else
                    newPos[0] += 1;
                break;
            case EAST:
                if (m == Structs.Move.FORWARD)
                    newPos[0] += 1;
                else
                    newPos[0] -= 1;
                break;
        }

        if (!room.isMovePossible(newPos)){
            isAlive = false;
        } else {
            playerPos = newPos;
        }
    }

    /***
     * Rotates the Car
     * @param rot , if turn is Right or Left
     */
    public void turn(Structs.Turn rot){
        if (!isAlive) return; // No need to move the car if the car has crashed
        switch (direction){
            case NORTH:
                if (rot == Structs.Turn.RIGHT)
                    direction = Structs.Orientation.EAST;
                else
                    direction = Structs.Orientation.WEST;
                break;
            case SOUTH:
                if (rot == Structs.Turn.RIGHT)
                    direction = Structs.Orientation.WEST;
                else
                    direction = Structs.Orientation.EAST;
                break;
            case WEST:
                if (rot == Structs.Turn.RIGHT)
                    direction = Structs.Orientation.NORTH;
                else
                    direction = Structs.Orientation.SOUTH;
                break;
            case EAST:
                if (rot == Structs.Turn.RIGHT)
                    direction = Structs.Orientation.SOUTH;
                else
                    direction = Structs.Orientation.NORTH;
                break;
        }
    }

    public Structs.Orientation getDirection(){
        return direction;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public String getPosition(){
        return Arrays.toString(playerPos);
    }


}

package com.IvanLarsson.models;

import com.IvanLarsson.util.Structs;

import java.util.Arrays;

public class Car {
    private Structs.Orientation direction;
    private Room room;
    private int[] playerPos = new int[2];

    private boolean isAlive;

    public Car(int xPos, int yPos, Room room, Structs.Orientation direction) {
        playerPos[0] = xPos;
        playerPos[1] = yPos;

        this.direction = direction;
        this.room = room;

        // Check if starting pos a possible
        if (room.isMovePossible(playerPos)) isAlive = true;
        else{
            playerPos[0] = -1;
            playerPos[1] = -1;
            isAlive = false;
        }

    }

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

package com.IvanLarsson.models;

import java.util.Arrays;

public class Room {
    private int[] RoomSize = new int[2];


    public Room(int width, int height) {
        this.RoomSize[0] = width;
        this.RoomSize[1] = height;
    }

    /**
     * Checks if a move is possible
     * @param pos
     * @return
     */
    public boolean isMovePossible(int[] pos){
        if ((pos[0] > RoomSize[0] || pos[0] < 0) || (pos[1] > RoomSize[1] || pos[1] < 0))
            return false;
        else
            return true;
    }

    public String getDimension(){
        return Arrays.toString(RoomSize);
    }

}

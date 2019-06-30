package com.IvanLarsson.models;

import java.util.Arrays;

public class Room {
    private int[] tableSize = new int[2];


    public Room(int width, int height) {
        this.tableSize[0] = width;
        this.tableSize[1] = height;
    }

    /**
     * Checks if a move is possible
     * @param pos
     * @return
     */
    public boolean isMovePossible(int[] pos){
        if ((pos[0] > tableSize[0] || pos[0] < 0) || (pos[1] > tableSize[1] || pos[1] < 0))
            return false;
        else
            return true;
    }

    public String getDimension(){
        return Arrays.toString(tableSize);
    }

}

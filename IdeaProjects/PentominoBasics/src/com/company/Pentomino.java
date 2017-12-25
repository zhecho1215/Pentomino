package com.company;

/**
 A single pentomino object
 */

public class Pentomino {

    private int[][] letterMat;
    private int booleanArrPos;
    private char character;

    /**
     Constructor
     @param Letter the matrix of the pentominoe
     @param BooArr the position the pentominoe is represented by in the boolean array
     @param Character the charac the pentominoe represents
     */
    public Pentomino(int[][] Letter, int BooArr, char Character){
        this.letterMat = Letter;
        this.booleanArrPos = BooArr;
        this.character = Character;
    }

    /**
     * Return LetterMatrix passed to the constructor.
     * @return LetterMatrix
     */
    public int[][] getLetterMat(){
        return this.letterMat;
    }

    /**
     * Return boolean array position passed to the constructor.
     * @return boolean array position
     */
    public int getBooleanArrayPos(){
        return this.booleanArrPos;
    }

    /**
     * Return character passed to the constructor.
     * @return Character */
    public char getCharacter(){
        return this.character;
    }

    /**
     Method that determines which index in the array is considered the starting point for placing the pentomino on the board.
     @return the column index of the first cell in the first row of the matrix that is 1 i.e. not empty
     */
    public int colIndexOfStartPoint(){
        int index=0;
        for (int i = 0; i < this.letterMat[0].length; i++) {
            if(this.letterMat[0][i] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

}
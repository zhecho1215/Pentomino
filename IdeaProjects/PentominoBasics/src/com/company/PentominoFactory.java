package com.company;

import java.util.Arrays;

/**
 Creates an array of pentomino objects
 */

public class PentominoFactory {

    /**
     *	Constructor
     *	Creates an array of pentomino objects each with a unique matrix
     *	@param inputLetters A char array of the pentominoes that should be represented
     *	@return An array of unique pentominoe objects
     */
    public static Pentomino[] createLetters(char[] inputLetters){

        int[][] baseRotation; //Original form of letter
        int count = 0; // Counter for all unique orientations of the input pentominoes

        Pentomino[] AllVar = new Pentomino[163];
        Pentomino[] currentPentomino = new Pentomino[8];// array for all rotations and flippings of the pentomino

        for (int i = 0; i < inputLetters.length; i++){//for every char
            baseRotation = MakeLetter(inputLetters[i]);
            int currentCounter = 0;

            for (int j = 0; j < 4; j++){
                if (isAllDifferent(baseRotation,currentPentomino)){
                    currentPentomino[currentCounter] = new Pentomino(baseRotation,i,inputLetters[i]);
                    currentCounter++;
                }
                baseRotation = Rotate(baseRotation);
            }

            if(isDifferent(Flip(baseRotation),baseRotation)){

                baseRotation = Flip(baseRotation);

                for (int j = 0; j < 4; j++){
                    if (isAllDifferent(baseRotation,currentPentomino)){
                        currentPentomino[currentCounter] = new Pentomino(baseRotation,i,inputLetters[i]);
                        currentCounter++;
                    }
                    baseRotation = Rotate(baseRotation);
                }
            }

            for (int k = 0; k < currentCounter; k++){
                AllVar[count] = currentPentomino[k];
                currentPentomino[k] = null;
                count++;
            }
        }
        return Arrays.copyOf(AllVar, count);
    }


    /**
     *	Creates a matrix that corresponds to which pentominoe it should represent
     *	@param Let the char that the matrix must represent
     *	@return A integer matrix that represents the Char input where 1 represents a filled block and 0 represents an empty block
     */
    private static int[][] MakeLetter(char Let){
        int[][] result;
        if (Let == 'p')
            result =  new int[][]{{1,1},{1,1},{1,0}};//P
        else if (Let == 'x')
            result =  new int[][]{{0,1,0},{1,1,1},{0,1,0}};//X
        else if (Let == 'f')
            result =  new int[][]{{0,1,1},{1,1,0},{0,1,0}};//F
        else if (Let == 'v')
            result =  new int[][]{{1,0,0},{1,0,0},{1,1,1}};//V
        else if (Let == 'w')
            result =  new int[][]{{1,0,0},{1,1,0},{0,1,1}};//W
        else if (Let == 'y')
            result =  new int[][]{{0,1},{1,1},{0,1},{0,1}};//Y
        else if (Let == 'i')
            result =  new int[][]{{1},{1},{1},{1},{1}};//I
        else if (Let == 't')
            result =  new int[][]{{1,1,1},{0,1,0},{0,1,0}};//T
        else if (Let == 'z')
            result =  new int[][]{{1,1,0},{0,1,0},{0,1,1}};//Z
        else if (Let == 'u')
            result =  new int[][]{{1,0,1},{1,1,1}};//U
        else if (Let == 'n')
            result =  new int[][]{{1,1,0,0},{0,1,1,1}};//N
        else if(Let == 'l')
            result =  new int[][] {{0,0,0,1},{1,1,1,1}};//L
        else result = null;

        return result;
    }

    /**
     *	Creates a mirror image of an inputted int matrix
     *	@param matrix The original matrix
     *	@return A mirror image of the original matrix, mirrored on a vertical axis
     */
    private static int[][] Flip(int[][] matrix){
        int matLen = matrix.length;
        int matWid = matrix[0].length;
        int[][] newMatrix = new int[matLen][matWid];
        for (int i = 0; i < matLen; i++){
            for (int j = 0; j < matWid; j++){
                newMatrix[i][matWid-j-1] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     *	Creates a copy of an imputted int matrix rotated 90degrees clockwise
     *	@params matrix The original matrix
     *	@return A matrix that is rotated 90 degrees clockwise from the original matrix
     */
    private static int[][] Rotate(int[][] matrix){
        int matLen = matrix.length;
        int matWid = matrix[0].length;
        int[][] newMatrix = new int[matWid][matLen];
        for (int i = 0; i < matLen; i++){
            for (int j = 0; j < matWid; j++){
                newMatrix[j][matLen-1-i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     *	Tests whether an inputted matrix is different to every pentomino in an inputted array of pentominoes
     *	@params Mat The matrix that is being tested
     *	@params Arr An array of pentominoes
     *	@return Whether the inputted matrix is different from all the other pentominoes
     */
    private static boolean isAllDifferent(int[][] Mat, Pentomino[] Arr){
        int i = 0;
        while (Arr[i] != null){
            if (isDifferent(Mat,Arr[i].getLetterMat()) == false)
                return false;
            i++;
        }
        return true;
    }


    /**
     *	Tests whether an inputted matrix is different to another inputted matrix
     *	@params Mat1 The first matrix that is being tested
     *	@params Mat2 The second matrix that is being tested
     *	@return Whether the two inputted arrays are different
     */
    private static boolean isDifferent(int[][] Mat1, int[][] Mat2){
        if (Mat1.length != Mat2.length || Mat1[0].length != Mat2[0].length)
            return true;
        else {
            for (int i = 0; i < Mat1.length; i++)
                for (int j = 0; j < Mat1[0].length; j++){
                    if (Mat1[i][j] != Mat2[i][j])
                        return true;
                }
        }
        return false;
    }
}
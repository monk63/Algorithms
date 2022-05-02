import java.util.Scanner;

import java.lang.Math;

class test {

    public static void main(String[] arg) {

        // Read number of rows from user

        Scanner scan = new Scanner(System.in);

        System.out.print("Rows: ");

        int rw = scan.nextInt();

        // Read number of columns from user

        System.out.print("Columns: ");

        int cl = scan.nextInt();

        // Read number of coins

        System.out.print("Number of coins : ");

        int totalCoins = scan.nextInt();

        // Read the maximum value of coin

        System.out.print("Maximum value of coin: ");

        int maxValue = scan.nextInt();

        // Initial matrix

        int[][] initMat = new int[rw][cl];

        // Array for random values

        int[] randVals = new int[totalCoins];

        // Random valie generation

        for (int i = 0; i < totalCoins; i++) {

            randVals[i] = 1 + (int) (Math.random() * maxValue);

        }

        // Initialize start as 0

        int start = 0;

        // Select random cell

        while (start < totalCoins) {

            int randRw = (int) (Math.random() * rw);

            int randCl = (int) (Math.random() * cl);

            // If it is 0 store the random value

            if (initMat[randRw][randCl] == 0) {

                initMat[randRw][randCl] = randVals[start++];

            }

        }

        System.out.println("\nCoin Value Distribution");

        // Print the matrix

        for (int i = 0; i < rw; i++) {

            for (int j = 0; j < cl; j++) {

                System.out.print(String.format("% 4d", initMat[i][j]));

            }

            System.out.println();

        }

        // Dynamic array

        int[][] dynArr = new int[rw + 1][cl + 1];

        // Dynamic array creation

        for (int i = 1; i <= rw; i++) {

            for (int j = 1; j <= cl; j++) {

                dynArr[i][j] = Math.max(initMat[i - 1][j - 1] + dynArr[i - 1][j],
                        initMat[i - 1][j - 1] + dynArr[i][j - 1]);

            }

        }

        System.out.println("\n Table of Dynamic Program");

        for (int i = 1; i <= rw; i++) {

            for (int j = 1; j <= cl; j++) {

                System.out.print(String.format("% 4d", dynArr[i][j]));

            }

            System.out.println();

        }

        // Array for the path traversed

        int[][] travPath = new int[rw + cl - 1][2];

        start = rw + cl - 3;

        int endRw = rw;

        int endCl = cl;

        // Variables to store the number of horizontal and vertical movements

        int numHzMvmnt = 0;

        int numVertMvmnt = 0;

        travPath[rw + cl - 2][0] = rw - 1;

        travPath[rw + cl - 2][1] = cl - 1;

        // finding path traversed

        while (start >= 0) {

            if (endRw > 1 && endCl > 1) {

                if (dynArr[endRw - 1][endCl] >= dynArr[endRw][endCl - 1]) {

                    endRw -= 1;

                    numVertMvmnt++;

                } else {

                    endCl -= 1;

                    numHzMvmnt++;

                }

            } else if (endRw > 1) {

                endRw -= 1;

                numVertMvmnt++;

            } else {

                endCl -= 1;

                numHzMvmnt++;

            }

            travPath[start][0] = endRw - 1;

            travPath[start--][1] = endCl - 1;

        }

        // Display the path traversed

        System.out.print("\nPath Traversed: [");

        for (int i = 0; i < rw + cl - 1; i++) {

            System.out.print(travPath[i][0] + " " + travPath[i][1]);

            if (i == rw + cl - 2) {

                System.out.print("]");

            } else {

                System.out.print(", ");

            }

        }

        // Print count of horizontal movement

        System.out.println("\n\nHorizontal Movements count: " + numHzMvmnt);

        System.out.print("[");

        int ct = 0;

        for (int i = 0; i < rw + cl - 2; i++) {

            if (travPath[i][1] < travPath[i + 1][1]) {

                System.out.print(travPath[i][0] + " " + travPath[i][1] + " --> ");

                System.out.print(travPath[i + 1][0] + " " + travPath[i + 1][1]);

                ct++;

                if (ct == numHzMvmnt) {

                    System.out.print("]");

                } else {

                    System.out.print(", ");

                }

            }

        }

        // print count of vertical movement

        ct = 0;

        System.out.println("\n\nCount of Vertical Movements: " + numVertMvmnt);

        System.out.print("[");

        for (int i = 0; i < rw + cl - 2; i++) {

            if (travPath[i][0] < travPath[i + 1][0]) {

                System.out.print(travPath[i][0] + " " + travPath[i][1] + " --> ");

                System.out.print(travPath[i + 1][0] + " " + travPath[i + 1][1]);

                if (ct == numVertMvmnt) {

                    System.out.print("]");

                } else {

                    System.out.print(", ");

                }

            }

        }

        System.out.println("\n");

    }

}



            // //Displaying the path traversed
            // System.out.print("\nPath Traversed: ");
            // System.out.print("\n");
            // int trav = 0;
            // for (int i = 0; i < row + column - 1; i++) {
            //     System.out.print(pathTraversed[i][0] + " , " + pathTraversed[i][1]);
            //     if (i == row + column - 2) {
            //         System.out.print(" ");
            //     } else {
            //         System.out.print(" \n");
            //     }
            // }

            // // Print count of horizontal movement
            // System.out.println("\n\nHorizontal Movements count: " + noOfRows);
            // System.out.print("[");
            // // int trav = 0;
            // for (int i = 0; i < row + column - 2; i++) {
            //     if (pathTraversed[i][1] < pathTraversed[i + 1][1]) {
            //         System.out.print(pathTraversed[i][0] + " " + pathTraversed[i][1] + " -- ");
            //         System.out.print(pathTraversed[i + 1][0] + " " + pathTraversed[i + 1][1]);
            //         trav++;
            //         if (trav == noOfRows) {
            //             System.out.print("]");
            //         } else {
            //             System.out.print(", ");
            //         }
            //     }
            // }

            // // print count of vertical movement
            // trav = 0;
            // System.out.println("\n\nCount of Vertical Movements: " + nooflastColumn);
            // System.out.print("[");
            // for (int i = 0; i < row + column - 2; i++) {
            //     if (pathTraversed[i][0] < pathTraversed[i + 1][0]) {
            //         System.out.print(pathTraversed[i][0] + " " + pathTraversed[i][1] + " -- ");
            //         System.out.print(pathTraversed[i + 1][0] + " " + pathTraversed[i + 1][1]);
            //         if (trav == nooflastColumn) {
            //             System.out.print(" ");
            //         } else {
            //             System.out.print(", ");
            //         }
            //     }
            // }
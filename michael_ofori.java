// @author michael_ofori
// Lab 6
// Algorithm Design and Analysis
//Reference : https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
//Reference : https://www.jsums.edu/nmeghanathan/files/2016/08/CSC323-Fall2016-Module-4-DynamicProgramming.pdf
import java.util.Scanner;
import java.lang.Math;

class michael_ofori {

    public static void coinproblem(){
        try (//Reading user input.
        Scanner input1 = new Scanner(System.in)) {
            //Getting number of rows from user.
            System.out.print("enter the number of rows : ");
            //Reading row number of rows from user input.
            int row = input1.nextInt();
            // Read number of columns from user.
            System.out.print("enter the number of columns : ");
            //Getting number of columns from user.
            int column = input1.nextInt();
            // Read number of coins.
            System.out.print("enter the number of coins : ");
            //Getting number of coins from user.
            int Coins = input1.nextInt();
            //Read the maximum value for a coin.
            System.out.print("enter the max. value for a coin :  ");
            //Getting max coin from user.
            int maxCoin = input1.nextInt();
            // Initial matrix.
            int[][] coinGrid = new int[row][column];
            // Array to randomly distribute number of coins.
            int[] randCoins = new int[Coins];  //instance of random class.
            // Generating random values.
            for (int i = 0; i < Coins; i++) {
                randCoins[i] = 1 + (int) (Math.random() * maxCoin);
            }

            int count = 0;
            // Select random cell from the grid.
            while (count < Coins) {

                int row1 = (int) (Math.random() * row);
                int column1 = (int) (Math.random() * column);

                // Cells with value 0 will be selected at random.
                if (coinGrid[row1][column1] == 0) {
                    coinGrid[row1][column1] = randCoins[count++];
                }
            }
            //Print distribution value of coins.
            System.out.println("\ndistribution of the Coin Values ");

            // Printing the matrix.
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(String.format("% 6d", coinGrid[i][j]));
                }
                System.out.println();
            }
           
            //Creating a 2D array to store the elements.
            int[][] size = new int[row + 1][column + 1];

            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    size[i][j] = Math.max(coinGrid[i - 1][j - 1] + size[i - 1][j],
                            coinGrid[i - 1][j - 1] + size[i][j - 1]);
                }
            }
            //Print dynamic programming table
            System.out.println("\n table of Dynamic Program");
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    System.out.print(String.format("% 6d", size[i][j]));
                }
                System.out.println();
            }
            // Array to tracking back the optimal path
            int[][] pathTraversed = new int[row + column - 1][2];
            count = row + column - 3;
            int lastRow = row;
            int lastColumn = column;
            int noOfRows = 0;
            int nooflastColumn = 0;  
            pathTraversed[row + column - 2][0] = row - 1;
            pathTraversed[row + column - 2][1] = column - 1;
            // Finding path traversed
            while (count >= 0) {
                if (lastRow > 1 && lastColumn > 1) {
                    if (size[lastRow - 1][lastColumn] >= size[lastRow][lastColumn - 1]) {
                        lastRow -= 1;
                        nooflastColumn++;
                    } else {
                        lastColumn -= 1;
                        noOfRows++;
                    }
                } else if (lastRow > 1) {
                    lastRow -= 1;
                    nooflastColumn++;
                } else {
                    lastColumn -= 1;
                    noOfRows++;
                }
                pathTraversed[count][0] = lastRow - 1;
                pathTraversed[count--][1] = lastColumn - 1;
            }
            //Displaying the path traversed
            System.out.print("\nPath Traversed: ");
            System.out.print("\n");
            //swapping the traversal
            System.out.println(pathTraversed[row + column - 2][0] + " "+pathTraversed[column + row - 2][1]);
            for (int i = row + column - 3 ; i>=0 ; i-- ){
                String path = " ";
                if (pathTraversed[i][1] < pathTraversed[i + 1][1]) {
                    path = " Horizontal Path Traversal";  
                }  else if (pathTraversed[i][0] < pathTraversed[i + 1][0]) {
                    path= "  Vertical Path Traversal";    
                }
                System.out.println(pathTraversed[i][0] + " , " + pathTraversed[i][1] + path);
            } System.out.println("\n");
        }
    }
    //Root of application
    public static void main(String[] arg) { 
        //command line argument
        coinproblem();   
        System.out.println("\n "); 
        System.out.println("\n Problem solved");
    }
}
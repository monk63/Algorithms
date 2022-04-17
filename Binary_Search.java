// Problem 1: Implementing a modified version of binary search
// @author :  Michael Nana Kofi Ofori
// Algorithm Design and Analysis
// Assignment 01: Brute Force Algorithms
// Import the File class
// Import this class to handle errors
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Binary_Search {

	static int binarySearch(int[] store, int target) {
		int start = 0;
		int end = store.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2; // same thing, this will never exceed the int range
			if (target > store[mid]) {
				start = mid + 1;
			} else if (target < store[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		// writes the index of number in the array, or -1 if the number does not exist in the text.
		return -1;
	}

    public static void interactive() {

        int  store;

        Scanner input1 = new Scanner(System.in);

        System.out.print("Enter the number of elements you want to store : ");

        store=input1.nextInt();
	
        //creates an array in memory of length 100.
        int[] array= new int [store]  ;
		
        System.out.println("Enter the elements of the array: ");

        for (int i = 0; i < store; i++){
            //reading array elememts from the user
            array[i]=input1.nextInt();
        }

        //select element from array
        int target;

        Scanner input2 = new Scanner(System.in);

        System.out.print("Select element from array : ");

        target=input2.nextInt();

        System.out.println("The elements in the array are : ");
        for (int i = 0;i<store;i++)
        {
            System.out.println(array[i]);
        }

        //selecting one element
       // int[] array2 = new int[1];          

		int index = binarySearch(array, target);
		if (index == -1)
			System.out.println("Element not Found");
		else
			System.out.println("Output : "+ (index)+" ( The index of "+(target)+" in the array )" );
	}


    
  



	public static void main(String[] args) throws IOException {

      //  interactive method
       interactive();

    }   
}
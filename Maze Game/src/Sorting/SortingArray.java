package Sorting;

import java.util.Scanner;

public class SortingArray {

	public static void main(String[] args) {
		// Problem: Input 6 student grades and sort them from lowest to highest. User
		// may decide the student grades.
		Scanner input = new Scanner(System.in);
		Array[] grades = new Array[6];

		for (int i = 0; i < grades.length; i++) {
			grades[i] = new Array();
		}

		for (int x = 0; x < 6; x++) {
			System.out.println("Enter mark for student " + (x + 1) + ": ");
			grades[x].setArray(input.nextInt());
		}
		boolean i = true;
		Array tempHolder;
		int highestIndex, noOfComparisons;

		highestIndex = grades.length - 1;
		noOfComparisons = highestIndex;

		while (i == true) {
			System.out.println("Would you like to sort it from: \n1)lowest to highest \n2)highest to lowest");
			int decision = input.nextInt();

			// Lowest to highest
			if (decision == 1) {
				i = false;
				for (int x = 0; x < highestIndex; x++) {
					for (int j = 0; j < noOfComparisons; j++) {
						if (grades[j].getArray() > grades[j + 1].getArray()) {
							tempHolder = grades[j];
							grades[j] = grades[j + 1];
							grades[j + 1] = tempHolder;
						}
					}
					noOfComparisons--;

				} // end of outer loop

				// printing the sorted array
				System.out.println("The Sorted Array........\n");
				for (int i1 = 0; i1 < grades.length; i1++) {
					System.out.print("Student " + (i1 + 1) + " Mark:" + grades[i1].getArray() + "\n");

				}
			}
			// Highest to lowest
			else if (decision == 2) {
				i = false;
				for (int x = 0; x < highestIndex; x++) {
					for (int j = 0; j < noOfComparisons; j++) {
						if (grades[j].getArray() < grades[j + 1].getArray()) {
							tempHolder = grades[j];
							grades[j] = grades[j + 1];
							grades[j + 1] = tempHolder;
						}
					}
					noOfComparisons--;

				} // end of outer loop

				// printing the sorted array
				System.out.println("The Sorted Array........\n");
				for (int i1 = 0; i1 < grades.length; i1++) {
					System.out.print("Student " + (i1 + 1) + " Mark:" + grades[i1].getArray() + "\n");

				}
			}
			// Error checking
			else {
				System.out.println("Invalid input, please enter 1 or 2..\n");
			}
		}

	}

}

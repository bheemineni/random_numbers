package com.sbheemineni.projects.numbers;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Utility class for dealing with random numbers.
 * 
 * @author SrinivasBheemineni
 *
 */
public class RandomNumberUtil {

	public static int[] randomIntegers = {100,1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,
			18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,
			11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11,200};

	public static void main(String[] args) {
		System.out.println("Before Sorting:\t" + randomIntegers.length);

		for (int i=0;i<randomIntegers.length; i++ ) {
			System.out.print(randomIntegers[i]+"\t");
		}

		int[] output = new RandomNumberUtil().removeDuplicates(randomIntegers);

		System.out.println("\n\nAfter Sorting:\t" + output.length);
		for (int i=0;i<output.length; i++ ) {
			System.out.print(output[i]+"\t");
		}
	}

	/**
	 * (1)
	 * 
	 * This method removes duplicates from an integer array.
	 * 
	 * Removes duplicates first and then copy the unique elements into a new array, 
	 * truncates unnecessary elements and return.
	 * 
	 * Advantage: Removed duplicates without using any other API.
	 * 
	 * Disadvantage: To remove the unnecessary elements from the array, we used Arrays. 
	 * And it's difficult to maintain original order. 
	 * 
	 * @param randomNumbers	Array of random numbers with duplicates
	 * @return					Array of random numbers after removing duplicates.
	 */	
	public int[] removeDuplicates(int[] randomNumbers) {

		int numberOfUniqueElements = randomNumbers.length;

		for (int i = 0; i < numberOfUniqueElements; i++) {
			for (int j = i+1; j < numberOfUniqueElements; j++) {
				if(randomNumbers[i] == randomNumbers[j]) {
					randomNumbers[j] = randomNumbers[numberOfUniqueElements-1];
					numberOfUniqueElements--;
					j--;
				}
			}
		}

		return Arrays.copyOf(randomNumbers, numberOfUniqueElements);
	}


	/**
	 * (2)
	 *  
	 * This method uses Collection API
	 * To maintain the original order, use LinkedHashSet instead of HashSet.
	 * 
	 * Adds all the original elements into a Set which retains unique elements only. 
	 * And then copies these unique elements into a new integer array and return it.
	 * 
	 * Can accommodate original order or can sort elements if needed.
	 * Disadvantage is that we created a new Set implementation to remove duplicates, then copied elements to a new array.
	 * 
	 * @param randomIntegers	Array of random numbers with duplicates
	 * @param originalOrder		If true, maintain original order. 
	 * 							If false, sort the elements after removing duplicates.
	 * @return					Array of random numbers after removing duplicates, possibly with sorted order.
	 * 
	 */
	public int[] removeDuplicatesWithCollectionAPI(int[] randomNumbers, boolean originalOrder){

		// Use HashSet for random order or LinkedHashSet to maintain the insertion order.
		Set<Integer> uniqueNumbers = new LinkedHashSet<Integer>(); 

		int length = randomNumbers.length;
		for(int i = 0; i < length; i++){
			uniqueNumbers.add(randomNumbers[i]);
		}

		int[] result = new int[uniqueNumbers.size()];
		int i = 0;	    
		for (Integer s : uniqueNumbers) {
			result[i++] = s;
		}

		if(!originalOrder) { // For sorting
			Arrays.sort(result);
		}

		return result;
	}


	/**
	 * (3)
	 * 
	 * This method uses Java 8 Streams for removing duplicates and sorting.
	 * 
	 * This is the best way of sorting when compared to other two methods.
	 * It's just one line code. It uses Java's built-in API to sort and remove duplicates.
	 * 
	 * @param randomIntegers	Array of random numbers with duplicates
	 * @param originalOrder		If true, maintain original order. 
	 * 							If false, sort the elements after removing duplicates.
	 * @return					Array of random numbers after removing duplicates, possibly with sorted order.
	 * 
	 */
	public int[] removeDuplicatesWithJava8Stream(int[] randomIntegers, boolean originalOrder) {
		if(originalOrder) {
			return Arrays.stream(randomIntegers).distinct().toArray();
		}
		else {
			return Arrays.stream(randomIntegers).distinct().sorted().toArray();
		}
	}

}

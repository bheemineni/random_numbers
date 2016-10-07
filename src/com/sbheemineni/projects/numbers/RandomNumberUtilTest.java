package com.sbheemineni.projects.numbers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test class for RandomNumberUtil
 * 
 * @author SrinivasBheemineni
 *
 */
public class RandomNumberUtilTest {

	private RandomNumberUtil randomNumberUtil;
	
	private int[] RANDOM_NUMBERS = {100,1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,
			18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,
			11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11,200};
	
	@Before
	public void initialize() {
		randomNumberUtil = new RandomNumberUtil();
	}
	
	@After
	public void destroy() {
		randomNumberUtil = null;
	}
	
	@Test
	public void removeDuplicates() {
		int[] uniqueNumbers = randomNumberUtil.removeDuplicates(RANDOM_NUMBERS);
		Assert.assertEquals(30, uniqueNumbers.length);
		Assert.assertEquals(100, uniqueNumbers[0]); // No effect on original order.
		Assert.assertEquals(8, uniqueNumbers[uniqueNumbers.length - 1]);
	}
	
	
	
	@Test
	public void removeDuplicatesWithCollectionAPI_OriginalOrder() {
		int[] uniqueNumbers = randomNumberUtil.removeDuplicatesWithCollectionAPI(RANDOM_NUMBERS, true);
		Assert.assertEquals(30, uniqueNumbers.length);
		Assert.assertEquals(100, uniqueNumbers[0]); // No effect on original order.
		Assert.assertEquals(200, uniqueNumbers[uniqueNumbers.length - 1]);
	}
	
	@Test
	public void removeDuplicatesWithCollectionAPI_Sorted() {
		int[] uniqueNumbers = randomNumberUtil.removeDuplicatesWithCollectionAPI(RANDOM_NUMBERS, false);
		Assert.assertEquals(30, uniqueNumbers.length);
		Assert.assertEquals(1, uniqueNumbers[0]); // No effect on original order.
		Assert.assertEquals(10000, uniqueNumbers[uniqueNumbers.length - 1]);
	}
	
	
	
	@Test
	public void removeDuplicatesWithJava8Stream_OriginalOrder() {
		int[] uniqueNumbers = randomNumberUtil.removeDuplicatesWithJava8Stream(RANDOM_NUMBERS, true);
		Assert.assertEquals(30, uniqueNumbers.length);
		Assert.assertEquals(100, uniqueNumbers[0]); // No effect on original order.
		Assert.assertEquals(200, uniqueNumbers[uniqueNumbers.length - 1]);
	}
	
	@Test
	public void removeDuplicatesWithJava8Stream_Sorted() {
		int[] uniqueNumbers = randomNumberUtil.removeDuplicatesWithJava8Stream(RANDOM_NUMBERS, false);
		Assert.assertEquals(30, uniqueNumbers.length);
		Assert.assertEquals(1, uniqueNumbers[0]); // smallest number should be at the beginning after sorting
		Assert.assertEquals(10000, uniqueNumbers[uniqueNumbers.length - 1]); // largest number should be at the end after sorting
	}
	
}

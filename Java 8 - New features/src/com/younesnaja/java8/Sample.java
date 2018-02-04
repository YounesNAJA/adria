package com.younesnaja.java8;
import java.util.Arrays;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		/**
		 * External iterators
		 */
//		for(int i = 0; i < values.size(); i++) {
//			System.out.println(values.get(i));
//		}
		
//		for(int e : values) {
//			System.out.println(e);
//		}
		
		/**
		 * Internal iterators
		 * Autopilot iteration : You don't have to tell
		 */
		
		/**
		 * Consumer is a new interface available in Java 8
		 * forEach else is new in Java 8
		 */
//		values.forEach(new Consumer<Integer>() {
//
//			@Override
//			public void accept(Integer value) {
//				System.out.println(value);
//				
//			}
//			
//		});
		
		/**
		 * Anonymous function
		 */
//		values.forEach((Integer value) -> System.out.println(value));
		
//		values.forEach(value -> System.out.println(value));
		
//		values.forEach(value -> System.out.println(value));
		
		values.forEach(System.out::println);
		
	}

}

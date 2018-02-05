package com.younesnaja.java8;

import java.util.Arrays;
import java.util.List;

public class Sample5 {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9);
		
		// the double of the first even number in the list
		int result = 0;
		for(int e : values) {
			if(e > 3 && e % 2 == 0) { 
				result = e * 2;
				break;
			}
		}
		System.out.println(result);
		
		System.out.println(values.stream().filter(e -> e > 3).filter(e -> e % 2 == 0).map(e -> e * 2).findFirst().orElse(0));
	}

}

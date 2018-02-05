package com.younesnaja.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample4 {
	public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
//		int total = 0;
//		for(int e : numbers) {
//			if(selector.test(e)) total += e;
//		}
//		return total;
		return numbers.stream().filter(selector).reduce(0, (c, e) -> c + e);
	}
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		System.out.println(totalValues(values, e -> true));
		System.out.println(totalValues(values, e -> e % 2 == 0));
		System.out.println(totalValues(values, e -> e % 2 != 0));
	}
}

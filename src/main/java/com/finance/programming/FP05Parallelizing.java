package com.finance.programming;

import java.util.stream.LongStream;

public class FP05Parallelizing {
	
	public static void main(String[] args) {
		System.out.println("WITHOUT PARALLELISM");
		withoutParallelism();
		// WITH PARALLELISM

		System.out.println("WITH PARALLELISM");
		long time = System.currentTimeMillis();
		// 0, 1000000
		System.out.println(LongStream.range(0, 100000).parallel().sum());
		System.out.println(System.currentTimeMillis() - time);

	}

	private static void withoutParallelism(){

		long time = System.currentTimeMillis();
		// 0, 1000000
		System.out.println(LongStream.range(0, 100000).sum());
		System.out.println(System.currentTimeMillis() - time);

	}


}

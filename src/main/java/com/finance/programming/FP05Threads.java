package com.finance.programming;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP05Threads {

	public static void main(String[] args) {

		Runnable runnable = () -> IntStream.range(0, 10000)
					.forEach(i -> System.out.println(System.currentTimeMillis() + ": "+ i));

		Thread thread = new Thread(() -> {
			for(int i = 0; i < 10000; i++)
				System.out.println(Thread.currentThread().getId() + " : " + i);
		});
		thread.start();

		Thread thread2 = new Thread(runnable);
		thread2.start();

		Thread thread3 = new Thread(runnable);
		thread3.start();


	}

}

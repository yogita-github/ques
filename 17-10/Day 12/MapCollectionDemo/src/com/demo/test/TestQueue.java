package com.demo.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<Integer> pq=new PriorityQueue<>();
		pq.add(23);
		pq.add(12);
		pq.add(5);
		pq.add(17);
		pq.remove();
		System.out.println(pq.peek()+","+pq.poll()+","+pq.peek());
		

	}

}

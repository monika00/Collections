package Collections_Int;

//The Queue interface basically orders the element in FIFO(First In First Out)manner

import java.util.*;

public class Queue_exp {

	public static void main(String[] args) {
		
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("bbb");
		pq.add("bbb");
		pq.add("ccc");
		pq.add("aaa");
		
		System.out.println("Iterating the Queue");
		Iterator<String> itr = pq.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());			
		}
		
		pq.remove();
		pq.poll();
		
		System.out.println("After methods");
		Iterator<String> itr2 = pq.iterator();
		while(itr2.hasNext()){
			System.out.println(itr2.next());
		}

	}

}

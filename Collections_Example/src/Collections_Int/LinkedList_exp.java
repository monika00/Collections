package Collections_Int;

//Java LinkedList class uses doubly linked list to store the elements. It extends the AbstractList class and implements List and Deque interfaces.
//Java LinkedList class can contain duplicate elements
//Java LinkedList class maintains insertion order
//Java LinkedList class is non synchronized
//In Java LinkedList class, manipulation is fast because no shifting needs to be occurred
//Java LinkedList class can be used as list, stack or queue

import java.util.*;

public class LinkedList_exp {

	public static void main(String[] args) {
		
		LinkedList<String> l1 = new LinkedList<String>();
		l1.add("aaa");
		l1.add("bbb");
		l1.add("ccc");
		
		Iterator <String> itr = l1.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

	}

}

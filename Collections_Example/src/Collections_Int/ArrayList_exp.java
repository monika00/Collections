package Collections_Int;

//Java ArrayList class uses a dynamic array for storing the elements.It extends AbstractList class and implements List interface
//Java ArrayList class can contain duplicate elements
//Java ArrayList class maintains insertion order
//Java ArrayList class is non synchronized
//Java ArrayList allows random access because array works at the index basis
//In Java ArrayList class, manipulation is slow because a lot of shifting needs to be occurred if any element is removed from the array list.

import java.util.*;


public class ArrayList_exp {

	public static void main(String[] args) {
		
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("aaa");
		a1.add("bbb");
		a1.add("ccc");
		
		
		Iterator itr = a1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

	}

}

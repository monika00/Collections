package Collections_Int;

import java.util.*;

public class Collections_Int {
	
	public static void main(String[] args){
	
    List a1 = new ArrayList();
    a1.add("Zara");
    a1.add("Mahnaz");
    a1.add("Ayan");
    System.out.println(" ArrayList Elements");
    System.out.print("\t" + a1);

    //LinkedList
    List l1 = new LinkedList();
    l1.add("Zara");
    l1.add("Mahnaz");
    l1.add("Ayan");
    System.out.println();
    System.out.println(" LinkedList Elements");
    System.out.print("\t" + l1);
	
	//HashSet
    Set s1 = new HashSet();
    s1.add("Zara");
    s1.add("Mahnaz");
    s1.add("Avan");
    System.out.println();
    System.out.println("HashSet elements");
    System.out.println("\t" + s1);
    
    //HashMap 
    Map m1 = new HashMap();
    m1.put("Zara","8");
    m1.put("Mahnaz", "30");
    m1.put("Avan","40");
    System.out.println();
    System.out.println("HashMap");
    System.out.println("\t" + m1);
	
	}
    
}

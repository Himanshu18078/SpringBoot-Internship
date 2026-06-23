package Comparator;

import java.util.ArrayList;
import java.util.*;

public class EmployeeExample {
    public static void main(String [] args){
//        ArrayList<String> emp = new ArrayList<>();
//        emp.add("Amit");
//        emp.add("Sumit");
//        emp.add("Rohit");
//        emp.add("Rakesh");
//        System.out.print("Before sorting"+emp+" ");
//        System.out.println();
//        Collections.sort(emp);
//        System.out.println("After Sorting"+emp+" ");


        ArrayList<Employee> emp  =new ArrayList<>();
        emp.add(new Employee(101,400,"Amit"));
        emp.add(new Employee(120,200,"Sumit"));
        emp.add(new Employee(105,600,"Rohit"));
        emp.add(new Employee(115,800,"Rakesh"));
        emp.add(new Employee(115,900,"Rakesh"));

        /*
        Here I have used ID comparator.
        System.out.println("Before sorting : "+emp+" \n");
        Collections.sort(emp, new IDComparator());
        System.out.println("After Sorting : "+emp+" \n");
        */

        System.out.println("Before sorting : "+emp+" \n");
        Collections.sort(emp, new SalaryComparator());
        System.out.println("After Sorting : "+emp+" \n");
    }
}
/*
Comparator Interface

Comparator is used to define a custom sorting rule for objects.
It is available in the java.util package.

Why Comparator?

A class can have only one compareTo() method through Comparable,
but the same object may need to be sorted in multiple ways.

Comparator allows us to create different sorting logics
without modifying the original class.

How it works

Collections.sort(list, comparator);

Here:

list
    Collection of objects that need to be sorted.

comparator
    Object containing the comparison logic.

What happens internally

1. Collections.sort() receives:
   - The collection of objects.
   - The comparator object.

2. The sorting algorithm picks two objects from the collection.

3. It automatically calls:

   comparator.compare(o1, o2);

4. The compare() method returns:

   Negative value (< 0)
       o1 should come before o2

   Zero (0)
       Both objects are equal for sorting purposes

   Positive value (> 0)
       o1 should come after o2

5. Based on the returned value, Java rearranges the objects.

6. This process continues until the collection is sorted.

Key Point

We do not pass o1 and o2 manually.

Collections.sort() automatically selects objects from the
collection and passes them to the compare() method whenever
a comparison is required during sorting.
*/

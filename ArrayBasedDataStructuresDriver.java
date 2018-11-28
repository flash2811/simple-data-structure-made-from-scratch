/**
 * This is the driver
 * it tests the queue, stack and arrayList classes
 *
 * @author Subhrajyoti Mondal
 * @version (7/8/2018)
 *
 */

//remove the line below
package com.company;

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		stackTests();
		System.out.println();

		queueTests();
		System.out.println();

		arrayListTests();
	}
	/**
	 * arrayListTests
	 * --------
	 * This method tests the arrayList class
	 * @param : NONE
	 * @return : NONE
	 * PRE:  NONE
	 * POST: NONE
	 */
	private static void arrayListTests() {
		//todo: make more tests here
		ArrayList a = new ArrayList();

		a.insert('B', 0);
		a.insert('a',0);
		a.insert('t',1);
		
		System.out.println(a.toString());
		if(a.get(0).equals('a')){
			System.out.println("a.get(0).equals('a') |True|");
		}
		if(a.indexOf('a') == 0){
			System.out.println("a.indexOf('a') == 0  |True|");
		}

		ArrayList b = new ArrayList();

		b.insert('B', 0);
		b.insert('a',0);
		b.insert('t',1);
		if(a.equals(b)){
			System.out.println("a.equals(b) |True|");
		}

		while(a.isEmpty() == false) {
			System.out.println(a.remove(0));
		}

		System.out.println("Size should be 0 --> " + a.size());


	}

	/**
	 * queueTests
	 * --------
	 * This method tests the queueTests class
	 * @param : NONE
	 * @return : NONE
	 * PRE:  NONE
	 * POST: NONE
	 */
	private static void queueTests() {
		//todo: make more tests here
		Queue a = new Queue();

		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');
		a.dequeue();

		System.out.println(a.toString());
		Queue b = new Queue();

		b.enqueue('B');
		b.enqueue('a');
		b.enqueue('t');
		b.dequeue();

		System.out.println("Is a and b the same? |True| " + a.equals(b));

		while(a.isEmpty() == false) {
			System.out.println(a.dequeue());
		}

		System.out.println("Size should be 0 --> " + a.size());
		System.out.println("Is Stack Empty? |True| " + a.isEmpty());

	}

	/**
	 * stackTests
	 * --------
	 * This method tests the stackTests class
	 * @param : NONE
	 * @return : NONE
	 * PRE:  NONE
	 * POST: NONE
	 */
	private static void stackTests() {
		//todo: make more tests here
		Stack a = new Stack();

		a.push('B');
		a.push('a');
		a.push('t');
		//verify what happens we try to push null value
		//uncomment below line to test, it would give exception
		//a.push(null);


		System.out.println(a.toString());

		Stack b = new Stack();

		b.push('B');
		b.push('a');
		b.push('t');

		System.out.println("Is a and b the same? |True| " + a.equals(b));
		while(a.isEmpty() == false) {
			System.out.println(a.pop());
		}
		//test for size
		System.out.println("Size should be 0 --> " + a.size());

		//testing the empty method
		System.out.println("Is Stack Empty? |True| " + a.isEmpty());
	}
	

}

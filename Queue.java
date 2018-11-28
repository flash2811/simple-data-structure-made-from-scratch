package com.company;
/**
 * This is the Queue class
 * it is a simple version of the normal queue class
 * this also has a dependency of the Node class
 * which is present in Stack.java
 * @author Subhrajyoti Mondal
 * @version (7/8/2018)
 */

public class Queue implements AbstractQueue {
    private Node first, last;
    private int currentSize = 0;

    /**
     * enqueue
     * --------
     * This method takes in a object item
     * and puts it in the queue
     * @param item : it is a object, and can be of any kind
     * PRE:  the item has to be valid, and not be null
     *       or the method will throw a nullPointerException
     * POST: the object is added to the queue
     */
    public void enqueue(Object item){
        //stopping if the item is null
        if(item == null){
            throw new NullPointerException();
        }

        if(first == null){
            last = new Node(item);
            first = last;
        }
        else{
            last.next = new Node(item);
            last = last.next;
        }
        currentSize++;
    }

    /**
     * dequeue
     * --------
     * This method removes the first object from the queue, if possible
     * @param : NONE
     * @return : the removed object or null if nothing is found
     * PRE:  NONE
     * POST: Null or item is returned
     */
    public Object dequeue(){
        if(first != null){
            Object item = first.data;
            first = first.next;
            if(first == null)
            {
                last = null;
            }
            currentSize--;
            return item;

        }
        return null;
    }

    //returns the size
    public int size(){
        return currentSize;
    }

    //creates a string version of the queue
    @Override
    public String toString() {
        String stringForm = "";

        //a temporary version is created
        //and the original is not disturbed
        Node nFirst = first;

        while (nFirst != null) {
            stringForm += nFirst.data.toString();
            stringForm += "\n";
            nFirst = nFirst.next;
        }
        return stringForm;
    }

    //checks if the the queue is empty or not
    public boolean isEmpty() {
        //this is done by check the value of currentSize
        if (this.currentSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * equals
     * --------
     * This method checks if the queue is same as the
     * other from the parameter
     * @param that : Queue form the driver
     * @return : true or false
     * PRE:  NONE
     * POST: true or false
     */
    public boolean equals(Queue that) {
        if (that == null) {
            return false;
        }
        if (this.size() != that.size())
        {
            return false;
        }

        if (this.toString().equals(that.toString())){
            return true;
        }
        return false;
    }
}

/**
 * This is the interface of the queue class
 * @author Subhrajyoti Mondal
 * @version (7/8/2018)
 */
interface AbstractQueue {
    public void enqueue(Object item);
    public Object dequeue();
    public int size();
    public String toString();
    public boolean isEmpty();
    public boolean equals(Queue that);
}
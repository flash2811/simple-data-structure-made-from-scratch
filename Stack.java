package com.company;
/**
 * This is the Stack class
 * it is a simple version of the normal Stack class
 * @author Subhrajyoti Mondal
 * @version (7/8/2018)
 */
public class Stack implements AbstractStack {
    private int currentSize = 0;

    Node top;

    /**
     * push
     * --------
     * this method just puts an object on the stack
     * @param item : it is a object, and can be of any kind
     * PRE:  the item has to be valid, and not be null
     *           or the method will throw a nullPointerException
     * POST: Null or item is returned
     */
    public void push(Object item) {
        //stopping if the item is null
        if(item == null){
            throw new NullPointerException();
        }

        Node t = new Node(item);
        t.next = this.top;
        this.top = t;
        currentSize++;
    }

    /**
     * pop
     * --------
     * This method removes the top object from the stack, if possible
     * @param : NONE
     * @return : the removed object or null if nothing is found
     * PRE:  NONE
     * POST: Null or item is returned
     */
    public Object pop() {
        if (this.top != null) {
            Object item = top.data;
            top = top.next;
            currentSize--;
            return item;
        }
        return null;
    }

    //returns the very first thing on the stack
    public Object peek() {
        return top.data;
    }

    //returns the size
    public int size() {
        return currentSize;
    }

    //creates a string version of the stack
    @Override
    public String toString() {
        String stringForm = "";

        Node nTop = top;

        while (nTop != null) {
            stringForm += nTop.data.toString();
            stringForm += "\n";
            nTop = nTop.next;
        }
        return stringForm;
    }

    //checks if the the stack is empty or not
    public boolean isEmpty() {
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
    public boolean equals(Stack that) {
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
 * This is the Node class which is used by
 * both stack and queue class
 * got the gist from this youtube video  --> https://www.youtube.com/watch?v=zSJRn8erf9M
 * its somewhere around 4:51 in the video
 * @author Subhrajyoti Mondal
 * @version (7/8/2018)
 */
class Node {
    public Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
    }
}

/**
 * This is the interface of the Stack class
 * @author Subhrajyoti Mondal
 * @version (7/8/2018)
 */

interface AbstractStack {
    public void push(Object item);
    public Object pop();
    public int size();
    public String toString();
    public boolean isEmpty();
    public boolean equals(Stack that);
}
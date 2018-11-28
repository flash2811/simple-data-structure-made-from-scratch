/**
 * This is the ArrayList class
 * it is a simple version of the normal ArrayList class
 * @author Subhrajyoti Mondal
 * @version (7/7/2018)
 */
//Remove the line below
package com.company;
//interface is at the bottom
public class ArrayList implements AbstractList{
    private int currentSize;
    private int totalCapacity;
    private Object[] listLikeArray;

    public ArrayList(){
        this.currentSize = 0;
        this.totalCapacity = 5;
        this.listLikeArray = new Object[this.totalCapacity];
    }

    /**
     * insert
     * --------
     * this method just inserts an object into the arrayList
     * based on the index value
     * @param o : it is a object, and can be of any kind
     * @param index : this the index location, the place where
     *              o will be inserted
     * PRE:  the item has to be valid, and not be null
     *           or the method will throw a nullPointerException
     * POST: item is returned
     */
    public void insert(Object o, int index){
        //Add the object at the specified index, shifting other elements over as needed.
        if(o == null){
            throw new NullPointerException();
        }

        this.totalCapacity++;

        Object[] arrNew = new Object[this.totalCapacity];

        for(int i = 0; i < listLikeArray.length; i++) {
            if (i < index) {
                arrNew[i] = this.listLikeArray[i];
            }
            else if (i == index) {
                arrNew[i] = o;
                arrNew[i + 1] = this.listLikeArray[i];
            }
            else {
                arrNew[i + 1] = this.listLikeArray[i];
            }
        }
        this.listLikeArray = arrNew;
        this.currentSize++;
    }

    /**
     * insert
     * --------
     * this method just removes the object from the given index
     * @param index : this the index location which will be removed
     * PRE:  the index has to be valid, and not be null
     *           or the method will throw a nullPointerException
     * POST: object is returned
     */
    public Object remove(int index){
        //check if the index is within range
        if(index < 0 || index > currentSize){
            throw new IndexOutOfBoundsException();
        }

        //Remove and return the object at the specified index
        for(int i = index; i < currentSize - 1; i++) {
            this.listLikeArray[i] = this.listLikeArray[i + 1];
        }
        this.listLikeArray[currentSize] = null;
        this.currentSize--;

        return listLikeArray[index];
    }

    //returns the size
    public int size(){
        return currentSize;
    }

    //converts the list to a string
    public String toString(){
        String arrStringForm = "" ;
        //loop through the listLikeArray
        //and create a string
        for(int i = 0; i < currentSize; i++){
            if(listLikeArray[i] != null){
                arrStringForm += listLikeArray[i].toString();
                arrStringForm += "\n";
            }
        }
        return arrStringForm;
    }

    //checks if the list is empty or not
    public boolean isEmpty(){
        if(this.currentSize == 0){
            return true;
        }
        else {
            return false;
        }
    }

    //returns the int using the object
    public int indexOf(Object o){
        //this is done by a for loop
        for(int i = 0; i < this.currentSize; i++){
            if(this.listLikeArray[i] == o){
                return i;
            }
        }
        //returns -1 if not found
        return -1;
    }

    /**
     * equals
     * --------
     * This method checks if the ArrayList is same as the
     * other from the parameter
     * @param that : ArrayList form the driver
     * @return : true or false
     * PRE:  NONE
     * POST: true or false
     */
    public boolean equals(ArrayList that){
        if(that == null){
            return false;
        }

        if(this.currentSize != that.currentSize){
            return false;
        }

        for(int i = 0; i < this.listLikeArray.length; i++){
            if(this.listLikeArray[i] != that.listLikeArray[i]){
                return false;
            }
        }

        return true;
    }

    //gets the object using the index
    public Object get(int index){
        return this.listLikeArray[index];
    }
}
/**
 * This is the interface of the ArrayList class
 * @author Subhrajyoti Mondal
 * @version (7/8/2018)
 */

interface AbstractList {
    public void insert(Object o, int index);
    public Object remove(int index);
    public int size();
    public String toString();
    public boolean isEmpty();
    public int indexOf(Object o);
    boolean equals(ArrayList that);
    public Object get(int index);

}

/** Name : Annanya Jain
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ListQueue is a class created for priority list queue containing inner classes named Node<E> and Iter.
 * It has two data fields : Node<E> front and int size.
 * @param <E>
 */
public class ListQueue<E> {
    private Node<E> front;
    private int size;

    /**
     * Node class containing :
     * 1. Three data fields namely : E data, Node<E> next, int priority.
     * 2. Three Constructors for Node.
     * 3. Getter methods which returns data and next node.
     * @param <E>
     */
    public static class Node<E> {
        private E data;
        private Node<E> next;
        private int priority;

        public Node(E dataItem) {
            data = dataItem;
            next = null;
            priority = Integer.MAX_VALUE;
        }

        public Node(E dataItem, int priority) {
            data = dataItem;
            next = null;
            this.priority = priority;
        }

        public Node(E dataItem, Node<E> next, int priority) {
            data = dataItem;
            this.next = next;
            this.priority = priority;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

    }

    /**
     * An inner class of ListQueue called Iter is created which include operations namely hasNext(), next(), remove().
     */
    public class Iter implements Iterator<E> {

        /**
         * Data fields for Iter is created.
         */
        private Node<E> next = front;


        /**
         * hasNext() checks if the next node is present or not.
         * @return - returns true when the next Node is not equal to null otherwise returns false.
         */

        @Override
        public boolean hasNext() {
            if (next == null) {
                return false;
            } else {
                return true;
            }
        }

        /**
         * next() will update the next node attribute with the next node of next node by first checking if there exist a next node by making use of hasNext().
         * If a next node doesn't exist, it throws an exception.
         * @return - it returns the data stored in the next node (attribute).
         */

        public E next() {
            if (hasNext() == false) {
                throw new NoSuchElementException();
            } else {
                E item = next.getData();
                next = next.next;
                return item;
            }

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * It creates an empty single-linked list representing the priority queue.
     */
    public ListQueue() {
        front = null;
        size = 0;
    }

    /**
     * This creates a one-element single-linked list representing the priority queue. first parameter will be stored in front of the queue.
     * @param first
     */
    public ListQueue(Node<E> first) {
        front = first;
        size = 1;
    }

    /**
     * getter and setter method for front.
     */
    public Node<E> getFront() {
        return front;
    }

    public void setFront(Node<E> front) {
        this.front = front;
    }

    /**
     * Getter method for returning size of the queue.
     */
    public int getSize() {
        return size;
    }

    /**
     * @return : peek() returns null if front is equal to null, otherwise it returns the information at the front of the queue.
     */
    public E peek() {
        if (front == null) {
            return null;
        } else {
            return front.data;
        }
    }


    /**
     * offer() adds item to a position according to its priority and update the next node accordingly.
     * It also keeps track of the size and increments it once a new item is added.
     * @param item
     * @param priority
     * @return : It returns null if the item sent to the method is null. Otherwise, it returns true once a new item is added to the queue.
     */
    public boolean offer(E item, int priority) {
        Node<E> addnewNode = new Node<E>(item, priority);

        if (item == null) {
            throw new NullPointerException();
        }
        else if (front == null) {
            front = addnewNode;
        }

        else if (front.priority > addnewNode.priority) {
            addnewNode.next = front;
            front = addnewNode;

        } else {
            Node<E> current = front;
            while (current.next != null && current.next.priority <= addnewNode.priority) {
                current = current.next;
            }
            addnewNode.next = current.next;
            current.next = addnewNode;
        }
        size++;
        return true;
    }

    /**
     * addRear() adds item at the end of queue update the size accordingly.
     * @param item
     */
    public boolean addRear(E item) {
        Node<E> addnewNode = new Node<E>(item);

        if (item == null) {
            throw new NullPointerException();
        }
        if (front == null) {
            front = addnewNode;
        } else {
            Node<E> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = addnewNode;
        }
        size++;
        return true;
    }

    /**
     * @return - poll() returns the data at the front of the queue and removes it from the queue.
     */
    public E poll() {
        if (front == null) {
            throw new NullPointerException();
        } else {
            E copy = front.data;
            front= front.next;
            size--;
            return copy;
        }

    }

    /**
     * remove() takes a node to be removed and removes it from the queue and updates the size.
     * @param toBeRemoved
     * @return - It returns true if the node is successfully removed.
     */
    public boolean remove(Node<E> toBeRemoved){

        boolean isfound = false;
        if(front == null){
            isfound = false;
        }

        else if(front.data == toBeRemoved.data){
            front = front.next;
            isfound = true;
            size--;
        }

        else{
            Node<E> curr = front;
            while (curr.next != null && curr.next.getData() != toBeRemoved.data){
                curr = curr.next;
            }
            if(curr.next != null) {
                curr.next = curr.next.next;
                isfound = true;
                size--;
            }
        }
        return isfound;

    }

    /**
     * @return This method will return an instance of Iter class.
     */
    public Iterator<E> iterator(){
        return new Iter();
    }
}




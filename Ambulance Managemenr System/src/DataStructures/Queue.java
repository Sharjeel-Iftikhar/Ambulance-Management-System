/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.Serializable;

/**
 *
 * @author Aadi
 */
public class Queue<E> implements Serializable{
    private LinkedList<E> list = new LinkedList();
    // Method to add in Queue EnQueue
    public void EnQueue(E data)
    {
        this.list.insert(data);
    }
    
    // Method to DeQueue
    public E DeQueue()
    {
        return this.list.DeleteFromStart();
    }
    
    public E peek()
    {
        return this.list.head.data;
    }
    
    public int size()
    {
        return this.list.size();
    }
    
}

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
public class Stack<E> implements Serializable{
  private LinkedList<E> list = new LinkedList();
    // Method to push data in stack
    public void Push(E data)
    {
        boolean flag = this.list.isEmpty();
        if(flag==false)
        {
            this.list.AddAtHead(data);
            System.out.println("Data is pushed in Stack");
        }
        else
        {
            System.out.println("In else");
            Node nd = new Node(data);
            this.list.head = nd;
                    
        }
    }
    
    public int size()
    {
        return list.size();
    }
    
    public boolean empty()
    {
        return list.isEmpty();
    }
    // Method to pull data from stack
    public E Pop()
    {
        E a  = (E) this.list.DeleteFromStart();
        return a;
    }
    // Method of top to view the Top most element in Stack
    public E peek()
    {
        boolean flag = this.list.isEmpty();
        if(flag==false)
        {
            return (E) this.list.head.data;
            //System.out.println("Top most element in Stack is "+this.list.head.data);
        }
        else
        {
            System.out.println("Stack is Empty");
        }
      return null;
        
    }
    // Method to print whole stack
//    public void PrintStack()
//    {
//        this.list.Print();
//    }
}

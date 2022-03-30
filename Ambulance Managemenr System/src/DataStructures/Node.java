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
public class Node<E> implements Serializable{
    E data;
    Node<E> next;
    // Constructor
    Node(E d)
    {
        Node r = new Node();
        this.data=d;
        this.next=null;
    }
    // default constructor
    Node()
    {
    }
            
}

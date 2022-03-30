/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import AMS.Person;
import java.io.*;
import java.util.*;

/**
 *
 * @author Aadi
 */
public class LinkedList<E> implements Serializable{

    Node<E> head;

    public LinkedList() {
        head = null;
    }

    public int size() {

        if (head == null) {
            return 0;
        }
        int i = 1;
        Node end = this.head; // initializing Node end to head of the list
        while (end.next != null) {
            end = end.next;
            i++;
        }
        return i;
    }

    public E get(int index) {
        if (index < 0) {
            System.out.println("Invalid, index should be freater than or equal to 0");
        } else {
            Node temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("list index out of range ");
                    break;
                }
            }
            return (E) temp.data;
        }
        return null;
    }

    // Method to insert a new Node
    public void insert(E data) {

        Node newNd = new Node(data);
        if (this.head == null) {
            this.head = newNd;
        } else {

            Node end = this.head; // initializing Node end to head of the list

            while (end.next != null) {
                end = end.next;
            }
            // now insert at the end

            end.next = newNd;
        }
        //return list;
    }

//    public void insertNode(RBNode data)
//    {
//        
//        //Node newNd = new Node(data);
//        if(this.head==null)
//        {
//           this.head=data;
//        }
//        else
//        {
//            
//            Node end=this.head; // initializing Node end to head of the list
//            
//            while(end.next!=null){
//               end = end.next;
//            }
//            // now insert at the end
//            
//            end.next = newNd;
//        }
//        //return list;
//    }
    // Method to check if list is empty or not
    // return true if the list is empty otherwise false
    public boolean isEmpty() {
        boolean flag = false;
        Node now = this.head;
        if (now == null) {
            flag = true;
            //System.out.println("List is Empty");
        }
        return flag;
    }

    // Method to print the linkedlist
//    public void Print()
//    {
//        Node now = this.head;
//        if(this.head==null)
//        {
//            System.out.print("List is empty!!");
//        }
//        else
//        {
//            System.out.print("Linked list :");
//            while(now!=null) // here we take now because we have to check it at last elment
//            {
//               System.out.print(now.data+" , ");
//               now = now.next;
//            }
//        }
//    }
    // Method to add at the head
    public void AddAtHead(E data) {
        Node newNde = new Node();
        newNde.data = data;
        newNde.next = this.head;
        this.head = newNde;
    }

    public void set(E data, int index) {
        Node newNd = new Node(data);
        if (index < 1) {
            System.out.println("Invalid, index should be freater than or equal to 1");
        } else if (index == 1) {
            head.data = data;
        } else {
            Node temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("list index out of range ");
                    break;
                }
            }
            temp.data = data;
        }
    }

    // Method to insert at particular index
    public void insertAtIndex(E data, int index) {
        Node newNd = new Node(data);
        if (index < 1) {
            System.out.println("Invalid, index should be freater than or equal to 1");
        } else if (index == 1) {
            this.AddAtHead(data);
        } else {
            Node temp = this.head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("list index out of range ");
                    break;
                }
            }
            newNd.next = temp.next;
            temp.next = newNd;
        }
    }

    // Method to get object index wise
    public E getatIndex(int index) {
        if (index < 0) {
            System.out.println("Invalid, index should be freater than or equal to 0");
        } else {
            Node temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("list index out of range ");
                    break;
                }

            }
            return (E) temp.data;
        }
        return null;
    }

    ///////////////////////////////////// Deletion Functions///////////////////////////////////////\
    // Method to delete from start
    public E DeleteFromStart() {
        boolean flag = this.isEmpty();
        if (flag == false) {
            E a = this.head.data;
            //System.out.println("Removed data is "+this.head.data);
            this.head = head.next;
            return a;
        }
        return null;
    }

    // Method to delete from end
    public void DeleteFromEnd() {
        boolean flag = this.isEmpty();
        if (flag == false) {
            Node n = this.head;
            while (n.next.next != null) {
                n = n.next;
            }
            n.next = null;
        }
    }

    // Method to Delete All occurances of the list
    public void DeleteAllOccurance(E data) {
        boolean flag = this.isEmpty(); // checking is list is empty or not
        if (flag == false) {
            Node n = this.head;
            while (n != null && this.head != null) {  // checking head as null because in all similar list entitiy case we delete only from head
                if (this.head.data == data) {
                    this.DeleteFromStart();
                } else if (this.head.data != data && n.next != null && n.next.data == data) {
                    if (n.next.next != null) {
                        n.next = n.next.next; // moving to the next digit
                    } else {
                        n.next = null;
                    }
                } else {
                    n = n.next;
                }

            }
        }
    }

    // Method to delete the last occurnace of element
    public void DeleteLastOccurance(E data) {
        boolean flg = this.isEmpty();
        Node start = this.head;
        Node temp = this.head;
        int count = 0;
        if (flg == false) {
            while (start != null) {
                if (start.data == data) {
                    temp = start;
                }
                start = start.next;
            }
            if (count == 0) {
                System.out.println("Digit does not occur in list");
            } else if (temp == this.head && count != 0) {
                this.DeleteFromStart();
            } else if (temp.next == null) {
                this.DeleteFromEnd();
            } else {
                temp.data = temp.next.data;
                temp.next = temp.next.next;
            }

        }
    }

    public void remove(int index) {
        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
            if (temp == null) {
                System.out.println("list index out of range ");
                break;
            }
        }
        temp.data = temp.next.data;
        temp.next = temp.next.next;

//       } 
//        temp = temp.next;
    }

    public void remove_person(String id) {
        Node node;
        Node pre = new Node();
        node = this.head;
        Person pr = (Person)this.head.data;
        if(pr.getId_number().equals(id))
        {
            this.head = head.next;
        }
        else
        {
        while (node != null) {
            pr = (Person)node.data;
            
            if (pr.getId_number().equals(id)) {
                pre.next = node.next;
                break;
            }
            pre = node;
            node = node.next;
        }
        }
        
        
        
    }

    /////////////////////////////////////////// Methof to Search a digit in list /////////////////
    public boolean Search(E data) {
        boolean flg = this.isEmpty();
        if (flg == false) {
            Node st = this.head;
            while (st != null) {
                if (st.data == data) {
                    return true;
                    
                } else {
                    st = st.next;
                }
            }
        }
        return false;

    }

}

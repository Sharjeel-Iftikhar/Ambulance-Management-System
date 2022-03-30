/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
import AMS.Admin;
import AMS.Manager;
import AMS.Person;
/**
 *
 * @author Aadi
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> list = new LinkedList();
       
//          Queue qe = new Queue();
//          qe.EnQueue(6);
//          qe.EnQueue(8);
//          qe.EnQueue(1);
//          qe.EnQueue(9);
//          qe.DeQueue();
//          qe.DeQueue();
//        Stack st = new Stack();
//        st.Push(2);
//        st.Push(9);
//        st.Push(6);
//        st.Push(5);
//        st.Top();
//        st.Pop();
//        st.PrintStack();
//
//
        //Admin a = Admin.admin_instance();
        //list.insert(a);
        list.insert(4);
        list.insert(3);
        list.insert(5);
        list.insert(7);
//        System.out.println(list.get(2));
//        list.set(11, 2);
        list.remove(3);
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        // insert at index 2
//        //list.insertAtIndex(9, 2);
//       // list.DeleteLastOccurance(2);
//         
//        list.Search(6);
//        
//        // print 
        
    }
    
}

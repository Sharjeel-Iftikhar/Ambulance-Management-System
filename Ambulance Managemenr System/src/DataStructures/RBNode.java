/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
import AMS.Person;
/**
 *
 * @author m_nou
 */
class RBNode {
  Person person;
  RBNode parent;
  RBNode left;
  RBNode right;
  int color;
  
  
  public RBNode(Person key)
  {
      this.person =key;
      this.color = 1;
      this.left = null;
      this.right = null;
      this.parent = null;
  }
  
  

}
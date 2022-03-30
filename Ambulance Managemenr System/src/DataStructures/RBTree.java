package DataStructures;

import AMS.Person;

// Implementing Red-Black Tree in Java
public class RBTree {

    private RBNode root;

    public RBTree() {
        root = null;
    }

    public void insert(Person key) {
        RBNode node = new RBNode(key);

        RBNode y = null;
        RBNode x = this.root;

        while (x != null) {
            y = x;
            if (node.person.getEmploye_number() < x.person.getEmploye_number()) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.person.getEmploye_number() < y.person.getEmploye_number()) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }
//        if(node.parent.parent.left == null)
//        {
//        ret
//        }

        fixInsert(node);
    }

    private void fixInsert(RBNode k) {
        RBNode u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                System.out.println("color");
                System.out.println(u.color);
                System.out.println(u.person.getEmploye_number());
                System.out.println("adsad");
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    public void leftRotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(RBNode x) {
        RBNode y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private void deleteNodeHelper(RBNode node, int key) {
        RBNode z = null;
        RBNode x, y;
        while (node != null) {
            if (node.person.getEmploye_number() == key) {
                z = node;
            }

            if (node.person.getEmploye_number() <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (z == null) {
            System.out.println("Couldn't find key in the tree");
            return;
        }

        y = z;
        int yOriginalColor = y.color;
        if (z.left == null) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == null) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = min_node(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0) {
            fixDelete(x);
        }
    }

    // Inorder
    // Post order
//  private void postOrderHelper(Node node) {
//    if (node != TNULL) {
//      postOrderHelper(node.left);
//      postOrderHelper(node.right);
//      System.out.print(node.data + " ");
//    }
//  }
    // Search the tree
//  private Node searchTreeHelper(Node node, int key) {
//    if (node == null || key == node.data) {
//      return node;
//    }
//
//    if (key < node.data) {
//      return searchTreeHelper(node.left, key);
//    }
//    return searchTreeHelper(node.right, key);
//  }
    public RBNode findNode(RBNode root, int x) {
        try {
            if (root.person.getEmploye_number() == x) {
                return root;
            } else if (root.person.getEmploye_number() < x) {
                return this.findNode(root.right, x);
            } else if (root.person.getEmploye_number() > x) {
                return this.findNode(root.left, x);
            }

        } catch (Exception e) {
            return null;
        }
        return null;
    }

    // Balance the tree after deletion of a node
    private void fixDelete(RBNode x) {
        RBNode s;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    private void rbTransplant(RBNode u, RBNode v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    public int size(RBNode x) {
        int size = 1;
        if (x.right != null) {
            size = size + this.size(x.right);
        }
        if (x.left != null) {
            size = size + this.size(x.left);
        }
        return size;
    }

    public static LinkedList GetNodeOfSameType(String type, RBNode node) {
        LinkedList<Person> a = new LinkedList<>();

//        if (node == null) {
//            System.out.println("Tree is empty");
//        } else {
//            if (node.left != null) {
//                GetNodeOfSameType(type,node.left);
//            }
//            if(node.person.getType().equals(type))
//            {
//                a.insert(node);
//            }
//            if (node.right != null) {
//                GetNodeOfSameType(type,node.right);
//            }
//        }

        // Create an empty stack and push root to it
        Stack<RBNode> nodeStack = new Stack<RBNode>();
        nodeStack.Push(node);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            RBNode mynode = nodeStack.peek();
            if(mynode.person.getType().equals(type))
            {
                a.insert(node.person);
            }
            nodeStack.Pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.Push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.Push(mynode.left);
            }
        }
        return a;
    }
    // Balance the node after insertion

    private void printHelper(RBNode root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == 1 ? "RED" : "BLACK";
            System.out.println(root.person.getEmploye_number() + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

    public RBNode min_node(RBNode x) {
        if (this.root == null) {
            System.out.println("Tree is empty");
        } else if (x.left != null) {
            return this.min_node(x.left);
        } else if (x.left == null) {
            return x;
        }
        return null;
    }

    public RBNode max_node(RBNode x) {
        if (this.root == null) {
            System.out.println("Tree is empty");
        } else if (x.right != null) {
            return this.min_node(x.right);
        } else if (x.right == null) {
            return x;
        }
        return null;
    }

    public RBNode successor(RBNode x) {
        if (x != null) {
            if (x.right != null) {
                RBNode y = x.right;
                return this.min_node(y);
            } else if (x.right == null) {
                RBNode y = x;
                RBNode z = x.parent;
                while (true) {
                    if (y.person.getEmploye_number() == y.left.person.getEmploye_number()) {
                        return y;
                    } else {
                        y = z;
                        z = y.parent;
                    }
                }
            } else if (x.right == null && x.left == null) {
                return null;
            }
        }
        return null;
    }

    public RBNode predecessor(RBNode x) {
        if (x != null) {
            if (x.left != null) {
                RBNode y = x.left;
                return this.max_node(y);
            } else if (x.left == null) {
                RBNode y = x;
                RBNode z = x.parent;
                while (true) {
                    if (y.person.getEmploye_number() == y.right.person.getEmploye_number()) {
                        return y;
                    } else {
                        y = z;
                        z = y.parent;
                    }
                }
            } else if (x.right == null && x.left == null) {
                return null;
            }
        }
        return null;
    }

    public RBNode getRoot() {
        return this.root;
    }

    public void deleteNode(int data) {
        deleteNodeHelper(this.root, data);
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

    public void inorderWalk(RBNode node) {
        if (this.root == null) {
            System.out.println("Tree is empty");
        } else {
            if (node.left != null) {
                this.inorderWalk(node.left);
            }
            System.out.println(node.person.getEmploye_number());
            if (node.right != null) {
                this.inorderWalk(node.right);
            }
        }
    }

}

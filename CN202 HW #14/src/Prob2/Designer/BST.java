/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prob2.Designer;

import Prob3.Designer.*;
import Prob4.Designer.Queue;

/**
 *
 * @author somsa
 */
public class BST implements BSTADT {

    private Node root;

    public BST() {
        root = null;
    }

    public boolean isBST() {
        return isBST(root);
    }

    private boolean isBST(Node local) {
        if (local == null) {
            return true;
        }
        if ((local.getLeftChild() != null) && (local.getLeftChild().getKey() > local.getKey())) {
            return false;
        }
        if ((local.getRightChild() != null) && (local.getRightChild().getKey() < local.getKey())) {
            return false;
        }

        return isBST(local.getLeftChild()) && isBST(local.getRightChild());
    }

    public void insert(int i) {
        Node newNode = new Node(i, null, null);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = root;

            while (true) {
                parent = current;
                if (current.getKey() > i) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        break;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        break;
                    }
                }
            }

        }

    }

    public int findFloor(int x) {
        if (root == null) {
            return -1;
        } else {
            Node current = root;
            int target = current.getKey();

            while (current.getKey() != x) {
                if (current.getKey() > x) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
                if (current == null) {
                    break;
                } else {
                    target = current.getKey();
                }
            }

            if (target == x) {
                return 0;
            }
            else
                return target;
        }

    }
    
    public void traverseBFS()
    {
     Queue qNode = new Queue();
     
     qNode.insert(root);
     while(!qNode.isEmpty()){
         Node current = (Node)qNode.remove();
         
         System.out.print(current.getKey()+" ");
         if(current.getLeftChild() != null)
             qNode.insert(current.getLeftChild());
         if(current.getRightChild() != null)
             qNode.insert(current.getRightChild());
     }
        
    }
    
    

}

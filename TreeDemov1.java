class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
	    * Preorder traversal
	    * Prints the value of every node preorder
       * @param root the current Node in the tree
	    */
	   public void preOrderTraversal(Node root){
		   
         //base case
         if (root == null) {
            return;
         }
		   
         //print root value
         System.out.print(root.value + " ");
         
         //recur left
         preOrderTraversal(root.left);
         
         //recur right
         preOrderTraversal(root.right);
	   }

	   
	   
	   /**
       * Inorder traversal
       * Prints the value of every node in order
       * @param root the current Node in the tree
       */
	   public void inOrderTraversal(Node root){
	      
         //base case
         if (root == null) {
            return;
         }
         
         //recur left
         inOrderTraversal(root.left);
         
         //print the nodes value
         System.out.print(root.value + " ");
         
         //recur right
         inOrderTraversal(root.right);
	   }
	   
	   
	   
	   /**
       * PostOrderTraversal
       * Prints the value of each node in post order
       * @param root the current Node in the tree
       */
	  
	   public void postOrderTraversal(Node root){
         
         //base case
         if (root == null) {
            return;
         }
		   
         //recur left
         postOrderTraversal(root.left);
         
         //recur right
         postOrderTraversal(root.right);
         
         //print the current nodes value
         System.out.print(root.value + " ");
	   }
	   
	   
	   
	   /**
	    * A method to find the node in the tree
	    * with a specific value
       * @param root the root node value 
       * @param key the number to find
       * @return boolean
	    */
	   public boolean find(Node root, int key){
		 
         //base cases 
         if (root == null) {
            return false;
         }
         
         if (root.value == key) {
            return true;
         }
		   
         //recur left
         boolean result1 = find(root.left, key);
         
         //key is in left subtree
         if (result1) {
            return true;
         }
         
         //search right subtree
         boolean result2 = find(root.right, key);
         
         return result2;
	   }
	   
	   
	   
	   /**
	    * A method to find the node in the tree with the smallest key
	    * @param the root Node
       * @return the smallest value in the tree
	    */
	   public int getMin(Node root){
         
         //base case
         if (root.left == null) {
            return root.value;
         }
	      
         //recur left until last node is reached
         return getMin(root.left);
	   }
	  
	  
	  
	   /**
	    * A method to find the node in the tree with the largest key
	    * @param the root Node
       * @return the largest value in the tree
	    */
	   public int getMax(Node root){
         
         //base case
         if (root.right == null) {
            return root.value;
         }
	      
         //recur right until last node is reached
         return getMin(root.right);   
	   }
	   
      
      
	   /**
	    * A method to delete the node in the tree with the key passed in
	    * @param the root Node
       * @param the key value to be deleted
       * @return the root Node
	    */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	      
         //test the implemented methods      
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	      
         System.out.print("pre-order :   ");
	      t1.preOrderTraversal(t1.root);     
	      System.out.println();
         
         System.out.print("post-order :   ");
	      t1.postOrderTraversal(t1.root);     
	      System.out.println();
         
         System.out.print("min number in tree: " + t1.getMin(t1.root));
         System.out.println();
         
         System.out.print("max number in tree: " + t1.getMax(t1.root));
         System.out.println();
         
         System.out.print("Test to see if 100 is in the tree: " + t1.find(t1.root, 100));
	   }  
	}

package BST_A2;

public class BST_Node {
  BST_Node root;
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s){
	  {
		    int compare = data.compareTo(s);
		    
		    if (compare == 0) {
		      return true;
		    }
		    if (compare > 0) {
			      if (getLeft() != null) {
			        return left.containsNode(s);
			      }
			      return false;
			    }
		    if (compare < 0) {
		      if (getRight() != null) {
		        return right.containsNode(s);
		      }
		      return false;
		    }
		    
		    return false;
	  }
}
  public boolean insertNode(String s){
  if(data.compareTo(s) > 0) {
	  if(left == null) {
		  left = new BST_Node(s);
		  return true;
	  }
	  return left.insertNode(s);
  	}
  if(data.compareTo(s) < 0) {
	  if(right == null) {
		  right = new BST_Node(s);
		  return true;
	  }
	  return right.insertNode(s);
  	}
  return false;
  }
  public boolean removeNode(String s){ 
	  if (data == null) 
		  {
		  return false;
		  }
	    if (data.equals(s)) {
	      if (left != null) {
	        data = left.findMax().data;
	        left.removeNode(data);
	        if (left.data == null) left = null;
	      }
	      else if (right != null) {
	        data = right.findMin().data;
	        right.removeNode(data);
	        if (right.data == null) right = null;
	      } else {
	        data = null; }
	      return true;
	    }
	    if (data.compareTo(s) < 0) {
		      if (right == null) 
		    	  return false;
		      if (!right.removeNode(s)) 
		    	  return false;
		      if (right.data == null) 
		    	  right = null;
		      return true;
		    }
	    if (data.compareTo(s) > 0) {
	      if (left == null) 
	    	 return false;
	      if (!left.removeNode(s)) 
	    	  return false;
	      if (left.data == null) 
	    	  left = null;
	      return true;
	    }
	    
	    return false;
	  }
  public BST_Node findMin(){ 
	 if(left != null) {
		 return left.findMin();
	 }
	 return this;
}
  public BST_Node findMax(){ 
	  if(right != null) {
		  return right.findMax();
	  }
	  return this;
  }
  public int getHeight(BST_Node node){ 
	
	  if(node == null) {
		  return -1;
	  }
	 int leftHeight = getHeight(node.left);
	 int rightHeight = getHeight(node.right);
	 return Math.max(leftHeight, rightHeight) + 1;
}
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
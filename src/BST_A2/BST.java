package BST_A2;

public class BST implements BST_Interface {
    public BST_Node root;
    int size;

    public BST(){ size=0; root=null; }

    @Override
    //used for testing, please leave as is
    public BST_Node getRoot(){ return root; }

    @Override
    public boolean insert(String s) {
        // TODO Auto-generated method stub
        if(root == null) {
            root = new BST_Node(s);
            size+=1;
            return true;
        }
        if(root.insertNode(s)) {
            size+=1;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String s) {
        // TODO Auto-generated method stub
        if(root == null) {
            return false;
        }
        if(size == 1 && root.data.equals(s)) {
            root = null;
            size-=1;
            return true;
        }
        if(root.removeNode(s)) {
            size-=1;
            return true;
        }
        return false;
    }

    @Override
    public String findMin() {
        // TODO Auto-generated method stub
        if(root != null)  {
            return root.findMin().getData();
        }
        return null;
    }

    @Override
    public String findMax() {
        // TODO Auto-generated method stub
        if(root != null) {
            return root.findMax().getData();
        }
        return null;
    }

    @Override
    public boolean empty() {
        // TODO Auto-generated method stub
        if(root == null || size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String s) {
        // TODO Auto-generated method stub
        if(size == 0) {
            return false;
        }
        if(root.containsNode(s)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        if(root == null) {
            return -1;
        }
        return root.getHeight(root);
    }

}
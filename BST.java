class NodeB {
    String key;
    NodeB parent;
    NodeB left;
    NodeB right;
    
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public NodeB getParent() {
        return parent;
    }
    
    public void setParent(NodeB parent) {
        this.parent = parent;
    }

    public NodeB getLeft() {
        return left;
    }
    
    public void setLeft(NodeB left) {
        this.left = left;
    }

    public NodeB getRight() {
        return right;
    }
    
    public void setRight(NodeB right) {
        this.right = right;
    }
}

class BST {
  NodeB root;
  
  public BST() { this.root = null; }
  public void setRoot(NodeB root) { this.root = root; }
  public NodeB getRoot() { return this.root; }
  
  public int searchNode(String key) {
    NodeB temp = this.root;
    int count = 0;
    while (temp != null) {
      int compareValue = key.compareTo(temp.getKey());
        
      if (compareValue == 0)
        count++;
        
      if (compareValue < 0)
        //search LEFT
        temp = temp.getLeft();
        
      else
        //search RIGHT
        temp = temp.getRight();
    }
    return count;
  }
  
  public void insertNode(String value) {
    //A new node is created. This node will be inserted in the 
    //binary search tree
    NodeB node = new NodeB();
    node.setKey(value); 
    node.setParent(null);
    node.setLeft(null);
    node.setRight(null);
    
    //If the tree is empty, the new node is the root
    if(this.root == null) {
      this.root = node;
    } 
    else { 
      //If it is not empty
      NodeB parentNode = null;
      NodeB temp = this.root;
      while(temp != null) {
        parentNode = temp;
        //What does the compareTo method do?
        //the magic happens here
        int compareValue = node.getKey().compareTo(temp.getKey());
        if(compareValue <= 0) {
          temp = temp.getLeft();
        } 
        
        else {
          temp = temp.getRight();
        }
        }
      
      node.setParent(parentNode);

      if(node.getKey().compareTo(parentNode.getKey()) <= 0) {
        parentNode.setLeft(node);
      } 
      
      else {
        parentNode.setRight(node);
      }
    }
  }
  
}
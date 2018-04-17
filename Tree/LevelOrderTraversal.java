class Node{
    int data;
    Node left;
    Node right;
    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class CreateTestTree{
    public static Node createTree1(){
        Node t1 = new Node(1,null,null);
        t1.left = new Node(2,null,null);
        t1.right = new Node(3,null,null);

        t1.left.left = new Node(4,null,null);
        t1.left.right = new Node(5,null,null);
        
        t1.right.left = new Node(6,null,null);
        t1.right.right = new Node(7,null,null);

        return  t1;
    }
}

class TreeReaderRecursion{
    
    /**
        This processData is general method and user can do anything whatever he
        wants to do in this method for processing of the data

     */

    public void processData(int data){
        System.out.println(data);
    }

    
    /**
        process  root
        process left subtree
        process right subtree
     */
    public void preOrderTraversal(Node node){
        if(node != null){
            processData(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    
    /**
        process left subtree
        process  root
        process right subtree
     */
    public void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.left);
            processData(node.data);        
            inOrderTraversal(node.right);
        }
    }

    /**
        process left subtree
        process right subtree
        process  root
     */
    public void postOrderTraversal(Node node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            processData(node.data);        
        }
    }
}

class Main{
    public static void main(String ...argv){
        Node node1 = CreateTestTree.createTree1();
        TreeReaderRecursion treeRR = new TreeReaderRecursion();
        
        System.out.println("Pre Order Traversal");
        treeRR.preOrderTraversal(node1);
        System.out.println("------------------------------------------------------------------");
        
        System.out.println("Post Order Traversal");
        treeRR.postOrderTraversal(node1);
        System.out.println("------------------------------------------------------------------");

        System.out.println("In Order Traversal");
        treeRR.inOrderTraversal(node1);
        System.out.println("------------------------------------------------------------------");
    }
}
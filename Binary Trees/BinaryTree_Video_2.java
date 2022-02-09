import java.util.*;

public class BinaryTree_Video_2 {
    public static void main(String [] args){
        
        BinaryTree bt = new BinaryTree();
        bt.display();

    }
}

class BinaryTree{

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    BinaryTree(){
        
        Scanner s = new Scanner(System.in);
        this.root = constructBT(s, null, false);
    }

    private Node constructBT(Scanner s, Node parent, boolean ilc){

        if(parent == null){
            System.out.println("Enter the data for root node");
        }else{
            if(ilc){
                System.out.println("Enter the data for left child of " + parent.data);
            }else{
                System.out.println("Enter the data for right child of " + parent.data);
            }
        }

        int nodeData = s.nextInt();
        Node node = new Node(nodeData, null, null);

        System.out.println("Add a left child for " + node.data + " ?");
        if(s.nextBoolean()){
            node.left = constructBT(s, node, true);
        }


        System.out.println("Add a right child for " + node.data + " ?");
		if(s.nextBoolean()){
            node.right = constructBT(s, node, false);
        }

        return node;
    }


    public void display(){
		display(this.root);
	}

    private void display(Node node){


        if(node == null){
            return;
        }


        String str = "";
		
        if(node.left != null)
			str += node.left.data + " => ";
		else 
			str += "END=> ";


        str += node.data;

        if(node.right != null)
            str += " <= " + node.right.data;
        else
            str += " <= END";

        System.out.println(str);

        display(node.left);
		display(node.right);
		
	}

}

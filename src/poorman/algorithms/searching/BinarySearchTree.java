package poorman.algorithms.searching;


public class BinarySearchTree {

	Node rootNode;
	
	
	public void add(int key) {
		
		Node newNode = new Node(key);
					
					
		if(rootNode == null)
			rootNode = newNode;
		else {
			Node focusedNode = rootNode;
			Node parentNode;
			
			while(true) {
				
				parentNode = focusedNode;
				if(focusedNode.key > key) {
					focusedNode = focusedNode.leftChild;
					
					if(focusedNode == null) {
						parentNode.leftChild = newNode;
						return;
					}
				} else {
					focusedNode = focusedNode.rightChild;
					
					if(focusedNode == null) {
						parentNode.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void addAllModify() {
		Sum sum = new Sum();
		
		addAllModify(rootNode, sum);
	}
	
	private void addAllModify(Node focusNode, Sum sum) {
		 if (focusNode != null) {
			 
            addAllModify(focusNode.rightChild, sum);
            
            sum.update(focusNode);
            updateNode(focusNode, sum);
		 	
		 	addAllModify(focusNode.leftChild, sum);
		 }
	}

	private void updateNode(Node node, Sum sum) {
		 node.key = sum.sum;
	}

       
	

	public void printTree() {
		printTree(rootNode);
	}
	
	private void printTree(Node focusNode) {

        if (focusNode != null) {

        	printTree(focusNode.leftChild);

            System.out.println(focusNode);

            printTree(focusNode.rightChild);
        }
	}


	class Sum {
		int sum;
		
		void update(Node node){
			sum = sum + node.key;
		}
	}
	
	class Node {
		
		int key;
		
		Node leftChild;
		Node rightChild;
		
		public Node(int key) {
			this.key = key;
		}
		
		public String toString() {
			return Integer.toString(key);
		}
	}
	
}

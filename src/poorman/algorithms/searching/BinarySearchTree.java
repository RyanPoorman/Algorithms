package poorman.algorithms.searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

	Node rootNode;
	List<Integer> nodes;

	public void add(int key) {

		Node newNode = new Node(key);

		if (rootNode == null)
			rootNode = newNode;
		else {
			Node focusedNode = rootNode;
			Node parentNode;

			while (true) {

				parentNode = focusedNode;
				if (focusedNode.key > key) {
					focusedNode = focusedNode.leftChild;

					if (focusedNode == null) {
						parentNode.leftChild = newNode;
						return;
					}
				} else {
					focusedNode = focusedNode.rightChild;

					if (focusedNode == null) {
						parentNode.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean remove(int key) {
		if (rootNode == null)
			return false;
		else {
			if (rootNode.key == key) {
				Node node = new Node(0);
				node.leftChild = rootNode;
				boolean result = rootNode.remove(key, node);
				rootNode = node.leftChild;
				return result;
			} else {
				return rootNode.remove(key, null);
			}
		}
	}

	public void addAllNodesFactorial() {
		Sum sum = new Sum();

		addAllNodesFactorial(rootNode, sum);
	}

	private void addAllNodesFactorial(Node focusNode, Sum sum) {
		if (focusNode != null) {

			addAllNodesFactorial(focusNode.rightChild, sum);

			sum.update(focusNode);
			updateNode(focusNode, sum);

			addAllNodesFactorial(focusNode.leftChild, sum);
		}
	}

	private void updateNode(Node node, Sum sum) {
		node.key = sum.sum;
	}

	public List<Integer> getNodeKeysAsList() {
		nodes = new ArrayList<Integer>();
		return getNodeKeysAsList(rootNode);
	}

	private List<Integer> getNodeKeysAsList(Node focusNode) {

		if (focusNode != null) {

			getNodeKeysAsList(focusNode.leftChild);

			nodes.add(focusNode.key);

			getNodeKeysAsList(focusNode.rightChild);
		}

		return nodes;
	}

	public int size() {
		return size(rootNode);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + size(node.leftChild) + size(node.rightChild);
	}

	public int getLeafCount() {
		if (rootNode == null) {
			return 0;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(rootNode);
		int count = 0;
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.leftChild != null) {
				stack.push(node.leftChild);
			}
			if (node.rightChild != null) {
				stack.push(node.rightChild);
			}
			if (node.rightChild == null && node.leftChild == null)
				count++;
		}
		return count;
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

	public void printChildren(int key) {
		Node node = findNode(key);
		printTree(node);
	}

	private Node findNode(int key) {
		Node node = findNode(key, rootNode);
		return node;
	}

	private Node findNode(int key, Node focusNode) {

		if (focusNode != null) {

			if (focusNode.key == key) {
				System.out.println(focusNode.key);
				return focusNode;
			}

			findNode(key, focusNode.leftChild);

			findNode(key, focusNode.rightChild);
		}

		return null;
	}

	public boolean nodeExists(int key) {
		if (rootNode == null)
			return false;
		else
			return rootNode.search(key);
	}

	public boolean nodeExists(Node node) {
		if (node == null) {
			return false;
		} else {
			return node.search(node.key);
		}
	}

	public boolean hasChildren(int key) {
		if (rootNode == null) {
			return false;
		} else {
			Node node = rootNode.getNode(key);
			if (node != null) {
				return hasChildren(node);
			}
			return false;
		}
	}

	public boolean hasChildren(Node node) {
		if (node == null) {
			return false;
		} else {
			if (node.getNode(node.key) != null) {
				return node.hasChildren(node.key);
			}
			return false;
		}
	}

	class Sum {
		int sum;

		void update(Node node) {
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

		public boolean search(int key) {

			if (key == this.key)
				return true;
			else if (key < this.key) {
				if (leftChild == null)
					return false;
				else
					return leftChild.search(key);
			} else if (key > this.key) {
				if (rightChild == null)
					return false;
				else
					return rightChild.search(key);
			}
			return false;
		}

		public Node getNode(int key) {

			if (key == this.key) {
				return this;
			} else if (key < this.key) {
				if (leftChild == null) {
					return null;
				} else {
					return leftChild.getNode(key);
				}
			} else if (key > this.key) {
				if (rightChild == null) {
					return null;
				} else {
					return rightChild.getNode(key);
				}
			}
			return null;
		}

		public boolean remove(int value, Node parent) {
			if (value < this.key) {
				if (leftChild != null)
					return leftChild.remove(value, this);
				else
					return false;
			} else if (value > this.key) {
				if (rightChild != null)
					return rightChild.remove(value, this);
				else
					return false;
			} else {
				if (leftChild != null && rightChild != null) {
					this.key = rightChild.minValue();
					rightChild.remove(this.key, this);
				} else if (parent.leftChild == this) {
					parent.leftChild = (leftChild != null) ? leftChild : rightChild;
				} else if (parent.rightChild == this) {
					parent.rightChild = (leftChild != null) ? leftChild : rightChild;
				}
				return true;
			}
		}

		public int minValue() {
			if (leftChild == null)
				return key;
			else
				return leftChild.minValue();
		}

		public boolean hasChildren(int key) {
			return (rightChild != null || leftChild != null);
		}

	}

}

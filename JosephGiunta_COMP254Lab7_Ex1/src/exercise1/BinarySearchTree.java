package exercise1;

public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public Node treeSearchIterative(Node p, int key) {
        while (p != null) {
            if (key == p.key) {
                return p;
            } else if (key < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int key : keys) {
            bst.insert(key);
        }
        System.out.println("Binary Search Tree created with keys: " + java.util.Arrays.toString(keys));

        int searchKey1 = 60;
        int searchKey2 = 99;

        System.out.println("\n Testing Iterative Tree Search");
        Node result1 = bst.treeSearchIterative(bst.root, searchKey1);
        if (result1 != null) {
            System.out.println("Iterative Search: Node with key " + searchKey1 + " found");
        } else {
            System.out.println("Iterative Search: Node with key " + searchKey1 + " not found.");
        }

        Node result2 = bst.treeSearchIterative(bst.root, searchKey2);
        if (result2 != null) {
            System.out.println("Iterative Search: Node with key " + searchKey2 + " found");
        } else {
            System.out.println("Iterative Search: Node with key " + searchKey2 + " not found.");
        }
    }
}

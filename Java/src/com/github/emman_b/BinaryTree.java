package com.github.emman_b;

public class BinaryTree<T> extends Collections {
    /**
     * Binary tree node inner class for holding data
     * in the BinaryTree
     */
    protected class BinaryTreeNode {
        // fields
        private T data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        // constructors

        /**
         * Creates a new BinaryTreeNode without children
         * @param data
         */
        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        // methods

        /**
         * Retrieves the left child of this node
         * @return the left child of this node
         */
        public BinaryTreeNode getLeft() {
            return this.left;
        }

        /**
         * Retrieves the right child of this node
         * @return the right child of this node
         */
        public BinaryTreeNode getRight() {
            return this.right;
        }

        /**
         * Retrieves the data at the node
         * @return the data at the node
         */
        public T getData() {
            return this.data;
        }
    }

    // fields
    private BinaryTreeNode root;
    private int size;

    // constructors

    /**
     * Constructs BinaryTree with null root node
     */
    public BinaryTree() {
        root = null;
        size = 0;
    }

    // lookup methods

    /**
     * Retrieves the size of the tree
     * @return the size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves the root node
     * @return the root node
     */
    public BinaryTreeNode getRoot() {
        return root;
    }

    /**
     * Turns the binary tree into an Object array. This should match how insertion is done in the tree in which
     * a level-order traversal is needed
     * @return
     */
    @Override
    public Object[] toObjectArray() {
        Object[] data = new Object[size];
        int index;

        // level-order traversal
        Queue<BinaryTreeNode> queue = new Queue<>();

        return data;
    }

    // manipulation methods

    /**
     * Inserts into the binary tree in an unordered manner. The insert is done using level traversal, attempting to
     * find the first empty node.
     * @param value the value to insert
     */
    public void add(T value) {
        // unique case: root is null, so make a new BTN there
        if (root == null) {
            root = new BinaryTreeNode(value);
            ++size;
            return; // leave
        }

        // use queues for level-order traversal
        Queue<BinaryTreeNode> nodes = new Queue<>();
        nodes.enqueue(root);

        // traverse through the tree in level-order
        BinaryTreeNode current = nodes.dequeue();
        // boolean for checking if it's the left node or right node
        boolean isLeftOfCurrent = false;
        // loop while the current node isn't null
        while (current != null) {
            // check the left node if it's not null
            if (current.left == null) {
                // if it is, set the corresponding boolean
                isLeftOfCurrent = true;
                // leave the loop
                break;
            } else {
                // otherwise, add the left node to the queue
                nodes.enqueue(current.left);
            }

            // do the same thing for the right side
            if (current.right == null) {
                // if it is, isLeftOfCurrent is already false so we do nothing except leave the loop
                break;
            } else {
                // otherwise, add the right node to the queue
                nodes.enqueue(current.right);
            }

            // set the current for the next loop
            current = nodes.dequeue();
        }

        // at this point, the node can be added to the tree. Use isLeftOfCurrent to decide where to add it
        if (isLeftOfCurrent) {
            current.left = new BinaryTreeNode(value);
        } else {
            current.right = new BinaryTreeNode(value);
        }
        // increment size
        ++size;
    }

    /**
     * Gets the preorder traversal of the tree
     * @return the array representation of the traversal
     */
    public T[] getPreorderTraversal() {
        // list for storing traversal information
        DoublyLinkedList<T> traversalList = new DoublyLinkedList<>();

        // run a function that recursively traverses the tree
        preorderTraverse(traversalList, root);

        // convert the list into an array
        T[] traversalArray = (T[]) new Object[size];
        for (int i = 0; i < size; ++i) {
            traversalArray[i] = traversalList.popFront();
        }
        return traversalArray;
    }

    /**
     * Helper function for traversing pre-order
     * @param traversalList the list to add to when traversing
     * @param current the current node in the traversal
     */
    private void preorderTraverse(DoublyLinkedList<T> traversalList, BinaryTreeNode current) {
        if (current != null) {
            // add current to the list
            traversalList.pushBack(current.data);
            // recurse into the left and right children
            preorderTraverse(traversalList, current.left);
            preorderTraverse(traversalList, current.right);
        }
    }

    public T[] getInorderTraversal() {
        // list for storing traversal information
        DoublyLinkedList<T> traversalList = new DoublyLinkedList<>();

        inorderTraverse(traversalList, root);

        // convert the list into an array
        T[] traversalArray = (T[]) new Object[size];
        for (int i = 0; i < size; ++i) {
            traversalArray[i] = traversalList.popFront();
        }
        return traversalArray;
    }

    private void inorderTraverse(DoublyLinkedList<T> traversalList, BinaryTreeNode current) {
        if (current != null) {
            // traverse to the left, add the current to the list, then traverse to the right
            inorderTraverse(traversalList, current.left);
            traversalList.pushBack(current.data);
            inorderTraverse(traversalList, current.right);
        }
    }

    public T[] getPostorderTraversal() {
        // list for storing traversal information
        DoublyLinkedList<T> traversalList = new DoublyLinkedList<>();

        postorderTraverse(traversalList, root);

        // convert the list into an array
        T[] traversalArray = (T[]) new Object[size];
        for (int i = 0; i < size; ++i) {
            traversalArray[i] = traversalList.popFront();
        }
        return traversalArray;
    }

    private void postorderTraverse(DoublyLinkedList<T> traversalList, BinaryTreeNode current) {
        if (current != null) {
            // traverse to the left, traverse to the right, and then add the current to the list
            postorderTraverse(traversalList, current.left);
            postorderTraverse(traversalList, current.right);
            traversalList.pushBack(current.data);
        }
    }
}

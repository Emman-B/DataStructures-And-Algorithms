package com.github.emman_b.datastructures;

import com.github.emman_b.datastructures.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void EmptyBT_ShouldHaveZeroSize() {
        // create the binary tree
        BinaryTree<Integer> tree = new BinaryTree<>();

        // verify the size is 0
        assertEquals(0, tree.size());
    }

    @Test
    void EmptyBT_WhenRetrievingRoot_ShouldBeNull() {
        // create the tree
        BinaryTree<String> tree = new BinaryTree<>();

        // verify the root is null
        assertNull(tree.getRoot());
    }

    @Test
    void BT_WhenAddingOneItem_ShouldHaveItemStored() {
        // create the tree
        BinaryTree<Integer> tree = new BinaryTree<>();

        // add item
        tree.add(5);

        // verify the root has the correct value
        assertEquals(5, tree.getRoot().getData());
    }

    @Test
    void BT_WhenAddingManyItems_ShouldHaveAllItemsStoredInLevelOrder() {
        // create the tree
        BinaryTree<Integer> tree = new BinaryTree<>();

        // add the items
        for (int i = 1; i <= 5; ++i) {
            tree.add(i);
        }

        // get the items
        int one = tree.getRoot().getData();
        int two = tree.getRoot().getLeft().getData();
        int three = tree.getRoot().getRight().getData();
        int four = tree.getRoot().getLeft().getLeft().getData();
        int five = tree.getRoot().getLeft().getRight().getData();

        // verify the items are in level order
        assertEquals(1, one);
        assertEquals(2, two);
        assertEquals(3, three);
        assertEquals(4, four);
        assertEquals(5, five);
    }

    @Test
    void BT_WhenAddingManyItems_ShouldHaveCorrectPreorderTraversal() {
        // create the tree and insert the data in level order
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 1; i <= 5; ++i) {
            tree.add(i);
        }

        // create the expected preorder traversal
        Integer[] expectedData = new Integer[] { 1, 2, 4, 5, 3 };

        // verify the expected data
        assertArrayEquals(expectedData, tree.getPreorderTraversal());
    }

    @Test
    void BT_WhenAddingManyItems_ShouldHaveCorrectInorderTraversal() {
        // create the tree and insert the data in level order
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 1; i <= 5; ++i) {
            tree.add(i);
        }

        // create the expected inorder traversal
        Integer[] expectedData = new Integer[] { 4, 2, 5, 1, 3 };

        // verify the expected data
        assertArrayEquals(expectedData, tree.getInorderTraversal());
    }

    @Test
    void BT_WhenAddingManyItems_ShouldHaveCorrectPostorderTraversal() {
        // create the tree and insert the data in level order
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 1; i <= 5; ++i) {
            tree.add(i);
        }

        // create the expected postorder traversal
        Integer[] expectedData = new Integer[] { 4, 5, 2, 3, 1 };

        // verify the expected data
        assertArrayEquals(expectedData, tree.getPostorderTraversal());
    }
}
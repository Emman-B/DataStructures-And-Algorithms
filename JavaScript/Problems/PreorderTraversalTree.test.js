/*
    Problem: Perform a preorder traversal of a binary search tree. You
    need to complete this twice, with recursion and without recursion.
*/
const TreeNode = require('../DataStructures/BinaryTreeNode.js');

function preorderRecursive(root) {
    // case: empty tree
    if (root == null) return [];

    const result = [];

    var recurse = function(current) {
        if (current != null) result.push(current.value);
        else return;
        recurse(current.left);
        recurse(current.right);
    }

    recurse(root);
    return result;
}

function preorderIterative(root) {
    // case: empty tree
    if (root == null) return [];

    const stack = [];
    const result = [];

    stack.push(root);
    while (stack.length > 0) {
        const current = stack.pop();
        result.push(current.value);
        if (current.right) {
            stack.push(current.right);
        }
        if (current.left) {
            stack.push(current.left);
        }
    }

    return result;
}

test('Preorder Recursive Traversal test with empty tree should return empty array', () => {
    // Setup
    const root = undefined;

    // Exercise
    const traversal = preorderRecursive(root);

    // Verify
    expect(traversal).toEqual([]);
});

test('Preorder Iterative Traversal test with empty tree should return empty array', () => {
    // Setup
    const root = undefined;

    // Exercise
    const traversal = preorderIterative(root);

    // Verify
    expect(traversal).toEqual([]);
});

test('Preorder Recursive Traversal test with tree of one element should return array of that one element', () => {
    // Setup
    const root = new TreeNode(23);

    // Exercise
    const traversal = preorderRecursive(root);

    // Verify
    expect(traversal).toEqual([23]);
});

test('Preorder Iterative Traversal test with tree of one element should return array of that one element', () => {
    // Setup
    const root = new TreeNode(17);

    // Exercise
    const traversal = preorderIterative(root);

    // Verify
    expect(traversal).toEqual([17]);
});

test('Preorder Recursive Traversal test with tree of many elements should return correct array', () => {
    // Setup (build a tree with multiple nodes)
    const root = new TreeNode(100);
    root.left = new TreeNode(50);
    root.right = new TreeNode(150);
    root.left.left = new TreeNode(25);
    root.left.right = new TreeNode(75);
    root.right.left = new TreeNode(125);
    root.right.right = new TreeNode(175);
    root.right.left.left = new TreeNode(110);

    // Exercise
    const traversal = preorderRecursive(root);

    // Verify
    expect(traversal).toEqual([100, 50, 25, 75, 150, 125, 110, 175]);
});

test('Preorder Iterative Traversal test with tree of many elements should return correct array', () => {
    // Setup (build a tree with multiple nodes)
    const root = new TreeNode(100);
    root.left = new TreeNode(50);
    root.right = new TreeNode(150);
    root.left.left = new TreeNode(25);
    root.left.right = new TreeNode(75);
    root.right.left = new TreeNode(125);
    root.right.right = new TreeNode(175);
    root.right.left.left = new TreeNode(110);

    // Exercise
    const traversal = preorderIterative(root);

    // Verify
    expect(traversal).toEqual([100, 50, 25, 75, 150, 125, 110, 175]);
});

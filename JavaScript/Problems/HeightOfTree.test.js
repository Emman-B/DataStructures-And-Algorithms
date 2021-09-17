/*
    Problem: Write a function used to calculate the height of an
    arbitrary tree.
*/
const TreeNode = require('../DataStructures/BinaryTreeNode.js');

function getHeight(root) {
    // case: empty tree has 0 height
    if (root == null) return 0;

    // Recursive helper function that keeps track of height values
    var helper = function(height, current) {
        // case: reaching leaf, we want the current height
        if (current.left == null & current.right == null) {
            return height;
        }

        // recurse into children
        const results = [];
        if (current.left != null) {
            results.push(helper(height + 1, current.left));
        }
        if (current.right != null) {
            results.push(helper(height + 1, current.right));
        }
        
        if (results.length === 2) {
            // case: both left and right were non-null
            return Math.max(...results);
        } else {
            // case: only one result, return that height
            return results[0];
        }
    }

    return helper(1, root);
}

test('Calculate height of empty tree, expecting 0', () => {
    // Setup, Exercise, Verify
    expect(getHeight(null)).toBe(0);
});

test('Calculate height of tree with only root, expecting 1', () => {
    // Setup
    const root = new TreeNode(5);
    
    // Exercise, Verify
    expect(getHeight(root)).toBe(1);
});

test('Calculate height of tree with many nodes, expecting 4', () => {
    // Setup
    const root = new TreeNode('A');
    // level 1
    root.left = new TreeNode('B');
    root.right = new TreeNode('C');
    // level 2
    root.right.left = new TreeNode('D');
    root.right.right = new TreeNode('E');
    // level 3
    root.right.left.left = new TreeNode('F');
    root.right.left.right = new TreeNode('G');
    root.right.right.right = new TreeNode('H');

    // Exercise
    const height = getHeight(root);

    // Verify
    expect(height).toBe(4);
});

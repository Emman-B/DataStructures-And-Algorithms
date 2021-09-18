/*
    Given a Binary Search Tree (generalizing it to be just a binary tree)
    and given two nodes in the tree, find the lowest common ancestor
    between the nodes.
*/

const TreeNode = require('../DataStructures/BinaryTreeNode.js');


function lowestCommonAncestor(root, node1, node2) {
    // case: if node1 or node2 is root, then there is no common ancestor
    if (node1 === root || node2 === root) {
        return undefined;
    }

    const parentMap = new Map(); // this maps nodes to their parents

    // go through all of the nodes and identify their parents
    parentMap.set(root, undefined); // root has no parent

    // use stack for iterating through the tree
    const stack = [root];

    // do a DFS search
    while (stack.length > 0) {
        const parent = stack.pop();
        if (parent.right !== undefined && parent.right !== null) {
            stack.push(parent.right);
            parentMap.set(parent.right, parent);
        }
        if (parent.left !== undefined && parent.left !== null) {
            stack.push(parent.left);
            parentMap.set(parent.left, parent);
        }
    }

    // now, create two lists using the parent map and the provided nodes
    const node1Path = [];
    const node2Path = [];
    let n1Itor = parentMap.get(node1);
    let n2Itor = parentMap.get(node2);
    while (n1Itor != null) {
        node1Path.push(n1Itor);
        n1Itor = parentMap.get(n1Itor);
    }
    node1Path.reverse();
    while (n2Itor != null) {
        node2Path.push(n2Itor);
        n2Itor = parentMap.get(n2Itor);
    }
    node2Path.reverse();
    
    // Now we have both paths, we need to iterate until we find an uncommon ancestor
    let commonAncestor = root; // the root should be the most common ancestor
    for (let i = 1; i < Math.min(node1Path.length, node2Path.length); ++i) {
        if (node1Path[i] === node2Path[i]) {
            commonAncestor = node1Path[i];
        } else {
            break;
        }
    }

    return commonAncestor;
}


test('LCA of tree with many nodes should provide correct common ancestor', () => {
    // Setup
    const root = new TreeNode(20);
    let current = root; // this is for moving around the tree for easier setup
    current.left = new TreeNode(8);
    current.right = new TreeNode(22);
    current = current.left;
    current.left = new TreeNode(4);
    current.right = new TreeNode(12);
    current = current.right;
    current.left = new TreeNode(10);
    current.right = new TreeNode(14);

    const node1 = root.left.left; // should be node 4
    const node2 = root.left.right.right; // should be node 14
    const expectedAnswer = root.left; // should be node 8

    // Exercise
    const actualAnswer = lowestCommonAncestor(root, node1, node2);

    // Verify
    expect(actualAnswer).toBe(expectedAnswer);
});

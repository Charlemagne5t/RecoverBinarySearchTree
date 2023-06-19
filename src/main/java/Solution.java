import java.util.Stack;

public class Solution {
    public void recoverTree(TreeNode root) {
        inorder(root);
        printInorder(root);
    }

    private void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode previous = null;
        TreeNode firstPair1 = null;
        TreeNode firstPair2 = null;
        TreeNode secondPair1 = null;
        TreeNode secondPair2 = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;

            }
            current = stack.pop();

            if (previous != null && firstPair1 == null && firstPair2 == null) {
                if (previous.val > current.val) {
                    firstPair1 = previous;
                    firstPair2 = current;
                }
                previous = current;
            } else if (previous == null) {
                previous = current;
            } else if (secondPair1 == null && secondPair2 == null) {
                if (previous.val > current.val) {
                    secondPair1 = previous;
                    secondPair2 = current;

                }
                previous = current;
            }

            current = current.right;


        }

        if (firstPair1 != null && firstPair2 != null && secondPair1 == null && secondPair2 == null) {
            int temp = firstPair1.val;
            firstPair1.val = firstPair2.val;
            firstPair2.val = temp;
        } else if (secondPair1 != null && secondPair2 != null) {
            int temp = firstPair1.val;
            firstPair1.val = secondPair2.val;
            secondPair2.val = temp;
        }
    }


    public boolean areTreesEqual(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null || tree1.val != tree2.val) {
            return false;
        }

        return areTreesEqual(tree1.left, tree2.left) && areTreesEqual(tree1.right, tree2.right);
    }

    public void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInorder(root.left); // Print left subtree

        System.out.print(root.val + " "); // Print current node

        printInorder(root.right); // Print right subtree
    }
}

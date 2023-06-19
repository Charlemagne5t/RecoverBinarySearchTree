
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void recoverTreeTest1() {
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(3);
        input.left.right = new TreeNode(2);

        TreeNode output = new TreeNode(3);
        output.left = new TreeNode(1);
        output.left.right = new TreeNode(2);

        new Solution().recoverTree(input);
        Assert.assertTrue(new Solution().areTreesEqual(input, output));
    }

    @Test
    public void recoverTreeTest2() {
        TreeNode input = new TreeNode(3);
        input.left = new TreeNode(1);
        input.right = new TreeNode(4);
        input.right.left = new TreeNode(2);

        TreeNode output = new TreeNode(2);
        output.left = new TreeNode(1);
        output.right = new TreeNode(4);
        output.right.left = new TreeNode(3);

        new Solution().recoverTree(input);
        Assert.assertTrue(new Solution().areTreesEqual(input, output));
    }


}

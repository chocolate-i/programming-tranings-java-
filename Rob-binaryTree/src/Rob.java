public class Rob {

    // 定义二叉树节点类
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        // 构造函数，合并冗余逻辑
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        // 默认构造函数
        public TreeNode() {}

        // 带单参的构造函数
        public TreeNode(int val) {
            this(val, null, null);
        }
    }

    // 主方法修正签名
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // 构建测试用例树
        TreeNode node5 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5, node4, node5);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);

        // 调用DFS并打印结果
        int[] result = dfs(node1);
        System.out.println("With Node Value: " + result[0]);
        System.out.println("Without Node Value: " + result[1]);
    }

    /**
     * 深度优先搜索 (DFS) 实现
     * @param node 当前树节点
     * @return 包含两个值的数组：
     *         - 第一个值表示选择当前节点时的最大收益
     *         - 第二个值表示不选择当前节点时的最大收益
     */
    public static int[] dfs(TreeNode node) {
        // 边界条件：如果节点为空，返回 [0, 0]
        if (node == null) {
            return new int[]{0, 0};
        }

        // 递归计算左右子树的结果
        int[] leftResult =  dfs(node.left);
        int[] rightResult = dfs(node.right);

        // 计算选择当前节点时的最大收益
        int withNodeValue = node.val + leftResult[1] + rightResult[1];

        // 计算不选择当前节点时的最大收益
        int withoutNodeValue = Math.max(leftResult[0], leftResult[1])
                + Math.max(rightResult[0], rightResult[1]);

        // 返回结果数组
        return new int[]{withNodeValue, withoutNodeValue};

    }


}

public class Main {
    public static void main(String[] args) {
        int[][] cityConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Hello, World!");

        System.out.println(mergeFind(new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}}));
        System.out.println(mergeFind(cityConnected));
    }

    private static int mergeFind(int[][] cityConnected) {
        int cities = cityConnected.length;
        int[] head = new int[cities];
        int[] level = new int[cities];

        for (int i = 0; i < cities; i++) {
            head[i] = i;
            level[i] = 1; // 初始化为1
        }

        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (cityConnected[i][j] == 1) {
                    merge(i, j, head, level);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < cities; i++) {
            if (head[i] == i) {
                count++;
            }
        }
        return count;
    }

    /**
     * 合并两个集合
     * 此方法用于合并两个由数组 head 表示的不相交集合，并根据level数组中的等级进行合并
     * 如果两个元素已经在同一个集合中，则无需进行任何操作
     * 如果两个元素属于不同的集合，根据它们的等级进行合并，等级高的集合合并等级低的集合
     * 如果两个集合的等级相同，则任意选择一个作为合并后的集合，并提升其等级
     *
     * @param x 第一个集合中的元素
     * @param y 第二个集合中的元素
     * @param head 集合的代表元素数组，用于查找元素所属的集合
     * @param level 集合的等级数组，用于决定合并时哪个集合合并到哪个集合
     */
    static void merge(int x, int y, int[] head, int[] level) {
        // 查找x和y各自所属的集合代表
        int i = find(x, head);
        int j = find(y, head);
        // 如果x和y属于同一个集合，则无需合并
        if (i == j) return;
        // 根据集合的等级进行合并
        if (level[i] < level[j]) {
            // 将等级较低的集合合并到等级较高的集合中
            head[i] = head[j];
        } else if (level[i] > level[j]) {
            // 将等级较低的集合合并到等级较高的集合中
            head[j] = head[i];
        } else if (level[i] == level[j]){
            // 如果两个集合等级相同，则任意选择一个作为合并后的集合，并提升其等级
            level[i]++;
            level[j]++;
        }
    }

    private static int find(int x, int[] head) {
        if (head[x] == x) return x;
        head[x] = find(head[x], head); // 递归 路径压缩
        return head[x];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[][] matrix = new Main().generateMatrix(3);
        printMatrix(matrix); // 替换外部依赖为内置打印逻辑
    }

    /**
     * 生成 n x n 的螺旋矩阵
     * @param n 矩阵的大小
     * @return 螺旋填充的矩阵
     */
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("矩阵大小 n 必须为非负整数");
        }
        if (n == 0) {
            return new int[0][0]; // 返回空矩阵
        }

        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1, target = n * n;

        while (num <= target) {
            // 从左到右填充顶部行
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // 从上到下填充右侧列
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 从右到左填充底部行（如果存在）
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            // 从下到上填充左侧列（如果存在）
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }

    /**
     * 打印矩阵到控制台
     * @param matrix 输入的二维矩阵
     */
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("空矩阵");
            return;
        }

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}

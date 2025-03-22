public class Main {
    public static void main(String[] args) {


        System.out.println("Hello, World!");
        System.out.println(Champagnetower(5,2,1));
    }

    /**
     * 计算香槟塔中特定杯子的香槟量
     *
     * @param poured 倒入顶部杯子的香槟量
     * @param query_row 查询的行号（从0开始）
     * @param query_glass 查询的杯子号（在指定行内，从0开始）
     * @return 指定杯子中的香槟量，返回值不会超过1，因为杯子的容量是有限的
     */
    public static double Champagnetower(int poured, int query_row, int query_glass) {
        // 初始化一个二维数组来存储每个杯子的香槟量
        double[][] ca = new double[100][100];
        // 将所有的香槟倒入顶部杯子
        ca[0][0] = poured;
        // 遍历每一行的杯子，直到查询的行
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                // 计算当前杯子溢出的香槟量，如果有的话，会均分到下一行的两个杯子中
                double d = (ca[i][j] - 1.0) / 2;
                if (d > 0) {
                    // 香槟溢出，分配到下一行的两个杯子中
                    ca[i + 1][j] += d;
                    ca[i + 1][j + 1] += d;
                }
            }
        }
        // 返回指定杯子中的香槟量，确保返回值不超过1
        return Math.min(1, ca[query_row][query_glass]);
    }


}
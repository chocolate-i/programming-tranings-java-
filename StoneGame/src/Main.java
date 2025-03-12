public class Main {
    public static void main(String[] args) {
        // 打印Hello, World!到控制台
        System.out.println("Hello, World!");

        // 初始化一个整数数组
        int[] arr = new int[]{5, 200, 2, 3, 5};
        // 初始化总和变量为0
        int sum = 0;
        // 遍历数组，计算数组元素的总和
        for (int j : arr) {
            sum += j;
        }
        // 调用maxScore方法，计算从数组的第0个元素到最后一个元素的最大得分
        int p1 = maxScore(arr, 0, arr.length - 1);
        // 判断并打印玩家一的最大得分是否大于另一个玩家的得分
        System.out.println(p1 > sum - p1);
        System.out.println(maxScore1(arr, 0, arr.length - 1));
        System.out.println(dp(arr));
    }



    /**
     * 计算给定数组中，玩家一从索引l到r的最大得分
     * @param arr 代表游戏得分的整数数组
     * @param l   起始索引
     * @param r   结束索引
     * @return 返回玩家一的最大得分
     */
    static int maxScore(int[] arr, int l, int r) {
        // 当只有一个元素时，返回该元素的值
        if (l == r) {
            return arr[l];
        }
        // 初始化左侧和右侧的得分变量
        int sleft = 0, sright = 0;
        // 当只有两个元素时，分别赋值给左侧和右侧的得分
        if (r - l == 1) {
            sright = arr[r];
            sleft = arr[l];
        }

        // 当有三个或更多元素时，计算玩家一选择最右侧或最左侧元素时的最大得分
        if (r - l >= 2) {//分情况讨论

            sright = arr[r] + Math.min(maxScore(arr, l, r - 2), maxScore(arr, l + 1, r - 1));
            //如果玩家一选择最右侧元素，则玩家二有两种选择l  r-1，根据这两种选择分别计算剩余部分的得分，取最小值


            sleft = arr[l] + Math.min(maxScore(arr, l + 2, r), maxScore(arr, l + 1, r - 1));
            //如果玩家一选择最左侧元素，则玩家二有两种选择，l+1 r,根据这两种选择分别计算剩余部分的得分，取最小值
        }
        // 返回左侧和右侧得分中的最大值
        return Math.max(sright, sleft);
    }
    static int maxScore1(int[] arr, int l, int r){
        // 当只有一个元素时，返回该元素的值
        if (l == r) {
            return arr[l];
        }

        int  sright = arr[r] -maxScore(arr, l, r  -1);



        int sleft = arr[l] -maxScore(arr, l +1, r);
     return  Math.max(sright, sleft);
    }


    /**
     * 动态规划方法，用于计算在给定数组中，玩家一是否能赢得玩家二
     * 通过构建一个二维数组dp来存储玩家一相对于玩家二的得分差的最大值
     * @param arr 给定的整数数组，代表每个元素的得分
     * @return 如果玩家一能赢得玩家二，则返回true；否则返回false
     */
    static boolean dp(int[] arr){
        // 数组的长度
        int length=arr.length;
        // 初始化一个二维数组用于动态规划
        int [][]dp=new int[length][length];
        // 初始化对角线元素，即只有一个元素时的情况时候，差值即为该元素
        for (int i = 0; i <length ; i++) {
            dp[i][i]=arr[i] ;
        }
        // 从右下角开始填充dp数组，计算所有可能的得分差的最大值
        for (int i = length-1; i >=0 ; i--) {
            for (int j = i+1; j <length ; j++) {
                // 玩家一可以选择左边或右边的元素，选择使其与玩家二的得分差最大的策略
                dp[i][j]=Math.max(arr[i]-dp[i+1][j],arr[j]-dp[i][j-1]);
            }
        }

        // 如果玩家一的得分差最大值大于0，则玩家一可以赢得玩家二
        return  dp[0][length-1]>0;

    }

}





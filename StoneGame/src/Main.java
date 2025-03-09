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

    }





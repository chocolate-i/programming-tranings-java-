public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(new Main().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 查找长度最小的子数组，其和至少为target
     * 如果不存在这样的子数组，则返回0
     *
     * @param target 目标和
     * @param nums   输入的整数数组
     * @return 最小子数组的长度，如果不存在则返回0
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 初始化左指针、当前和、最小子数组长度
        int left = 0, sum = 0, result = Integer.MAX_VALUE;
        // 遍历数组，使用滑动窗口寻找符合条件的最小子数组
        for (int right = 0; right < nums.length; right++) {
            // 将当前元素加到sum中
            sum += nums[right];
            // 当当前和大于等于目标值时，尝试缩小窗口
            while (sum >= target) {
                // 更新最小子数组长度
                result = Math.min(result, right - left + 1);
                // 移动左指针，缩小窗口
                sum -= nums[left];
                left++;
            }
        }
        // 如果result未被更新，则说明没有找到符合条件的子数组，返回0
        // 否则返回找到的最小子数组长度
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
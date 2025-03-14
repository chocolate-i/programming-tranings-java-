public class Rob {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(maxMoney(new int[]{1,2,3,1},4));
    }

    static int maxMoney(int [] nums,int length){
        // 动态规划
        if (nums==null)
        {
            return 0;
        }
        if (length == 1){
            return nums[0];
        }
        int[] dp=new int[length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for (int i = 2; i <length ; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return  dp[length-1];
    }

}
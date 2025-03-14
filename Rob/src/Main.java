public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] nums=new int[]{1,2,3,1};
        System.out.println(maxMoney(nums,nums.length-1));
        System.out.println(maxMoney1(nums,nums.length));
        System.out.println(maxMoney2(nums,nums.length));
    }

      static int maxMoney(int [] nums,int index){
        //递归
        if (nums==null||index<0)
        {
            return 0;
        }
        if (index == 0){
                return nums[0];
            }

        return Math.max(maxMoney(nums,index-2)+nums[index],maxMoney(nums,index-1));

    }
    static int maxMoney1(int [] nums,int length){
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
    static int maxMoney2(int [] nums,int length){
        // 动态规划 空间复杂度优化
        if (nums==null)
        {
            return 0;
        }
        if (length == 1){
            return nums[0];
        }

        int first=nums[0];
        int second=nums[1];

        for (int i = 2; i <length ; i++) {
          int temp=Math.max(first+nums[i],second);
          first=second;
          second=temp;
        }
        return  second;

    }
}
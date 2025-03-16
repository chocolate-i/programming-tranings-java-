public class Rob {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] nums=new int[]{1,2,3,1};

        //有环的情况下，第一个或者最后一个只能选其一
        System.out.println(maxMoney(nums,0,nums.length-2));
        System.out.println(maxMoney(nums,1,nums.length-1));
    }

    static int maxMoney(int [] nums,int start,int end){
        // 动态规划
        if (nums==null)
        {
            return 0;
        }

         int first=nums[start];
        int second=Math.max(nums[start],nums[start+1]);

        for (int i = start+2; i <=end ; i++) {
            int temp=Math.max(first+nums[i],second);
            first=second;
            second=temp;
        }

        return  second;
    }




}
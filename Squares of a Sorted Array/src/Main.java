

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int []nums=new int[]{-4,-1,0,3,10};
       

    }



    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int p1=0,p2=nums.length-1,pos=nums.length-1;
        while (p1<=p2){
            ans[pos--]= abs(nums[p1]) >abs(nums[p2])? abs(nums[p1++]):abs(nums[p2--]);


        }
        return ans;
    }

    public int   abs(int a){
        return a*a;

    }

}
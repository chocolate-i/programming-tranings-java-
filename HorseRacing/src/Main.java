import java.util.*;

public class Main {
    /**
     * 主函数入口
     * 打印Hello, World!并调用advantageCount方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int []A=new int[]{10,24,8,32};
        int[]B=new int[]{13,25,25,11};
        // 打印advantageCount方法的结果
        System.out.println(Arrays.toString(advantageCount(A,B)));
    }

    /**
     * 根据数组B中的元素，从数组A中找到具有相对优势的元素组成的新数组
     * 优势定义为A中的元素大于B中的对应元素
     * @param A 第一个数组，包含待选择的元素
     * @param B 第二个数组，作为参考
     * @return 返回一个新的数组，包含A中对B具有优势的元素
     */
    public static int[] advantageCount(int[] A, int[] B) {
        // 对B数组进行从小到大排序，以便后续比较
        int [] sortedB=B.clone();
        Arrays.sort(sortedB);
        // 对A数组进行从小到大排序，以便后续比较
        Arrays.sort(A);

        // 使用哈希表和链表 挂载B中每个元素对应的优势元素
        Map<Integer, Deque<Integer>> bmap=new HashMap<>();
        for (int b: B){
            bmap.put(b,new LinkedList<>());
        }

        // 存储A中没有匹配到B中元素的情况  比B中的元素小的元素
        Deque<Integer> aq=new LinkedList<>();
        int j=0;
        // 遍历A数组，为B中的每个元素找到优势元素  挂载在bmap对应位置中
        for (int a:A){
            if (a>sortedB[j]){
                bmap.get(sortedB[j++]).add(a);
            }else aq.add(a);
        }

        // 构建最终的结果数组
        int[]  ans=new int[A.length];
        for (int i = 0; i < B.length; i++) {
            // 如果B中的元素有对应的优势元素，则使用之
            if (!bmap.get(B[i]).isEmpty()){
                ans[i]=bmap.get(B[i]).removeLast();
            }else {
                // 否则使用A中剩余的元素
                ans[i]=aq.removeLast();
            }
        }

        // 返回最终的结果数组
        return  ans;
    }
}

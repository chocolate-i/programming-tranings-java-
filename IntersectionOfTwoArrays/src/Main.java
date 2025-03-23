import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    /**
     * 主函数入口
     * 打印"Hello, World!"并计算两个数组的交集
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // 创建Main类的实例并调用intersection方法计算交集
        System.out.println(Arrays.toString(new Main().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    /**
     * 计算两个数组的交集
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 两个数组的交集
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 使用HashSet存储数组nums1的元素，去除重复并便于后续操作
        Set<Integer> set1 = new HashSet<Integer>();
        // 使用HashSet存储数组nums2的元素，去除重复并便于后续操作
        Set<Integer> set2 = new HashSet<Integer>();
        if (nums1.length==0||nums2.length==0){//如果其中一个数组为空，则返回空数组
            return new int[0];
        }
        // 遍历数组nums1，将元素添加到set1中
        for (int num : nums1) {
            set1.add(num);
        }
        // 遍历数组nums2，将元素添加到set2中
        for (int num : nums2) {
            set2.add(num);
        }
        // 调用getIntersection方法计算两个集合的交集并返回
        return getIntersection(set1, set2);
    }

    /**
     * 计算两个集合的交集
     * 优化处理：确保set1是较大的集合，以减少查找次数
     * @param set1 第一个集合
     * @param set2 第二个集合
     * @return 两个集合的交集
     */
    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        // 如果set1的大小小于set2的大小，交换它们以优化交集计算
        if (set1.size() < set2.size()) {
            return getIntersection(set2, set1);
        }
        // 用于存储交集结果的集合
        Set<Integer> Intersectionset = new HashSet<>();
        // 遍历较大的集合，检查元素是否也存在于另一个集合中
        for (int num : set1) {
            if (set2.contains(num)) {
                // 如果元素同时存在于两个集合中，则添加到交集集合中
                Intersectionset.add(num);
            }
        }
        // 将交集集合转换为数组形式
        int[] intersection = new int[Intersectionset.size()];
        int i = 0;
        // 遍历交集集合，将元素复制到数组中
        for (int num : Intersectionset) {
            intersection[i++] = num;
        }
        // 返回交集数组
        return intersection;
    }
}

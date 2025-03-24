import java.util.HashSet;
import java.util.Set;

public class Main {
    /**
     * 程序的入口点
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(new Main().isHappy(19));
    }

    /**
     * 判断一个数是否是快乐数
     * 快乐数定义：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 最终会得到1或者是若干个数字组成的循环，沿循环无法到达1
     *
     * @param n 待检查的正整数
     * @return 如果是快乐数返回true，否则返回false
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 计算下一个数字
     * 下一个数字是当前数字每个位置上的数字的平方和
     *
     * @param n 当前数字
     * @return 下一个数字
     */
    public int getNext(int n) {//计算n的每个位置上的数字的平方和
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            n = n / 10;
            sum += temp * temp;
        }
        return sum;
    }
}

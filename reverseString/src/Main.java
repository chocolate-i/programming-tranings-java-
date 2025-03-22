public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(new Main().reverseStr("abcdefg", 2));

    }
    /**
     * 反转字符串中每隔k个字符的前k个字符
     *
     * @param s 待处理的字符串
     * @param k 指定的间隔和反转的字符数
     * @return 经过局部反转后的字符串
     */
    public String reverseStr(String s, int k) {
        // 将字符串转换为字符数组，便于逐个字符操作
        char[] arr = s.toCharArray();
        // 获取字符串的长度
        int n = s.length();

        // 每2k个字符为一组，对每组的前k个字符进行反转
        for (int i = 0; i < n; i += 2 * k) {
            // 反转当前组的前k个字符，注意不要超出字符串的长度
            reverse(arr, i, Math.min(i + k, n) - 1);
        }

        // 将处理后的字符数组转换回字符串并返回
        return new String(arr);
    }

    /**
     * 反转字符数组中指定区间的字符
     *
     * @param arr 字符数组
     * @param left 反转区间的起始索引
     * @param right 反转区间的结束索引
     */

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
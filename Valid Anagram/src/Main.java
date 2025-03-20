public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(new Main().isAnagram("anagram", "nagaram"));
    }
    /**
     * 判断两个字符串是否互为字谜（anagram）
     * 字谜指的是两个字符串在重新排列字符后可以相互转换的情况，即两个字符串中每个字符出现的次数都相同
     *
     * @param s 第一个字符串
     * @param t 第二个字符串
     * @return 如果s和t互为字谜返回true，否则返回false
     */
    public boolean isAnagram(String s, String t) {
        // 如果两个字符串长度不同，则它们不可能互为字谜
        if(s.length() != t.length())
            return false;

        // 创建一个数组来记录字母'a'到'z'在字符串s和t中出现的次数差异
        int[] letters = new int[26];

        // 遍历字符串s和t，更新letters数组以记录每个字符的出现次数差异
        for(int i = 0; i < s.length(); i++){
            // 在s中出现的字符，对应的计数加1
            letters[s.charAt(i) - 'a']++;
            // 在t中出现的字符，对应的计数减1
            letters[t.charAt(i) - 'a']--;
        }

        // 检查letters数组中的每个值，如果存在非0的值，则s和t不是字谜
        for(int i = 0; i < 26; i++){
            if(letters[i] != 0)
                return false;
        }
        // 如果所有字符计数都为0，说明s和t互为字谜
        return true;
    }
}
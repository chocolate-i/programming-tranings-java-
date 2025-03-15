import java.util.Arrays;

public class StringSearch {
    //使用kmp算法实现字符串的搜索 
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String str1="ababababab";
        String pattern="abab";
        int[]  next=new int[pattern.length()];
        getNext(pattern.toCharArray(),next);
        int index=search(next,pattern.toCharArray(),str1.toCharArray());
        System.out.println(Arrays.toString(next));
        System.out.println(index);


    }

    
    static int search(int[] next, char[] pattern,char[] str) {
        int i=0,j=0;
        while (i<str.length&&j<pattern.length){
            if (str[i]==pattern[j]){
                i++;
                j++;
            }else if (j>0){
                j=next[j-1];
            }
            else {
                i++;
            }
        }
        if (j==pattern.length){
            return i-j;
        }else if (i==str.length){
            return -1;
        }
        return -1;
    }

     static  void  getNext(char[] pattern ,int[] next ) {
      next[0]=0;
      int i=0,j=0;
        while (i<pattern.length){
            if (j==-1)
                {
                i++;
                j++;

            } else if ( pattern[i]==pattern[j]) {
                i++;
                j++;
                next[i]=j;
            } else {
                j=next[j];
            }
        }


    }

}
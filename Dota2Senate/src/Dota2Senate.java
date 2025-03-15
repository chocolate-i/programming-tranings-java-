import java.util.LinkedList;
import java.util.Queue;
public class Dota2Senate {
    /**
     * 主函数入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // 创建Dota2Senate实例并调用predictPartyVictory方法
        System.out.println(new Dota2Senate().predictPartyVictory("RDD"));
    }

    /**
     * 预测哪个政党会胜利
     * @param senate 参议院的字符串表示，其中'R'代表Radiant政党，'D'代表Dire政党
     * @return 如果Radiant政党胜利返回"Radiant"，否则返回"Dire"
     */
    public String predictPartyVictory(String senate) {
        // Radiant政党的参议员队列
        Queue<Integer> qr = new LinkedList<Integer>();
        // Dire政党的参议员队列
        Queue<Integer> qd = new LinkedList<Integer>();
        int length = senate.length();
        // 初始化队列，存储每个参议员的位置
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                qr.offer(i);
            } else if (senate.charAt(i) == 'D') {
                qd.offer(i);
            }
        }

        // 当两个队列都不为空时，进行模拟
        while (!qr.isEmpty() && !qd.isEmpty()) {
            int r = qr.poll();
            int d = qd.poll();
            // 比较两个参议员的位置，位置小的参议员会禁止位置大的参议员，并重新排队
            if (r < d) {
                qr.offer(r + length);
            } else {
                qd.offer(d + length);
            }
        }

        // 根据队列是否为空判断哪个政党胜利
        return qd.isEmpty() ? "Radiant" : "Dire";
    }
}

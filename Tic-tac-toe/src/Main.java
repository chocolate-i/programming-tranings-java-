public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(Tictactoe(new String[]{"XXX","OXO ","O O"}));
        System.out.println(Tictactoe(new String[]{"XXX","OX ","O O"}));
        System.out.println(Tictactoe(new String[]{"XOX","OXO","  X"}));
    }



    /**
     * 检查井字游戏（Tic-tac-toe）的棋盘状态是否有效
     * 井字游戏是一个双方对弈的游戏，一方使用'O'标记，另一方使用'X'标记，轮流在3x3的棋盘上标记空位
     * 获胜的条件是任一方的标记在棋盘的任一行、任一列或两条对角线上连续出现三次
     * 此方法通过检查棋盘上'O'和'X'的数量及其分布，判断当前的游戏状态是否符合逻辑
     *
     * @param board 表示棋盘状态的字符串数组，每个字符串代表棋盘的一行
     * @return 返回一个布尔值，表示棋盘状态是否有效 true表示有效，false表示无效
     */
    public static boolean Tictactoe(String[] board) {
        // 初始化'O'和'X'的计数器
        int oCount = 0, xCount = 0;

        // 遍历棋盘的每一行
        for (String row : board) {
            // 遍历每一行中的每个字符
            for (char c : row.toCharArray()) {
                // 如果字符是'O'，则'O'的计数器加一
                if (c == 'O') {
                    oCount++;
                }
                // 如果字符是'X'，则'X'的计数器加一
                if (c == 'X') {
                    xCount++;
                }
            }
        }

        // 检查'O'和'X'的数量是否符合游戏规则
        // 'O'的数量应等于'X'的数量或比'X'的数量少一个，因为'X'总是先手
        if (oCount != xCount && xCount - oCount != 1) {
            return false;
        }

        // 检查'O'是否获胜，同时确保'O'的数量等于'X'的数量
        // 如果'O'获胜时数量不符，返回false，因为这表明游戏状态不合法
        if (win(board, "OOO") && oCount != xCount) {
            return false;
        }

        // 检查'X'是否获胜，同时确保'X'的数量比'O'的数量多一个
        // 如果'X'获胜时数量不符，返回false，因为这表明游戏状态不合法
        if (win(board, "XXX") && xCount - oCount != 1) {
            return false;
        }

        // 如果以上所有条件都满足，则返回true，表示棋盘状态有效
        return true;
    }

    static  boolean win(String[] board,String flag){

        for (int i=0;i<3;i++){
            // check rows  横向成三个
            if (flag.equals(board[i])){
                return  true;
            }
            // check columns  纵向成三个
            if (flag.equals(board[0].charAt(i)+" "+board[1].charAt(i)+" "+board[2].charAt(i))){
                return  true;
            }
            // check diagonals  正对角线成三个
            if (flag.equals(board[0].charAt(0)+" "+board[1].charAt(1)+" "+board[2].charAt(2))){
                return  true;
            }
            // check diagonals  反对角线成三个
            if (flag.equals(board[0].charAt(2)+" "+board[1].charAt(1)+" "+board[2].charAt(0))){
                return  true;
            }

        }

        return  false;
    }
}
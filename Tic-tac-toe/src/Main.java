public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(Tictactoe(new String[]{"XXX","OXO ","O O"}));
        System.out.println(Tictactoe(new String[]{"XXX","OX ","O O"}));
        System.out.println(Tictactoe(new String[]{"XOX","OXO","  X"}));
    }



    public  static boolean Tictactoe(String[] board) {
         int oCount=0, xCount=0;
         for (String row:board){
             for (char c:row.toCharArray()){
                 if (c=='O'){
                     oCount++;
                 }
                 if (c=='X') {
                     xCount++;
                 }

             }

         }
        if (oCount!=xCount && xCount-oCount!=1){
            return false;

        }
        if (win(board,"OOO") && oCount!=xCount){
            return false;
        }
        if (win(board,"XXX") && xCount-oCount!=1){
            return false;
        }
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
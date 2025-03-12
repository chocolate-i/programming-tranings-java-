public class Main {
    public static void main(String[] args) {


        System.out.println("Hello, World!");
        System.out.println(Champagnetower(5,2,1));
    }

    public  static double Champagnetower(int poured,int query_row,int query_glass){
        double[][]ca=new double [100][100];
        ca[0][0]=poured;
        for (int i = 0; i <=query_row; i++) {
            for (int j = 0; j <= i; j++) {
            double d=(ca[i][j]-1.0)/2;
            if (d>0){
                ca[i+1][j]+=d;
                ca[i+1][j+1]+=d;
            }

            }
        }
        return Math.min(1,ca[query_row][query_glass]);

    }

}
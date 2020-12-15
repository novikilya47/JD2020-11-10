package by.it.rydzeuski.jd01_15;

public class TaskA {


    public static void main(String[] args) {
        int [][] array= new int [6][4];
        for (int [] row:array) {
            for (int i = 0; i <row.length ; i++) {
                row[i]=-15+(int)(Math.random()*31);

            }

        }
        array[0][0]=-15;
        array[1][1]=15;
    }
}

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    public static void main(String[] args) {
        Scanner size = new Scanner(System.in);
        System.out.println("Tarla satır boyutunu belirle :");
        int a = size.nextInt();
        System.out.println("Tarla satır boyutunu belirle :");
        int b = size.nextInt();
        int[][] matris1 = Mmatris(a, b);
        int[][] matris2 = Cmatris(a, b, matris1);
        String[][] matris3 = Pmatris(a, b, matris1);
        String[][] matris4 = Omatris(a, b);
        System.out.println("MAYIN HARİTASI :\n");
        Yazdir(matris3);
        System.out.println("\n================");
        Oynanis(a, b, matris3, matris2, matris4);


    }

    static void Oynanis(int a, int b, String[][] matris3, int[][] matris2, String[][] Omatris) {

        Yazdir(Omatris);
        System.out.println("=======================\n");
        Scanner inp = new Scanner(System.in);
        System.out.println("Satır :");
        int x = inp.nextInt();
        x = DegerCntrla(a, x);
        System.out.println("Sütün :");
        int y = inp.nextInt();
        y = DegerCntrlb(b, y);

        if (matris3[x][y].equals("o")) {

            Omatris[x][y] = String.valueOf(matris2[x][y]);
            Oynanis(a, b, matris3, matris2, Omatris);
        }else {
            Yazdir(matris3);
            System.out.println("\n Kaybettiniz :(");
        }

    }

    static int DegerCntrla(int a, int x) {
        Scanner inp = new Scanner(System.in);
        if (x >= a || x < 0) {
            System.out.println("Geçerli bir aralık giriniz : 0<->" + a);
            x = inp.nextInt();
            x = DegerCntrla(a, x);
        }
        return x;
    }

    static int DegerCntrlb(int b, int y) {
        Scanner inp = new Scanner(System.in);
        if (y >= b || y < 0) {
            System.out.println("Geçerli bir aralık giriniz : 0<->" + b);
            y = inp.nextInt();
            y = DegerCntrlb(b, y);
        }
        return y;
    }

    static void Yazdir(String[][] matris1) {
        for (String[] u : matris1) {
            for (String y : u) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }

    static String[][] Omatris(int x, int y) {
        String[][] Matris = new String[x][y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                Matris[i][j] = "-";
            }

        }
        return Matris;
    }

    static int[][] Mmatris(int x, int y) {
        int[][] Matris = new int[x + 2][y + 2];
        for (int i = 0; i < (x * y) / 4; ++i) {
            int a = rnd(x);
            int b = rnd(y);
            if (Matris[a][b] == 0) {
                Matris[a][b] = 1;
            } else --i;
        }
        return Matris;
    }

    static int[][] Cmatris(int x, int y, int[][] matris) {
        int[][] matris1 = matris;
        int[][] matris2 = new int[x][y];
        for (int i = 1; i < (x + 1); ++i) {
            for (int j = 1; j < (y + 1); ++j) {
                matris2[i - 1][j - 1] = matris1[i + 1][j + 1] + matris1[i][j + 1] + matris1[i + 1][j] + matris1[i - 1][j - 1] + matris1[i - 1][j] + matris1[i][j - 1] + matris1[i - 1][j + 1] + matris1[i + 1][j - 1];
            }
        }
        return matris2;
    }

    static String[][] Pmatris(int x, int y, int[][] matris) {
        String[][] matris1 = new String[x][y];
        for (int i = 1; i < x + 1; ++i) {
            for (int j = 1; j < y + 1; ++j) {
                if (matris[i][j] == 0) {
                    matris1[i - 1][j - 1] = "o";
                } else {
                    matris1[i - 1][j - 1] = "*";
                }
            }
        }
        return matris1;

    }

    static int rnd(int x) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(x);
        if (rand_int1 == 0) ++rand_int1;
        return rand_int1;
    }

}

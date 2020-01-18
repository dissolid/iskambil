import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        soru3();
    }

    public static void soru3() {


        String[][] iskambil = new String[4][13];
        desteOlustur(iskambil);
        desteShuffle(iskambil);
        desteGoster(iskambil);
        System.out.println("*************");
        desteDagit(iskambil);
        System.out.println("");


    }

    // 3. Soru Metodları >>>
    public static void desteOlustur(String[][] iskambil) {

        for (int i = 0; i < iskambil.length; i++) {
            for (int j = 0; j < iskambil[i].length; j++) {
                if (i == 0) {
                    desteFill(iskambil, "Karo", i, j);
                } else if (i == 1) {
                    desteFill(iskambil, "Kupa", i, j);
                } else if (i == 2) {
                    desteFill(iskambil, "Sinek", i, j);
                } else if (i == 3) {
                    desteFill(iskambil, "Maça", i, j);
                }
            }
        }
    }

    public static void desteFill(String[][] iskambil, String text, int i, int j) {
        // Bu metod if döngüsü desteOlustur metodunun içinde 4 defa tekrar edeceği için metod haline getirilmiştir.
        if (j == 0) {
            iskambil[i][j] = text + " As";
        } else if (j > 0 && j < 10) {
            iskambil[i][j] = text + " " + (j + 1);
        } else {
            switch (j) {
                case 10:
                    iskambil[i][j] = text + " Vale";
                    break;
                case 11:
                    iskambil[i][j] = text + " Kız";
                    break;
                case 12:
                    iskambil[i][j] = text + " Papaz";
                    break;
            }
        }
    }

    public static void desteShuffle(String[][] deste) {

        int toplamEleman = 52;

        for (int j = 0; j < toplamEleman; j++) {
            int x = (int) (Math.random() * 4);
            int y = (int) (Math.random() * 13);
            int xTmp = (int) (Math.random() * 4);
            int yTmp = (int) (Math.random() * 13);
            String tmp = deste[x][y];
            deste[x][y] = deste[xTmp][yTmp];
            deste[xTmp][yTmp] = tmp;
        }
    }

    public static void desteGoster(String[][] deste) {
        for (String[] strings : deste) {
            for (String string : strings) {
                System.out.print(string + ", ");
            }
            System.out.println();
        }
    }

    public static void desteDagit(String[][] deste) {
        String[] dagitilacakDeste = new String[52];
        List<String> player1Deste = new ArrayList<String>();
        List<String> player2Deste = new ArrayList<String>();
        List<String> player3Deste = new ArrayList<String>();
        List<String> player4Deste = new ArrayList<String>();

        // Tek dizi  haline getirdik(Oyunculara desteyi dağıtırken kolay olması için)
        for (int i = 0; i < deste.length; i++) {
            for (int j = 0; j < deste[i].length; j++) {
                if (i != 0) {
                    dagitilacakDeste[(deste[i].length * i) + j] = deste[i][j];
                } else {
                    dagitilacakDeste[j] = deste[i][j];
                }
            }
        }
        // Oyunculara desteyi sıralı bir şekilde dağıttık
        for (int i = 0; i < dagitilacakDeste.length; i++) {
            if (i % 4 == 0) {
                player1Deste.add(dagitilacakDeste[i]);
            }
            if (i % 4 == 1) {
                player2Deste.add(dagitilacakDeste[i]);
            }
            if (i % 4 == 2) {
                player3Deste.add(dagitilacakDeste[i]);
            }
            if (i % 4 == 3) {
                player4Deste.add(dagitilacakDeste[i]);
            }
        }
        System.out.print("Birinci Oyuncunun Destesi: " + player1Deste + "\n");
        System.out.print("İkinci Oyuncunun Destesi: " + player2Deste + "\n");
        System.out.print("Üçüncü Oyuncunun Destesi: " + player3Deste + "\n");
        System.out.print("Dördüncü Oyuncunun Destesi: " + player4Deste + "\n");

    }


}

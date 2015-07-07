/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author syogo
 */
public class Main {

    static String line0 = "0";
    static int length = 0;

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\省吾\\Documents\\NetBeansProjects\\codeforces\\src\\B_2015\\testdata"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        int n = scan.nextInt();
        length = n;
        String[] room = new String[n];
        for (int i = 0; i < n; i++) {
            room[i] = scan.next();
        }

        for (int i = 0; i < n - 1; i++) {
            line0 += "0"; //n個の0を持つ行を生成
        }

        int max = 0;

        // 行単位で探索
        for (int i = n; i > 0; i--) {
            max = Math.max(max, cleanup(room, i));
        }

        System.out.println(max);
    }

    // 各列を左から順に綺麗にする
    // 深さはn回分
    // 最も綺麗な行が多かった時の綺麗な行数を返す
    static int cleanup(String[] room, int n) {
        if (n > 0) {
            // 面の状態を反転させる
            // 1なら0へ、0なら1へ
            int m = 0; //その回の綺麗な行の数

            for (int i = 0; i < length; i++) {
                StringBuffer sb = new StringBuffer(room[i]);
                if (sb.charAt(n-1) == '0') {
                    sb.replace(n - 1, n, "1"); //0から1へ
                } else {
                    sb.replace(n - 1, n, "0"); //1から0へ
                }
                if (sb.toString().equals(line0)) {
                    m++;
                }
                room[i] = sb.toString();
            }
            //System.out.println(n);
            for (int i = 0; i < room.length; i++) {
                System.out.println(room[i]);
            }
            System.out.println("--------------");

            return Math.max(m, cleanup(room, n - 1));
        } else {
            return 0;
        }
    }
}

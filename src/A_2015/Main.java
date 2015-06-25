package A_2015;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syogo
 */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String w = scan.next();
        int n = w.length();
        
        System.out.println((26*n)-n); 
    }
    
}

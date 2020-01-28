/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_201602935;

import java.util.Scanner;

/**
 *
 * @author lourd
 */
public class Tarea1_201602935 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int M;
        Scanner m = new Scanner(System.in);
        System.out.println("Ingresar valor de m");
        M = m.nextInt();
        String[][] matriz = new String[M][M];
        
        for( int i = 0; i < M; i++ ) {
            for( int j = 0; j < M; j++ ) {
                if( i==0 || i==M-1 || j==0 || j==M-1 )
                    System.out.print("1");
                else
                     System.out.print(" ");
             }
             System.out.println(" ");
        }
        
        
    }
    
}

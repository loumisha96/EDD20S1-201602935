/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moneda;

import java.util.Scanner;

/**
 *
 * @author lourd
 */
public class Moneda{
      public String nombre;
      public int valor;
      public static int cantMonedero;
      public int IDdueño;
      public int cantUsuario;
      public static String[][] matriz;
      public static int k;//tamaño de la matriz
    /**
     * @param args the command line arguments
     */
      
      public static void main(String[] args) {
        // TODO code application logic here
        Scanner dueño = new Scanner(System.in);
        String nombre;
        
        System.out.println("Ingresar cantidad de dueños");
        k = dueño.nextInt();
        
        matriz = new String[k][3];
        for(int i=0; i<k; i++){
            System.out.println("Ingresar nombre del dueño");
            nombre = dueño.next();
            matriz[i][0]= String.valueOf(i);
            matriz[i][1]= nombre;
            matriz[i][2]= String.valueOf(0);
        }
        Moneda mon = new Moneda("dsg",3);
        mon.CrearMoneda("quetzal", 1);
        mon.CrearMoneda("quetzal", 2);
        mon.CrearMoneda("cinco", 5);
        mon.CrearMoneda("diez", 10);
        System.out.println("Monedas en el monedero= " + cantMonedero);
        mon.TransferirFrom("1", "2", 5);
        mon.Transferir("2",5);
        mon.TransferirFrom("2", "0", 5);
        System.out.println("Monedas en el monedero= " + cantMonedero);
        
    }
    //se crean  monedas
    public Moneda(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
        
    }
    public void CrearMoneda(String nombre, int valor){
        Moneda moneda = new Moneda(nombre, valor);
        cantMonedero = cantMonedero+valor;
        
    }
    //del monedero al dueño
    //Parámetro de entrada es el ID del dueño
    public void Transferir(String IDdueño, int cant ){
        if(cantMonedero< cant){
            System.out.println("No hay monedas");
        }else{
            
                for (int i = 0; i<5; i++){
                    if((IDdueño.equals( matriz[i][0]))){
                        matriz[i][2] = matriz[i][2]+cant;
                        cantMonedero = cantMonedero - cant;
                        System.out.println(matriz[i][1]+ " tiene " +matriz[i][2]+ " monedas");
                        i=5;
                    }
                }
            
        }
        
    }
    //dueño1 transfiere a dueño2
    //Los parámetros de entrada son los ID de los dueños
    public void TransferirFrom(String IDdueño1, String IDdueño2, int cant){
        for(int i = 0; i<k; i ++){
            if(matriz[i][0].equals(IDdueño1)){
                if(Integer.parseInt(matriz[i][2])<cant){
                    System.out.println(matriz[i][1]+ " no tiene monedas para transferir");
                    i=5;
                }
                else{
                    int mon = Integer.parseInt(matriz[i][2]);
                    matriz[i][2]=String.valueOf(mon-cant);
                    for(int j=0; j<5; j++){
                        int mon1 = Integer.parseInt(matriz[j][2]);
                        matriz[j][2]=String.valueOf(mon1-cant);
                        
                        if(matriz[j][0].equals(IDdueño2)){
                            matriz[j][2]=String.valueOf(mon1+cant);
                            System.out.println(matriz[j][1]+ " recibió " +cant + " monedas");
                            j=5;
                        }
                    }
                    i=5;
                }
            }
        }
    }
}

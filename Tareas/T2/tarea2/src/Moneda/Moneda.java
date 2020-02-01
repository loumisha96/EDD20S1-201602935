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
      public static int[][] matriz;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner dueño = new Scanner(System.in);
        int nombre;
        int j;
        System.out.println("Ingresar cantidad de dueños");
        j = dueño.nextInt();
        
        matriz = new int[j][3];
        for(int i=0; i<j; i++){
            System.out.println("Ingresar nombre del dueño");
            nombre = dueño.nextInt();
            matriz[i][0]= i;
            matriz[i][1]= 3;
            matriz[i][2]= 0;
        }
        Moneda mon = new Moneda("dsg",3);
        mon.CrearMoneda("quetzal", 1);
        mon.CrearMoneda("quetzal", 2);
        mon.CrearMoneda("cinco", 5);
        mon.CrearMoneda("diez", 10);
        System.out.println("Monedas en el monedero= " + cantMonedero);
        mon.TransferirFrom(1, 0, 5);
        mon.Transferir(0,5);
        mon.TransferirFrom(0, 1, 5);
        System.out.println("Monedas en el monedero= " + cantMonedero);
        
    }
    //se crean con 0 monedas
    public void AgregarUsuario(String nombre){
      //  matriz[][] =  
    }
    public Moneda(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
        
    }
    public void CrearMoneda(String nombre, int valor){
        Moneda moneda = new Moneda(nombre, valor);
        cantMonedero = cantMonedero+valor;
        
    }
    //del monedero al dueño
    public void Transferir(int IDdueño, int cant ){
        if(cantMonedero< cant){
            System.out.println("No hay monedas");
        }else{
            
                for (int i = 0; i<5; i++){
                    if((IDdueño == matriz[i][0])){
                        matriz[i][2] = matriz[i][2]+cant;
                        cantMonedero = cantMonedero - cant;
                        System.out.println("El Usuario "+IDdueño+ " tiene " +matriz[i][2]+ " monedas");
                        i=5;
                    }
                }
            
        }
        
    }
    //dueño1 transfiere a dueño2
    public void TransferirFrom(int IDdueño1, int IDdueño2, int cant){
        for(int i = 0; i<5; i ++){
            if(matriz[i][0]== IDdueño1){
                if(matriz[i][2]<cant){
                    System.out.println("El usuario " +IDdueño+ " no tiene monedas para transferir");
                    i=5;
                }
                else{
                    matriz[i][2]=matriz[i][2]-cant;
                    for(int j=0; j<5; j++){
                        if(matriz[j][0] ==IDdueño2){
                            matriz[j][2]=matriz[j][2]+cant;
                            System.out.println("Moneda recibida");
                            j=5;
                        }
                    }
                    i=5;
                }
            }
        }
    }
}

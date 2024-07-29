/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import java.util.Scanner;

/**
 *
 * @author Gahel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion = 0;
        
        while (opcion != 6) {
        
        Scanner numeros = new Scanner(System.in);
        
        System.out.println("\nBienvenido a la calculadora");
    
        System.out.println("Ingrese el numero de la operacion que quiera hacer");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Tablas de multiplicar");
        System.out.println("6. Salir de la calculadora");
        opcion = numeros.nextInt();
            
            switch (opcion) {
            
            case 1:
                System.out.print("\nIngrese el primer número: ");
                double n1 = numeros.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double n2 = numeros.nextDouble();
                System.out.println("\nResultado de la Suma: " + (n1 + n2));
            break;
            
            case 2:
                System.out.print("\nIngrese el primer número: ");
                double n1r = numeros.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double n2r = numeros.nextDouble();
                System.out.println("\nResultado de la Resta: " + (n1r - n2r));
            break;
            
            case 3:
                System.out.print("\nIngrese el primer número: ");
                double n1p = numeros.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double n2p = numeros.nextDouble();
                System.out.println("\nResultado de la Multiplicación: " + (n1p * n2p));
            break;
            
            case 4:
                System.out.print("\nIngrese el primer número: ");
                double n1s = numeros.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double n2s = numeros.nextDouble();
                if (n2s != 0) {
                    System.out.println("\nResultado de la División: " + (n1s / n2s));
                    int cociente = (int) (n1s/n2s);
                    System.out.println("cociente: " + cociente);
                    int residuo = (int) (n1s%n2s);
                    System.out.println("residuo: " + residuo);
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
                
            break;
            
            case 5:
                int sn, sf, sq;
                System.out.println("\nIngrese el numero de la tabla para multiplicar: ");
                sn = numeros.nextInt();
                System.out.println("Ingrese el numero de inicio de rango: ");
                sf = numeros.nextInt();
                System.out.println("Ingrese el numero del final del rango: ");
                sq = numeros.nextInt();
                while (sq<sf) {
                    System.out.println("Error: El numero de inicio debe ser menor o igual al numero de fin");
                    System.out.println("Ingrese el numero de inicio de rango: ");
                    sf = numeros.nextInt();
                    System.out.println("Ingrese el numero del final del rango: ");
                    sq = numeros.nextInt();
                    }
                    for (int i = sf; i <= sq; i++) {
                    int operacion = (sn*i);
                    System.out.println(sn+"*"+i+"="+ operacion);
                    }
                    break;
                    
            case 6:
                System.out.println("\nGracias por usar mi maravillosa calculadora");
                System.out.println("Autor: Ottoniel Fabricio Vásquez Pineda");
                System.out.println("Carne: 202307820");
                break;
            
             }
                    
                
        }
        

    
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class CajeroAutomatico {

    Scanner entrada = new Scanner(System.in);
    protected int transacciones, retiro, deposito;
    private static int saldo = 500;

    public void operaciones() {
        int bandera = 0;
        int seleccion = 0;

        do {
            do {
                System.out.println("Porfavor escoja una opcion");
                System.out.println("    1. Consulta saldo");
                System.out.println("    2. Retiro de efectivo");
                System.out.println("    3. Deposito de efectivo");
                System.out.println("    4. Salir");

                seleccion = entrada.nextInt();
                if (seleccion >= 1 && seleccion <= 4) {
                    bandera = 1;
                } else {
                    System.out.println("------------------------------------------------");
                    System.out.println("Opcion no disponible, vuelva a intentar porfavor");
                    System.out.println("------------------------------------------------");
                }

            } while (bandera == 0);
                switch (seleccion) {
                    case 1:
                        //estado de cuneta
                        this.consultarSaldo();
                        break;
                    case 2:
                        //retiro
                        this.retirarDinero();
                        break;
                    case 3:
                        //deposito
                        this.depositarDinero();
                        break;
                    case 4:
                        //salir
                        bandera = this.salir();
                        break;
                    default:
                        break;
                }
        } while (bandera != 2);
    }
    private void consultarSaldo(){
        System.out.println("--------------------------------------");
        System.out.println("Su cuenta tiene un saldo de: " + saldo);
        System.out.println("--------------------------------------");
    }
    private void retirarDinero(){
        System.out.print("Ingrese el monto a retirar: ");
        retiro = entrada.nextInt();
        if (retiro <= saldo && retiro > 0) {
            System.out.println("-------------------------------------------------");
            System.out.println("Retiraste: " + retiro);
            saldo = saldo - retiro;
            System.out.println("Tu saldo actual es de: " + saldo);
            System.out.println("--------------------------------------------------");
        }else{
            System.out.println("------------------------------------------------------");
            System.out.println("Usted no tiene dinero es pobre porfavor deposite algo");
            System.out.println("------------------------------------------------------");
        }
    }
    private void depositarDinero(){
        System.out.print("Cuanto dinero deseas depositar: ");
        deposito = entrada.nextInt();
        if (deposito > 0) {
            System.out.println("----------------------------------");
            System.out.println("Depositaste: " + deposito);
            saldo = deposito + saldo;
            System.out.println("Tu saldo actual es de: " + saldo);                    
            System.out.println("-----------------------------------");
        }else{
            System.out.println("------------------------------------------------------");
            System.out.println("Porfavor elija un valor valido");
            System.out.println("------------------------------------------------------");
        }
    }
    public int salir(){
        System.out.println("----------------------");
        System.out.println("Gracias, vuelva pronto");
        System.out.println("----------------------");
        return 2;
    }
}

package CajeroAutomatico;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.InputMismatchException;

public class UsuarioComun {

    private String nombre;
    private int NIP, montoRetiro, saldoCajero, retiroMinimo;
    private int saldo = (int) (1000 + Math.random() * 49000);
    private Scanner leer = new Scanner(System.in);
    private int accionRealizada = 0;
    private int cancelar = 0;
    ArchivoDeTexto texto = new ArchivoDeTexto();
    ArchivoBinario binario = new ArchivoBinario();

    public UsuarioComun(String nombre, int NIP) {
        this.nombre = nombre;
        this.NIP = NIP;
        texto.crear("logs.txt");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void menu() {
        do {
            try {
                System.out.println("¿Que desea realizar?");
                System.out.println("1: Consultar su saldo");
                System.out.println("2: Realizar un retiro de efectivo");
                System.out.println("3: Salir del cajero");
                accionRealizada = leer.nextInt();
                switch (accionRealizada) {
                    case 1:
                        this.consultaSaldo();
                        break;
                    case 2:
                        binario.instanciarBilletes("billetes.dat");
                        this.retiroEfectivo();
                        break;
                    case 3:
                        this.salirCajero();
                        break;
                    default:
                        System.out.println("Esta opcion no es valida, intentalo de nuevo");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingreso una opcion no valida, intentelo de nuevo");
                leer.nextLine();
            }

        } while (accionRealizada < 1 || accionRealizada > 3);
    }

    public void consultaSaldo() {
        System.out.println("Su saldo es de " + saldo + " pesos");
        System.out.println("Accion realizada con exito");
        Movimientos movimiento = new Movimientos("Consulta", this.getNombre(), this.getSaldo(), "Si");
        texto.escribir("logs.txt", movimiento, true);
        this.menu();
    }

    public void retiroEfectivo() {
        boolean comprobar;
        do {
            try {
                this.saldoCajero = binario.saldoCajero("billetes.dat");
                this.retiroMinimo = binario.retiroMinimo("billetes.dat");
                System.out.println("El retiro minimo es de " + retiroMinimo);

                System.out.println("¿Cuánto desea retirar?");
                this.montoRetiro = leer.nextInt();
                comprobar = true;
                if (montoRetiro > saldo || montoRetiro > saldoCajero) {
                    System.out.println("Tu o el cajero no tienen la cantidad necesaria para realizar el retiro");
                    do {
                        try {
                            System.out.println("¿Desea cancelar?");
                            System.out.println("1: Si");
                            System.out.println("2: No");
                            cancelar = leer.nextInt();
                            switch (cancelar) {
                                case 1:
                                    Movimientos movimiento = new Movimientos("Retiro", this.getNombre(), this.montoRetiro, "No");
                                    texto.escribir("logs.txt", movimiento, true);
                                    this.menu();
                                    break;
                                case 2:
                                    this.retiroEfectivo();
                                    break;
                                default:
                                    System.out.println("Esta opcion no es valida, intentalo de nuevo");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Ingreso una opcion no valida, intentelo de nuevo");
                            leer.nextLine();
                        }

                    } while (cancelar < 1 || cancelar > 3);
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresó una cantidad no válida. la operacion sera cancelada.");
                leer.next();
                this.menu();
                comprobar = false;
            }
        } while (montoRetiro % retiroMinimo != 0 || comprobar == false);

        boolean continuar;
        continuar = binario.obtenerDatos("billetes.dat", montoRetiro);
        if (continuar == true) {
            System.out.println("Retiro realizado con exito");
            saldo -= montoRetiro;
            System.out.println("Su nuevo saldo es de " + saldo);
            Movimientos movimiento = new Movimientos("Retiro", this.getNombre(), this.montoRetiro, "Si");
            texto.escribir("logs.txt", movimiento, true);
            this.menu();
        }
    }

    public void salirCajero() {
        System.out.println("Saliendo del cajero");
        System.exit(0);
    }
}

package CajeroAutomatico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrador {

    private String nombre;
    private int NIP;
    private int accionRealizada = 0;
    Scanner leer = new Scanner(System.in);
    ArchivoDeTexto texto = new ArchivoDeTexto();
    ArchivoBinario binario = new ArchivoBinario();

    public Administrador() {
        this.nombre = "admin";
        this.NIP = 3243;
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

    public void menu() {
        do {
            try {
                System.out.println("¿Que desea realizar?");
                System.out.println("1: Consultar mivimientos del cajero");
                System.out.println("2: Consultar Billetes disponibles");
                System.out.println("3: Salir del cajero");
                accionRealizada = leer.nextInt();
                switch (accionRealizada) {
                    case 1:
                        this.consultaMovimientos();
                        break;
                    case 2:
                        this.consultaBilletes();
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

    private void consultaMovimientos() {
        texto.leer("logs.txt");
        this.menu();
    }

    private void consultaBilletes() {
        binario.leer("billetes.dat");
        this.menu();
    }

    private void salirCajero() {
        System.out.println("Saliendo del cajero");
        System.exit(0);
    }
}

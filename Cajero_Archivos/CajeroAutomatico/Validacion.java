package CajeroAutomatico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validacion {

    private String nombre;
    private int NIP = 0;
    private Scanner leer = new Scanner(System.in);

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

    public int validar() {
        do {
            try {

                System.out.println("Nombre de Ususario: ");
                this.nombre = leer.nextLine();
                System.out.print("NIP: ");
                this.NIP = Integer.parseInt(leer.nextLine());
                if (nombre.equals("admin") && NIP == 3243) {
                    return 1;
                } else if (String.valueOf(NIP).length() == 4) {
                    return 2;
                } else {
                    System.out.println("El NIP ingresado no es valido");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Error: El nombre o NIP son invalidos, intentelo de nuevo");
            }

        } while (String.valueOf(NIP).length() != 4);
        return 3;
    }
}

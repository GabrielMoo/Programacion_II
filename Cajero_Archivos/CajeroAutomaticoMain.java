
import java.util.Scanner;
import CajeroAutomatico.*;
import java.io.IOException;
import java.util.ArrayList;

public class CajeroAutomaticoMain {

    public static void main(String[] args) {

        String nombre;
        int NIP = 0;
        int tipoUsuario, accionRealizada = 0;
        Scanner leer = new Scanner(System.in);

        Validacion NuevoNip = new Validacion();
        tipoUsuario = NuevoNip.validar();

        if (tipoUsuario == 1) {
            Administrador admin = new Administrador();
            System.out.println("Usted a accedido al perfil de administrador");
            admin.menu();
            accionRealizada = leer.nextInt();
        } else if (tipoUsuario == 2) {
            UsuarioComun user = new UsuarioComun(NuevoNip.getNombre(), NuevoNip.getNIP());
            System.out.println("Bienvenido al cajero");
            user.menu();
        }

    }
}

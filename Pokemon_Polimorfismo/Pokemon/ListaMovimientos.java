package Pokemon;
import java.util.ArrayList;

public class ListaMovimientos {
    
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos()
    {
        // movimientos de Gengar
        movimientos.add(new Movimiento("Lenguetazo", 30, 30, Tipo.FANTASMA, ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Comesueños", 100, 15, Tipo.PSIQUICO, ClaseMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Bola Sombra", 80, 15, Tipo.FANTASMA, ClaseMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Hipnosis", 0, 20, Tipo.PSIQUICO, ClaseMovimiento.ESTADO));
    
        // movimientos de Blastoise
        movimientos.add(new Movimiento("Pistola Agua", 40, 25, Tipo.AGUA, ClaseMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Agua Cola", 90, 10, Tipo.AGUA, ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Placaje", 40, 35, Tipo.NORMAL, ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Refugio", 0, 40, Tipo.AGUA, ClaseMovimiento.ESTADO));
    }
        
    public Movimiento buscarMovimientosPorNombre(String nombre)
    {
        for(Movimiento movimiento : movimientos)
        {
            if(movimiento.getNombre().equals(nombre))
            {
                return movimiento;
            }
        }
        return null;
    }
}

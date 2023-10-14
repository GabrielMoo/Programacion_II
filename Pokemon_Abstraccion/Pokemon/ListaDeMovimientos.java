package pokemon;
import java.util.ArrayList;

public class ListaDeMovimientos
{
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaDeMovimientos()
    {
        // movimientos de tipo Fantasma
        movimientos.add(new Movimiento("Puño Sombra", 60, Tipo.FANTASMA, 20));
        movimientos.add(new Movimiento("Lenguetazo", 30, Tipo.FANTASMA, 30));
        movimientos.add(new Movimiento("Impresionar", 30, Tipo.FANTASMA, 15));
        movimientos.add(new Movimiento("Golpe Fantasma", 90, Tipo.FANTASMA, 10));

        // movimientos de tipo Lucha
        movimientos.add(new Movimiento("Golpe Roca", 40, Tipo.LUCHA, 15));
        movimientos.add(new Movimiento("Demolicion", 75, Tipo.LUCHA, 15));
        movimientos.add(new Movimiento("Ultrapuño", 40, Tipo.LUCHA, 30));
        movimientos.add(new Movimiento("A Bocajarro", 120, Tipo.LUCHA, 5));
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
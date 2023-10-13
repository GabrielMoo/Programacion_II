package pokemon;
import java.util.ArrayList;

public class ListaDeMovimientos
{
    private ArrayList<movimiento> movimientos = new ArrayList<>();

    public ListaDeMovimientos()
    {
        // movimientos de tipo Fantasma
        movimientos.add(new Movimiento("Puño Sombra", 120, Tipo.FANTASMA, 10));
        movimientos.add(new Movimiento("Lenguetazo", 100, Tipo.FANTASMA, 10));
        movimientos.add(new Movimiento("Vendetta", 100, Tipo.SINIESTRO, 10));
        movimientos.add(new Movimiento("Golpe Bajo", 140, Tipo.SINIESTRO, 10));

        // movimientos de tipo Lucha
        movimientos.add(new Movimiento("Golpe Roca", 100, Tipo.LUCHA, 10));
        movimientos.add(new Movimiento("Garra Metal", 100, Tipo.ACERO, 10));
        movimientos.add(new Movimiento("Velocidad exterema", 160, tipo.NORMAL, 10));
        movimientos.add(new Movimiento("A Bocajarro", 190, Tipo.LUCHA, 10));

        public Movimiento buscarMovimientoPorNombre(String nombre)
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
}
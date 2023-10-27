package Pokemon;

public class Blastoise extends Pokemon {

private Tipo primario;

    public Blastoise(String Nombre, int Nivel) {
        super(79, 83, 100, 85, 105, 78, Nivel, Nombre);
        this.primario = Tipo.AGUA;
        
        ListaMovimientos listaDeMovimientos = new ListaMovimientos();
        setMovimientos(0, listaDeMovimientos.buscarMovimientosPorNombre("Pistola Agua"));
        setMovimientos(1, listaDeMovimientos.buscarMovimientosPorNombre("Agua Cola"));
        setMovimientos(2, listaDeMovimientos.buscarMovimientosPorNombre("Placaje"));
        setMovimientos(3, listaDeMovimientos.buscarMovimientosPorNombre("Refugio")); 
    }

    public Tipo getPrimario() {
        return primario;
    }

    @Override
    public double obtenerEfectividad(Movimiento movimiento) {
        double efectividad = 1.0;
        if(movimiento.getTipo() == Tipo.ACERO) efectividad = 0.5;
        if(movimiento.getTipo() == Tipo.AGUA) efectividad = 0.5;
        if(movimiento.getTipo() == Tipo.ELECTRICO) efectividad = 2.0;
        if(movimiento.getTipo() == Tipo.FUEGO) efectividad = 0.5;
        if(movimiento.getTipo() == Tipo.HIELO) efectividad = 0.5;
        if(movimiento.getTipo() == Tipo.PLANTA) efectividad = 2.0;
        return efectividad;
    }
    
}

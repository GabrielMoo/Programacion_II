package Pokemon;

public class Gengar extends Pokemon{
    private Tipo primario;
    private Tipo Secundario;

    public Gengar(String Nombre, int Nivel) {
        super(60, 65, 60, 130, 75, 110, Nivel, Nombre);
        this.primario = Tipo.FANTASMA;
        this.Secundario = Tipo.VENENO;
        
        ListaMovimientos listaDeMovimientos = new ListaMovimientos();
        setMovimientos(0, listaDeMovimientos.buscarMovimientosPorNombre("Lenguetazo"));
        setMovimientos(1, listaDeMovimientos.buscarMovimientosPorNombre("Comesueños"));
        setMovimientos(2, listaDeMovimientos.buscarMovimientosPorNombre("Bola Sombra"));
        setMovimientos(3, listaDeMovimientos.buscarMovimientosPorNombre("Hipnosis"));      
    }

    public Tipo getPrimario() {
        return primario;
    }

    public Tipo getSecundario() {
        return Secundario;
    }

    @Override
    public double obtenerEfectividad(Movimiento movimiento) {
        double efectividad = 1.0;
        if(movimiento.getTipo() == Tipo.BICHO) efectividad = 0.25;
        if(movimiento.getTipo() == Tipo.HADA) efectividad = 2.0;
        if(movimiento.getTipo() == Tipo.FANTASMA) efectividad = 2.0;
        if(movimiento.getTipo() == Tipo.PLANTA) efectividad = 0.5;
        if(movimiento.getTipo() == Tipo.LUCHA) efectividad = 0.0;
        if(movimiento.getTipo() == Tipo.NORMAL) efectividad = 0.0;
        if(movimiento.getTipo() == Tipo.PSIQUICO) efectividad = 2.0;
        if(movimiento.getTipo() == Tipo.SINIESTRO) efectividad = 2.0;
        if(movimiento.getTipo() == Tipo.TIERRA) efectividad = 2.0;
        if(movimiento.getTipo() == Tipo.VENENO) efectividad = 0.25;
        return efectividad;
    }
    
    
}


package pokemon;

public class PokemonLucha extends Pokemon
{
    public PokemonLucha(String nombre, int nivel)
    {
        super(nombre, Tipo.LUCHA, nivel);
        ListaDeMovimientos listaDeMovimientos = new ListaDeMovimientos();
                
        setMovimiento(0, listaDeMovimientos.buscarMovimientosPorNombre("Golpe Roca"));
        setMovimiento(1, listaDeMovimientos.buscarMovimientosPorNombre("Demolicion"));
        setMovimiento(2, listaDeMovimientos.buscarMovimientosPorNombre("Ultrapuño"));
        setMovimiento(3, listaDeMovimientos.buscarMovimientosPorNombre("A Bocajarro"));
    }
    
    @Override
    public double obtenerEfectividad(Pokemon pokemon)
    {
        double efectividad = 1.0;
        if(pokemon.getTipo() == Tipo.PSIQUICO) efectividad = 0.0;
        if(pokemon.getTipo() == Tipo.FANTASMA) efectividad = 2.0;
        return efectividad;
    }
}
package pokemon;

public class PokemonFantasma extends Pokemon
{
    public PokemonFantasma(String nombre, int nivel)
    {
        super(nombre, Tipo.FANTASMA, nivel);
        ListaDeMovimientos listaDeMovimientos = new ListaDeMovimientos();
                
        setMovimiento(0, listaDeMovimientos.buscarMovimientosPorNombre("Puño Sombra"));
        setMovimiento(1, listaDeMovimientos.buscarMovimientosPorNombre("Lenguetazo"));
        setMovimiento(2, listaDeMovimientos.buscarMovimientosPorNombre("Impresionar"));
        setMovimiento(3, listaDeMovimientos.buscarMovimientosPorNombre("Golpe Fantasma"));
    }
    
    @Override
    public double obtenerEfectividad(Pokemon pokemon)
    {
        double efectividad = 1.0;
        if(pokemon.getTipo() == Tipo.PSIQUICO) efectividad = 0.0;
        if(pokemon.getTipo() == Tipo.LUCHA) efectividad = 2.0;
        return efectividad;
    }
}
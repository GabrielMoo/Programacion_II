import pokemon.PokemonLucha;
import pokemon.PokemonFantasma;

public class BatallaPokemon
{
    public static void main(String[]args)
    {
        PokemonLucha Lucario = new PokemonLucha("Lucario", 10);
        PokemonFantasma Gengar = new PokemonFantasma("Gengar", 10);
        
        Lucario.atacar(0, Gengar);
        Gengar.atacar(2, Lucario);
    }
}
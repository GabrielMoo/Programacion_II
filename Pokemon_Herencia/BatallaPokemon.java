public class BatallaPokemon
{
    public static void main(String[]args)
    {
        PokemonLucha Lucario = new PokemonLucha("Lucario", 10);
        PokemonFantasma Gengar = new PokemonFantasma("Gengar", 10);
        
        Lucario.atacar("Ataque Rápido Quick Attack", Gengar);
        Gengar.atacar("Shadow Punch", Lucario);
    }
}
import Pokemon.Blastoise;
import Pokemon.Gengar;

public class BatallaPokemon {

    public static void main(String[] args) {
        Blastoise blastoise = new Blastoise("Blastoise", 1);
        Gengar gengar = new Gengar("Gengar", 1);
        
        blastoise.atacar(0, gengar);
        gengar.atacar(2, blastoise);
    }
}

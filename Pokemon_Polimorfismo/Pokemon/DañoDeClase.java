package Pokemon;

public interface DañoDeClase {
    
    public void danioFisico(int efectividad, int potencia, int nivel, int ataque , int defensa);
    public void danioEspecial(int efectividad, int potencia, int nivel, int ataqueEspecial, int defensaEspecial);
    public void DanioEstado();
    
}

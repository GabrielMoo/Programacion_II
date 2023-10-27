package Pokemon;

public abstract class Pokemon implements DañoDeClase
{
    private int PS, Ataque, Defensa, AtaqueEspecial, DefensaEspecial, Velocidad, Nivel;
    private String Nombre;
    private Movimiento[] movimientos;

    public Pokemon(int PS, int Ataque, int Defensa, int AtaqueEspecial, int DefensaEspecial, int Velocidad, int Nivel, String Nombre) {
        this.PS = PS;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.AtaqueEspecial = AtaqueEspecial;
        this.DefensaEspecial = DefensaEspecial;
        this.Velocidad = Velocidad;
        this.Nivel = Nivel;
        this.Nombre = Nombre;
        this.movimientos = new Movimiento[4];
    }

    public int getPS() {
        return PS;
    }

    public int getAtaque() {
        return Ataque;
    }

    public int getDefensa() {
        return Defensa;
    }

    public int getAtaqueEspecial() {
        return AtaqueEspecial;
    }

    public int getDefensaEspecial() {
        return DefensaEspecial;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public int getNivel() {
        return Nivel;
    }

    public String getNombre() {
        return Nombre;
    }

    public Movimiento getMovimientos(int pocision) {
        return movimientos[pocision];
    }

    public void setMovimientos(int pocision, Movimiento movimientos) {
        this.movimientos[pocision] = movimientos;
    }

    private void calculaDanio(ClaseMovimiento clase, double efectividad) {   
        int variacion = (int)(85 + Math.random()*16);
        int danio = (int)(efectividad * variacion * 0.01);
        float daño = (float)danio;
	this.PS -= danio;
        System.out.printf("%s recibe %.2f puntos de danio \n", this.getNombre(), daño);
    } 

    public void recibirAtaque(Movimiento movimiento, double efectividad) {  
        System.out.printf("%s recibe ATK %s\n", this.getNombre(),movimiento.getNombre());
        calculaDanio(movimiento.getClaseMovimiento(),efectividad);   
    }
  
    protected boolean seHaConcretadoAtaque (Movimiento movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n",this.getNombre(),pokemon.getNombre(),movimiento.getNombre());
        double efectividad = pokemon.obtenerEfectividad(movimiento);
        if(movimiento.getPP()>0) {
            if(movimiento.getClaseMovimiento()==ClaseMovimiento.FISICO) {
                double danio = ((((0.2 * this.getNivel()+ 1)* (this.getAtaque() * movimiento.getPotencia()))/ (25 * pokemon.getDefensa()))+2);
                efectividad = efectividad * danio;
            } else if(movimiento.getClaseMovimiento()==ClaseMovimiento.ESPECIAL){
                 double danio = ((((0.2 * this.getNivel()+ 1)* (this.getAtaqueEspecial()* movimiento.getPotencia()))/ (25 * pokemon.getDefensaEspecial()))+2);
                efectividad = efectividad * danio;
            }
            
            pokemon.recibirAtaque(movimiento,efectividad);
            return true;
        }else{
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }  
    }
  
    public void atacar(int m, Pokemon pokemon) {
        Movimiento movimiento = getMovimientos(m);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon);
        if (seHaConcretadoAtaque) {
            pokemon.getMovimientos(m).setPP(movimiento.getPP()-1);
        }
    }   
    
    @Override
    public void danioFisico(int efectividad, int potencia, int nivel, int ataque, int defensa) {
        System.out.println("Daño Fisico");
    }

    @Override
    public void danioEspecial(int efectividad, int potencia, int nivel, int ataqueEspecial, int defensaEspecial) {
        System.out.println("Daño Especial");
    }

    @Override
    public void DanioEstado() {
        System.out.println("Este ataque no genera daño");
    }
    
    public abstract double obtenerEfectividad(Movimiento movimiento);

}

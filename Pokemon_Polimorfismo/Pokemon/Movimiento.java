package Pokemon;

public class Movimiento {
    
    private String nombre;
    private int potencia, PP;
    private Tipo tipo;
    private ClaseMovimiento claseMovimiento;

    public Movimiento(String nombre, int potencia, int PP, Tipo tipo, ClaseMovimiento claseMovimiento) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.PP = PP;
        this.tipo = tipo;
        this.claseMovimiento = claseMovimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getPP() {
        return PP;
    }
    
    public void setPP(int PP) {
        this.PP = PP;
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public ClaseMovimiento getClaseMovimiento() {
        return claseMovimiento;
    }
        
}

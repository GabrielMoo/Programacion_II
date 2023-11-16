package CajeroAutomatico;

import java.io.Serializable;

public class Movimientos implements Serializable {

    private String accion;
    private String usuario;
    private int saldo;
    private String seRealizo;

    public Movimientos(String accion, String usuario, int saldo, String seRealizo) {
        this.accion = accion;
        this.usuario = usuario;
        this.saldo = saldo;
        this.seRealizo = seRealizo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String isSeRealizo() {
        return seRealizo;
    }

    public void setSeRealizo(String seRealizo) {
        this.seRealizo = seRealizo;
    }

    @Override
    public String toString() {
        return "Movimiento [accion=" + accion + ", nombreUsuario=" + usuario + ", cantidad=" + saldo + ", accionRealizada=" + seRealizo + "]";
    }
}

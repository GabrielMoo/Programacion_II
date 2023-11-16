package CajeroAutomatico;

import java.io.Serializable;

public class Billete implements Serializable {

    int denominacion, cantidad;

    public Billete(int denominacion, int cantidad) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }

    public int getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Billete [Denominacion=" + denominacion + ", Cantidad=" + cantidad + "]";
    }
}

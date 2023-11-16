package CajeroAutomatico;

import java.io.*;
import java.util.ArrayList;

public class ArchivoBinario {

    int billetesUsados, billeteDe1000, billeteDe500, billeteDe200, billeteDe100, saldoCajero, retiroMinimo;
    ArrayList<Billete> billetesRestantes;

    public void crear(String nombre, ArrayList<Billete> billetes) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombre));
            outputStream.writeObject(billetes);
            outputStream.close();
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void escribir(String nombre, ArrayList<Billete> billetes) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombre));

            outputStream.writeObject(billetes);
            outputStream.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void leer(String nombre) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));

            try {
                while (true) {
                    ArrayList<Billete> billetes = (ArrayList<Billete>) inputStream.readObject();
                    for (Billete m : billetes) {
                        System.out.println('1');
                        System.out.println(m);
                    }
                }
            } catch (EOFException e) {
                // Fin del archivo
            }
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    public boolean obtenerDatos(String nombre, int montoRetiro) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));

            try {
                ArrayList<Billete> billetes = (ArrayList<Billete>) inputStream.readObject();
                billetesRestantes = this.usar(montoRetiro, billetes);
                this.escribir("billetes.dat", billetesRestantes);
            } catch (EOFException e) {
                // Fin del archivo
            }
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return true;
    }

    public ArrayList usar(int montoRetiro, ArrayList<Billete> billetes) {
        ArrayList<Billete> registro = new ArrayList<>();
        if (montoRetiro / 1000 >= 1 && billetes.get(0).getCantidad() > 0) {
            billetesUsados = (int) montoRetiro / 1000;
            if(billetesUsados > billetes.get(0).getCantidad()){
                billetesUsados = billetes.get(0).getCantidad();
            }
            billeteDe1000 = billetes.get(0).getCantidad();
            billeteDe1000 -= billetesUsados;
            billetes.get(0).setCantidad(billeteDe1000);
            montoRetiro -= billetesUsados * 1000;
        }

        if (montoRetiro / 500 >= 1 && billetes.get(1).getCantidad() > 0) {
            billetesUsados = (int) montoRetiro / 500;
            if(billetesUsados > billetes.get(1).getCantidad()){
                billetesUsados = billetes.get(1).getCantidad();
            }
            billeteDe500 = billetes.get(1).getCantidad();
            billeteDe500 -= billetesUsados;
            billetes.get(1).setCantidad(billeteDe500);
            montoRetiro -= billetesUsados * 500;
        }

        if (montoRetiro / 200 >= 1 && billetes.get(2).getCantidad() > 0) {
            billetesUsados = (int) montoRetiro / 200;
            if(billetesUsados > billetes.get(2).getCantidad()){
                billetesUsados = billetes.get(2).getCantidad();
            }
            billeteDe200 = billetes.get(2).getCantidad();
            billeteDe200 -= billetesUsados;
            billetes.get(2).setCantidad(billeteDe200);
            montoRetiro -= billetesUsados * 200;
        }

        if (montoRetiro / 100 >= 1 && billetes.get(3).getCantidad() > 0) {
            billetesUsados = (int) montoRetiro / 100;
            if(billetesUsados > billetes.get(3).getCantidad()){
                billetesUsados = billetes.get(3).getCantidad();
            }
            billeteDe100 = billetes.get(3).getCantidad();
            billeteDe100 -= billetesUsados;
            billetes.get(3).setCantidad(billeteDe100);
            montoRetiro -= billetesUsados * 100;
        }
        registro = billetes;
        return registro;
    }

    public void instanciarBilletes(String nombre) {
        ArrayList<Billete> billetes = new ArrayList<>();
        billetes.add(new Billete(1000, 10));
        billetes.add(new Billete(500, 20));
        billetes.add(new Billete(200, 100));
        billetes.add(new Billete(100, 100));
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre))) {
            billetesRestantes = (ArrayList<Billete>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            this.escribir(nombre, billetes);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer desde el archivo");
        }
    }

    public int saldoCajero(String nombre) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));

            try {
                ArrayList<Billete> billetes = (ArrayList<Billete>) inputStream.readObject();
                this.saldoCajero = (billetes.get(0).cantidad * billetes.get(0).getDenominacion()) + (billetes.get(1).cantidad * billetes.get(1).getDenominacion()) + (billetes.get(2).cantidad * billetes.get(2).getDenominacion()) + (billetes.get(3).cantidad * billetes.get(3).getDenominacion());
            } catch (EOFException e) {
                // Fin del archivo
            }
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return saldoCajero;
    }

    public int retiroMinimo(String nombre) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));

            try {
                ArrayList<Billete> billetes = (ArrayList<Billete>) inputStream.readObject();

                for (int i = 0; i < billetes.size(); i++) {
                    if (billetes.get(i).getCantidad() > 0) {
                        this.retiroMinimo = billetes.get(i).getDenominacion();
                    }
                }
            } catch (EOFException e) {
                // Fin del archivo
            }
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return retiroMinimo;
    }
}

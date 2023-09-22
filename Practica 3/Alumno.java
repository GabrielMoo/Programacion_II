public class Alumno {
    private String nombre;
    private String carrera;
    private int matricula;
    private int grado;
    private char grupo;
    private Tutor tutor=new Tutor();

    public Alumno(String nombre, String carrera, int matricula, int grado, char grupo) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.matricula = matricula;
        this.grado = grado;
        this.grupo = grupo;
    }
    
    public Tutor gettutor() {
        return tutor;
    }

}

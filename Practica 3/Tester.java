public class Tester
{
    public static void main(String[] args)
    {
    Alumno pepito=new Alumno("Pepito", "ISC", 64888, 2, 'B');
    String telefono=pepito.gettutor().gettelefono().toString();
    System.out.println(telefono);
    }
}


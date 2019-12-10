package MetodosBusqueda;

public class regAlumnos{

    long cve;
    String name;
    int edad;
    char sexo;
    static int tam=94;

    public regAlumnos()
    {
        cve=0;edad=0;name="";sexo=' ';
    }

    public regAlumnos(String n, int e, char s)
    {
        name=n;
        edad=e;
        sexo=s;
    }
}
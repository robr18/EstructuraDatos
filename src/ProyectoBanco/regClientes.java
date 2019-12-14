package ProyectoBanco;

public class regClientes{

    long cve;
    String name;
    int edad;
    char sexo;
    double saldo;
    String RFC;

    static int tam=130;

    public regClientes()
    {
        cve=0;edad=0;name="";sexo=' ';
    }

    public regClientes(String n, int e, char s)
    {
        name=n;
        edad=e;
        sexo=s;
    }

    public String toString()
    {
        return "Contenido del registro\n"+"Clave: "+cve+" Nombre: "+name+" Edad: "+edad+" Sexo: "+sexo;
    }
}
package MetodosBusqueda;

import java.util.*;

public class Lectura{
    static Scanner sc=new Scanner(System.in);

    public static String Cadena(String mens)
    {
        String cad;
        System.out.print(mens);
        cad=sc.nextLine();
        return cad;
    }

    public static int Entero(String mens)
    {
        String cad;
        int x;
        System.out.print(mens);
        cad=sc.nextLine();
        try{
            x=Integer.parseInt(cad);
        }catch(NumberFormatException e){
            return Entero(mens);
        }
        return x;
    }

    public static Long EnteroL(String mens)
    {
        String cad;
        long x;
        System.out.print(mens);
        cad=sc.nextLine();
        try{
            x=Long.parseLong(cad);
        }catch(NumberFormatException e){
            return EnteroL(mens);
        }
        return x;
    }

    public static char Caracter(String mens)
    {
        String cad;
        System.out.println(mens);
        cad=sc.nextLine();
        return cad.charAt(0);
    }
}
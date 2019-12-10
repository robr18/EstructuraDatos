package MetodosBusqueda;

import java.util.*;

public class Lectura{
    Scanner sc=new Scanner(System.in);

    public String Cadena(String mens)
    {
        String cad;
        System.out.print(mens);
        cad=sc.nextLine();
        return cad;
    }

    public int Entero(String mens)
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

    public Long EnteroL(String mens)
    {
        String cad;
        long x;
        System.out.print(mens);
        cad=sc.nextLine();
        try{
            x=Integer.parseInt(cad);
        }catch(NumberFormatException e){
            return EnteroL(mens);
        }
        return x;
    }

    public char Caracter(String mens)
    {
        String cad;
        System.out.println(mens);
        cad=sc.nextLine();
        return cad.charAt(0);
    }
}
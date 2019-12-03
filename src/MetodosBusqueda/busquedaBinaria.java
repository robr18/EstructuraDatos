package MetodosBusqueda;
import java.util.*;

public class busquedaBinaria
{
    int numS[];
    public busquedaBinaria(int t)
    {
        numS=new int[t];
    }

    public void llenar()
    {
        Random R=new Random();
        for(int i=0;i<numS.length;i++)
        {
            numS[i]=R.nextInt(100);
        }
    }

    public void mostrar()
    {
        for(int i=0;i<numS.length;i++)
            System.out.print(numS[i]+" ");
        System.out.println();
    }

    public int Secuencial(int num)
    {
        for(int i=0;i<numS.length;i++)
        {
            if(num==numS[i])
                return i;
        }
        return -1;
    }

    public int Binaria(int num)
    {
        int ini=0, fin=numS.length-1;
        int mitad;
        Arrays.sort(numS);
        System.out.println("Numeros ordenados");
        mostrar();
        while(ini<=fin)
        {
            mitad=(ini+fin)/2;
            if(num==numS[mitad])
                return mitad;
            else
                if(num>numS[mitad])
                    ini=mitad+1;
                else
                    fin=mitad-1;
        }
        return -1;
    }

    public void modulo(int num)
    {
        int dir=num%5;
        System.out.println(dir);
    }


    public static void main(String[] args) {
        busquedaBinaria obj=new busquedaBinaria(50);
        obj.llenar();
        obj.mostrar();
        int res=obj.Secuencial(55);
        if(res!=-1)
            System.out.println("Localizado en la posición "+res);
        else
            System.out.println("No existe el numero");
        res=obj.Binaria(55);
        if(res!=-1)
            System.out.println("Localizado en la posición "+res);
        else
            System.out.println("No existe el numero");
    }

}
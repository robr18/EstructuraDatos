package Evaluacion;

import java.util.*;

public class examen5{

    Random R=new Random();
    int vnc[]={10,11,12,13,14,15,16,17,18,19};
    int vec[];

    public examen5(int tam)
    {
        vec=new int[tam];
    }

    public void Generador()
    {
        String mid="420";

        for(int i=0;i<vec.length;i++)
        {
            String fin=R.nextInt(1000)+"";
            if(fin.length()==1)
            {
                String temp="00";
                fin=temp+fin;
            }else{
                if(fin.length()==2)
                {
                    String temp="0";
                    fin=temp+fin;
                }

            }
            int posprim=R.nextInt(10);
            String prim=vnc[posprim]+"";
            String ncS=prim+mid+fin;
            int nc=Integer.parseInt(ncS);
            vec[i]=nc;
        }
   }

public int Mayor() {
    int mayor = 0;
    for (int i = 0; i < vec.length; i++)
        if (vec[i] > mayor)
            mayor = vec[i];
    return mayor;
}

public void Radix()
{
       
       int pasadas=10;
       LinkedList<Integer>Ldig[]=new LinkedList[10];
       for(int i=0;i<Ldig.length;i++)
           Ldig[i]=new LinkedList<Integer>();
       int factorx=1,num,res,dig,ind;
       for(int p=0;p<pasadas;p++)
       {
           for(int j=0;j<vec.length;j++)
           {
               num=vec[j];
               res=num/factorx;
               dig=res%10;
               Ldig[dig].add(num);
           }
           //sacar los elementos de las listas
           //regresarlos al vector numeros
           ind=0;
           for(int i=0;i<Ldig.length;i++)
           {
               while(!Ldig[i].isEmpty())
               {
                   vec[ind++]=Ldig[i].remove(0);
               }
           }
           factorx*=10;
       }

}

   public void mostrar()
   {
       for(int i=0;i<vec.length;i++)
            System.out.print(vec[i]+" ");
        System.out.println();
   }


    public static void main(String[] args) {
        examen5 obj=new examen5(10);
        obj.Generador();
        obj.mostrar();
        obj.Radix();
        System.out.println("Numeros ordenados");
        obj.mostrar();
    }

}

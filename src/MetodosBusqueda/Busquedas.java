package MetodosBusqueda;

import java.util.Random;

public class Busquedas{

    long cves[];

    public Busquedas()
    {
        cves=new long[100];
    }
    public void genCves()
    {
        String tec="420";
        Random R=new Random();
        for(int i=0;i<cves.length;i++)
        {
            tec=(10+R.nextInt(10))+tec+(100+R.nextInt(800));
            cves[i]=Integer.parseInt(tec);
            tec="420";
            System.out.print(cves[i]+" ");
        }
    }

    public int modulo(long cve)
    {
        int pos=0;

        pos=(int)(cve%97);


        return pos;
    }

    public void asignarCvesHash()
    {
        indice arch=new indice();
        for(int i=0;i<cves.length;i++)
        {
            long cve=cves[i];
            int pos=modulo(cve);
            molde temp=new molde(cve,pos,true);
            molde t=arch.Leer(pos);

            if(!t.g)
            {
                arch.grabar(temp);
            }else{
                //prueba lineal avanzar a la sig posición
                boolean guardo=false;
                do{
                temp.pos++;
                t=arch.Leer(temp.pos);
                if(t!=null)
                {    if(!t.g)
                        {
                            arch.grabar(temp);
                            guardo=true;
                        }
                }else{
                    temp.pos=-1;

                }
                }while(!guardo);
            }

        }
    }

    public static void main(String[] args) {
        Busquedas obj=new Busquedas();
        obj.genCves();
        obj.asignarCvesHash();
    }
}
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

    //Metodos que generan las posiciones de forma cuadratica

    public int cuadratica(long cve)
    {
        int pos=0;

        long numC=(long)Math.pow(cve, 2);
        //long numC=cve*cve;
        String posS=digC(numC);
        pos=Integer.parseInt(posS);
        return pos;
    }

    public String digC(long cve)
    {
        String temp=cve+"";
        int posc=(temp.length()/2);
        return temp.substring(posc-1,posc+1);
    }

    public void asignarCvesHash()
    {
        int contCol=0;
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
                boolean guardado=false;
                do{
                temp.pos++;
                contCol++;
                if(temp.pos==cves.length) 
                    temp.pos=0;
                t=arch.Leer(temp.pos);
                if(t!=null)
                {    if(!t.g)
                        {
                            arch.grabar(temp);
                            guardado=true;
                        }
                }
                }while(!guardado);
            }
        }
        System.out.println("Total de colisiones: "+contCol);
    }

    public void unaSolaVez(){
        indice archt=new indice();
        molde regt=new molde(0l,0,false);
        for(int i=0;i<100;i++)
        {
            regt.pos=i;
            archt.grabar(regt);
        }
        archt.Cerrar();

    }

    public static void main(String[] args) {
        Busquedas obj=new Busquedas();
        //obj.genCves();
        //obj.unaSolaVez();
        //obj.asignarCvesHash();
        //indice archt=new indice();
        //archt.reporte();
        //archt.Cerrar();
        int res=obj.cuadratica(9359);
        System.out.println(res);
    }
}
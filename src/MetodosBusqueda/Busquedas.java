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
        String temp=numC+"";
        int posc=(temp.length()/2);
        String posS=digC(numC,posc);
        pos=Integer.parseInt(posS);
        return pos;
    }

    public String digC(long cve,int pos)
    {
        String temp=cve+"";
        return temp.substring(pos-1,pos+1);
    }

    //Metodos de plegamiento

    public int plegamiento(long cve)
    {
        int pos=0;
        String suma=sumaPartes(cve);
        pos=Integer.parseInt(suma.substring(suma.length()-2));

        return pos;
    }

    public String sumaPartes(long cve)
    {
        int suma=0;
        String cveS=cve+"";
        String partes[]=new String[(cveS.length())];

        //Dividimos la clave en partes iguales
        for(int i=0,j=0;i<partes.length;i++,j++){

            int calcF=i+2;
            if(calcF>cveS.length())
            {
                partes[j]=cveS.charAt(i-2)+"";
            }else
                partes[j]=cveS.substring(i, calcF);
            i++;
        }

        for(int i=0;i<partes.length;i++)
        {
            if(partes[i]!=null)
            {
                int num=Integer.parseInt(partes[i]);
                suma+=num;
            }else{
                break;
            }
        }
        return suma+"";
    }

    //Metodo de truncamiento

    public int truncamiento(long cve)
    {
        int pos=0;

        //*Generado con digitos impares
        //!Selecciona los digitos de izq a der por que hay mas variación de los nc

        String cveS=cve+"";

        String vecC[]=new String[3];
        vecC[0]=cveS.charAt(cveS.length()-1)+"";
        vecC[1]=cveS.charAt(cveS.length()-3)+"";
        cveS=vecC[0]+vecC[1];
        pos=Integer.parseInt(cveS);

        return pos;

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
        indice archt=new indice();
        DatosAlum dA=new DatosAlum();
        dA.Abrir();
        regAlumnos regt=new regAlumnos();
        molde r=new molde();
        for(int i=0;i<100;i++)
        {
            r=archt.Leer(i);
            regt.cve=r.cve;
            dA.Grabar(regt,r.pos);
        }

        archt.Cerrar();
        dA.Cerrar();
        archt.reporte();
        archt.Cerrar();
}
}
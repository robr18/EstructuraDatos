package MetodosBusqueda;

import java.io.IOException;
import java.io.RandomAccessFile;


class molde{
    static int tam=13;
    int pos;
    long cve;
    boolean g;

    public molde()
    {
        g=false;
        pos=0;
        cve=0;
    }

    public molde(Long c, int p, boolean gr)
    {
        cve=c;pos=p;
        g=gr;
    }

    public String toString()
    {
        return cve+" "+pos;
    }
}

public class indice{

    RandomAccessFile arch;

    public indice()
    {
        try{
        arch=new RandomAccessFile("/src/indice.oto", "rw");
        }catch(IOException e){
            System.out.println("Error de apertura");
        }
    }

    public void grabar(molde reg)
    {
        try{
            arch.seek(reg.pos*molde.tam);
            arch.writeBoolean(reg.g);
            arch.writeLong(reg.cve);
            arch.writeInt(reg.pos);

        }catch(IOException e)
        {
            System.out.println("Error de escritura");
        }
    }

    public molde Leer(int pos)
    {
        molde reg=new molde();

        try{
            arch.seek(pos*molde.tam);
            reg.g=arch.readBoolean();
            reg.cve=arch.readLong();
            reg.pos=arch.readInt();
        }catch(IOException e){
            return null;
        }
        catch(Exception e)
        {
            System.out.println("Error de lectura");
        }
        return reg;
    }

    public void Cerrar()
    {
        try{
            arch.close();
        }catch(IOException e){}
    }
}
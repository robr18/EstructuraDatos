package MetodosBusqueda;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CveAsignada{

    RandomAccessFile arch;

    public void Abrir()
    {
        try{
            arch=new RandomAccessFile("cveasig.oto", "rw");
            }catch(Exception e){
                System.out.println("Error de apertura");
            }
    }

    public void Cerrar()
    {
        try{
            arch.close();
        }catch(IOException e){

        }
    }

    public void Grabar(int num)
    {
        try{
            arch.seek(0);
            arch.writeInt(num);
        }catch(IOException e){}
    }

    public int Leer()
    {
        int num;
        try{
            arch.seek(0);
            num=arch.readInt();
        }catch(IOException e){
            return -1;
        }
        return num;
    }

    public static void main(String[] args) {
        CveAsignada obj=new CveAsignada();
        obj.Abrir();
        obj.Grabar(0);
        obj.Cerrar();
    }
}
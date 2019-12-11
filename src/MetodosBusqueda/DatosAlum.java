package MetodosBusqueda;

import java.io.*;

public class DatosAlum{

    RandomAccessFile archA=null;

    public void Abrir()
    {
        try{
            archA=new RandomAccessFile("Datos.txt", "rw");
        }catch(IOException e){
            System.out.println("Error de Apertura");
        }
    }

    public void Cerrar()
    {
        try{
            archA.close();
        }catch(IOException e)
        {

        }
    }

    public void Grabar(regAlumnos reg,int pos)
    {
        try{
            archA.seek(pos*regAlumnos.tam);
            archA.writeLong(reg.cve);
            archA.writeUTF(reg.name);
            archA.writeInt(reg.edad);
            archA.writeChar(reg.sexo);
        }catch(IOException e){
            System.out.println("Error de escritura");
        }
    }

    public regAlumnos Leer(int pos)
    {
        regAlumnos regt=new regAlumnos();
        try{
            archA.seek(pos*regAlumnos.tam);
            regt.cve=archA.readLong();
            regt.name=archA.readUTF();
            regt.edad=archA.readInt();
            regt.sexo=archA.readChar();

        }catch(EOFException e){
            return null;
        }
        catch(IOException e){
            System.out.println("Error de Lectura");
        }

        return regt;
    }

}
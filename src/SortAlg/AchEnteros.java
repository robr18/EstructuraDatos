package SortAlg;
import java.io.*;
public class AchEnteros {

	RandomAccessFile Arch;
	public AchEnteros()
	{
		Arch=null;
		
	}
	
	public void Abrir(String ruta)
	{
		try {
			Arch=new RandomAccessFile(ruta,"rw");
		}catch(IOException e) {
			System.out.println("El archivo no existe");
		}
	}
	
	public void Cerrar()
	{
		try {
			Arch.close();
		}catch(IOException e) {
			System.out.println("El archivo ya esta cerrado");
		}
	}
	
	public void Guardar(int num)
	{
		try {
			Arch.writeInt(num);
		}catch(IOException e)
		{
			System.out.println("Error de escritura");
		}
	}
	
	public void Guardar(int num,int pos)
	{
		try {
			Arch.seek(pos*4);
			Arch.writeInt(num);
		}catch(IOException e)
		{
			System.out.println("Error de escritura");
		}
	}
	
	public int Leer()
	{
		int num=0;
		try {
			num=Arch.readInt();
		}catch(EOFException e) {
			return -1;
		}catch(IOException e) {
			System.out.println("Error de lectura");
		}
		return num;
	}
	
	public int Leer(int pos)
	{
		int num=0;
		try {
			Arch.seek(pos*4);
			num=Arch.readInt();
		}catch(EOFException e) {
			return -1;
		}catch(IOException e) {
			System.out.println("Error de lectura");
		}
		return num;
	}
	
	public void Reiniciar()
	{
		try {
			Arch.seek(0L);
		}catch(IOException e) {
			System.out.println("No se reincio el puntero");
		}
	}
	
	public void mostrar()
	{
		
		Reiniciar();
		int num=-1;
		do {
			num=Leer();
			if(num!=-1)
				System.out.print(num+" ");
		}while(num!=-1);
		System.out.println();
	}
	
	public void mostrarP(int pos)
	{
		int pos1=0;
		int num=-1;
		do {
			num=Leer(pos1);
			if(num!=-1)
				System.out.print(num+" ");
			pos1++;
		}while(num!=-1);
		System.out.println();
	}
	
	public int numElem()
	{
		int tam=0;
		try {
			long contBytes=Arch.length();
			tam=(int)(contBytes/4);
		}catch(IOException e) {}
		return tam;
	}
	
	public void borrar()
	{
		try {
			Arch.setLength(0L);
		}catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		AchEnteros obj=new AchEnteros();
		obj.Abrir("src/pruebavscode.txt");
		obj.Guardar(33);
		obj.Guardar(48);
		obj.Guardar(55);
		obj.Guardar(66);
		obj.Guardar(75);
		obj.Guardar(10);
		obj.mostrar();
		System.out.println("Numero de Elementos: "+obj.numElem());
		obj.Guardar(57,1);
		obj.mostrar();
		System.out.println(obj.Leer(2));
		obj.borrar();
		obj.mostrar();
		obj.Cerrar();
	}
}

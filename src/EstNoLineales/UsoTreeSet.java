package EstNoLineales;

import java.util.*;
class Alumno implements Comparable<Alumno>{
	String nombre;
	int edad;
	char sexo;
	public Alumno(String n,int e,char s)
	{
		nombre=n;
		edad=e;
		sexo=s;
	}
	public String toString()
	{
		return nombre+" "+edad+" "+sexo;
	}
	public int compareTo(Alumno o) {
		return nombre.compareToIgnoreCase(o.nombre);
		//return sexo-o.sexo;
	}
}
public class UsoTreeSet {
public static void main(String[] args) {
	String nombres[]={"Morgado","Koffo","Diego","Isra",
			"Metal Foco","Juan","Antonio Star"};
	TreeSet<String>Arbol=new TreeSet<String>();
	for(int i=0;i<nombres.length;i++)
		Arbol.add(nombres[i]);
	mostrar2(Arbol);
	Alumno a1=new Alumno("Morgado",19,'M');
	Alumno a2=new Alumno("Antonio Banderas",19,'M');
	Alumno a3=new Alumno("Eileen",19,'F');
	Alumno a4=new Alumno("Israel",19,'M');
	TreeSet<Alumno>A2=new TreeSet<Alumno>();
	A2.add(a1);
	A2.add(a2);
	A2.add(a3);
	A2.add(a4);
	mostrar3(A2);
}
public static void mostrar3(TreeSet<Alumno>A)
{
	Iterator <Alumno>I=A.iterator();
	while(I.hasNext())
		System.out.println(I.next());
	System.out.println();
}
public static void mostrar1(TreeSet<String>A)
{
	Iterator <String>i=A.iterator();
	while(i.hasNext())
		System.out.print(i.next()+" ");
	System.out.println();
}
public static void mostrar2(TreeSet<String>A)
{
	Object noms[]=A.toArray();
	for(int i=0;i<noms.length;i++)
		System.out.print(noms[i]+" ");
	System.out.println();
}
}


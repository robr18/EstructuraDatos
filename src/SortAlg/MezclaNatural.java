package SortAlg;

import java.util.Random;

public class MezclaNatural {

	AchEnteros Archo, Arch1, Arch2;

	public MezclaNatural()
	{
		Archo=new AchEnteros();
		Arch1=new AchEnteros();
		Arch2=new AchEnteros();
		Archo.Abrir("src/archon.oto");
		Arch1.Abrir("src/arch1n.oto");
		Arch2.Abrir("src/arch2n.oto");
	}

	public void Llenar(int tam)
	{
		Random R=new Random();
		Archo.borrar();
		for(int i=0;i<tam;i++)
		{
			Archo.Guardar(R.nextInt(100),i);
		}
	}

	public void Ordenar()
	{
		System.out.println("Archivo o: ");
		Archo.mostrarP(0);
		do {
			Particion();
			Fusion();
		}while(Arch2.numElem()!=0);

		System.out.println("Archivo o ordenado:");
		Archo.mostrarP(0);
	}

	public void Fusion()
	{

		Arch1.Reiniciar();
		Arch2.Reiniciar();
		Archo.borrar();
		int num1=Arch1.Leer();
		int num2=Arch2.Leer();
		if(num2!=-1)
		{
			do {

				if(num1<=num2)
				{ //agregar el numero 1

					Archo.Guardar(num1);
					num1=Arch1.Leer();
				}
				else {
					Archo.Guardar(num2);
					num2=Arch1.Leer();
				}
			}while(num1!=-1 && num2!=-1);

		}//fin del if

		if(num1!=-1)
		{
			do {
				Archo.Guardar(num1);
				num1=Arch1.Leer();
			}while(num1!=-1);
		}
		if(num2!=-1)
		{
			Archo.Guardar(num2);
			num2=Arch1.Leer();
		}
	}

	public void Particion()
	{
		Arch1.borrar();
		Arch2.borrar();
		Archo.Reiniciar();
		int ant=0;
		int num=Archo.Leer();
		do {
			do {
				if(num!=-1)
				{
					Arch1.Guardar(num);
					ant=num;
					num=Archo.Leer();
				}
			}while(num>=ant && num!=-1);

			do {
				if(num!=-1)
				{
					Arch2.Guardar(num);
					ant=num;
					num=Archo.Leer();
				}
			}while(num>=ant && num!=-1);
		}while(num!=-1);

		System.out.println("Archivo 1: ");
		Arch1.mostrarP(0);
		System.out.println("Archivo 2: ");
		Arch1.mostrarP(0);

		}

	public static void main(String[] args) {
		MezclaNatural mn=new MezclaNatural();
		mn.Llenar(10);
		mn.Ordenar();
	}

}

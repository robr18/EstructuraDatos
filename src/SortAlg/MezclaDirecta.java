package SortAlg;

import java.util.Random;

public class MezclaDirecta {

	AchEnteros ArchO,Arch1,Arch2;

	public MezclaDirecta()
	{
		ArchO=new AchEnteros();
		Arch1=new AchEnteros();
		Arch2=new AchEnteros();

		ArchO.Abrir("src/ArchO.oto");
		Arch1.Abrir("src/Arch1.oto");
		Arch2.Abrir("src/ARch2.oto");

	}

	public void Llenar(int tam)
	{
		Random R=new Random();
		ArchO.borrar();
		for(int i=0;i<tam;i++)
		{
			ArchO.Guardar(R.nextInt(100),i);
		}
	}


	public void Ordenar()
	{
		System.out.println("Archivo O: ");
		ArchO.mostrar();
		int particion=1;
		int tamArch=ArchO.numElem();
		do {
			System.out.println("Tama�o de particin "+particion);
			Intercalar(particion);
			//Fusion
			Fusion(particion);
			particion*=2;
		}while(particion<tamArch);
	}

	public void Fusion(int part)
	{
		Arch1.Reiniciar();
		Arch2.Reiniciar();
		ArchO.borrar();
		int num1=Arch1.Leer();
		int num2=Arch2.Leer();
		int tamp1=0;
		int tamp2=0;
		do {
			while(tamp1<part && num1!=-1 && num2!=-1 && tamp2<part) {
				if(num1<=num2) {
					if(num1!=-1) {
						ArchO.Guardar(num1);
						tamp1++;
						num1=Arch1.Leer();
					}
				}else {
					if(num2!=-1) {
						ArchO.Guardar(num2);
						tamp2++;
						num2=Arch2.Leer();
					}
				}
			}//Esta es la llave del while

			//if cuando el archivo 1 se queda con un tama�o de particion menor
			//a la particion
			if(tamp1<part && num1!=-1)
			{
				for(int i=tamp1;i<part && num1!=-1;i++)
				{
					ArchO.Guardar(num1);
					num1=Arch1.Leer();
					tamp1++;
				}
			}//fin del if del archivo1

			if(tamp2<part && num2!=-1)
			{
				for(int i=tamp2;i<part && num2!=-1;i++)
				{
					ArchO.Guardar(num2);
					num2=Arch2.Leer();
					tamp2++;
				}
			}
			tamp1=0;
			tamp2=0;
		}while(num1!=-1 && num2!=-1);

		//if cuando un archivo llega a su fin y el otro archivo no ha terminado
		if(num1!=-1)
		{
			do {
				ArchO.Guardar(num1);
				num1=Arch1.Leer();
			}while(num1!=-1);
		}

		if(num2!=-1)
		{
			do {
				ArchO.Guardar(num2);
				num2=Arch2.Leer();
			}while(num2!=-1);
		}

		System.out.print("ArchO: ");
		ArchO.mostrar();
	}

	public void Intercalar(int part)
	{
		Arch1.borrar();
		Arch2.borrar();
		ArchO.Reiniciar();
		int num=ArchO.Leer();
		do {
			for(int i=0;i<part;i++)
			{
				if(num!=-1) {
					Arch1.Guardar(num);
					num=ArchO.Leer();
					}
			}
			for(int i=0;i<part;i++)
			{
				Arch2.Guardar(num);
				num=ArchO.Leer();
			}
		}while(num!=-1);

		System.out.println("Arch1: ");
		Arch1.mostrarP(0);
		System.out.println("Arch2: ");
		Arch2.mostrarP(0);

	}

	public static void main(String[] args) {
		MezclaDirecta M=new MezclaDirecta();
		M.Llenar(100);
		M.Ordenar();
	}
}

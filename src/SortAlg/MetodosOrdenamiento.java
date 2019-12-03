package SortAlg;
import java.util.*;

public class MetodosOrdenamiento {
    int numeros[];
    public MetodosOrdenamiento(final int tam) {
		numeros = new int[tam];
	}

	public void llenar() {
		final Random R = new Random();
		final int tam = numeros.length;
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = R.nextInt(tam);
		}
	}

	public void mostrar(final String mens) {
		System.out.println(mens);
		for (int i = 0, j = 1; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
			if (j % 30 == 0)
				System.out.println();
			j++;
		}
		System.out.println();
	}

	public void Burbuja() {
		int temp = 0;
		for (int i = 0; i < numeros.length; i++) // numero de elementos a ordenar
			for (int j = 0; j < (numeros.length - 1) - i; j++)
				if (numeros[j] > numeros[j + 1]) {
					temp = numeros[j + 1];
					numeros[j + 1] = numeros[j];
					numeros[j] = temp;
				}
	}

	public void Qsort(final int ini, final int fin) {
		//Obtenemos la posición del pivote en la mitad del numero de elementos
		final int posPivote = (ini + fin) / 2;
		final int pivote = numeros[posPivote];
		//Establecemos los indices de izquierda y derecha
		int izq = ini, der = fin;
		//Declaración de una variable temporal para el intercambio
		int temp = 0;
		do {
			//Este while recorre los elementos hasta encontrar un numero mayor al pivote por izquierda
			while (numeros[izq] < pivote)
				izq++;
			//Este while recorre los elementos hasta encontrar un numero mayor al pivote por derecha
			while (numeros[der] > pivote)
				der--;
			// intercambiar
			if (izq <= der) {
				temp = numeros[izq];
				numeros[izq] = numeros[der];
				numeros[der] = temp;
				izq++;
				der--;
			}
		} while (izq <= der);
		//Se manda de manera recursiva el metodo para que realice lo mismo con el lado izquierdo del pivote y derecho
		if (ini < der)
			Qsort(ini, der);
		if (izq < fin)
			Qsort(izq, fin);
	}

	/* ShellSort
		Este metodo funciona por intervalos, donde va comparando el numero del indice con el numero de la posición
		que marca el intervalo.

		FUNCIONAMIENTO
		El primer intervalo con el que trabaja es con la mitad de la cantidad de elementos a ordenar estableciendo un
		índice en 0 para comenzar desde el principio de los elementos; este indice se va incrementando.
		La comparación que hace es de la siguienete forma arreglo[indice] > arreglo[indice+intervalo]. Se compara
		la posición indice+intervalo para incrementar el intervalo y tener una condición de salida simple.
		Y este sería el ciclo de nuestro algoritmo donde cada vez que termine de comparar e intercambiar elementos para un
		intervalo este regresa al ciclo padre para obtener otro intervalo de la mitad del tamaño del intervalo anterior
		hasta que estemos trabajando con un intervalo de tamaño 1.

		Cuando termina la ultima comparación con el intervalo 1 los elementos ya estarían ordenados.
	*/

	public void ShellSort() {
		int intervalo = numeros.length, ind = 0, temp = 0;
		//La variable otravez controla si el ciclo se tiene que repetir
		boolean otravez;
		//ciclo que controla las vueltas de los intervalos hasta que llegue al intervalo=1
		do {
			intervalo = intervalo / 2;
			otravez = true;
			while (otravez) {
				ind = 0;
				otravez = false;
				//Ciclo para hacer el recorrido de los elementos con el intervalo
				while ((ind + intervalo) < numeros.length-1) {

					if (numeros[ind] > numeros[ind + intervalo]) { // intercambiar
						temp = numeros[ind];
						numeros[ind] = numeros[ind + intervalo];
						numeros[ind + intervalo] = temp;
						otravez = true;
					} // if
					ind++;
				} // intercambio
			} // otravez
		} while (intervalo != 1);
	}

	public int Mayor() {
		int mayor = 0;
		for (int i = 0; i < numeros.length; i++)
			if (numeros[i] > mayor)
				mayor = numeros[i];
		return mayor;
	}

	public void Radix(int mayor)
    {
    	   String mayorS=mayor+"";
    	   int pasadas=mayorS.length();
    	   LinkedList<Integer>Ldig[]=new LinkedList[10];
    	   for(int i=0;i<Ldig.length;i++)
    		   Ldig[i]=new LinkedList<Integer>();
    	   int factorx=1,num,res,dig,ind;
    	   for(int p=0;p<pasadas;p++)
    	   {
    		   for(int j=0;j<numeros.length;j++)
    		   {
    			   num=numeros[j];
    			   res=num/factorx;
    			   dig=res%10;
    			   Ldig[dig].add(num);
    		   }
    		   //sacar los elementos de las listas
    		   //regresarlos al vector numeros
    		   ind=0;
    		   for(int i=0;i<Ldig.length;i++)
    		   {
    			   while(!Ldig[i].isEmpty())
    			   {
    				   numeros[ind++]=Ldig[i].remove(0);
    			   }
    		   }
    		   factorx*=10;
    	   }

	}

	public static void mostrarT(final long t, final String mens) {
		System.out.print(mens);
		final long min = t / 60000l;
		final long sobraM = t % 60000l;
		final long seg = sobraM / 1000l;
		final long mili = sobraM % 1000l;
		System.out.println(min + ":" + seg + ":" + mili);
	}

	public void imprimeLength()
	{
		int l=numeros.length;
		System.out.println(l);
	}

	public static void main(final String[] args) {
		final MetodosOrdenamiento M = new MetodosOrdenamiento(20);
		M.llenar();
		M.mostrar("Numeros desordenados");
		final Calendar tiempoi = Calendar.getInstance();
		M.Qsort(0, M.numeros.length-1);
		final Calendar tiempof = Calendar.getInstance();
		M.mostrar("Numeros Ordenados");
		final long tiempoDuro = tiempof.getTimeInMillis()
				             -tiempoi.getTimeInMillis();
		mostrarT(tiempoDuro,"Tiempo Butbuja");
	}
}
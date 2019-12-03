package EstNoLineales;

import java.util.*;

public class ArbolEnteros {
	 NodoSA raiz;
     int numNodos;
 
     public ArbolEnteros()
     {
    	   raiz=null;
    	   numNodos=0;
     }
     public NodoSA buscar(int valor)
     {
    	     NodoSA temp=raiz; NodoSA ant=null;
    	     while(temp!=null)
    	     {
    	    	    if(valor>temp.num)
    	    	    {
    	    	    	   ant=temp;	
    	    	    	   temp=temp.der;
    	    	    }else if(valor<temp.num)
    	    	    	{
    	    	    	   ant=temp;
    	    	    	   temp=temp.izq;
    	    	    	}else{ //el numero ya esiste en el arbol
    	    	    		return null;
    	    	    	}
    	     }
    	     return ant;
     }
     public void Agregar(int valor)
     {
    	    NodoSA nuevo=new NodoSA(valor);
    	    if(raiz==null)
    	    {
    	    	   raiz=nuevo; numNodos++;
    	    	   System.out.println("Se agrego al arbol "+valor);
    	    }else{
    	    	    NodoSA ubic=buscar(valor);
    	    	    if(ubic!=null)
    	    	    {
    	    	    	   //agregar al arbol nodo nuevo
    	    	    	   if(valor>ubic.num)
    	    	    	   { //derecho
    	    	    		 ubic.der=nuevo;  
    	    	    	   }else{
    	    	    		   //izquierdo
    	    	    		 ubic.izq=nuevo;  
    	    	    	   }
    	    	    	   System.out.println("Se agrego al arbol "+valor);
    	    	    	   numNodos++;
    	    	    }else{
    	    	    	  System.out.println("Numero "+valor+
    	    	    			  " ya existe en el arbol");
    	    	    }
    	    	    
    	    }
     }
   
     public int RecorridoNivel()
     { int altura=0;
    	   LinkedList<NodoSA>L1=new LinkedList<NodoSA>(); 
    	   LinkedList<NodoSA>L2=new LinkedList<NodoSA>(); 
    	   L1.add(raiz);
    do{	   
    	   mostrarLista(L1); altura++;
    	   //sacar los hijos de L1 y guardarlos en L2
    	   for(int i=0;i<L1.size();i++)
    	   {
    		   if(L1.get(i).izq!=null)
    			   L2.add(L1.get(i).izq);
    		   if(L1.get(i).der!=null)
    			   L2.add(L1.get(i).der);
    	   }
    	   //borrar lo que tiene L1
    	   L1.clear();
    	   //pasar los elementos de L2 a L1
    	   for(int i=0;i<L2.size();i++)
    		   L1.add(L2.get(i));
    	   //borrar L2
    	   L2.clear();
    }while(!L1.isEmpty());
       return altura;
     }
     public void mostrarLista(LinkedList<NodoSA>L)
     {
    	    for(int i=0;i<L.size();i++)
    	    	    System.out.print(L.get(i).num+"\t");
    	    System.out.println();
     }
     
     
     //Metodos del examen
     
     public NodoSA buscarN(int valor)
     {
    	    
    	 	NodoSA tempder=raiz; 
    	 		while(tempder.izq!=null || tempder.der!=null)
    	    	{
    	    	 	if(valor==tempder.num)
    	    	 		return tempder;
    	    	 	else{
    	    	 		tempder=tempder.der;
    	    	 	}
    	    	}
    	    NodoSA tempizq=raiz;
    	    while(tempizq.izq!=null || tempizq.der!=null)
	    	{
	    	 	if(valor==tempizq.num)
	    	 		return tempizq;
	    	 	else{
	    	 		tempizq=tempizq.der;
	    	 	}
	    	}
    	    if(tempizq!=null)
				return tempizq;
			return tempder;
     }
     
     
     public void buscarHijos(int valor)
 	{
 		NodoSA nodo=buscarN(valor);
 		if(nodo!=null)
 		{
 			if(nodo.izq!=null)
 				System.out.println("El hijo izquierdo es: "+nodo.izq.num);
 			else 
 				System.out.println("El nodo no tiene hijos izquierdos");
 			if(nodo.der!=null)
 				System.out.println("El hijo derecho es: "+nodo.der.num);
 			else
 				System.out.println("El nodo no tiene hijos derechos");
 		}else {
 			System.out.println("El nodo es nulo");
 		}
 	}
     
     public void arbolEquilibrado()
     {
    	 NodoSA ramizq=raiz;
    	 NodoSA ramder=raiz;
    	 int rami=0;
    	 int ramd=0;
    	 while(ramizq.izq!=null) {
    		 ramizq=ramizq.izq;
    		 rami++;
    	 }
    	 
    	 while(ramder.der!=null) {
    		 ramder=ramder.der;
    		 ramd++;
    	 }
    	 
    	 int altura=Math.abs((rami-ramd));
    	 
    	 if(altura<=1)
    	 {
    		 System.out.println("El arbol esta equilibrado");
    	 }else {
    		 System.out.println("El arbol no esta equilibrado");
    	 }
     }
     
     
     public static void main(String[] args) {
		ArbolEnteros A=new ArbolEnteros();
		A.Agregar(55);
		A.Agregar(33);
		A.Agregar(68);
		A.Agregar(75);
		A.Agregar(65);
		A.Agregar(60);
		A.Agregar(67);
		A.buscarHijos(33);
		A.arbolEquilibrado();
		A.RecorridoNivel();
		
	}
}

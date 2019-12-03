package Evaluaciones;

import java.util.LinkedList;

public class EvalAr {

	NodoSAE raiz;
	
	public EvalAr()
	{
		raiz=null;
	}
	
	public NodoSAE buscarN(int valor)
    {
   	     NodoSAE temp=raiz; 
   	     while(temp!=null)
   	     {
   	    	    if(valor>temp.num)
   	    	    {	
   	    	    	   temp=temp.der;
   	    	    }else if(valor<temp.num)
   	    	    	{
   	    	    	   temp=temp.izq;
   	    	    	}else{ //el numero ya esiste en el arbol
   	    	    		return null;
   	    	    	}
   	     }
   	     return temp;
    }
	
	public void buscarHijos(int valor)
	{
		NodoSAE nodo=buscarN(valor);
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
		}
	}
	
	public int RecorridoNivel()
    { int altura=0;
   	   LinkedList<NodoSAE>L1=new LinkedList<NodoSAE>(); 
   	   LinkedList<NodoSAE>L2=new LinkedList<NodoSAE>(); 
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
    public void mostrarLista(LinkedList<NodoSAE>L)
    {
   	    for(int i=0;i<L.size();i++)
   	    	    System.out.print(L.get(i).num+"\t");
   	    System.out.println();
    }
	
	public void Agregar(int valor)
    {
   	    NodoSAE nuevo=new NodoSAE(valor);
   	    if(raiz==null)
   	    {
   	    	   raiz=nuevo;
   	    	   System.out.println("Se agrego al arbol "+valor);
   	    }else{
   	    	    NodoSAE ubic=buscarN(valor);
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
   	    	    }else{
   	    	    	  System.out.println("Numero "+valor+
   	    	    			  " ya existe en el arbol");
   	    	    }
   	    	    
   	    }
    }
	
	public static void main(String[] args) {
		EvalAr Arb=new EvalAr();
		Arb.Agregar(60);
		Arb.Agregar(10);
		Arb.Agregar(89);
		Arb.Agregar(2);
		Arb.Agregar(15);
		Arb.Agregar(12);
		Arb.Agregar(35);
		Arb.Agregar(40);
		Arb.buscarN(10);
		Arb.RecorridoNivel();
	}	
}

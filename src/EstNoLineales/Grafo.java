package EstNoLineales;

public class Grafo {
	 static int tablaT[][]={{1,6,8,12,4},  //q0
	  		  {2,5,5,4,4},  //q1
	  		  {3,4,4,4,4},  //q2
	  		  {4,4,4,4,4},  //q3
	  		  {4,4,4,4,4},  //q4
	  		  {4,4,4,4,4},  //q5
	  		  {7,4,4,4,4},  //q6
	  		  {2,4,4,4,4},  //q7
	  		  {1,6,9,11,11}, //q8
	  		  {1,6,10,4,4}, //q9
	  		  {1,6,4,4,4},  //q10
	  		  {1,6,4,4,4},  //q11
	  		  {1,6,8,4,4}}; //q12
public static int checar(int edo,char alf[],
	  char c)
{
 for(int i=0;i<alf.length;i++)
	  if(c==alf[i])
		  return tablaT[edo][i];
 return 4;  //error
}
public static boolean evaluar(String numRomano)
{
 int q0=0;  char 
 alfabeto[]={'I','V','X','L','C'};
 char car[]=numRomano.toCharArray();
 for(int pos=0;pos<car.length;pos++)
 {
	  char c=car[pos];
	  q0=checar(q0,alfabeto,c);
	  if(q0==4)
		  return false;
 }
 if(q0!=4)
	  return true;
 else
	  return false;
}
public static void main(String[] args) {
 System.out.println(evaluar("XVIIV"));
}	
}

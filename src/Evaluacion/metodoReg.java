package Evaluacion;

import java.util.*;


class reg{

    int edad;
    int num_tarjeta;

    public reg(){

        edad=num_tarjeta=0;
    }

    public reg(int e, int nt)
    {
        edad=e;
        num_tarjeta=nt;
    }

    public String toString()
    {
        return edad+" "+num_tarjeta+",";
    }

}


public class metodoReg{

    reg vec1[];
    reg vec2[];
   // LinkedList <Integer> vec1, vec2;

    public void llenar()
    {
        for(int i=0;i<vec1.length;i++)
        {
            reg temp=new reg();
            vec1[i]=temp;
        }
    }

    public void Fusion(reg vec[], reg vec2[])
    {
        /*
            No se porque tiene ese error, pero para evitar eso puedes usar vectores en lugar de las listas de abajo
            Si usas vectores te quedaria asi
            reg temp1[]=new reg[vec.length+1];
            reg temp2[]=new reg[vec.length+1];
            reg vecfusionado[]=new reg[temp1.length+temp2.length];

            El mas uno en la longitud de los vectores es para que el ultimo elemento sea un valor nulo y 
            funcionen las condiciones de abajo, y no les tire la excepcion.

            Ya solo le cambian los valores donde estan los .add por el vector y su indice y ya funciona
        */
        reg temp1[]=new reg[vec.length+1];
        reg temp2[]=new reg[vec.length+1];
        reg vecfusionado[]=new reg[temp1.length+temp2.length];
        int ind=0;

        for(int i=0;i<vec.length;i++)
        {
            temp1[i]=vec[i];
            temp2[i]=vec2[i];
        }

            reg reg1=temp1[0];
            int num1=reg1.edad;
            reg reg2=temp2[0];
            int num2=reg2.edad;

        if(reg2!=null)
        {
            
            do{
            if(num1<=num2)
            {
                vecfusionado[ind]=reg1;
                ind++;
                reg1=temp1[ind];
            }else{
                vecfusionado[ind]=reg2;
                ind++;
                reg2=temp2[ind];
                num2=reg2.edad;
            }
            }while(reg1!=null && reg2!=null);
        }

        if(reg1!=null)
		{
			do {
				vecfusionado[ind]=reg1;
                reg1=temp1[ind];
                ind++;
			}while(reg1!=null);
		}
		if(reg2!=null)
		{
			do{
                vecfusionado[ind]=reg2;
                reg2=temp2[ind];
                ind++;
             }while(reg2!=null);
		}


        //Mostrar la lista fucionada

        for(int i=0;i<vecfusionado.length;i++)
            System.out.print(vecfusionado[i]+" ");

    }

    public static void main(String[] args) {
        metodoReg obj=new metodoReg();

        reg n1=new reg(18,348);
        reg n2=new reg(25,64);
        reg n3=new reg(33,17);
        reg n4=new reg(35,85);
        reg n5=new reg(37,94);
        reg n6=new reg(42,64);
        reg n7=new reg(44,12);
        reg n8=new reg(45,120);

        reg vec1[]={n1,n2,n3,n4,n5,n6,n7,n8};

        reg n10=new reg(17,215);
        reg n20=new reg(19,313);
        reg n30=new reg(23,33);
        reg n40=new reg(33,13);
        reg n50=new reg(36,17);
        reg n60=new reg(29,22);
        reg n70=new reg(43,48);
        reg n80=new reg(48,65);

        reg vec2[]={n10,n20,n30,n40,n50,n60,n70,n80};

        obj.Fusion(vec1,vec2);

    }




}
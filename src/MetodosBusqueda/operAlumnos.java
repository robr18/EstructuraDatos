package MetodosBusqueda;

import java.util.Scanner;

public class operAlumnos{
    String menu[]={"  M E N U\n", "1) Alta de Alumno\n", "2)Busqueda\n", "3)Salir\n","Selecciona una opción"};

    public int mostrarM()
    {
        int opc=0;
        for(int i=0;i<menu.length;i++)
        {
            System.out.print(menu[i]);
        }
        Scanner sc=new Scanner(System.in);
        opc=sc.nextInt();
        return opc;
    }

    public static void main(String[] args) {
        operAlumnos obj=new operAlumnos();
        int opc=0;
        do{
            opc=obj.mostrarM();

            switch(opc){
                case 1:
                
                    break;

                case 2:
                
                    break;
            }

        }while(opc!=3);
    }

}
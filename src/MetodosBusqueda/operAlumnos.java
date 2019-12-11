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
    public int modulo(long cve)
    {
        int pos=0;

        pos=(int)(cve%97);


        return pos;
    }

    public static void main(String[] args) {
        operAlumnos obj=new operAlumnos();
        int opc=0;
        do{
            opc=obj.mostrarM();

            switch(opc){
                case 1: //Pedir los datos del alumno
                    regAlumnos reg=new regAlumnos();
                    reg.name=Lectura.Cadena("Dame el nombre del alaumno");
                    reg.edad=Lectura.Entero("Dame la edad del alumno");
                    reg.sexo=Lectura.Caracter("Dame el sexo del alumno");
                    //Asignar la clave que le corresponda
                    CveAsignada C=new CveAsignada();
                    C.Abrir();
                    int pos=C.Leer();
                    indice I=new indice();
                    molde r=I.Leer(pos);
                    reg.cve=r.cve;
                    pos++;
                    C.Grabar(pos);
                    C.Cerrar();
                    I.Cerrar();

                    System.out.println(reg);
                    char resp=Lectura.Caracter("Estan correctos los datos S/N");
                    if(resp=='S' || resp=='s')
                    {
                        DatosAlum D=new DatosAlum();
                        D.Abrir();
                        D.Grabar(reg, r.pos);
                        D.Cerrar();
                    }

                    break;

                case 2:
                    long cve=Lectura.EnteroL("Dame la clave de la persona a consultar");
                    pos=obj.modulo(cve);
                    indice In=new indice();
                    r=In.Leer(pos);
                    //System.out.println(pos+" "+r);
                    if(cve==r.cve)
                    {
                        //no hay colision
                        DatosAlum D=new DatosAlum();
                        D.Abrir();
                        regAlumnos regm=D.Leer(pos);
                        System.out.println(regm);
                        D.Cerrar();
                    }else{
                        boolean existe=false; int cont=0;
                        while(!existe && cont<100)
                        {
                            pos++;
                            if(pos==100)    pos=0;
                            r=In.Leer(pos);
                            cont++;
                            if(cve==r.cve)
                            {
                                DatosAlum D=new DatosAlum();
                                D.Abrir();
                                regAlumnos regm=D.Leer(pos);
                                System.out.println(regm);
                                D.Cerrar(); existe=true;
                            }
                        }
                        if(existe==false)
                        {
                            System.out.println("Clave "+cve+" incorrecta");
                        }
                    }
                    break;
            }

        }while(opc!=3);
    }

}
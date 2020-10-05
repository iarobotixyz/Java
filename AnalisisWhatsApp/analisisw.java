import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//javac analisisw.java //Compila
//java analisisw hola //Ejecuta
public class analisisw
{
    public static void abreprocesabaseCP(String archivo, String cpBusqueda) throws FileNotFoundException, IOException 
    {
        String cadena;
        String caddos;
        String fec;
        String fecc;

        String naa="";
        String nbb="";

        String nnaa="";
        String nnbb="";
        int conaa=0;
        int conbb=0;

        String fecchat;
        
        boolean existe;

        existe = false;
        int contadormsj=0;
        int contadorpuntos=3;
        int busquedavartextfin=0;

        int num=1;

        int tota=1;
        
        
        //Abrimos el archivo de la Base de Datos (BD)
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        System.out.println(" ------IMPRIME PALABRA DE BUSQUEDA ----"); 
        System.out.println(cpBusqueda); //Imprime variable CP a buscar

        fec = cpBusqueda.replace("/", ",");
        //System.out.println(fec); //Imprime variable CP a buscar
        String[] varfeoarray= fec.split(",");//cada , se guarda la var en el array para el procesamiento.
        //System.out.println(varfeoarray[0]);//imprime fecha dia
        //System.out.println(varfeoarray[1]);//imprime fecha mes
        //System.out.println(varfeoarray[2]);//imprime fecha año
        String aa = varfeoarray[0];
        String bb = varfeoarray[1];
        String cc = varfeoarray[2];

        cpBusqueda=Long.valueOf(aa)+"/"+Long.valueOf(bb)+"/"+Long.valueOf(cc);
        System.out.println(" --------------------------------------"); 
        while((cadena = b.readLine())!=null) 
        {
          caddos = cadena.replace(" ", ",");
         String[] vartextoarray= caddos.split(",");//cada , se guarda la var en el array para el procesamiento.
         
         //System.out.println(vartextoarray);
         for (int i=0; i<1; i++) 
         {
            String cp=vartextoarray[i];

            //System.out.println(vartextoarray[0]); //Total de Mensajes
            tota=tota+1;

            if (cp.contains(cpBusqueda)) 
            {

              fecc = cpBusqueda.replace("/", ",");
              //System.out.println(fec); //Imprime variable CP a buscar
              String[] varfeoarrayy= fecc.split(",");//cada , se guarda la var en el array para el procesamiento.
              String aaa = varfeoarrayy[0];//dia
              String bbb = varfeoarrayy[1];//mes
              String ccc = varfeoarrayy[2];//año
                             
              //System.out.println(vartextoarray[0]); //fecha del chat original
              fecchat = vartextoarray[0].replace("/", ",");
              //System.out.println(fec); //Imprime variable CP a buscar
              String[] vahsarrayy= fecchat.split(",");
              //System.out.println(vahsarrayy[0]); //dia chat separado
              String diasepaaa = vahsarrayy[0];

              if(diasepaaa.equals(aaa)) 
              {
              

               //System.out.println(vartextoarray[1]); //hora 
               //System.out.println(vartextoarray[2]); //esto es el -

               if (vartextoarray[3].contains(":")) //nombre corto sin espacios
                {
                   if(naa.equals("")) 
                    {
                      naa = vartextoarray[3];
                    }//Fin compara variable vacia y asigna primer nombre
                }//fin de nombre corto sin espacios
                else 
                {

                  for (int n=0; n<10;) 
                  {
                    if (vartextoarray[contadorpuntos].contains(":")) //nombre corto sin espacios
                    {
                      break;
                    }
                    else
                    {
                      nbb+=vartextoarray[contadorpuntos]+" "; 

                      contadorpuntos=contadorpuntos+1;
                      n++;
                    }
                   
                    nbb+=vartextoarray[contadorpuntos]+" "; 
                      
                  }//Fin for 

                }//ELSE
               
               System.out.println(num+++" "+cadena);//imprime cadena completa 

              if(nnaa.equals("")) 
                    {
                      nnaa=vartextoarray[3];
                      conaa=conaa+1;
                    }
              else if (nnaa.equals(vartextoarray[3])) 
                    {
                      conaa=conaa+1;
                    }

               existe=true; 
               contadormsj=contadormsj+1;
              }//fin compara variable dias busqueda vs dia chat

            }//Fin contiene compara busqueda fecha 

         } //fin for ciclo de array

        }//fin de while cadena 

        System.out.println("   _____________________________________________________________  ");

        System.out.println("     Numero de Mensajes del dia "+cpBusqueda+" es: "+contadormsj);
        System.out.println("     Primer Mensaje es: ");

        System.out.println("     Mensajes del dia "+cpBusqueda+" del usuario "+naa+" "+conaa);

        System.out.print("     ");
        
        for (int n=0; n<conaa; n++) 
          {
            System.out.print("▒");
          }
        System.out.println();
        
        System.out.println("     Mensajes del dia "+cpBusqueda+" del usuario "+nbb+" "+(contadormsj-conaa));

        System.out.print("     ");
        
        for (int r=0; r<(contadormsj-conaa); r++) 
          {
            System.out.print("▒");
          }
        System.out.println();


        System.out.println("   _____________________________________________________________  ");
        System.out.println("   ▒  Total de Mensajes "+tota+"                                   ▒");

        System.out.println("   -------------------------------------------------------------  ");

        b.close();//Cierra Archivo abierto.

    }//fin void abreprocesabaseCP

    public static void main(String[] args) throws IOException 
    {
        if (args.length>0) 
        {
            abreprocesabaseCP("chatuan.txt", args[0]);//direccion de bd de C.P. Busqueda
        }
        else
        {
         System.out.println("Error poner fecha ejemplo: 9/6/2020");
         
        }//fin else 
    }//fin void main
}//fin class 
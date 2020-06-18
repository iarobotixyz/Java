import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class zip_code
{
    public static void abreprocesabaseCP(String archivo, String cpBusqueda) throws FileNotFoundException, IOException 
    {
        String cadena;
        String caddos;
        boolean existe;
        existe = false;
        //Abrimos el archivo de la Base de Datos (BD)
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        //System.out.println(cpBusqueda); //Imprime variable CP a buscar
         
        while((cadena = b.readLine())!=null) 
        {
         //System.out.println(cadena);//imprime cadena completa de archivo BD CP         
         //System.out.println(cadena.replace("|", ","));//toma la cadena completa y reemplaza | por,
         caddos = cadena.replace("|", ",");
         String[] vartextoarray= caddos.split(",");//cada , se guarda la var en el array para el procesamiento.
         //System.out.println(vartextoarray);
         for (int i=0; i<1; i++) 
         {
            String cp=vartextoarray[i];
            if (cp.contains(cpBusqueda)) 
            {
               //System.out.println(cp); //codigo postal = 0
               //System.out.println(vartextoarray[1]); //colonia asentamiento
               //System.out.println(vartextoarray[2]); //colonia tipo asentamiento
               //System.out.println(vartextoarray[3]); //delegacion
               //System.out.println(vartextoarray[4]); //estado
               //System.out.println(vartextoarray[5]); //ciudad
               //System.out.println(vartextoarray[6]); //cp
               //System.out.println(vartextoarray[7]); //c_estado
               //System.out.println(vartextoarray[8]); //c_oficina
               //System.out.println(vartextoarray[9]); //cCP
               //System.out.println(vartextoarray[10]); //c_tipo_asenta
               //System.out.println(vartextoarray[11]); //municipio
               //System.out.println(vartextoarray[12]); //id_asenta_cpcons
               //System.out.println(vartextoarray[13]); //urbano
               //System.out.println(vartextoarray[14]); //c_cve_ciudad
                
//d_codigo|d_asenta|d_tipo_asenta|D_mnpio|d_estado|d_ciudad|d_CP|c_estado|c_oficina|c_CP|c_tipo_asenta|c_mnpio|id_asenta_cpcons|d_zona|c_cve_ciudad

String json1 = "```json{\"zip_code\": \""+cp+"\"," + "\"locality\":\""+vartextoarray[4]+"\"," 
   + "\"federal_entity\":\""+vartextoarray[5]+"\"," 
   + "\"settlements\": [{\"name\": \""+vartextoarray[1]+"\",\"zone_type\": \""+vartextoarray[13]+"\",\"settlement_type\": \""+vartextoarray[2]+"\",}], \"municipality\": \""+vartextoarray[3]+"\"}```";
               
               System.out.println(json1);

               existe=true;  
            }
         } //fin for ciclo de array
        }//fin de while cadena 
        b.close();//Cierra Archivo abierto.
          if (existe) 
         {  //System.out.println("Si existe");
            //Ya se imprimio el JSON
         }
         else
         {  //Imprime JSON con 404
            //System.out.println("No existe");
            System.out.println("404 No existe"); 
            String json2 ="```json {} ```";
            System.out.println(json2);

         }
    }//fin void abreprocesabaseCP

    public static void main(String[] args) throws IOException 
    {
        if (args.length>0) 
        {
           //System.out.println(args.length>0 ? args[0] : "CP Confirmado");
           //## Fuentes de datos
           //Puede descargar el registro completo de códigos postales de México aquí.
           //- https://www.correosdemexico.gob.mx/SSLServicios/ConsultaCP/Descarga.aspx
            abreprocesabaseCP("CPdescarga.txt", args[0]);//direccion de bd de C.P. Busqueda
        }
        else
        {
         //System.out.println(args.length>0 ? args[0] : "CP Faltante");
         System.out.println("  ");
         System.out.println(" Introducir Codigo Postal para continuar. ");
         System.out.println(" Ejemplo: "); 
         System.out.println(" java zip_code 06140 "); 
         System.out.println("  ");
        }//fin else falta codigo postal
    }//fin void main
}//fin class zip_code
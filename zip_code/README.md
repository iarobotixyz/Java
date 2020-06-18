-En terminal de Cloud Shell descargar el repositorio con el comando

git clone     https://github.com/iarobotixyz/Java

-Entrar en el repositorio con 

cd zip_code

Descargar la base de datos de codigos postales, el archivo CPdescarga.txt contiene la bd completa. 
https://www.correosdemexico.gob.mx/SSLServicios/ConsultaCP/Descarga.aspx

-compilar el archivo con 

javac zip_code.java

Va a generar un archivo llamado zip_code.class 
Ejecutar el archivo generado con el comando

java zip_code 06140

teniendo como resultado una cadena json con la informacion del codigo postal.

```json{"zip_code": "06140","locality":"Ciudad de M�xico","federal_entity":"Ciudad de M�xico","settlements": [{"name": "Condesa","zone_type": "Urbano","settlement_type": "Colonia",}], "municipality": "Cuauht�moc"}```

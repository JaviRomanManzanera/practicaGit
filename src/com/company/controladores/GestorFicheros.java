package com.company.controladores;

import com.company.Contacto;
import com.company.LogicaAgenda;

import java.io.*;
import java.util.ArrayList;


public class GestorFicheros {
    static final String RUTA = "./src/ficheros/";
    public static final String FICHERO = "Contactos.txt";

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fichero = null;
    PrintWriter pw = null;

    LogicaAgenda logicaAgenda;

    public GestorFicheros(LogicaAgenda logicaAgenda) {
        this.logicaAgenda = logicaAgenda;
        leerFichero(FICHERO);
    }

    //Recoge los Json del fichero y llama a una funcion que lo convierte en objetos contacto y los mete en un array
    public void leerFichero(String nombreFichero){
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(RUTA+nombreFichero);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null) {
                if(nombreFichero.equals(FICHERO)) {
                    logicaAgenda.actualizarArrayEntrada(linea);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            /* En el finally cerramos el fichero, para asegurarnos
             que se cierra tanto si todo va bien como si salta
             una excepcion.*/
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    //guarda cada contacto que hay en el array como Json en el fichero
    public void escribirFichero(String nombreFichero, ArrayList<Contacto> arrayList){
        try {
            fichero = new FileWriter(RUTA+nombreFichero);
            pw = new PrintWriter(fichero);

            for (Contacto indice: arrayList) {
                pw.println(indice.getJson());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}

package com.company;

import com.company.controladores.ControladorVista;
import com.company.controladores.GestorFicheros;

import javax.swing.*;
import java.util.ArrayList;

public class LogicaAgenda {

    ControladorVista controladorVista;
    GestorFicheros gestorFicheros;
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    Contacto contacto;
    private int i;


    public LogicaAgenda() {
        controladorVista = new ControladorVista(this);
        gestorFicheros = new GestorFicheros(this);
    }

    //recibe un Json, lo transforma a objeto y lo añade al array
    public void actualizarArrayEntrada(String linea) {
        contactos.add(Contacto.crearObjeto(linea));
    }

    //añade un nuevo contacto con los datos que introduce el usuario al array (con sus respectivas comprobaciones)
    public void aniadirContacto() {
        int telefonoAux, idAux;
        int cont = 0;

        telefonoAux = transformarEntero(controladorVista.getTextFieldTelefono());
        idAux = transformarEntero(controladorVista.getTextFieldId());

        //buscar si el id ya esta registrado porque dos contactos no pueden tener el mismo id
        for (Contacto indice: contactos) {
            if (indice.getId() != idAux){
                cont++;
            }
        }
        //si el id no ha sido encontrado se añade
        if (cont == contactos.size() && idAux>0) {
            contactos.add(new Contacto(idAux, controladorVista.getTextFieldNombre(), controladorVista.getTextFieldCiudad(), telefonoAux));
            JOptionPane.showMessageDialog(null, "Contacto añadido correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Este Id ya esta registrado o es menor que 0, pruebe con otro Id diferente");
        }
    }

    //metodo que tengo hecho para transformar una cadena a entero (siempre que se pueda)
    public int transformarEntero(String string){
        try {
            int numero;
            numero= Integer.parseInt(string);

            return numero;
        }catch (Exception e){
            System.out.println("No se ha podido pasar la cadena a número entero correctamente (return 0) ");
            return 0;
        }
    }

    //se pasan los objetos contacto que estan en el array a Json y se escriben en el fichero
    public void guardarFichero() {
        gestorFicheros.escribirFichero(GestorFicheros.FICHERO, contactos);
    }

    //modifica un contacto con los datos que introduce el usuario (menos la id, que es unica por cada contacto creado)
    public void modificarContacto() {
        int telefonoAux;

        telefonoAux = transformarEntero(controladorVista.getTextFieldTelefonoModificado());

        contactos.get(i).setNombre(controladorVista.getTextFieldNombreModificado());
        contactos.get(i).setCiudad(controladorVista.getTextFieldCiudadModificado());
        contactos.get(i).setTelefono(telefonoAux);

        JOptionPane.showMessageDialog(null, "Contacto modificado correctamente");
    }

    //muestra el contacto seleccionado en la vista indicada
    public void mostrarContacto(int i) {
        switch (i){
            //se llama desde la vista ver
            case 1:
                controladorVista.setJlabelIdVer(""+contacto.getId());
                controladorVista.setJlabelNombreVer(contacto.getNombre());
                controladorVista.setJlabelCiudadVer(contacto.getCiudad());
                controladorVista.setJlabelTelefonoVer(""+contacto.getTelefono());
                break;
            //se llama desde la vista modificar
            case 2:
                controladorVista.setTextFieldId(""+contacto.getId());
                controladorVista.setTextFieldNombre(contacto.getNombre());
                controladorVista.setTextFieldCiudad(contacto.getCiudad());
                controladorVista.setTextFieldTelefono(""+contacto.getTelefono());
                break;
            //se llama desde la vista eliminar
            case 3:
                controladorVista.setJlabelIdEliminar(""+contacto.getId());
                controladorVista.setJlabelNombreEliminar(contacto.getNombre());
                controladorVista.setJlabelCiudadEliminar(contacto.getCiudad());
                controladorVista.setJlabelTelefonoEliminar(""+contacto.getTelefono());
                break;
        }

    }

    //crea un contacto auxiliar con los datos del contacto seleccionado (no haria falta realmente pero lo empecé a hacer asi y lo he dejado)
    public void seleccionarContacto(){
        contacto = new Contacto(contactos.get(i).getId(),
                contactos.get(i).getNombre(),
                contactos.get(i).getCiudad(),
                contactos.get(i).getTelefono());
    }

    //gestiona el boton siguiente de la vista modificar controlando que no se salga de la longitud del array
    public void siguienteContactoModificar() {
        if (i>=0 && i<contactos.size()-1){
            i++;
            seleccionarContacto();
            mostrarContacto(2);
        }else{
            JOptionPane.showMessageDialog(null, "Este es el último contacto guardado");
        }
    }

    //gestiona el boton anterior de la vista modificar controlando que no sea menor que 0
    public void anteriorContactoModificar() {
        if (i>0 && i<=contactos.size()){
            i--;
            seleccionarContacto();
            mostrarContacto(2);
        }else{
            JOptionPane.showMessageDialog(null, "Este es el primer contacto guardado");
        }
    }

    //gestiona el boton siguiente de la vista eliminar controlando que no se salga de la longitud del array
    public void siguienteContactoEliminar() {
        if (i>=0 && i<contactos.size()-1){
            i++;
            seleccionarContacto();
            mostrarContacto(3);
        }else{
            JOptionPane.showMessageDialog(null, "Este es el último contacto guardado");
        }
    }

    //gestiona el boton anterior de la vista eliminar controlando que no sea menor que 0
    public void anteriorContactoEliminar() {
        if (i>0 && i<=contactos.size()){
            i--;
            seleccionarContacto();
            mostrarContacto(3);
        }else{
            JOptionPane.showMessageDialog(null, "Este es el primer contacto guardado");
        }
    }

    //gestiona el boton siguiente de la vista ver controlando que no se salga de la longitud del array
    public void siguienteContactoVer() {
        if (i>=0 && i<contactos.size()-1){
            i++;
            seleccionarContacto();
            mostrarContacto(1);
        }else{
            JOptionPane.showMessageDialog(null, "Este es el último contacto guardado");
        }
    }

    //gestiona el boton anterior de la vista ver controlando que no sea menor que 0
    public void anteriorContactoVer() {
        if (i>0 && i<=contactos.size()){
            i--;
            seleccionarContacto();
            mostrarContacto(1);
        }else{
            JOptionPane.showMessageDialog(null, "Este es el primer contacto guardado");
        }
    }

    //para que cada vez que se abra la opcion de modificar, ver o eliminar empiece desde el primer contacto
    public void reiniciarI() {
        i = 0;
    }

    //eliminar el contacto seleccionado del array y por lo tanto no se reescribe en el fichero tampoco
    public void eliminarContacto() {
        contactos.remove(i);
        JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente");

        //para que salga el anterior al eliminado
        i--;
        seleccionarContacto();
        mostrarContacto(3);
    }
}

package com.company.controladores;

import com.company.LogicaAgenda;
import com.company.vistas.*;

import javax.swing.*;
import java.awt.event.*;

public class ControladorVista extends WindowAdapter implements ActionListener {
    LogicaAgenda logicaAgenda;
    VistaAniadir vistaAniadir;
    VistaPrincipal vistaPrincipal;
    VistaEliminar vistaEliminar;
    VistaModificar vistaModificar;
    VistaVer vistaVer;

    public ControladorVista(LogicaAgenda logicaAgenda) {
        this.logicaAgenda = logicaAgenda;
        vistaPrincipal = new VistaPrincipal(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //si es el menu item que cierra la app se guardan los contactos en el fichero
        if(actionEvent.getActionCommand().equals(VistaPrincipal.MENU_ITEM_EXIT)){
            logicaAgenda.guardarFichero();
            System.exit(0);
        }else {
            try {
                actionEvent.getSource().getClass().equals(JButton.class);
                JButton aux = (JButton) actionEvent.getSource();
                switch (aux.getName()) {    //Controla que boton se ha clickeado y realiza la accion correspondiente
                    case VistaPrincipal.ID_BOTON_ANIADIR_VISTA_PRINCIPAL:
                        vistaAniadir = new VistaAniadir(this);
                        break;
                    case VistaAniadir.ID_BOTON_ANIADIR:
                        logicaAgenda.aniadirContacto();
                        vistaAniadir.dispose();
                        break;
                    case VistaPrincipal.ID_BOTON_BORRAR_VISTA_PRINCIPAL:
                        vistaEliminar = new VistaEliminar(this);
                        logicaAgenda.reiniciarI();
                        logicaAgenda.seleccionarContacto();
                        logicaAgenda.mostrarContacto(3);
                        break;
                    case VistaPrincipal.ID_BOTON_MODIFICAR_VISTA_PRINCIPAL:
                        vistaModificar = new VistaModificar(this);
                        logicaAgenda.reiniciarI();
                        logicaAgenda.seleccionarContacto();
                        logicaAgenda.mostrarContacto(2);
                        break;
                    case VistaPrincipal.ID_BOTON_VER:
                        vistaVer =new VistaVer(this);
                        logicaAgenda.reiniciarI();
                        logicaAgenda.seleccionarContacto();
                        logicaAgenda.mostrarContacto(1);
                        break;
                    case VistaModificar.ID_BOTON_MODIFICAR:
                        logicaAgenda.modificarContacto();
                        vistaModificar.dispose();
                        break;
                    case VistaModificar.ID_BOTON_SIGUIENTE:
                        logicaAgenda.siguienteContactoModificar();
                        break;
                    case VistaModificar.ID_BOTON_ANTERIOR:
                        logicaAgenda.anteriorContactoModificar();
                        break;
                    case VistaEliminar.ID_BOTON_ELIMINAR:
                        logicaAgenda.eliminarContacto();
                        break;
                    case VistaEliminar.ID_BOTON_SIGUIENTE:
                        logicaAgenda.siguienteContactoEliminar();
                        break;
                    case VistaEliminar.ID_BOTON_ANTERIOR:
                        logicaAgenda.anteriorContactoEliminar();
                        break;
                    case VistaVer.ID_BOTON_SIGUIENTE:
                        logicaAgenda.siguienteContactoVer();
                        break;
                    case VistaVer.ID_BOTON_ANTERIOR:
                        logicaAgenda.anteriorContactoVer();
                        break;
                }
            } catch (Exception e) {
                logicaAgenda.guardarFichero();
                System.exit(-1);
            }
        }
    }
    //recoger texto vista aniadir
    public String getTextFieldId() {
        return vistaAniadir.getTextFieldId();
    }

    public String getTextFieldNombre() {
        return vistaAniadir.getTextFieldNombre();
    }

    public String getTextFieldCiudad() {
        return vistaAniadir.getTextFieldCiudad();
    }

    public String getTextFieldTelefono() {
        return vistaAniadir.getTextFieldTelefono();
    }

    //recoger texto vista modificar
    public String getTextFieldNombreModificado() {
        return vistaModificar.getTextFieldNombre();
    }

    public String getTextFieldCiudadModificado() {
        return vistaModificar.getTextFieldCiudad();
    }

    public String getTextFieldTelefonoModificado() {
        return vistaModificar.getTextFieldTelefono();
    }

    //pasar de logica a vista modificar
    public void setTextFieldId(String string) {
        vistaModificar.setTextFieldId(string);
    }

    public void setTextFieldNombre(String string) {
        vistaModificar.setTextFieldNombre(string);
    }

    public void setTextFieldCiudad(String string) {
        vistaModificar.setTextFieldCiudad(string);
    }

    public void setTextFieldTelefono(String string) {
        vistaModificar.setTextFieldTelefono(string);
    }


    //pasar de logica a vista eliminar
    public void setJlabelIdEliminar(String string) {
        vistaEliminar.setLabelId(string);
    }

    public void setJlabelNombreEliminar(String string) {
        vistaEliminar.setLabelNombre(string);
    }

    public void setJlabelCiudadEliminar(String string) {
        vistaEliminar.setLabelCiudad(string);
    }

    public void setJlabelTelefonoEliminar(String string) {
        vistaEliminar.setLabelTelefono(string);
    }

    //pasar de logica a vista ver
    public void setJlabelIdVer(String string) {
        vistaVer.setLabelId(string);
    }

    public void setJlabelNombreVer(String string) {
        vistaVer.setLabelNombre(string);
    }

    public void setJlabelCiudadVer(String string) {
        vistaVer.setLabelCiudad(string);
    }

    public void setJlabelTelefonoVer(String string) {
        vistaVer.setLabelTelefono(string);
    }

    //controlar que al cerrar la ventana se guarden los contactos en el fichero
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        logicaAgenda.guardarFichero();
        System.exit(0);
    }
}

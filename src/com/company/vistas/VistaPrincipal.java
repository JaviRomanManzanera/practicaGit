package com.company.vistas;

import com.company.controladores.ControladorVista;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JFrame {
    public static final String MENU_ITEM_EXIT = "EXIT";
    public static final String ID_BOTON_VER = "Boton Ver Contactos";
    public static final String ID_BOTON_ANIADIR_VISTA_PRINCIPAL = "Boton Añadir Contacto VistaPrincipal";
    public static final String ID_BOTON_MODIFICAR_VISTA_PRINCIPAL = "Boton Modificar Contacto VistaPrincipal";
    public static final String ID_BOTON_BORRAR_VISTA_PRINCIPAL = "Boton Borrar Contacto VistaPrincipal";

    ControladorVista controladorVista;
    private MenuItem menuItemExit;
    private JPanel panelTitulo,panelModificar,panelAniadir,panelBorrar,panelVer;
    private JButton buttonVer, buttonModificar, buttonAniadir, buttonBorrar;

    public VistaPrincipal(ControladorVista controladorVista) {
        super("Agenda Javier Román");
        this.controladorVista = controladorVista;
        configurarVentana();
        crearInterfaz();
        mostrarVentana();
    }

    private void crearInterfaz() {
        crearMenuBar();
        crearPanelTitulo();
        crearPanelAux();
        crearPanelVer();
        crearPanelModificar();
        crearPanelAniadir();
        crearPanelBorrar();
        crearFondo();
    }

    private void crearFondo() {
        panelBorrar.setBackground(Color.BLACK);
        panelModificar.setBackground(Color.BLACK);
        panelVer.setBackground(Color.BLACK);
        panelAniadir.setBackground(Color.BLACK);
        panelTitulo.setBackground(Color.BLACK);
    }

    private void crearPanelAux() {
        JPanel panelAux = new JPanel();
        panelAux.setBackground(Color.BLACK);
        this.add(panelAux);
    }

    private void crearPanelBorrar() {
        panelBorrar = new JPanel();

        buttonBorrar = new JButton("Borrar Contacto");
        buttonBorrar.setName(ID_BOTON_BORRAR_VISTA_PRINCIPAL);
        buttonBorrar.addActionListener(controladorVista);

        panelBorrar.add(buttonBorrar);

        this.add(panelBorrar);
    }

    private void crearPanelModificar() {
        panelModificar = new JPanel();

        buttonModificar = new JButton("Modificar Contacto");
        buttonModificar.setName(ID_BOTON_MODIFICAR_VISTA_PRINCIPAL);
        buttonModificar.addActionListener(controladorVista);

        panelModificar.add(buttonModificar);

        this.add(panelModificar);
    }

    private void crearPanelVer() {
        panelVer = new JPanel();

        buttonVer = new JButton("Ver Contactos");
        buttonVer.setName(ID_BOTON_VER);
        buttonVer.addActionListener(controladorVista);

        panelVer.add(buttonVer);

        this.add(panelVer);
    }

    private void crearPanelAniadir() {
        panelAniadir = new JPanel();

        buttonAniadir = new JButton("Añadir Contacto");
        buttonAniadir.setName(ID_BOTON_ANIADIR_VISTA_PRINCIPAL);
        buttonAniadir.addActionListener(controladorVista);

        panelAniadir.add(buttonAniadir);

        this.add(panelAniadir);
    }

    private void crearPanelTitulo() {
        JLabel jLabelTitulo = new JLabel("AGENDA JAVIER ROMÁN");
        jLabelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        jLabelTitulo.setForeground(Color.GREEN);

        panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());

        jLabelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));

        panelTitulo.add(jLabelTitulo);

        this.add(panelTitulo);
    }

    private void crearMenuBar() {
        MenuBar menuBar= new MenuBar();
        Menu menuArchivo = new Menu("Salir");
        menuItemExit = new MenuItem(MENU_ITEM_EXIT);
        menuItemExit.addActionListener(controladorVista);
        menuArchivo.add(menuItemExit);
        menuBar.add(menuArchivo);
        this.setMenuBar(menuBar);
    }

    private void configurarVentana() {
        this.setLayout(new GridLayout(6, 0));
        this.addWindowListener(controladorVista);
    }

    private void mostrarVentana() {
        this.setSize(600, 600);
        this.setVisible(true);
    }
}

package com.company.vistas;

import com.company.controladores.ControladorVista;

import javax.swing.*;
import java.awt.*;

public class VistaAniadir extends JFrame {
    public static final String ID_BOTON_ANIADIR = "Boton Añadir Contacto";


    ControladorVista controladorVista;
    private JPanel panelTitulo,panelTitulo2, panelId, panelNombre, panelCiudad, panelTelefono, panelBoton;
    private TextField textFieldId, textFieldNombre, textFieldCiudad, textFieldTelefono;
    private JButton buttonAniadir;

    public VistaAniadir(ControladorVista controladorVista){
        super("Agenda");
        this.controladorVista = controladorVista;
        configurarVentana();
        crearInterfaz();
        mostrarVentana();
    }

    private void crearInterfaz() {
        crearPanelTitulo();
        crearPanelTitulo2();
        crearPanelId();
        crearPanelNombre();
        crearPanelCiudad();
        crearPanelTelefono();
        crearPanelBoton();
        generarFondo();
    }

    private void generarFondo() {
        panelTitulo.setBackground(Color.BLACK);
        panelTitulo2.setBackground(Color.BLACK);
        panelTelefono.setBackground(Color.BLACK);
        panelCiudad.setBackground(Color.BLACK);
        panelNombre.setBackground(Color.BLACK);
        panelBoton.setBackground(Color.BLACK);
        panelId.setBackground(Color.BLACK);
    }

    private void crearPanelTitulo2() {
        JLabel jLabelTitulo2 = new JLabel("Añadir Contacto");
        jLabelTitulo2.setFont(new Font("Arial", Font.BOLD, 24));
        jLabelTitulo2.setForeground(Color.WHITE);

        panelTitulo2 = new JPanel();
        panelTitulo2.setLayout(new FlowLayout());

        jLabelTitulo2.setLayout(new FlowLayout(FlowLayout.CENTER));

        panelTitulo2.add(jLabelTitulo2);

        this.add(panelTitulo2);
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

    private void crearPanelId() {
        JLabel jLabelId = new JLabel("Id: ");
        jLabelId.setForeground(Color.WHITE);
        JPanel panelAux1 = new JPanel();
        panelAux1.setBackground(Color.BLACK);
        JPanel panelAux2 = new JPanel();
        panelAux2.setBackground(Color.BLACK);
        JPanel panelAux3 = new JPanel();
        panelAux3.setBackground(Color.BLACK);
        JPanel panelAux4 = new JPanel();
        panelAux4.setBackground(Color.BLACK);
        JPanel panelTextField;

        panelId = new JPanel();
        panelId.setLayout(new GridLayout(0,4));

        panelId.add(panelAux1);
        panelId.add(jLabelId);

        panelTextField = new JPanel();
        panelTextField.setLayout(new GridLayout(3,0));
        panelTextField.add(panelAux3);
        textFieldId = new TextField();
        panelTextField.add(textFieldId);
        panelTextField.add(panelAux4);
        panelTextField.setBackground(Color.BLACK);

        panelId.add(panelTextField);

        panelId.add(panelAux2);

        this.add(panelId);
    }

    private void crearPanelNombre() {
        JLabel jLabelNombre = new JLabel("Nombre: ");
        jLabelNombre.setForeground(Color.WHITE);
        JPanel panelAux1 = new JPanel();
        panelAux1.setBackground(Color.BLACK);
        JPanel panelAux2 = new JPanel();
        panelAux2.setBackground(Color.BLACK);
        JPanel panelAux3 = new JPanel();
        panelAux3.setBackground(Color.BLACK);
        JPanel panelAux4 = new JPanel();
        panelAux4.setBackground(Color.BLACK);
        JPanel panelTextField;

        panelNombre = new JPanel();
        panelNombre.setLayout(new GridLayout(0,4));

        panelNombre.add(panelAux1);
        panelNombre.add(jLabelNombre);

        panelTextField = new JPanel();
        panelTextField.setLayout(new GridLayout(3,0));
        panelTextField.add(panelAux3);
        textFieldNombre = new TextField();
        panelTextField.add(textFieldNombre);
        panelTextField.add(panelAux4);
        panelTextField.setBackground(Color.BLACK);

        panelNombre.add(panelTextField);

        panelNombre.add(panelAux2);

        this.add(panelNombre);
    }

    private void crearPanelCiudad() {
        JLabel jLabelCiudad = new JLabel("Ciudad: ");
        jLabelCiudad.setForeground(Color.WHITE);
        JPanel panelAux1 = new JPanel();
        panelAux1.setBackground(Color.BLACK);
        JPanel panelAux2 = new JPanel();
        panelAux2.setBackground(Color.BLACK);
        JPanel panelAux3 = new JPanel();
        panelAux3.setBackground(Color.BLACK);
        JPanel panelAux4 = new JPanel();
        panelAux4.setBackground(Color.BLACK);
        JPanel panelTextField;

        panelCiudad = new JPanel();
        panelCiudad.setLayout(new GridLayout(0,4));

        panelCiudad.add(panelAux1);
        panelCiudad.add(jLabelCiudad);

        panelTextField = new JPanel();
        panelTextField.setLayout(new GridLayout(3,0));
        panelTextField.add(panelAux3);
        textFieldCiudad = new TextField();
        panelTextField.add(textFieldCiudad);
        panelTextField.add(panelAux4);
        panelTextField.setBackground(Color.BLACK);

        panelCiudad.add(panelTextField);

        panelCiudad.add(panelAux2);

        this.add(panelCiudad);
    }

    private void crearPanelTelefono() {
        JLabel jLabelTelefono = new JLabel("Telefono: ");
        jLabelTelefono.setForeground(Color.WHITE);
        JPanel panelAux1 = new JPanel();
        panelAux1.setBackground(Color.BLACK);
        JPanel panelAux2 = new JPanel();
        panelAux2.setBackground(Color.BLACK);
        JPanel panelAux3 = new JPanel();
        panelAux3.setBackground(Color.BLACK);
        JPanel panelAux4 = new JPanel();
        panelAux4.setBackground(Color.BLACK);
        JPanel panelTextField;

        panelTelefono = new JPanel();
        panelTelefono.setLayout(new GridLayout(0,4));

        panelTelefono.add(panelAux1);
        panelTelefono.add(jLabelTelefono);

        panelTextField = new JPanel();
        panelTextField.setLayout(new GridLayout(3,0));
        panelTextField.add(panelAux3);
        textFieldTelefono = new TextField();
        panelTextField.add(textFieldTelefono);
        panelTextField.add(panelAux4);
        panelTextField.setBackground(Color.BLACK);

        panelTelefono.add(panelTextField);

        panelTelefono.add(panelAux2);

        this.add(panelTelefono);
    }

    private void crearPanelBoton() {
        panelBoton = new JPanel();

        buttonAniadir = new JButton("Añadir Contacto");
        buttonAniadir.setName(ID_BOTON_ANIADIR);
        buttonAniadir.addActionListener(controladorVista);
        panelBoton.add(buttonAniadir);

        this.add(panelBoton);
    }


    private void configurarVentana() {
        this.setLayout(new GridLayout(7, 0));
        this.setBackground(Color.BLACK);
    }

    private void mostrarVentana() {
        this.setSize(600, 600);
        this.setVisible(true);
    }

    //recoger todos los campos introducidos por el cliente
    public String getTextFieldId() {
        return textFieldId.getText();
    }

    public String getTextFieldNombre() {
        return textFieldNombre.getText();
    }

    public String getTextFieldCiudad() {
        return textFieldCiudad.getText();
    }

    public String getTextFieldTelefono() {
        return textFieldTelefono.getText();
    }

    //cierra la ventana sin cerrar la aplicacion
    @Override
    public void dispose() {
        super.dispose();
    }
}

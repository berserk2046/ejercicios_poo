package com.mycompany.crudarchivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCRUD extends JFrame implements ActionListener {

    private final JLabel lblDocumento;
    private final JLabel lblNombre;
    private final JLabel lblEdad;
    private final JLabel lblTelefono;
    private final JLabel lblModo;

    private final JTextField txtDocumento;
    private final JTextField txtNombre;
    private final JTextField txtEdad;
    private final JTextField txtTelefono;

    private final JButton btnCrear;
    private final JButton btnConsultar;
    private final JButton btnActualizar;
    private final JButton btnAceptarActualizacion;
    private final JButton btnEliminar;

    private final JTextArea areaMensajes;
    private final JScrollPane scroll;

    private String cedulaActualizando;

    public VentanaCRUD() {

        setTitle("CRUD Personas");
        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(30, 30, 100, 30);
        add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(140, 30, 180, 30);
        add(txtDocumento);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 80, 100, 30);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 80, 250, 30);
        add(txtNombre);

        lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 130, 100, 30);
        add(lblEdad);

        lblModo = new JLabel("");
        lblModo.setBounds(450, 30, 200, 80);
        add(lblModo);

        txtEdad = new JTextField();
        txtEdad.setBounds(140, 130, 100, 30);
        add(txtEdad);

        lblTelefono = new JLabel("Telefono:");
        lblTelefono.setBounds(30, 180, 100, 30);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(140, 180, 180, 30);
        add(txtTelefono);

        btnCrear = new JButton("Crear");
        btnCrear.setBounds(30, 250, 110, 35);
        btnCrear.addActionListener(this);
        add(btnCrear);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(160, 250, 110, 35);
        btnConsultar.addActionListener(this);
        add(btnConsultar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(290, 250, 110, 35);
        btnActualizar.addActionListener(this);
        add(btnActualizar);

        btnAceptarActualizacion = new JButton("Aceptar");
        btnAceptarActualizacion.setBounds(420, 250, 110, 35);
        btnAceptarActualizacion.addActionListener(this);
        btnAceptarActualizacion.setVisible(false);
        add(btnAceptarActualizacion);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(420, 250, 110, 35);
        btnEliminar.addActionListener(this);
        add(btnEliminar);

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);

        scroll = new JScrollPane(areaMensajes);
        scroll.setBounds(30, 320, 520, 110);
        add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCrear) {
            crearPersona();
        } else if (e.getSource() == btnConsultar) {
            consultarPersonas();
        } else if (e.getSource() == btnActualizar) {
            iniciarActualizacion();
        } else if (e.getSource() == btnAceptarActualizacion) {
            aceptarActualizacion();
        } else if (e.getSource() == btnEliminar) {
            eliminarPersona();
        }
    }

    private void crearPersona() {
        try {
            String documento = txtDocumento.getText().trim();
            String nombre = txtNombre.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            String telefono = txtTelefono.getText().trim();

            if (documento.isEmpty() || nombre.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }         

            ArchivoPersonas archivo = new ArchivoPersonas();
            Persona personaExistente = archivo.buscarPorCedula(documento);

            if (personaExistente != null) {
                JOptionPane.showMessageDialog(this, "Ya existe una persona con esa cedula.");
                return;
            }

            Persona persona = new Persona(documento, nombre, edad, telefono);            
            boolean guardado = archivo.crear(persona);

            if (guardado) {
                areaMensajes.setText("");
                areaMensajes.append("Registro guardado: " + persona.convertirLinea() + "\n");
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Registro creado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No fue posible guardar el registro.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un numero.");
        }
    }

    private void consultarPersonas() {
        String[] opciones = {"Toda la lista", "Una persona"};

        int respuesta = JOptionPane.showOptionDialog(
                this,
                "Que desea consultar?",
                "Consultar personas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (respuesta == 0) {
            ArchivoPersonas archivo = new ArchivoPersonas();
            String contenido = archivo.leerArchivo();
            areaMensajes.setText(contenido);
        } else if (respuesta == 1) {
            String cedula = JOptionPane.showInputDialog(this, "Digite la cedula:");

            if (cedula == null || cedula.trim().isEmpty()) {
                return;
            }

            ArchivoPersonas archivo = new ArchivoPersonas();
            Persona persona = archivo.buscarPorCedula(cedula.trim());

            if (persona == null) {
                areaMensajes.setText("No se encontro una persona con esa cedula.");
            } else {
                areaMensajes.setText(
                        "Documento: " + persona.getDocumento() + "\n"
                        + "Nombre: " + persona.getNombre() + "\n"
                        + "Edad: " + persona.getEdad() + "\n"
                        + "Telefono: " + persona.getTelefono() + "\n");
            }
        }
    }

    private void iniciarActualizacion() {
        String cedula = JOptionPane.showInputDialog(this, "Digite la cedula de la persona a actualizar:");

        if (cedula == null || cedula.trim().isEmpty()) {
            return;
        }

        ArchivoPersonas archivo = new ArchivoPersonas();
        Persona persona = archivo.buscarPorCedula(cedula.trim());
        
        if (persona == null) {
            JOptionPane.showMessageDialog(this, "No se encontro una persona con esa cedula.");
            return;
        }
        
        cedulaActualizando = persona.getDocumento();
        txtDocumento.setText(persona.getDocumento());
        txtNombre.setText(persona.getNombre());
        txtEdad.setText(String.valueOf(persona.getEdad()));
        txtTelefono.setText(persona.getTelefono());

        lblModo.setText("<html>Actualizando:<br>"
                + persona.getNombre() + "<br>"
                + persona.getDocumento() + "</html>");

        btnCrear.setVisible(false);
        btnConsultar.setVisible(false);
        btnActualizar.setVisible(false);
        btnEliminar.setVisible(false);

        btnAceptarActualizacion.setVisible(true);
    }

    private void aceptarActualizacion() {
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "Esta seguro de actualizar esta persona?",
                "Confirmar actualizacion",
                JOptionPane.YES_NO_OPTION);

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        String documento = txtDocumento.getText().trim();
        String nombre = txtNombre.getText().trim();
        int edad;
        String telefono = txtTelefono.getText().trim();
        
        if (documento.isEmpty() || nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }
        
        try {
            edad = Integer.parseInt(txtEdad.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un numero.");
            return;
        }
        
        Persona personaActualizada = new Persona(documento, nombre, edad, telefono);
        ArchivoPersonas archivo = new ArchivoPersonas();

        boolean actualizado = archivo.actualizarPorCedula(cedulaActualizando, personaActualizada);

        if (actualizado) {
            JOptionPane.showMessageDialog(this, "Persona actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la persona.");
        }

        salirModoActualizacion();
    }  

    private void eliminarPersona() {
        String cedula = JOptionPane.showInputDialog(this, "Digite la cedula de la persona a eliminar:");

        if (cedula == null || cedula.trim().isEmpty()) {
            return;
        }

        ArchivoPersonas archivo = new ArchivoPersonas();
        Persona persona = archivo.buscarPorCedula(cedula.trim());

        if (persona == null) {
            JOptionPane.showMessageDialog(this, "No se encontro una persona con esa cedula.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Esta seguro de que desea eliminar a: " + persona.getNombre() + "?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = archivo.eliminarPorCedula(cedula.trim());

            if (eliminado) {
                areaMensajes.setText("Registro eliminado: " + persona.getNombre() + " (" + cedula.trim() + ")");
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Persona eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro del archivo.");
            }
        }
    }

    private void salirModoActualizacion() {
        limpiarCampos();
        lblModo.setText("");

        btnCrear.setVisible(true);
        btnConsultar.setVisible(true);
        btnActualizar.setVisible(true);
        btnEliminar.setVisible(true);
        btnAceptarActualizacion.setVisible(false);
    }  

    private void limpiarCampos() {
        txtDocumento.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtDocumento.requestFocus();
    }
}

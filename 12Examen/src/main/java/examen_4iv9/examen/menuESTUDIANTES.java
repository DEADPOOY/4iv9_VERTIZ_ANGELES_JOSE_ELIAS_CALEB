/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_4iv9.examen;

/**
 *
 * @author DEADPOOY2
 * 
 * aqui va completamente la interfaz de estudiante despues
 * de que uno pulsa el boton en la primer interfaz
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class menuESTUDIANTES extends JFrame{
    private ArrayList<Estudiante> listaEstudiantes;
    private DefaultTableModel modelo;
    private JTable tabla;
    
    public menuESTUDIANTES(){
        listaEstudiantes = guardarArchivos.cargarEstudiantes();
        
        setTitle("Gestion de Estudiantes");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //tabla
        String[] columnas = {"ID", "Nombre", "Edad", "Boleta", "Carrera"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        actualizarTabla();
        
        JScrollPane scroll = new JScrollPane(tabla);
        
        //panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton boton_Agr = new JButton("Agregar Estudiante");
        JButton boton_edit = new JButton("Editar");
        JButton boton_del = new JButton("Eliminar");
        JButton boton_save = new JButton("📁 Guardar en Archivo");
        JButton boton_fresh = new JButton("");
        
        panelBotones.add(boton_Agr);
        panelBotones.add(boton_edit);
        panelBotones.add(boton_del);
        panelBotones.add(boton_fresh);
        panelBotones.add(boton_save);
        
        setLayout(new BorderLayout(10, 10));
        add(new JLabel("GESTIÓN DE ESTUDIANTES", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        // Acciones
        boton_Agr.addActionListener(e -> agregarEstudiante());
        boton_edit.addActionListener(e -> editarEstudiante());
        boton_del.addActionListener(e -> eliminarEstudiante());
        boton_save.addActionListener(e -> guardarDatos());
        boton_fresh.addActionListener(e -> actualizarTabla());
    }
    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (Estudiante e : listaEstudiantes) {
            modelo.addRow(new Object[]{
                e.getID(), e.getnombre(), e.getedad(), e.getBoleta(), e.getCarrera()
            });
        }
    }
    private void agregarEstudiante() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese ID:"));
            
            // Verificar si ya existe
            if (listaEstudiantes.stream().anyMatch(e -> e.getID() == id)) {
                JOptionPane.showMessageDialog(this, "Ya existe un estudiante con ese ID");
                return;
            }

            String nombre = JOptionPane.showInputDialog(this, "Nombre:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog(this, "Edad:"));
            int boleta = Integer.parseInt(JOptionPane.showInputDialog(this, "Boleta:"));
            String carrera = JOptionPane.showInputDialog(this, "Carrera:");

            Estudiante nuevo = new Estudiante(boleta, carrera, id, edad, nombre);
            listaEstudiantes.add(nuevo);
            actualizarTabla();

            JOptionPane.showMessageDialog(this, "Estudiante agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Verifique los datos ingresados");
        }
    }
    private void editarEstudiante() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante de la tabla");
            return;
        }

        Estudiante e = listaEstudiantes.get(fila);

        e.setnombre(JOptionPane.showInputDialog(this, "Nuevo Nombre:", e.getnombre()));
        e.setedad(Integer.parseInt(JOptionPane.showInputDialog(this, "Nueva Edad:", e.getedad())));
        e.setCarrera(JOptionPane.showInputDialog(this, "Nueva Carrera:", e.getCarrera()));

        actualizarTabla();
        JOptionPane.showMessageDialog(this, "Estudiante actualizado");
    }

    private void eliminarEstudiante() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante");
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este estudiante?") == 0) {
            listaEstudiantes.remove(fila);
            actualizarTabla();
        }
    }

    private void guardarDatos() {
        guardarArchivos.guardarEstudiantes(listaEstudiantes);
        JOptionPane.showMessageDialog(this, "Datos guardados correctamente en el archivo");
    }
}

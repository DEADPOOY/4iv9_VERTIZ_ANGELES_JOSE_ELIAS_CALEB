/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_4iv9.examen;

/**
 *
 * @author dell
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class menuPROFESORES extends JFrame {

    private ArrayList<Profesor> listaProfesores;
    private DefaultTableModel modelo;
    private JTable tabla;

    public menuPROFESORES() {
        listaProfesores = guardarArchivos.cargarProfesores();

        setTitle("Gestión de Profesores");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Edad", "Materia", "Salario"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        actualizarTabla();

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton btnAgregar = new JButton("Agregar Profesor");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnGuardar = new JButton("💾 Guardar en Archivo");
        JButton btnRefrescar = new JButton("");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRefrescar);
        panelBotones.add(btnGuardar);

        setLayout(new BorderLayout(10, 10));
        add(new JLabel("GESTIÓN DE PROFESORES", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> agregarProfesor());
        btnEditar.addActionListener(e -> editarProfesor());
        btnEliminar.addActionListener(e -> eliminarProfesor());
        btnGuardar.addActionListener(e -> guardarDatos());
        btnRefrescar.addActionListener(e -> actualizarTabla());
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (Profesor p : listaProfesores) {
            modelo.addRow(new Object[]{
                p.getID(), p.getnombre(), p.getedad(), p.getMateriaDada(), p.getSalario()
            });
        }
    }

    private void agregarProfesor() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese ID:"));
            
            if (listaProfesores.stream().anyMatch(p -> p.getID() == id)) {
                JOptionPane.showMessageDialog(this, "Ya existe un profesor con ese ID");
                return;
            }

            String nombre = JOptionPane.showInputDialog(this, "Nombre:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog(this, "Edad:"));
            String materia = JOptionPane.showInputDialog(this, "Materia:");
            double salario = Double.parseDouble(JOptionPane.showInputDialog(this, "Salario:"));

            Profesor nuevo = new Profesor(materia, salario, id, edad, nombre);
            listaProfesores.add(nuevo);
            actualizarTabla();

            JOptionPane.showMessageDialog(this, "Profesor agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados");
        }
    }

    private void editarProfesor() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor");
            return;
        }

        Profesor p = listaProfesores.get(fila);

        p.setnombre(JOptionPane.showInputDialog(this, "Nuevo Nombre:", p.getnombre()));
        p.setedad(Integer.parseInt(JOptionPane.showInputDialog(this, "Nueva Edad:", p.getedad())));
        p.setMateriaDada(JOptionPane.showInputDialog(this, "Nueva Materia:", p.getMateriaDada()));
        p.setSalario(Double.parseDouble(JOptionPane.showInputDialog(this, "Nuevo Salario:", p.getSalario())));

        actualizarTabla();
    }

    private void eliminarProfesor() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) return;

        if (JOptionPane.showConfirmDialog(this, "¿Eliminar este profesor?") == 0) {
            listaProfesores.remove(fila);
            actualizarTabla();
        }
    }

    private void guardarDatos() {
        guardarArchivos.guardarProfesores(listaProfesores);
        JOptionPane.showMessageDialog(this, "Datos guardados correctamente");
    }
}
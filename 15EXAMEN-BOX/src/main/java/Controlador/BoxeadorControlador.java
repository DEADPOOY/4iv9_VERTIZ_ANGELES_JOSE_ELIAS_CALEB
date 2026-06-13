/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author deadpooy
 */

import Modelo.Boxeador;
import Modelo.BoxeadorDAO;
import Vista.BoxeadorVista;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BoxeadorControlador {
    
    private BoxeadorDAO dao;
    private BoxeadorVista vista;
    
    public BoxeadorControlador(BoxeadorDAO dao, BoxeadorVista vista){
        this.dao = dao;
        this.vista = vista;
        inicializarEventos();
        cargarTabla();
    }
    
    private void inicializarEventos(){
        vista.getBtnAgregar().addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnBuscar().addActionListener(e -> buscar());
        vista.getBtnLimpiar().addActionListener(e -> limpiarFormulario());
        
        vista.getTablaBoxeadores().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    seleccionarFila();
                }
            }
        });
    }
    
    private void cargarTabla(){
        try{
            DefaultTableModel model = vista.getModeloTabla();
            model.setRowCount(0);
            for(Boxeador b : dao.listarTodos()){
                model.addRow(new Object[]{
                    b.getId(), b.getNombre(), b.getEdad(), b.getPeso(),
                    b.getCategoria(), b.getNacionalidad(),
                    b.getPeleasGanadas(), b.getPeleasPerdidas(), b.getPeleasEmpatadas(),
                    b.getGimnasio(), b.getManoDominante()
                });
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(vista, "Error al cargar tabla: " + ex.getMessage());
        }
    }
    
    private Boxeador construirBoxeador(){
        try{
            int id = Integer.parseInt(vista.getTxtId().getText());
            String nombre = vista.getTxtNombre().getText();
            int edad = Integer.parseInt(vista.getTxtEdad().getText());
            double peso = Double.parseDouble(vista.getTxtPeso().getText());
            
            return new Boxeador(id, nombre, edad, peso,
                vista.getTxtCategoria().getText(),
                vista.getTxtNacionalidad().getText(),
                Integer.parseInt(vista.getTxtGanadas().getText()),
                Integer.parseInt(vista.getTxtPerdidas().getText()),
                Integer.parseInt(vista.getTxtEmpatadas().getText()),
                vista.getTxtGimnasio().getText(),
                (String) vista.getCmbManoDominante().getSelectedItem());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(vista, "Error en datos numéricos");
            return null;
        }
    }
    
    private void agregar(){
        Boxeador b = construirBoxeador();
        if(b == null) return;
        try{
            dao.agregar(b);
            JOptionPane.showMessageDialog(vista, "Boxeador agregado exitosamente");
            cargarTabla();
            limpiarFormulario();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(vista, "Error al agregar: " + ex.getMessage());
        }
    }
    
    private void actualizar(){
        Boxeador b = construirBoxeador();
        if(b == null) return;
        try{
            dao.actualizar(b);
            JOptionPane.showMessageDialog(vista, "Boxeador actualizado");
            cargarTabla();
            limpiarFormulario();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(vista, "Error al actualizar");
        }
    }
    
    private void eliminar(){
        try{
            int id = Integer.parseInt(vista.getTxtId().getText());
            int confirm = JOptionPane.showConfirmDialog(vista, "¿Eliminar boxeador ID " + id + "?");
            if(confirm == 0){
                dao.eliminar(id);
                JOptionPane.showMessageDialog(vista, "Eliminado correctamente");
                cargarTabla();
                limpiarFormulario();
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(vista, "Seleccione un registro válido");
        }
    }
    
    private void buscar(){
        try{
            int id = Integer.parseInt(vista.getTxtId().getText());
            Boxeador b = dao.buscarPorId(id);
            if(b != null){
                // llenar formulario
                vista.getTxtNombre().setText(b.getNombre());
                vista.getTxtEdad().setText(String.valueOf(b.getEdad()));
                vista.getTxtPeso().setText(String.valueOf(b.getPeso()));
                vista.getTxtCategoria().setText(b.getCategoria());
                vista.getTxtNacionalidad().setText(b.getNacionalidad());
                vista.getTxtGanadas().setText(String.valueOf(b.getPeleasGanadas()));
                vista.getTxtPerdidas().setText(String.valueOf(b.getPeleasPerdidas()));
                vista.getTxtEmpatadas().setText(String.valueOf(b.getPeleasEmpatadas()));
                vista.getTxtGimnasio().setText(b.getGimnasio());
                vista.getCmbManoDominante().setSelectedItem(b.getManoDominante());
            } else {
                JOptionPane.showMessageDialog(vista, "Boxeador no encontrado");
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(vista, "Ingrese ID válido");
        }
    }
    
    private void seleccionarFila(){
        int fila = vista.getTablaBoxeadores().getSelectedRow();
        if(fila >= 0){
            DefaultTableModel model = vista.getModeloTabla();
            vista.getTxtId().setText(model.getValueAt(fila, 0).toString());
            vista.getTxtNombre().setText(model.getValueAt(fila, 1).toString());
        }
    }
    
    private void limpiarFormulario(){
        vista.getTxtId().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtEdad().setText("");
        vista.getTxtPeso().setText("");
        vista.getTxtCategoria().setText("");
        vista.getTxtNacionalidad().setText("");
        vista.getTxtGanadas().setText("");
        vista.getTxtPerdidas().setText("");
        vista.getTxtEmpatadas().setText("");
        vista.getTxtGimnasio().setText("");
    }
}

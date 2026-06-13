/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author deadpooy
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BoxeadorVista extends JFrame{
    
    private JTable tablaBoxeadores;
    private DefaultTableModel modeloTabla;
    
    private JTextField txtId, txtNombre, txtEdad, txtPeso, txtCategoria, 
                       txtNacionalidad, txtGanadas, txtPerdidas, txtEmpatadas, txtGimnasio;
    private JComboBox<String> cmbManoDominante;
    
    private JButton btnAgregar, btnActualizar, btnEliminar, btnBuscar, btnLimpiar;
    
    public BoxeadorVista(){
        setTitle("CRUD Boxeo - Gestión de Boxeadores");
        setSize(1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(220, 20, 60));
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN DE BOXEADORES 🥊");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.white);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        
        modeloTabla = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Edad", "Peso", "Categoría", "Nacionalidad", 
                        "G", "P", "E", "Gimnasio", "Mano"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){ return false; }
        };
        
        tablaBoxeadores = new JTable(modeloTabla);
        tablaBoxeadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaBoxeadores.setRowHeight(25);
        
        JScrollPane scrollTabla = new JScrollPane(tablaBoxeadores);
        scrollTabla.setPreferredSize(new Dimension(1100, 300));
        add(scrollTabla, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout(5,5));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelInferior.add(crearPanelFormulario(), BorderLayout.CENTER);
        panelInferior.add(crearPanelBotones(), BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridLayout(6, 4, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Boxeador"));

        panel.add(new JLabel("ID:"));           txtId = new JTextField(); panel.add(txtId);
        panel.add(new JLabel("Nombre:"));       txtNombre = new JTextField(); panel.add(txtNombre);
        panel.add(new JLabel("Edad:"));         txtEdad = new JTextField(); panel.add(txtEdad);
        panel.add(new JLabel("Peso (kg):"));    txtPeso = new JTextField(); panel.add(txtPeso);

        panel.add(new JLabel("Categoría:"));    txtCategoria = new JTextField(); panel.add(txtCategoria);
        panel.add(new JLabel("Nacionalidad:")); txtNacionalidad = new JTextField(); panel.add(txtNacionalidad);
        panel.add(new JLabel("Ganadas:"));      txtGanadas = new JTextField(); panel.add(txtGanadas);
        panel.add(new JLabel("Perdidas:"));     txtPerdidas = new JTextField(); panel.add(txtPerdidas);

        panel.add(new JLabel("Empatadas:"));    txtEmpatadas = new JTextField(); panel.add(txtEmpatadas);
        panel.add(new JLabel("Gimnasio:"));     txtGimnasio = new JTextField(); panel.add(txtGimnasio);
        panel.add(new JLabel("Mano Dominante:")); 
        cmbManoDominante = new JComboBox<>(new String[]{"Diestro", "Zurdo", "Ambidiestro"});
        panel.add(cmbManoDominante);

        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        btnLimpiar = new JButton("Limpiar");

        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);
        panel.add(btnLimpiar);

        return panel;
    }

    public JTable getTablaBoxeadores() { return tablaBoxeadores; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtEdad() { return txtEdad; }
    public JTextField getTxtPeso() { return txtPeso; }
    public JTextField getTxtCategoria() { return txtCategoria; }
    public JTextField getTxtNacionalidad() { return txtNacionalidad; }
    public JTextField getTxtGanadas() { return txtGanadas; }
    public JTextField getTxtPerdidas() { return txtPerdidas; }
    public JTextField getTxtEmpatadas() { return txtEmpatadas; }
    public JTextField getTxtGimnasio() { return txtGimnasio; }
    public JComboBox<String> getCmbManoDominante() { return cmbManoDominante; }

    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
}
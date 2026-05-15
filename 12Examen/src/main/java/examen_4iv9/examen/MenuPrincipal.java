/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_4iv9.examen;

/**
 *
 * @author DEADPOOY2
 */
import javax.swing.*;
import java.awt.*;

//clase heredada una ventana
public class MenuPrincipal extends JFrame{
    public MenuPrincipal(){
        setTitle("examen aca bien aca");//titulo
        setSize(500, 500);//tamaño
        setLocationRelativeTo(null);//cerrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//terminar programa
        setLayout(new GridLayout(3,1,10,10));//acomodo de componentes
        
        //crea un texto
        JLabel titulo = new JLabel("examen|GESTION ESCOLAR|", SwingConstants.CENTER);
        //fuente del textp
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        //boton estudiantes
        JButton boton_est = new JButton("GESTIONAR ESTUDIANTES");
        //boton profesores
        JButton boton_prof = new JButton("GESTIONAR PROFESORES");
        //boton salir
        JButton boton_salir = new JButton("SALIR");
        
        //fuentes
        boton_est.setFont(new Font("Arial", Font.PLAIN, 18));
        boton_prof.setFont(new Font("Arial", Font.PLAIN, 18));
        boton_salir.setFont(new Font("Arial", Font.PLAIN, 18));
        
        //como en javascript va a escuchar cuando haga click y crear
        //la ventana basicamente la llama desde otro archivo como
        //si fuera import en python xd 👻👻👻👻👻👻👻👻👻👻👻👻👻👻👻👻
        
        boton_est.addActionListener(e -> new menuESTUDIANTES().setVisible(true));
        boton_prof.addActionListener(e -> new menuPROFESORES().setVisible(true));
        boton_salir.addActionListener(e -> System.exit(0));
        //0 significa salida correcta
        
        //agregar los componetes
        add(titulo);
        add(boton_est);
        add(boton_prof);
        add(boton_salir);
    }
}

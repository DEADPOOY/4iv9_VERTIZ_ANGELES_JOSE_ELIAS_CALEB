/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nointernet;

/**
 *
 * @author deadpooy
 */

import Controlador.BoxeadorControlador;
import Modelo.BoxeadorDAO;
import Vista.BoxeadorVista;
import Modelo.ConexionBD;
import javax.swing.JOptionPane;

public class NoInternet {
    public static void main(String[] args) throws Exception {
        if(!ConexionBD.probarConexion()){
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos box_db");
            return;
        }
        
        BoxeadorDAO modelo = new BoxeadorDAO();
        BoxeadorVista vista = new BoxeadorVista();
        
        new BoxeadorControlador(modelo, vista);
        
        vista.setVisible(true);
    }
}
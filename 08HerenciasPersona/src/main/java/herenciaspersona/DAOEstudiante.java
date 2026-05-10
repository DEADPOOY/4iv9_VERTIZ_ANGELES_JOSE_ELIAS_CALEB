/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciaspersona;

/**
 *
 * @author DEADPOOY2
 */
import javax.swing.JOptionPane;

public class DAOEstudiante {
    
    //vamos a crear un programa para dar de alta 10 estudiantes
    
    //un objeto por parte de estudiante
    Estudiante obj[] = new Estudiante[10];
    int x = 0;
    
    //metodo del menu para el programa
    void menu(){
        String var = "si";
        String mensaje = "";
        
        while(var.equalsIgnoreCase("si")){
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo estudiante. \n"
                    + "2.- Mostrar los datos de todos los estudiantes \n"
                    + "3.-Modificar estudiante\n"));
            switch (op) {
                case 1:
                    //metodo para registrar
                    pedirEstudiante();                    
                    
                    break;
                case 2:
                    //mostrar estudiantes
                    mostrarEstudiante();
                    break;
                case 3:
                    modificarEstudiante();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            mensaje = JOptionPane.showInputDialog("¿Desea repetir el programa?");
        }
    }

    public void pedirEstudiante() {
        if (x >= 10){
            JOptionPane.showMessageDialog(null, "ya se guardaron 10 estudiantes");
            return;
        }
        
        int numboleta = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la boleta del estudiante: "));
        String nom = JOptionPane.showInputDialog(
                "Ingresa el nombre del estudiante");
        int edad = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la edad del estudiante: "));
        char gen = JOptionPane.showInputDialog(
                "Ingresa el genero del estudiante M/F").charAt(0);
        
        obj[x] = new Estudiante(numboleta, nom, edad, gen);
        
        obj[x].setNombre(nom);
        obj[x].setEdad(edad);
        obj[x].setGenero(gen);
        obj[x].setNumBoleta(numboleta);
        x++;
        
        JOptionPane.showMessageDialog(null, "estudiante guardadado correctamente");
    }

    public void mostrarEstudiante() {
        if (x == 0){
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }
        //necesitamos recorrer el arreglo del tamaño que sea
        
        for(int i = 0; i < x; i++){
            //visualizar los datos
            JOptionPane.showMessageDialog(null,
                    "=== Estudiante " + (i+1) + " ===\n" +
                    "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n"
                    +"El nombre del estudiante es: " + obj[i].getNombre()+ "\n"
                   +"La edad del estudiante es: " + obj[i].getEdad() + "\n"
                   +"El genero del estudiante es: " + obj[i].getGenero()+ "\n");
        }
    }
    
    //para lo de aplicar el set
    public void modificarEstudiante(){
        int boletaBuscada = Integer.parseInt(JOptionPane.showInputDialog("Ingresa boleta del estudiante a modificar:"));
        
        for(int i = 0; i < x; i++){
            if(obj[i].getNumBoleta() == boletaBuscada){
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:"));
                char nuevoGen = JOptionPane.showInputDialog("Nuevo género:").charAt(0);
                
                obj[i].setNombre(nuevoNombre);
                obj[i].setEdad(nuevaEdad);
                obj[i].setGenero(nuevoGen);
                
                JOptionPane.showMessageDialog(null, "¡Estudiante modificado!");
                return;
            }
        }
        
    }
    
}
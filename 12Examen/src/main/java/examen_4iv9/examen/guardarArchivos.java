/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_4iv9.examen;

/**
 *
 * @author DEADPOOY2
 * 
 * el java .io ya importa FileWriter
FileReader
BufferedWriter
BufferedReader
IOException
 */
import java.io.*;
import java.util.ArrayList;
public class guardarArchivos {
    private static final String DATOS_ESTUDIANTES = "estudiantes.txt";
    private static final String DATOS_PROFESORES = "profesores.txt";
    // aqui viene el de estudiantes
    //osea aqui se creea
    
    public static void guardarEstudiantes(ArrayList<Estudiante> lista){
        //abre el archivo si no lo existe lo crea
        try (BufferedWriter escribe = new BufferedWriter(new FileWriter(DATOS_ESTUDIANTES))){
            //recorre la lista de estudiantes
            for (Estudiante e : lista){
                escribe.write("boleta=" + e.getBoleta());
                escribe.newLine();
                escribe.write("id=" + e.getID());
                escribe.newLine();
                escribe.write("nombre=" + e.getnombre());
                escribe.newLine();
                escribe.write("edad=" + e.getedad());
                escribe.newLine();
                escribe.write("carrera=" + e.getCarrera());
                escribe.newLine();
                escribe.newLine(); // Separador entre registros
            }
            System.out.println("Estudiantes guardados en el archivo");
        }catch (IOException e){
            System.out.println("Error al guardar estudiantes: " + e.getMessage());
        }
        //pa devolver la lista de estudiantes
    }
    public static ArrayList<Estudiante> cargarEstudiantes() {
        //crea una lista vacia
        ArrayList<Estudiante> lista = new ArrayList<>();
        //abre el archivo y lee lineas
        try (BufferedReader leer = new BufferedReader(new FileReader(DATOS_ESTUDIANTES))){
            String linea;
            Estudiante est = null;
            //null es fin del archivo
            //mientras linea no sea null sigue leyendo
            while ((linea = leer.readLine()) != null){
                linea = linea.trim();
                //elimina espacios al inicio y al final
                if (linea.isEmpty()){
                    //checa si esta vacia
                    if (est != null){
                        //verifica si ya esta creado
                        lista.add(est);
                        //si no lo crea
                        est = null;
                        //reinicia el objeto
                    }
                    continue;
                }
                String[] partes = linea.split("=", 2);
                //divide la linea usando =
                if (partes.length == 2){
                    //verifica que existan 2 partes
                    String clave = partes[0];
                    //guarda parte izq
                    String valor = partes[1];
                    //guarda parte dcha
                    
                    if (est == null) {
                        //si no existe estudiante
                        est = new Estudiante(0, "");
                    }
                    switch (clave){
                        //revisa el dato que esta leyendo
                        case "boleta":
                            est.setBoleta(Integer.parseInt(valor));
                        case "id":
                            est.setID(Integer.parseInt(valor));
                            break;
                        case "nombre":
                            est.setnombre(valor);
                            break;
                        case"edad":
                            est.setedad(Integer.parseInt(valor));
                            break;
                        case "carrera":
                            est.setCarrera(valor);
                            break;
                    }
                }
            }
            if(est != null) lista.add(est); //ultimo registro
        }catch (Exception e){
            System.out.println("No se puede cargar el archivo de estudiantes");
        }
        return lista;
    }
    //aqui va el de profesores
    //no la voy a explicar porque es lo mismo solo que para profesor
    public static void guardarProfesores(ArrayList<Profesor> lista){
        try (BufferedWriter escribe = new BufferedWriter(new FileWriter(DATOS_PROFESORES))){
            for(Profesor p : lista){
                escribe.write("id=" + p.getID());
                escribe.newLine();
                escribe.write("nombre=" + p.getnombre());
                escribe.newLine();
                escribe.write("edad=" + p.getedad());
                escribe.newLine();
                escribe.write("materia=" + p.getMateriaDada());
                escribe.newLine();
                escribe.write("salario=" + p.getSalario());
                escribe.newLine();
                escribe.newLine();
            }
            System.out.println("Profesores guardados correctamente en " + DATOS_PROFESORES);
        }catch(Exception e){
            System.out.println("Error al guardar profesores: " + e.getMessage());
        }
    }
    public static ArrayList<Profesor> cargarProfesores(){
        ArrayList<Profesor> lista = new ArrayList<>();
        try (BufferedReader leer = new BufferedReader(new FileReader(DATOS_PROFESORES))){
            String linea;
            Profesor prof = null;
            
            while ((linea = leer.readLine()) != null){
                linea = linea.trim();
                if (linea.isEmpty()) {
                    if(prof != null) {
                        lista.add(prof);
                        prof = null;
                    }
                    continue;
                }
                
                String[] partes = linea.split("=", 2);
                if (partes.length == 2){
                    String clave = partes[0];
                    String valor = partes[1];
                
                    if (prof == null){
                        prof = new Profesor();
                    }
                    switch(clave){
                        case "id":
                            prof.setID(Integer.parseInt(valor));
                            break;
                        case "nombre":
                            prof.setnombre(valor);
                            break;
                        case "edad":
                            prof.setedad(Integer.parseInt(valor));
                            break;
                        case "materia":
                            prof.setMateriaDada(valor);
                            break;
                        case "salario":
                            prof.setSalario(Double.parseDouble(valor));
                            break;
                    }
                }
            }
            if (prof != null) lista.add(prof);
        }catch (Exception e){
            System.out.println("No se pudo cargar el archivo profesores");
        }
        return lista;
    }
}

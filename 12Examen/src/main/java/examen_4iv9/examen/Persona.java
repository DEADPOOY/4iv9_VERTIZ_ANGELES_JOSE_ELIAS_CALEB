/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_4iv9.examen;

/**
 *
 * @author DEADPOOY2
 */
public class Persona {
    //vamos a colocar primero los valores de las personas
    
    private int ID;
    private String nombre;
    private int edad;
    private String genero;
    
    
    public Persona(){}

    public Persona(int ID, int edad, String nombre) {
        this.ID = ID;
        this.edad = edad;
        this.nombre = nombre;
        this.genero = genero;
    }
    
    public int getID(){
    return ID;
    }
    public void setID(int ID){
    this.ID = ID;
    }
    
    public String getnombre(){
    return nombre;
    }
    public void setnombre(String nombre){
    this.nombre = nombre;
    }
    
    public int getedad(){
    return edad;
    }
    public void setedad(int edad){
    this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString() {
        return ID + "," + nombre + "," + edad;
    }
    //ya quedo para los valores lit todo lo hace
    //el ide no manches examen papa por el momento
}


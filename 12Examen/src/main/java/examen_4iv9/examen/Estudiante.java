/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_4iv9.examen;

/**
 *
 * @author DEADPOOY2
 */
public class Estudiante extends Persona {
    //vamos a gaurdar valores dentro de otros pa la localizacion
    //por ejemplo
    private int boleta;
    private String carrera;

    public Estudiante(int boleta, String carrera) {
        this.boleta = boleta;
        this.carrera = carrera;
    }

    public Estudiante(int boleta, String carrera, int ID, int edad, String nombre) {
        super(ID, edad, nombre);
        this.boleta = boleta;
        this.carrera = carrera;
    }

    public int getBoleta() {
        return boleta;
    }

    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}

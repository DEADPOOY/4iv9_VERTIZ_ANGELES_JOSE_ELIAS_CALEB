/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_4iv9.examen;

/**
 *
 * @author DEADPOOY2
 */
public class Profesor extends Persona{
    //los valores para profe
    private String materiaDada;
    private double salario;
    
    public Profesor(){}

    public Profesor(String materiaDada, double salario) {
        this.materiaDada = materiaDada;
        this.salario = salario;
    }

    public Profesor(String materiaDada, double salario, int ID, int edad, String nombre) {
        super(ID, edad, nombre);
        this.materiaDada = materiaDada;
        this.salario = salario;
    }

    public String getMateriaDada() {
        return materiaDada;
    }

    public void setMateriaDada(String materiaDada) {
        this.materiaDada = materiaDada;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    @Override
    public String toString() {
        return super.toString() + "," + materiaDada + "," + salario;
    }
}

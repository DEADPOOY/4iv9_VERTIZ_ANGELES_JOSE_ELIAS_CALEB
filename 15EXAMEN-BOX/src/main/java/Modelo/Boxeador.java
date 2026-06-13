/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author deadpooy
 */

public class Boxeador {
    
    private int id;
    private String nombre;
    private int edad;
    private double peso;          
    private String categoria;      
    private String nacionalidad;
    private int peleasGanadas;
    private int peleasPerdidas;
    private int peleasEmpatadas;
    private String gimnasio;
    private String manoDominante;
    
    public Boxeador(){
        this.id = 0;
        this.nombre = "";
        this.edad = 0;
        this.peso = 0.0;
        this.categoria = "";
        this.nacionalidad = "";
        this.peleasGanadas = 0;
        this.peleasPerdidas = 0;
        this.peleasEmpatadas = 0;
        this.gimnasio = "";
        this.manoDominante = "Diestro";
    }

    public Boxeador(int id, String nombre, int edad, double peso, String categoria,
                    String nacionalidad, int ganadas, int perdidas, int empatadas,
                    String gimnasio, String manoDominante) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.categoria = categoria;
        this.nacionalidad = nacionalidad;
        this.peleasGanadas = ganadas;
        this.peleasPerdidas = perdidas;
        this.peleasEmpatadas = empatadas;
        this.gimnasio = gimnasio;
        this.manoDominante = manoDominante;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { if(edad > 0) this.edad = edad; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { if(peso > 0) this.peso = peso; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getPeleasGanadas() { return peleasGanadas; }
    public void setPeleasGanadas(int ganadas) { this.peleasGanadas = ganadas; }

    public int getPeleasPerdidas() { return peleasPerdidas; }
    public void setPeleasPerdidas(int perdidas) { this.peleasPerdidas = perdidas; }

    public int getPeleasEmpatadas() { return peleasEmpatadas; }
    public void setPeleasEmpatadas(int empatadas) { this.peleasEmpatadas = empatadas; }

    public String getGimnasio() { return gimnasio; }
    public void setGimnasio(String gimnasio) { this.gimnasio = gimnasio; }

    public String getManoDominante() { return manoDominante; }
    public void setManoDominante(String manoDominante) { this.manoDominante = manoDominante; }

    public String mostrarDetalle(){
        return String.format("ID: %d | %s | %d años | %.1f kg | %s | %s | Récord: %d-%d-%d | Gimnasio: %s | %s",
                id, nombre, edad, peso, categoria, nacionalidad, peleasGanadas, peleasPerdidas, peleasEmpatadas, gimnasio, manoDominante);
    }

    @Override
    public String toString(){
        return mostrarDetalle();
    }
}
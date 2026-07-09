/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudarchivo;

public class Persona {

    private String documento;
    private String nombre;
    private int edad;
    private String telefono;

    public Persona(String documento, String nombre, int edad, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String convertirLinea() {
        return documento + ";" + nombre + ";" + edad + ";" + telefono;
    }

}
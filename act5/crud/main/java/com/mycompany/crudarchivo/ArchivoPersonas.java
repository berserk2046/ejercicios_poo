/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudarchivo;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ArchivoPersonas {

    private final String nombreArchivo;

    public ArchivoPersonas() {

        nombreArchivo = "personas.txt";

    }

    public boolean crear(Persona persona) {

        try {

            File archivo = new File(nombreArchivo);

            if (!archivo.exists()) {

                archivo.createNewFile();

            }

            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));

            escritor.write(persona.convertirLinea());

            escritor.newLine();

            escritor.close();

            return true;

        } catch (IOException e) {

            return false;

        }

    }
    public String leerArchivo() {

    String texto = "";

    try {

        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));

        String linea;

        while ((linea = lector.readLine()) != null) {

             String[] datos = linea.split(";");

            if (datos.length == 4) {

                texto += "Documento: " + datos[0] + "\n";
                texto += "Nombre: " + datos[1] + "\n";
                texto += "Edad: " + datos[2] + "\n";
                texto += "Telefono: " + datos[3] + "\n";
                texto += "-------------------------\n";

            }


        }

        lector.close();

    } catch (IOException e) {

        texto = "Error al leer el archivo.";

    }

    return texto;

    }
    public Persona buscarPorCedula(String cedula) {

        try {

            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(";");

                if (datos.length == 4 && datos[0].trim().equals(cedula.trim())) {

                    lector.close();

                    return new Persona(
                            datos[0],
                            datos[1],
                            Integer.parseInt(datos[2]),
                            datos[3]);

                }

            }

            lector.close();

        } catch (IOException | NumberFormatException e) {

            return null;

        }

        return null;

    }

    public boolean actualizarPorCedula(String cedula, Persona personaActualizada) {

        ArrayList<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try {

            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(";");

                if (datos.length == 4 && datos[0].trim().equals(cedula.trim())) {

                    lineas.add(personaActualizada.convertirLinea());
                    encontrado = true;

                } else {

                    lineas.add(linea);

                }

            }

            lector.close();

            if (!encontrado) {

                return false;

            }

            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, false));

            for (String nuevaLinea : lineas) {

                escritor.write(nuevaLinea);
                escritor.newLine();

            }

            escritor.close();

            return true;

        } catch (IOException e) {

            return false;

        }

    }
	public boolean eliminarPorCedula(String cedula) {
        ArrayList<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length == 4 && datos[0].trim().equals(cedula.trim())) {
                    encontrado = true;
                } else {
                    lineas.add(linea);
                }
            }
            lector.close();

            if (!encontrado) {
                return false;
            }

            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, false));
            for (String lineaMantener : lineas) {
                escritor.write(lineaMantener);
                escritor.newLine();
            }
            escritor.close();

            return true;

        } catch (IOException e) {
            return false;
        }
    }


}

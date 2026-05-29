package Notas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviación, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal(){
        inicio();
        setTitle("Notas"); 
        setSize(280, 390); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 

        // Nota 1
        nota1 = new JLabel("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);

        // Nota 2
        nota2 = new JLabel("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);

        // Nota 3
        nota3 = new JLabel("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);

        // Nota 4 (RECONSTRUIDO COMPLETAMENTE)
        nota4 = new JLabel("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);

        // Nota 5
        nota5 = new JLabel("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);

        // Botón Calcular
        calcular = new JButton("Calcular");
        calcular.setBounds(20, 170, 100, 23); 
        calcular.addActionListener(this);

        // Botón Limpiar
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(125, 170, 80, 23); 
        limpiar.addActionListener(this);

        // Etiquetas de Resultados
        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 210, 135, 23); 

        desviación = new JLabel("Desviación = ");
        desviación.setBounds(20, 240, 200, 23); 

        mayor = new JLabel("Nota mayor = ");
        mayor.setBounds(20, 270, 120, 23); 

        menor = new JLabel("Nota menor = ");
        menor.setBounds(20, 300, 120, 23); 

        // Adición de componentes al contenedor
        contenedor.add(nota1); contenedor.add(campoNota1);
        contenedor.add(nota2); contenedor.add(campoNota2);
        contenedor.add(nota3); contenedor.add(campoNota3);
        contenedor.add(nota4); contenedor.add(campoNota4);
        contenedor.add(nota5); contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviación);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { 
            JTextField[] campos = {campoNota1, campoNota2, campoNota3, campoNota4, campoNota5};
            
            for (int i = 0; i < campos.length; i++) {
                if (campos[i].getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "La Nota " + (i + 1) + " no ha sido ingresada.\nEs obligatorio rellenar las cinco notas.", 
                        "Alerta: Campo Faltante", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            Notas notas = new Notas(); 

            try {
                notas.listaNotas[0] = Double.parseDouble(campoNota1.getText().trim());
                notas.listaNotas[1] = Double.parseDouble(campoNota2.getText().trim());
                notas.listaNotas[2] = Double.parseDouble(campoNota3.getText().trim());
                notas.listaNotas[3] = Double.parseDouble(campoNota4.getText().trim());
                notas.listaNotas[4] = Double.parseDouble(campoNota5.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error: Uno o más datos ingresados no son numéricos.\nPor favor, use solo números (Ej: 4.5).", 
                    "Alerta: Formato No Válido", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            promedio.setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
            desviación.setText("Desviación estándar = " + String.format("%.2f", notas.calcularDesviación()));
            mayor.setText("Nota mayor = " + String.format("%.2f", notas.calcularMayor()));
            menor.setText("Nota menor = " + String.format("%.2f", notas.calcularMenor()));
        }

        if (evento.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio = ");
            desviación.setText("Desviación = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");
        }
    }
}

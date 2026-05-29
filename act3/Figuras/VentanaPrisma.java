package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lblBase, lblAncho, lblAltura, lblVolumen, lblSuperficie, lblImagen;
    private JTextField txtBase, txtAncho, txtAltura;
    private JButton btnCalcular;

    public VentanaPrisma() {
        setTitle("Prisma Rectangular");
        setSize(480, 270);
        setLocationRelativeTo(null);
        setResizable(false);
        initGUI();
    }

    private void initGUI() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lblBase = new JLabel("Largo Base (cms):");
        lblBase.setBounds(20, 20, 110, 23);
        contenedor.add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(140, 20, 70, 23);
        contenedor.add(txtBase);

        lblAncho = new JLabel("Ancho Base (cms):");
        lblAncho.setBounds(20, 50, 110, 23);
        contenedor.add(lblAncho);

        txtAncho = new JTextField();
        txtAncho.setBounds(140, 50, 70, 23);
        contenedor.add(txtAncho);

        lblAltura = new JLabel("Altura (cms):");
        lblAltura.setBounds(20, 80, 110, 23);
        contenedor.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(140, 80, 70, 23);
        contenedor.add(txtAltura);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 115, 190, 25);
        btnCalcular.addActionListener(this);
        contenedor.add(btnCalcular);

        lblVolumen = new JLabel("Volumen: ");
        lblVolumen.setBounds(20, 160, 200, 23);
        contenedor.add(lblVolumen);

        lblSuperficie = new JLabel("Superficie: ");
        lblSuperficie.setBounds(20, 190, 200, 23);
        contenedor.add(lblSuperficie);

        // Image Setup with Scaling
        lblImagen = new JLabel();
        lblImagen.setBounds(250, 20, 180, 140);
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        ImageIcon iconoOriginal = new ImageIcon("Figuras/images/prisma.png");
        if (iconoOriginal.getImageLoadStatus() == MediaTracker.COMPLETE || new java.io.File("Figuras/images/prisma.png").exists()) {
            Image imgEscalada = iconoOriginal.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(imgEscalada));
        }
        contenedor.add(lblImagen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                double largo = Double.parseDouble(txtBase.getText());
                double ancho = Double.parseDouble(txtAncho.getText());
                double altura = Double.parseDouble(txtAltura.getText());
                
                double volumen = largo * ancho * altura;
                double superficie = 2 * ((largo * ancho) + (largo * altura) + (ancho * altura));
                
                lblVolumen.setText(String.format("Volumen: %.2f cm³", volumen));
                lblSuperficie.setText(String.format("Superficie: %.2f cm²", superficie));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

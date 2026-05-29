package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lblLado, lblVolumen, lblSuperficie, lblImagen;
    private JTextField txtLado;
    private JButton btnCalcular;

    public VentanaCubo() {
        setTitle("Cubo");
        setSize(480, 270);
        setLocationRelativeTo(null);
        setResizable(false);
        initGUI();
    }

    private void initGUI() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lblLado = new JLabel("Lado (cms):");
        lblLado.setBounds(20, 20, 100, 23);
        contenedor.add(lblLado);

        txtLado = new JTextField();
        txtLado.setBounds(130, 20, 80, 23);
        contenedor.add(txtLado);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 60, 190, 25);
        btnCalcular.addActionListener(this);
        contenedor.add(btnCalcular);

        lblVolumen = new JLabel("Volumen: ");
        lblVolumen.setBounds(20, 120, 200, 23);
        contenedor.add(lblVolumen);

        lblSuperficie = new JLabel("Superficie: ");
        lblSuperficie.setBounds(20, 150, 200, 23);
        contenedor.add(lblSuperficie);

        // Image Setup with Scaling
        lblImagen = new JLabel();
        lblImagen.setBounds(250, 20, 180, 140);
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        ImageIcon iconoOriginal = new ImageIcon("Figuras/images/cubo.png");
        if (iconoOriginal.getImageLoadStatus() == MediaTracker.COMPLETE || new java.io.File("Figuras/images/cubo.png").exists()) {
            Image imgEscalada = iconoOriginal.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(imgEscalada));
        }
        contenedor.add(lblImagen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                double lado = Double.parseDouble(txtLado.getText());
                
                double volumen = Math.pow(lado, 3);
                double superficie = 6 * Math.pow(lado, 2);
                
                lblVolumen.setText(String.format("Volumen: %.2f cm³", volumen));
                lblSuperficie.setText(String.format("Superficie: %.2f cm²", superficie));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

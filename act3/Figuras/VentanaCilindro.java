package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lblRadio, lblAltura, lblVolumen, lblSuperficie, lblImagen;
    private JTextField txtRadio, txtAltura;
    private JButton btnCalcular;

    public VentanaCilindro() {
        setTitle("Cilindro");
        setSize(480, 270);
        setLocationRelativeTo(null);
        setResizable(false);
        initGUI();
    }

    private void initGUI() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lblRadio = new JLabel("Radio (cms):");
        lblRadio.setBounds(20, 20, 100, 23);
        contenedor.add(lblRadio);

        txtRadio = new JTextField();
        txtRadio.setBounds(130, 20, 80, 23);
        contenedor.add(txtRadio);

        lblAltura = new JLabel("Altura (cms):");
        lblAltura.setBounds(20, 60, 100, 23);
        contenedor.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(130, 60, 80, 23);
        contenedor.add(txtAltura);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 100, 190, 25);
        btnCalcular.addActionListener(this);
        contenedor.add(btnCalcular);

        lblVolumen = new JLabel("Volumen: ");
        lblVolumen.setBounds(20, 150, 200, 23);
        contenedor.add(lblVolumen);

        lblSuperficie = new JLabel("Superficie: ");
        lblSuperficie.setBounds(20, 180, 200, 23);
        contenedor.add(lblSuperficie);

        // Image Setup with Scaling
        lblImagen = new JLabel();
        lblImagen.setBounds(250, 20, 180, 140);
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        ImageIcon iconoOriginal = new ImageIcon("Figuras/images/cilindro.png");
        if (iconoOriginal.getImageLoadStatus() == MediaTracker.COMPLETE || new java.io.File("Figuras/images/cilindro.png").exists()) {
            Image imgEscalada = iconoOriginal.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(imgEscalada));
        }
        contenedor.add(lblImagen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                double radio = Double.parseDouble(txtRadio.getText());
                double altura = Double.parseDouble(txtAltura.getText());
                
                double volumen = Math.PI * Math.pow(radio, 2) * altura;
                double superficie = 2 * Math.PI * radio * (radio + altura);
                
                lblVolumen.setText(String.format("Volumen: %.2f cm³", volumen));
                lblSuperficie.setText(String.format("Superficie: %.2f cm²", superficie));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lblBase, lblAltura, lblApotema, lblVolumen, lblSuperficie, lblImagen;
    private JTextField txtBase, txtAltura, txtApotema;
    private JButton btnCalcular;

    public VentanaPiramide() {
        setTitle("Pirámide");
        setSize(480, 270);
        setLocationRelativeTo(null);
        setResizable(false);
        initGUI();
    }

    private void initGUI() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lblBase = new JLabel("Lado Base (cms):");
        lblBase.setBounds(20, 20, 110, 23);
        contenedor.add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(140, 20, 70, 23);
        contenedor.add(txtBase);

        lblAltura = new JLabel("Altura (cms):");
        lblAltura.setBounds(20, 50, 110, 23);
        contenedor.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(140, 50, 70, 23);
        contenedor.add(txtAltura);

        lblApotema = new JLabel("Apotema (cms):");
        lblApotema.setBounds(20, 80, 110, 23);
        contenedor.add(lblApotema);

        txtApotema = new JTextField();
        txtApotema.setBounds(140, 80, 70, 23);
        contenedor.add(txtApotema);

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
        
        ImageIcon iconoOriginal = new ImageIcon("Figuras/images/piramide.png");
        if (iconoOriginal.getImageLoadStatus() == MediaTracker.COMPLETE || new java.io.File("Figuras/images/piramide.png").exists()) {
            Image imgEscalada = iconoOriginal.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(imgEscalada));
        }
        contenedor.add(lblImagen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                double base = Double.parseDouble(txtBase.getText());
                double altura = Double.parseDouble(txtAltura.getText());
                double apotema = Double.parseDouble(txtApotema.getText());
                
                double areaBase = Math.pow(base, 2);
                double volumen = (areaBase * altura) / 3.0;
                double superficie = areaBase + (2 * base * apotema);
                
                lblVolumen.setText(String.format("Volumen: %.2f cm³", volumen));
                lblSuperficie.setText(String.format("Superficie: %.2f cm²", superficie));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

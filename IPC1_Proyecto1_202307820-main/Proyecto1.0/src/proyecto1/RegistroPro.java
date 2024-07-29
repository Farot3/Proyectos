

package proyecto1;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroPro extends JFrame implements ActionListener{

    private JTextField NameFIeld;
    private JTextField PrecioFIeld;
    private JTextField DescripField;
    private JTextField CantidadpField;
    

    private JButton registerButtonPro;
    
    
    public RegistroPro(){
        
        JLabel titleLabel = new JLabel("Registro de Productos");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 300, 30);
        this.add(titleLabel);
        
        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(70, 50, 80, 25);
        this.add(firstNameLabel);

        NameFIeld = new JTextField();
        NameFIeld.setBounds(150, 50, 260, 25);
        this.add(NameFIeld);

        JLabel PrecioLabel = new JLabel("Precio:");
        PrecioLabel.setBounds(70, 90, 80, 25);
        this.add(PrecioLabel);

        PrecioFIeld= new JTextField();
        PrecioFIeld.setBounds(150, 90, 260, 25);
        this.add(PrecioFIeld);
        
        JLabel DescripciónLabel = new JLabel("Descripción:");
        DescripciónLabel.setBounds(70, 130, 80, 25);
        this.add(DescripciónLabel);

        DescripField = new JTextField();
        DescripField.setBounds(150, 130, 260, 75);
        this.add(DescripField);
        
        JLabel CantidadLabel = new JLabel("Cantidad:");
        CantidadLabel.setBounds(70, 220, 80, 25);
        this.add(CantidadLabel);

        CantidadpField = new JTextField();
        CantidadpField.setBounds(150, 220, 260, 25);
        this.add(CantidadpField);

        registerButtonPro = new JButton("Registrar Producto");
        registerButtonPro.setBounds(180, 260, 150, 25);
        registerButtonPro.setForeground(Color.WHITE);
        registerButtonPro.setBackground(new Color(214, 225, 50));
        registerButtonPro.addActionListener(this);
        this.add(registerButtonPro);
        
        
        this.setTitle("Registro de Productos");
        this.setBounds(650, 400, 600, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Registrar Producto")) {
        String Name = NameFIeld.getText();
        int PRecio = Integer.parseInt(PrecioFIeld.getText());
        String descrip = DescripField.getText();
        int Cantidad = Integer.parseInt(CantidadpField.getText());
        
        Proyecto1.Agregar_Productos(Proyecto1.códigos, Name, PRecio, descrip, Cantidad);
            Proyecto1.códigos++;
            this.dispose();
            JOptionPane.showMessageDialog(this, "Se ha registrado el producto con exito");
            
            VentanaAdmin vtnl_admin = new VentanaAdmin();
        
    }
    
    }
    
}
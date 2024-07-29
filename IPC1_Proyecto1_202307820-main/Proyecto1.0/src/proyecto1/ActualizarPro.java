

package proyecto1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ActualizarPro extends JFrame implements ActionListener{
    private Producto Productos;
    
    private JTextField NameFIeld;
    private JTextField PrecioFIeld;
    private JTextField DescripField;
    private JTextField CantidadpField;
    

    private JButton btn_confirmarPro;
        
    
    public ActualizarPro(Producto Productos1){
        this.Productos = Productos1;
        
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
        DescripField.setBounds(150, 130, 260, 25);
        this.add(DescripField);
        
        JLabel CantidadLabel = new JLabel("Cantidad:");
        CantidadLabel.setBounds(70, 170, 80, 25);
        this.add(CantidadLabel);

        CantidadpField = new JTextField();
        CantidadpField.setBounds(150, 170, 260, 25);
        this.add(CantidadpField);

        btn_confirmarPro = new JButton("Confirmar Producto");
        btn_confirmarPro.setBounds(180, 240, 150, 25);
        btn_confirmarPro.setForeground(Color.WHITE);
        btn_confirmarPro.setBackground(new Color(214, 225, 50));
        btn_confirmarPro.addActionListener(this);
        this.add(btn_confirmarPro);
        
        NameFIeld.setText(Productos1.getNombre());
        PrecioFIeld.setText(String.valueOf(Productos1.getPrecio()));
        DescripField.setText(Productos1.getDescripción());
        CantidadpField.setText(String.valueOf(Productos1.getCantidad()));
                      
        
        
        btn_confirmarPro.setEnabled(false);  
        
        this.setTitle("Actualizar Productos");
        this.setBounds(650, 400, 600, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }
        };
        
        // Agrega el DocumentListener a todos los campos de texto
        NameFIeld.getDocument().addDocumentListener(documentListener);
        PrecioFIeld.getDocument().addDocumentListener(documentListener);
        DescripField.getDocument().addDocumentListener(documentListener);  
        CantidadpField.getDocument().addDocumentListener(documentListener);
        
    }
    
    
    private void checkFields() {
        // Verifica si todas las casillas están llenas
        boolean allFieldsFilled = !NameFIeld.getText().isEmpty() &&
                                  !PrecioFIeld.getText().isEmpty() &&
                                  !DescripField.getText().isEmpty() &&                                 
                                  !CantidadpField.getText().isEmpty();
        
        // Habilita o deshabilita el botón de registro según el estado de las casillas
        btn_confirmarPro.setEnabled(allFieldsFilled);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirmar Producto")) {
        String Name = NameFIeld.getText();
        int PRecio = Integer.parseInt(PrecioFIeld.getText());
        String descrip = DescripField.getText();
        int Cantidad = Integer.parseInt(CantidadpField.getText());
        
        Productos.setNombre(Name);
        Productos.setPrecio(PRecio);
        Productos.setDescripción(descrip);
        Productos.setCantidad(Cantidad);
        
        VentanaAdmin vtnt_admin = new VentanaAdmin();
    
        }
    }
    
}
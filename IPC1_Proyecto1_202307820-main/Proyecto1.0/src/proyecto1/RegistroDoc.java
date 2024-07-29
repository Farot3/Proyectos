
package proyecto1;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegistroDoc extends JFrame implements ActionListener{
    private JTextField firstNameCompletField;
    private JComboBox<String> genderComboBox;
    private JTextField edadField;
    private JTextField EspecialField;
    private JTextField TelField;
private JPasswordField Pasworrdpac;

    private JButton registerButtonD;

    public RegistroDoc() {
        JLabel titleLabel = new JLabel("Registro Doctor");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 150, 30);
        this.add(titleLabel);

        JLabel firstNameLabel = new JLabel("Nombre Completo:");
        firstNameLabel.setBounds(70, 50, 150, 25);
        this.add(firstNameLabel);

        firstNameCompletField = new JTextField();
        firstNameCompletField.setBounds(180, 50, 260, 25);
        this.add(firstNameCompletField);
        
        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(70, 90, 80, 25);
        this.add(genderLabel);

        String[] genders = {"Selecione la opción","M", "F"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(180, 90, 150, 25);
        this.add(genderComboBox);
        
        JLabel notaLabel = new JLabel("Edad:");
        notaLabel.setBounds(70, 130, 80, 25);
        this.add(notaLabel);

        edadField = new JTextField();
        edadField.setBounds(180, 130, 260, 25);
        this.add(edadField);

        JLabel lastNameLabel = new JLabel("Especialidad:");
        lastNameLabel.setBounds(70, 170, 80, 25);
        this.add(lastNameLabel);

        EspecialField = new JTextField();
        EspecialField.setBounds(180, 170, 260, 25);
        this.add(EspecialField);

        JLabel emailLabel = new JLabel("Teléfono:");
        emailLabel.setBounds(70, 200, 80, 25);
        this.add(emailLabel);

        TelField = new JTextField();
        TelField.setBounds(180, 200, 260, 25);
        this.add(TelField);
        
        JLabel Passwordlabel = new JLabel("Password:");
        Passwordlabel.setBounds(70, 230, 80, 25);
        this.add(Passwordlabel);

        Pasworrdpac = new JPasswordField();
        Pasworrdpac.setBounds(180, 230, 280, 25);
        this.add(Pasworrdpac);



        registerButtonD = new JButton("Registro Doctor");
        registerButtonD.setBounds(180, 270, 180, 25);
        registerButtonD.setForeground(Color.WHITE);
        registerButtonD.setBackground(new Color(214, 225, 50));
        registerButtonD.addActionListener(this);
        this.add(registerButtonD);
        
        
        this.setTitle("Registro de Doctor");
        this.setBounds(650, 400, 600, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
         registerButtonD.setEnabled(false);
         
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
        firstNameCompletField.getDocument().addDocumentListener(documentListener);
        edadField.getDocument().addDocumentListener(documentListener);
        EspecialField.getDocument().addDocumentListener(documentListener);  
        Pasworrdpac.getDocument().addDocumentListener(documentListener);
        
    }

         // Agrega un DocumentListener para monitorear los cambios en los campos de texto
        
    
        
        
    
    
     private void checkFields() {
        // Verifica si todas las casillas están llenas
        boolean allFieldsFilled = !firstNameCompletField.getText().isEmpty() &&
                                  !edadField.getText().isEmpty() &&
                                  !EspecialField.getText().isEmpty() &&                                 
                                  !Pasworrdpac.getText().isEmpty();
        
        // Habilita o deshabilita el botón de registro según el estado de las casillas
        registerButtonD.setEnabled(allFieldsFilled);
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registro Doctor")) {
            String NameComplet = firstNameCompletField.getText();
            String selectedGender = (String) genderComboBox.getSelectedItem();
            int Edad = Integer.parseInt(edadField.getText());
            String Especialidad = EspecialField.getText();
            String Teléfono = TelField.getText();
            
            String Password = Pasworrdpac.getText();
          
            Proyecto1.Agregar_Doctores(Proyecto1.codigo, NameComplet, selectedGender, Edad, Especialidad, Teléfono, Password);

            
            JOptionPane.showMessageDialog(this, "Su código de Inicio de sesión es:  " + Proyecto1.codigo + "\n Se ha registrado con exito");
            Proyecto1.codigo++;
            this.dispose();
            
        Login vtn_admin= new Login();
    }
    
    
    
}
}
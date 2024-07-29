

package proyecto1;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class RegistroPac extends JFrame implements ActionListener{
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField EdadField;
    private JComboBox<String> genderComboBox;
    private JPasswordField Pasworrdpac;

    private JButton registerButtonP;

    public RegistroPac() {
        
        JLabel titleLabel = new JLabel("Registro de Paciente");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 300, 30);
        this.add(titleLabel);

        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(70, 50, 80, 25);
        this.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(140, 50, 280, 25);
        this.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(70, 90, 80, 25);
        this.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(140, 90, 280, 25);
        this.add(lastNameField);
        
        JLabel Passwordlabel = new JLabel("Password:");
        Passwordlabel.setBounds(70, 130, 80, 25);
        this.add(Passwordlabel);

        Pasworrdpac = new JPasswordField();
        Pasworrdpac.setBounds(140, 130, 280, 25);
        this.add(Pasworrdpac);

        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(80, 170, 80, 25);
        this.add(genderLabel);

        String[] genders = {"Selecciones la opción","Masculino", "Femenino"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(140, 170, 170, 25);
        this.add(genderComboBox);
        
        JLabel notaLabel = new JLabel("Edad:");
        notaLabel.setBounds(80, 210, 80, 25);
        this.add(notaLabel);

        EdadField = new JTextField();
        EdadField.setBounds(140, 210, 280, 25);
        this.add(EdadField);


        registerButtonP = new JButton("Registrarse");
        registerButtonP.setBounds(180, 270, 150, 25);
        registerButtonP.setForeground(Color.WHITE);
        registerButtonP.setBackground(new Color(214, 225, 50));
        registerButtonP.addActionListener(this);
        this.add(registerButtonP);
        
        registerButtonP.setEnabled(false);
        
        this.setTitle("Registro Paciente");
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
        firstNameField.getDocument().addDocumentListener(documentListener);
        EdadField.getDocument().addDocumentListener(documentListener);
        lastNameField.getDocument().addDocumentListener(documentListener);  
        Pasworrdpac.getDocument().addDocumentListener(documentListener);
        
        
        
        
    }
    
    private void checkFields() {
        // Verifica si todas las casillas están llenas
        boolean allFieldsFilled = !firstNameField.getText().isEmpty() &&
                                  !EdadField.getText().isEmpty() &&
                                  !lastNameField.getText().isEmpty() &&                                 
                                  !Pasworrdpac.getText().isEmpty();
        
        // Habilita o deshabilita el botón de registro según el estado de las casillas
        registerButtonP.setEnabled(allFieldsFilled);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("Registrarse")) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String Password = Pasworrdpac.getText();
            int Edad = Integer.parseInt(EdadField.getText());
            String selectedGender = (String) genderComboBox.getSelectedItem();
            
            System.out.println("Nombre: " + firstName);
            System.out.println("Apellido: " + lastName);            
            System.out.println("Edad: " + Edad);
            System.out.println("Género: " + selectedGender);
            
            
            
            Proyecto1.Agregar_Pacientes(Proyecto1.Codigos1, firstName, lastName, Password, Edad, selectedGender);                       
            this.dispose();
            JOptionPane.showMessageDialog(this, "Su código de Inicio de sesión es:  " + Proyecto1.Codigos1 + "?\n Se ha registrado con éxito");
            Proyecto1.Codigos1++;

            Login vtn_admin= new Login();
        
        }
         
         
    }
}
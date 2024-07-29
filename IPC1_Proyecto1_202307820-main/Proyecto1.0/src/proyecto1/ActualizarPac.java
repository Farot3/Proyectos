

package proyecto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ActualizarPac extends JFrame implements ActionListener{
    private Pacientes Paciente;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField EdadField;
    private JComboBox<String> genderComboBox;
    private JPasswordField Pasworrdpac;
    private JButton btnConfirmarP;
    
    public ActualizarPac(Pacientes paciente1){
        
        this.Paciente = paciente1;
              
        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(70, 50, 80, 25);
        this.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(130, 50, 260, 25);
        this.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(70, 90, 80, 25);
        this.add(lastNameLabel);
        
        JLabel Passwordlabel = new JLabel("Password:");
        Passwordlabel.setBounds(70, 210, 80, 25);
        this.add(Passwordlabel);

        Pasworrdpac = new JPasswordField();
        Pasworrdpac.setBounds(130, 210, 280, 25);
        this.add(Pasworrdpac);

        lastNameField = new JTextField();
        lastNameField.setBounds(130, 90, 260, 25);
        this.add(lastNameField);

        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(80, 130, 80, 25);
        this.add(genderLabel);

        String[] genders = {"Masculino", "Femenino"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(130, 130, 150, 25);
        this.add(genderComboBox);
        
        JLabel notaLabel = new JLabel("Edad:");
        notaLabel.setBounds(80, 170, 80, 25);
        this.add(notaLabel);

        EdadField = new JTextField();
        EdadField.setBounds(130, 170, 260, 25);
        this.add(EdadField);

        btnConfirmarP = new JButton("Confirmación");
        btnConfirmarP.setBounds(180, 240, 150, 25);
        btnConfirmarP.setForeground(Color.WHITE);
        btnConfirmarP.setBackground(new Color(214, 225, 50));
        btnConfirmarP.addActionListener(this);
        this.add(btnConfirmarP);
        
        firstNameField.setText(paciente1.getNombres());
        lastNameField.setText(paciente1.getApellidos());
        EdadField.setText(String.valueOf(paciente1.getEdad()));
        genderComboBox.setSelectedItem(paciente1.getGénero());
        Pasworrdpac.setText(paciente1.getPassword());
        
        btnConfirmarP.setEnabled(false);             
        
        this.setTitle("Actualizar Paciente");
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
        btnConfirmarP.setEnabled(allFieldsFilled);
   
    }     
    
    
    /*public void setPaciente(Pacientes paciente) {
        this.Paciente = paciente;
        
        firstNameField.setText(paciente.getNombres());
        lastNameField.setText(paciente.getApellidos());
        EdadField.setText(String.valueOf(paciente.getEdad()));
        genderComboBox.setSelectedItem(paciente.getGénero());
        Pasworrdpac.setText(paciente.getPassword());
    }*/
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirmación")) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            int Edad = Integer.parseInt(EdadField.getText());
            String selectedGender = (String) genderComboBox.getSelectedItem();
            String Password = Pasworrdpac.getText();
       
            
            
            Paciente.setNombres(firstName);
            Paciente.setApellidos(lastName);
            Paciente.setEdad(Edad);
            Paciente.setGénero(selectedGender);
            Paciente.setPassword(Password);
  
            this.dispose();
            
            Login vtnl_admin = new Login();
        
        }         
    }    
}
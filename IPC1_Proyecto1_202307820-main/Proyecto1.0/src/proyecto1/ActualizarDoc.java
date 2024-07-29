
package proyecto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ActualizarDoc extends JFrame implements ActionListener{
    private Doctores Doctor;
    private JTextField firstNameCompletField;
    private JComboBox<String> genderComboBox;
    private JTextField edadField;
    private JTextField EspecialField;
    private JTextField TelField;
    private JButton btnConfirmar;
    private JPasswordField Pasworrdpac;
   

    public ActualizarDoc(Doctores doctor1) {
        this.Doctor = doctor1;
        
        JLabel firstNameLabel = new JLabel("Nombre Completo:");
        firstNameLabel.setBounds(70, 50, 150, 25);
        this.add(firstNameLabel);

        firstNameCompletField = new JTextField();
        firstNameCompletField.setBounds(180, 50, 260, 25);
        this.add(firstNameCompletField);
        
        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(70, 90, 80, 25);
        this.add(genderLabel);

        String[] genders = {"M", "F"};
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
        

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(180, 270, 100, 25);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setBackground(new Color(214, 225, 50));
        btnConfirmar.addActionListener(this);
        this.add(btnConfirmar);       
                
        firstNameCompletField.setText(doctor1.getNombre_Completo());
        genderComboBox.setSelectedItem(doctor1.getGénero());
        edadField.setText( String.valueOf(doctor1.getEdad()));
        EspecialField.setText(doctor1.getEspecialidad());
        TelField.setText(doctor1.getTeléfono());
        Pasworrdpac.setText(doctor1.getPassword());

       btnConfirmar.setEnabled(false);

        
        
        this.setTitle("Actualizador de Datos");
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
        firstNameCompletField.getDocument().addDocumentListener(documentListener);
        edadField.getDocument().addDocumentListener(documentListener);
        EspecialField.getDocument().addDocumentListener(documentListener);  
        Pasworrdpac.getDocument().addDocumentListener(documentListener);
        

    }

    ActualizarDoc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void checkFields() {
        // Verifica si todas las casillas están llenas
        boolean allFieldsFilled = !firstNameCompletField.getText().isEmpty() &&
                                  !edadField.getText().isEmpty() &&
                                  !EspecialField.getText().isEmpty() &&                                 
                                  !Pasworrdpac.getText().isEmpty();
        
        // Habilita o deshabilita el botón de registro según el estado de las casillas
        btnConfirmar.setEnabled(allFieldsFilled);
    }
    
    
    /*public void setDoctor(Doctores doctor) {
        this.Doctor = doctor;
        
        firstNameCompletField.setText(doctor.getNombre_Completo());
        genderComboBox.setSelectedItem(doctor.getGénero());
        edadField.setText( String.valueOf(doctor.getEdad()));
        EspecialField.setText(doctor.getEspecialidad());
        TelField.setText(doctor.getTeléfono());
    }*/


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirmar")) {
            // Aquí puedes obtener los nuevos datos ingresados por el usuario
            String NameComplet = firstNameCompletField.getText();
            String selectedGender = (String) genderComboBox.getSelectedItem();
            int Edad = Integer.parseInt(edadField.getText());
            String Especialidad = EspecialField.getText();
            String Teléfono = TelField.getText();
            String Password = Pasworrdpac.getText();
            
            for(int i = 0; i < Proyecto1.listaDoctores.size(); i++){
            if(Proyecto1.listaDoctores.get(i).getCódigo() == Proyecto1.CódigoDoc){
            
            Doctor.setNombre_Completo(NameComplet);
            Doctor.setGénero(selectedGender);
            Doctor.setEdad(Edad);
            Doctor.setEspecialidad(Especialidad);
            Doctor.setTeléfono(Teléfono);
            Doctor.setPassword(Password);
                    
            
            JOptionPane.showMessageDialog(this, "Los datos del doctor han sido actualizados correctamente.");

            break;
            
            
          }
        }
            Login vtn_admin= new Login();
            vtn_admin.setVisible(true);
            
            this.dispose();

   
        }
    }
}
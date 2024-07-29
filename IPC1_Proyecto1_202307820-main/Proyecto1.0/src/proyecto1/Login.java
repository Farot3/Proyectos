package proyecto1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.HashMap;
import static proyecto1.Proyecto1.listaDoctores;
import static proyecto1.Proyecto1.listaPacientes;


public class Login extends JFrame implements ActionListener{
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    private JButton loginButton, registButton;
    private HashMap<Integer, VentanaDoc> ventanasDoctores;
    private HashMap<Integer, ventanaPaciente> ventanasPacientes;
    
    private boolean ingresoPaciente(String username, String password){
        int j = listaPacientes.size();
        boolean existe = false;
        for (int i = 0; i < j; i++ ){ 
        if(Proyecto1.listaPacientes.get(i).getCodigos()== Integer.parseInt(username) && Proyecto1.listaPacientes.get(i).getPassword().equals(password) ){
            existe = true;
            System.out.print("El usuario ya­ existe");
            
        } else {System.out.print("El usuario no existe");}
    }  
        return existe;
  }
  
  private boolean ingresoDoctor(String username, String password){
      int j = listaDoctores.size();
      boolean existe = false;
        for (int i = 0; i < j; i++ ){
        if(Proyecto1.listaDoctores.get(i).getCódigo()== Integer.parseInt(username) && Proyecto1.listaDoctores.get(i).getPassword().equals(password) ){
            existe = true;
            System.out.print("El usuario ya­ existe");
        }else {System.out.print("El usuario no existe");}
            
    }  
        return existe;
  }
    
    public Login() {
        
        ventanasDoctores = new HashMap<>();
        ventanasPacientes = new HashMap<>();
        
        JLabel titulo = new JLabel("Bienvenido");
        titulo.setFont(new Font("Kristen ITC",  Font.BOLD, 20));
        titulo.setBounds(197, 10, 200, 30);
        this.add(titulo);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/macaco.jpg"));
        Image imageDimension = imageIcon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon adjustarImage = new ImageIcon(imageDimension);
        JLabel imageLabel = new JLabel(adjustarImage);
        imageLabel.setBounds(190, 30, 120, 110);
        this.add(imageLabel);
        
        JLabel usernameLabel = new JLabel("Codigo:");
        usernameLabel.setBounds(70, 140, 80, 25);
        this.add(usernameLabel);
        
        usernameField = new JTextField();
        usernameField.setBounds(130, 140, 260, 25);
        this.add(usernameField);
        
        
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 180, 80, 25);
        this.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 180, 260, 25);
        this.add(passwordField);
        
        loginButton = new JButton("Iniciar Sesion");
        loginButton.setBounds(250, 220, 130, 25);
        loginButton.setForeground(Color.GREEN);
        loginButton.setBackground(new Color(238, 90, 0));
        loginButton.addActionListener(this);
        this.add(loginButton);
        
        registButton = new JButton("Registrate");
        registButton.setBounds(120, 220, 100, 25);
        registButton.setForeground(Color.WHITE);
        registButton.setBackground(new Color(238, 90, 0));
        registButton.addActionListener(this);
        this.add(registButton);
        
        
        this.setTitle("Login");
        this.setBounds(650, 400, 500, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        
    }

      @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Iniciar Sesion")){
            String user = usernameField.getText();
            char[] pass = passwordField.getPassword();
            String pwd = new String(pass);
            
            if (user.equals("202307820") && pwd.equals("Proyecto1IPC1")) {
                VentanaAdmin vtn_Admin = new VentanaAdmin();
                this.dispose();
                } else if (ingresoPaciente(user, pwd)) {
                    Proyecto1.CódigoPac = Integer.parseInt(user);
                   System.out.println("Ha ingresado un Paciente");
                   ventanaPaciente vtn_paciente = ventanasPacientes.get(Proyecto1.CódigoPac);
                   this.dispose();
                if (vtn_paciente == null) {
                    ventanaPaciente ps2 = new ventanaPaciente();
                    
                    ps2.setVisible(true);
                    
                    ventanasPacientes.put(Proyecto1.CódigoPac, vtn_paciente);
                }
                   this.dispose();
                } else if (ingresoDoctor(user, pwd)) {
                    Proyecto1.CódigoDoc = Integer.parseInt(user);
                    VentanaDoc ventanaDoctor = ventanasDoctores.get(Proyecto1.CódigoDoc);
                    if (ventanaDoctor == null) {
        // Si no hay ventana para este doctor, creamos una nueva
                      VentanaDoc1(Proyecto1.CódigoDoc);
                    ventanasDoctores.put(Proyecto1.CódigoDoc, ventanaDoctor);
    }
                    System.out.println("Ha ingresado un Doctor");                 
                    this.dispose();
                } else {
                JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos.", "Error en el inicio de sesión",   JOptionPane.ERROR_MESSAGE);
                }
            
        }
        
        if (e.getSource() == registButton){
            RegistroPac vtn_Admin = new RegistroPac();
            this.dispose();
        }
    }
    
    private void VentanaDoc1(int codigoDoctor){
        VentanaDoc Pest2 = new VentanaDoc(codigoDoctor);
        Pest2.setVisible(true);
        
    }

}
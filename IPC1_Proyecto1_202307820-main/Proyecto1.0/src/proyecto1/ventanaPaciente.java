package proyecto1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;


public class ventanaPaciente extends JFrame implements ActionListener {
    
    private JTextField cuadro1;

    JButton btnGeneradorCIta, BTNMostrarDoctor, BTNMostrarHorario, BTNEditarPerfil;
    JTextField  motivoField;
    JPanel pest1;
    JPanel pest3;
    JTabbedPane tabbedPane;
    JComboBox<String> especialidadComboBox, fechaComboBox, horaComboBox;
    JComboBox<String> doctorComboBox;
    String[] doctor = new String[Proyecto1.listaDoctores.size()];
    ArrayList<String> doctores = new ArrayList<>();
    ArrayList<String> especialidadesUnicas = new ArrayList<>();
    ArrayList<String> fechas = new ArrayList<>();
    ArrayList<String> horas = new ArrayList<>();
    
    
    JTable table_Doctor;
    
   
    
    private void evaluar(){
        doctores.clear();
        pest1.remove(doctorComboBox);
        for (int i = 0; i < Proyecto1.listaDoctores.size(); i++) {
        String doctorEnLista = Proyecto1.listaDoctores.get(i).getNombre_Completo();

        if (Proyecto1.listaDoctores.get(i).getEspecialidad().equals((String) especialidadComboBox.getSelectedItem())) {
            if (!doctores.contains(doctorEnLista)) {
                doctores.add(doctorEnLista);
                doctor = doctores.toArray(new String[0]);
            }
        }
    }       
        doctorComboBox = new JComboBox<>(doctor);
        doctorComboBox.setBounds(130, 190, 175, 25);
        pest1.add(doctorComboBox);
    }
    
    
    
    public ventanaPaciente() {
        

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            
        pest1 = new JPanel(null); 
        JPanel pest2 = new JPanel(null);
        pest3 = new JPanel(null);
       
        tabbedPane.addTab("Solicitar cita", pest1);
        tabbedPane.addTab("Ver Estado Cita", pest2);
        tabbedPane.addTab("Farmacia", pest3);
        
        BTNEditarPerfil = new JButton("Editar perfil");
        BTNEditarPerfil.setBounds(1100,30,180,50);
        BTNEditarPerfil.setVisible(true);
        BTNEditarPerfil.setEnabled(true);
        BTNEditarPerfil.addActionListener(this);
        this.add(BTNEditarPerfil);
        
        
        
        JLabel especialidadLabel = new JLabel("Especialidad");
        especialidadLabel.setBounds(70, 150, 80, 25);
        pest1.add(especialidadLabel);
        
        
        
        int n = Proyecto1.listaDoctores.size();
        

        for(int i = 0; i < n; i++) {
        String especialidadActual = Proyecto1.listaDoctores.get(i).getEspecialidad();

        if(!especialidadesUnicas.contains(especialidadActual)) {
        especialidadesUnicas.add(especialidadActual);
        }
        }
        String[] especialidad = especialidadesUnicas.toArray(new String[0]);
        especialidadComboBox = new JComboBox<>(especialidad);
        especialidadComboBox.setBounds(150, 150, 175, 25);
        pest1.add(especialidadComboBox);

        
        JLabel doctorLabel = new JLabel("Doctor");
        doctorLabel.setBounds(70, 190, 80, 25);
        pest1.add(doctorLabel);
        
        JLabel Proo = new JLabel("Mira nuestros productos y visita nuestra farmacia para comprarlos");
        Proo.setBounds(350, 25, 750, 50);
        Proo.setOpaque(true);
        Proo.setVerticalAlignment(SwingConstants.CENTER);
        Proo.setFont(new Font(Proo.getFont().getFontName(), Font.BOLD, 20));
        Proo.setVisible(true);
        pest3.add(Proo);
        
        doctor = doctores.toArray(new String[0]);
        doctorComboBox = new JComboBox<>(doctor);
        doctorComboBox.setBounds(160, 190, 175, 25);
        pest1.add(doctorComboBox);
        evaluar();
        
        btnGeneradorCIta = new JButton("Generar cita");
        btnGeneradorCIta.setBounds(500,300,180,50);
        btnGeneradorCIta.setVisible(true);
        btnGeneradorCIta.setEnabled(true);
        btnGeneradorCIta.addActionListener(this);
        pest1.add(btnGeneradorCIta);
        
        BTNMostrarDoctor = new JButton("Mostrar doctor");
        BTNMostrarDoctor.setBounds(335,150,180,25);
        BTNMostrarDoctor.setVisible(true);
        BTNMostrarDoctor.addActionListener(this);
        pest1.add(BTNMostrarDoctor);
        
        BTNMostrarHorario = new JButton("Mostrar horario");
        BTNMostrarHorario.setBounds(335,190,180,25);
        BTNMostrarHorario.setVisible(true);
        BTNMostrarHorario.addActionListener(this);
        pest1.add(BTNMostrarHorario);
        
         JLabel motivoLabel = new JLabel("Motivo");
        motivoLabel.setBounds(70, 50, 50, 25);
        pest1.add(motivoLabel);
        
        motivoField = new JTextField();
        motivoField.setBounds(130, 50, 500, 90);
        pest1.add(motivoField);
        
         JLabel horarioLabel = new JLabel("Horarios");
        horarioLabel.setBounds(140, 230, 80, 20);
        pest1.add(horarioLabel);
                
         //JLabel FechaLabel = new JLabel("Fecha");
       // especialidadLabel.setBounds(70, 150, 80, 25);
       // pest1.add(especialidadLabel);
       
       


        String[] horario = {"2024/03/7", "2024-03-08", "2024-03-09", "2024-03-10"};
        fechaComboBox = new JComboBox<>(horario);
        fechaComboBox.setBounds(150, 260, 175, 25);
        pest1.add(fechaComboBox);
        


        for(int i = 0; i < Proyecto1.listaDocHora.size(); i++) {
        String horario2 = Proyecto1.listaDocHora.get(i).getHorario();

        if(!horas.contains(horario2)) {
        horas.add(horario2);
        }
        }
        String[] horario2 = horas.toArray(new String[0]);
        horaComboBox = new JComboBox<>(horario2);
        horaComboBox.setBounds(390, 260, 175, 25);
        pest1.add(horaComboBox);
                
        
        
        
        //Pestaña 2
      
        String[] columnNames2 = {"No.", "Estado", "Fecha", "Hora"}; 
        
        
        
        JLabel lbl5 = new JLabel("Horario de citas");
        lbl5.setBounds(25, 25, 750, 50);
        lbl5.setOpaque(true);
        lbl5.setVerticalAlignment(SwingConstants.CENTER);
        lbl5.setFont(new Font(lbl5.getFont().getFontName(), Font.BOLD, 24));
        lbl5.setVisible(true);
        pest2.add(lbl5);
        
        table_Doctor = new JTable(Proyecto1.convertirHorarioDoc_tabla(),columnNames2);
        
        JScrollPane scrollPanes2 = new JScrollPane(table_Doctor);
        scrollPanes2.setBounds(350, 180, 600, 350);
        pest2.add(scrollPanes2);

                

        getContentPane().add(tabbedPane);
        this.setTitle("Paciente");
        this.setBounds(200,140,1400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        
         
     agregarPanelesProductos();   
        
        
    }
    
    private void agregarPanelesProductos() {
        
        for (int i = 0; i < Proyecto1.listaProducto.size(); i++) {
            Producto producto = Proyecto1.listaProducto.get(i);

            JPanel panelProducto = new JPanel();
            panelProducto.setLayout(new GridLayout(3, 1)); // Layout para mostrar nombre, descripción y precio
            panelProducto.setBounds(50, (i * 60) + 100, 400, 50);
            panelProducto.setBackground(Color.orange);

            // Nombre del producto
            JLabel nombreLabel = new JLabel("Nombre: \n" + producto.getNombre());
            panelProducto.add(nombreLabel);

            // Descripción del producto
            JLabel descripcionLabel = new JLabel("Descripción: \n" + producto.getDescripción());
            panelProducto.add(descripcionLabel);

            // Precio del producto
            JLabel precioLabel = new JLabel("Precio: \nQ" + producto.getPrecio());
            panelProducto.add(precioLabel);

            // Agregar el panel del producto al panel de la pestaña 3 (Farmacia)
            pest3.add(panelProducto);
        }
        

        // Actualizar la pestaña "Farmacia" después de agregar los paneles de productos
        
        tabbedPane.setComponentAt(2, pest3);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    
        if (e.getSource() == btnGeneradorCIta) {
            
           
  
        }
        
        if(e.getSource()== BTNMostrarDoctor){

             
            evaluar();
            
        }
        
        if(e.getSource() == BTNMostrarHorario){
            
            
            
        }
        
        if (e.getSource() == BTNEditarPerfil){
           for(int i = 0; i < Proyecto1.listaPacientes.size(); i++){
            if(Proyecto1.listaPacientes.get(i).getCodigos()== Proyecto1.CódigoPac){
            actualizarPacientes(Proyecto1.listaPacientes.get(i));
            break;
          
            }
            }
             this.dispose();
            
  
        }
    
    }
    private void actualizarPacientes(Pacientes paciente) {
        ActualizarPac actualizador1 = new ActualizarPac(paciente);
        actualizador1.setVisible(true);  
    }

}
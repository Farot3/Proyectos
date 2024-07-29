
package proyecto1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
   import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;


public class VentanaDoc extends JFrame implements ActionListener{
    
    private JButton BTNEditper, BTN_Asignar;
    private JTable table_horariocitas, table_citas;
    private JTextField HorarioCi;
    private int codigoDoctor;
    
    public VentanaDoc(int codigoDoctor) {
        this.codigoDoctor = codigoDoctor;
        
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    
        JPanel Pest1 = new JPanel(null);
        JPanel Pest2 = new JPanel(null);
                
        tabbedPane.addTab("Citas", Pest1);
        tabbedPane.addTab("Asignar Horario", Pest2);
        
        BTNEditper = new JButton("Editar Perfil");
        BTNEditper.setBounds(900, 25, 180, 50);
        BTNEditper.setVisible(true);
        BTNEditper.setEnabled(true);
        BTNEditper.addActionListener(this);
        this.add(BTNEditper);
                       
        JLabel horarioLabel = new JLabel("Horario de citas:");
        horarioLabel.setBounds(200, 50, 250, 250);
        horarioLabel.setFont(new Font("Kristen ITC",  Font.BOLD, 20));
        Pest2.add(horarioLabel);
        
        HorarioCi = new JTextField();
        HorarioCi.setBounds(400, 165, 230, 25);
        Pest2.add(HorarioCi);
        
        BTN_Asignar = new JButton("Asignar");
        BTN_Asignar.setBounds(750, 165, 180, 30);
        BTN_Asignar.setBackground(Color.GREEN);
        BTN_Asignar.setVisible(true);
        BTN_Asignar.setEnabled(true);
        BTN_Asignar.addActionListener(this);
        Pest2.add(BTN_Asignar);
        
        
        
        
        JLabel lbl4 = new JLabel("Horario");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl4.setBounds(25, 25, 400, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como GRIS CLARO
        lbl4.setBackground(Color.LIGHT_GRAY);
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl4.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl4.setVerticalAlignment(SwingConstants.CENTER);
        lbl4.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl4.setFont(new Font(lbl4.getFont().getFontName(), Font.BOLD, 25));
        // Hacer que el JLabel sea visible
        lbl4.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        Pest2.add(lbl4);
        
        JLabel lbl6 = new JLabel("Mi horario disponible para citas:");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl6.setBounds(460, 250, 400, 50);

        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl6.setVerticalAlignment(SwingConstants.CENTER);
        lbl6.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl6.setFont(new Font(lbl4.getFont().getFontName(), Font.BOLD, 25));
        // Hacer que el JLabel sea visible
        lbl6.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        Pest2.add(lbl6);
        
        String[] columnNames = {"No.", "Horario de cita"};
        
        
        
        // Crear una instancia de JTable con los datos y nombres de columna
        table_horariocitas = new JTable(Proyecto1.convertirHorarioDoc_tabla(), columnNames);
        
        // Centrar el contenido de las celdas de la tabla horizontalmente
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Aplicar el renderizador de celdas centrado a todas las columnas de la tabla
        for (int i = 0; i < table_horariocitas.getColumnCount(); i++) {
            table_horariocitas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        table_horariocitas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
         
        
        JScrollPane scrollPane = new JScrollPane(table_horariocitas);
        scrollPane.setBounds(80, 300, 1200, 350);

        // Agregar el JScrollPane (que contiene la tabla) al panel pest1
        Pest2.add(scrollPane);
        
        
        
        
        
        getContentPane().add(tabbedPane);
        this.setTitle("Doctor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(25, 25, 1400, 700);
        this.setResizable(true);
        this.setVisible(true);
        
        JPanel panelPrincipal = new JPanel(new GridLayout(0, 1));
        panelPrincipal.setBounds(25, 80, 650, 300);

        
        
        for (int i = 0; i < Proyecto1.listaHorarioCitas2.size(); i++) {
         JPanel panelCita = new JPanel();
         panelCita.setSize(640,50);
         panelCita.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));

          
            JButton btnAceptar = new JButton("Aceptar");
            JButton btnRechazar = new JButton("Rechazar");
            JButton btnDetalles = new JButton("Ver Mas");
            JLabel labelNombre = new JLabel(Proyecto1.listaHorarioCitas2.get(i).getPACNombre());
            JLabel labelHora = new JLabel(Proyecto1.listaHorarioCitas2.get(i).getHora());
            JLabel labelFecha = new JLabel(Proyecto1.listaHorarioCitas2.get(i).getFecha());
            
            panelCita.add(labelNombre, BorderLayout.WEST);
            panelCita.add(labelHora, BorderLayout.CENTER);
            panelCita.add(labelFecha, BorderLayout.EAST);
            panelCita.add(btnDetalles, BorderLayout.EAST);
            panelCita.add(btnAceptar, BorderLayout.EAST);
            panelCita.add(btnRechazar, BorderLayout.EAST);
            
            
            panelPrincipal.add(panelCita);

            
            
        }

        JScrollPane ScrollPane = new JScrollPane(panelPrincipal);
        ScrollPane.setBounds(30, 200, 1300, 450);
        ScrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        Pest1.add(ScrollPane);
        
        JLabel NombrePaci = new JLabel("Nombre Paciente");        
        NombrePaci.setBounds(75, 30, 250, 250);
        NombrePaci.setFont(new Font("Comic Sans MS",  Font.BOLD, 15));
        Pest1.add(NombrePaci);
        
        JLabel HOraCi = new JLabel("Horario de cita");
        HOraCi.setBounds(325, 30, 250, 250);
        HOraCi.setFont(new Font("Comic Sans MS",  Font.BOLD, 15));
        Pest1.add(HOraCi);
        
        JLabel FechaCita = new JLabel("Fecha cita");
        FechaCita.setBounds(575, 30, 250, 250);
        FechaCita.setFont(new Font("Comic Sans MS",  Font.BOLD, 15));
        Pest1.add(FechaCita);
        
        JLabel Accions = new JLabel("Acciones");
        Accions.setBounds(1000, 30, 250, 250);
        Accions.setFont(new Font("Comic Sans MS",  Font.BOLD, 15));
        Pest1.add(Accions);
        
        
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Asignar")) {
            String Horario = HorarioCi.getText();
            Proyecto1.Agregar_horarios1(Horario, Proyecto1.Nomero);
                        
            this.dispose();
            VentanaDoc Pest2 = new VentanaDoc(codigoDoctor);
            Pest2.setVisible(true);
        } 
        Proyecto1.Nomero++;
        
        
        if (e.getActionCommand().equals("Editar Perfil")) {
            
            for(int i = 0; i < Proyecto1.listaDoctores.size(); i++){
            if(Proyecto1.listaDoctores.get(i).getCódigo() == Proyecto1.CódigoDoc){
            actualizarDoctores(Proyecto1.listaDoctores.get(i));
            break;
          
            }
            }
             this.dispose();
    }
        
        
        
    }
    private void actualizarDoctores(Doctores Doctor) {
        ActualizarDoc actualizador = new ActualizarDoc(Doctor);
        actualizador.setVisible(true);  
    }
    
    
}


package proyecto1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
   import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class VentanaAdmin extends JFrame implements ActionListener{
    
    private JTable table_doctores, table_pacientes, table_productos;
        private JButton btnDoctor, btn_actualizar_doctor, btn_eliminar, btn_CrearPac, btn_ActualizarPac, btn_EliminarPac;
        private JButton btn_CrearPro, btn_ActualizarPro, btn_EliminarPro;
        
    public VentanaAdmin() {
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JPanel Pest1 = new JPanel(null);
        JPanel Pest2 = new JPanel(null);
        JPanel Pest3 = new JPanel(null);
        
        tabbedPane.addTab("Doctores", Pest1);
        tabbedPane.addTab("Pacientes", Pest2);
        tabbedPane.addTab("Productos", Pest3);
        
        btnDoctor = new JButton("Crear doctor");
        btnDoctor.setBounds(900, 25, 180, 50);
        btnDoctor.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btnDoctor.setVisible(true);
        btnDoctor.setEnabled(true);
        btnDoctor.addActionListener(this);
        Pest1.add(btnDoctor);
        
        //BTN2	
        btn_actualizar_doctor = new JButton("Actualizar doctor");
        btn_actualizar_doctor.setBounds(1100, 25, 180, 50);
        btn_actualizar_doctor.setVisible(true);
        btn_actualizar_doctor.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_actualizar_doctor.setEnabled(true);
        btn_actualizar_doctor.addActionListener(this);
        Pest1.add(btn_actualizar_doctor);
        
        btn_eliminar = new JButton("Eliminar doctor");
        btn_eliminar.setBounds(1000, 100, 180, 50);
        btn_eliminar.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_eliminar.setVisible(true);
        btn_eliminar.setEnabled(true);
        btn_eliminar.addActionListener(this);
        Pest1.add(btn_eliminar);
        
        btn_CrearPac = new JButton("Crear Paciente");
        btn_CrearPac.setBounds(900, 25, 180, 50);
        btn_CrearPac.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_CrearPac.setVisible(true);
        btn_CrearPac.setEnabled(true);
        btn_CrearPac.addActionListener(this);
        Pest2.add(btn_CrearPac);
        
        btn_ActualizarPac = new JButton("Actualizar Paciente");
        btn_ActualizarPac.setBounds(1100, 25, 180, 50);
        btn_ActualizarPac.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_ActualizarPac.setVisible(true);
        btn_ActualizarPac.setEnabled(true);
        btn_ActualizarPac.addActionListener(this);
        Pest2.add(btn_ActualizarPac);
        
        btn_EliminarPac = new JButton("Eliminar Paciente");
        btn_EliminarPac.setBounds(1000, 100, 180, 50);
        btn_EliminarPac.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_EliminarPac.setVisible(true);
        btn_EliminarPac.setEnabled(true);
        btn_EliminarPac.addActionListener(this);
        Pest2.add(btn_EliminarPac);
        
        btn_CrearPro = new JButton("Crear Producto");
        btn_CrearPro.setBounds(900, 25, 180, 50);
        btn_CrearPro.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_CrearPro.setVisible(true);
        btn_CrearPro.setEnabled(true);
        btn_CrearPro.addActionListener(this);
        Pest3.add(btn_CrearPro);
        
        btn_ActualizarPro = new JButton("Actualizar Producto");
        btn_ActualizarPro.setBounds(1100, 25, 180, 50);
        btn_ActualizarPro.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_ActualizarPro.setVisible(true);
        btn_ActualizarPro.setEnabled(true);
        btn_ActualizarPro.addActionListener(this);
        Pest3.add(btn_ActualizarPro);
        
        btn_EliminarPro = new JButton("Eliminar Producto");
        btn_EliminarPro.setBounds(1000, 100, 180, 50);
        btn_EliminarPro.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));
        btn_EliminarPro.setVisible(true);
        btn_EliminarPro.setEnabled(true);
        btn_EliminarPro.addActionListener(this);
        Pest3.add(btn_EliminarPro);
        
        
        JLabel lbl4 = new JLabel("Listado de doctores");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl4.setBounds(25, 25, 800, 50);
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
        lbl4.setFont(new Font(lbl4.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl4.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        Pest1.add(lbl4);
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        ArrayList<Doctores> lista_ordenada = Proyecto1.bubblesortEdadDoctores(); 
        
        for(int i = 0; i < Math.min(8,lista_ordenada.size()) ; i++){
            datos.setValue(lista_ordenada.get(i).getEdad(), "Doctores Hospital", lista_ordenada.get(i).getEspecialidad());
        }
       
        
        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
            "Top 8 Doctores más jovenes",
            "Especialidades",
            "Edad",
            datos,
            PlotOrientation.HORIZONTAL,
            true,
            true,
            false
            
        );
        
        ChartPanel cPanel = new ChartPanel(grafico_barras);
        cPanel.setMouseWheelEnabled(true);
        // Asignamos la posición y las dimensiones de nuestro ChartPanel
        cPanel.setBounds(850, 160, 450, 300);
        // Agregamos a nuestra pestaña el ChartPanel con nuestro gráfico
        Pest1.add(cPanel); 

        //Tabla
        // Crear un modelo de tabla y agregar datos de ejemplo
        String[] columnNames = {"Codigo", "Nombre Completo", "Genero", "Edad", "Especialidad", "Teléfono"}; 

        // Crear una instancia de JTable con los datos y nombres de columna
        table_doctores = new JTable(Proyecto1.convertirDatosDoctores_tabla(), columnNames);
        
        JScrollPane scrollPane = new JScrollPane(table_doctores);
        scrollPane.setBounds(25, 80, 800, 570);
        scrollPane.setFont(new Font("Trebuchet MS",  Font.BOLD, 17));

        // Agregar el JScrollPane (que contiene la tabla) al panel pest1
        Pest1.add(scrollPane);
        
        JLabel lbl5 = new JLabel("Listado de pacientes");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl5.setBounds(25, 25, 800, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl5.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como GRIS CLARO
        lbl5.setBackground(Color.LIGHT_GRAY);
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl5.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl5.setVerticalAlignment(SwingConstants.CENTER);
        lbl5.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl5.setFont(new Font(lbl5.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl5.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        Pest2.add(lbl5);

        //Tabla
        // Crear un modelo de tabla y agregar datos de ejemplo
        String[] columnaNames = {"Codigo", "Nombres", "Apellidos", "Edad", "Género"};

        // Crear una instancia de JTable con los datos y nombres de columna
        table_pacientes = new JTable(Proyecto1.convertirDatosPacientes_tabla(), columnaNames);
        
        JScrollPane scrollPanel = new JScrollPane(table_pacientes);
        scrollPanel.setBounds(25, 80, 800, 570);

        // Agregar el JScrollPane (que contiene la tabla) al panel pest1
        Pest2.add(scrollPanel);
        
        JLabel lbl6 = new JLabel("Listado de Productos");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl6.setBounds(25, 25, 800, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl6.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como GRIS CLARO
        lbl6.setBackground(Color.LIGHT_GRAY);
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl6.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl6.setVerticalAlignment(SwingConstants.CENTER);
        lbl6.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl6.setFont(new Font(lbl5.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl6.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        Pest3.add(lbl6);

        //Tabla
        // Crear un modelo de tabla y agregar datos de ejemplo
        String[] columnasNames = {"Codigo", "Nombre", "Cantidad", "Descripción", "Precio"};

        // Crear una instancia de JTable con los datos y nombres de columna
        table_productos = new JTable(Proyecto1.convertirDatosProducto_tabla(), columnasNames);
        
        
        
        JScrollPane scrollsPane2 = new JScrollPane(table_productos);
        scrollsPane2.setBounds(25, 80, 800, 570);

        // Agregar el JScrollPane (que contiene la tabla) al panel pest1
        Pest3.add(scrollsPane2);
        
        DefaultCategoryDataset datosProd = new DefaultCategoryDataset();
        ArrayList<Producto> lista_ordenadaPRo = Proyecto1.bubblesortCantidadProducto(); 
        
        for(int i = 0; i < Math.min(8,lista_ordenadaPRo.size()) ; i++){
            datosProd.setValue(lista_ordenadaPRo.get(i).getCantidad(), "Productos hospital", lista_ordenadaPRo.get(i).getNombre());
        }
       
        
        JFreeChart grafico_barrasPro = ChartFactory.createBarChart3D(
            "Top 8 cantidad de producto",
            "Nombre",
            "Cantidad",
            datosProd,
            PlotOrientation.HORIZONTAL,
            true,
            true,
            false
            
        );
        
        ChartPanel cPanePro = new ChartPanel(grafico_barrasPro);
        cPanePro.setMouseWheelEnabled(true);
        // Asignamos la posición y las dimensiones de nuestro ChartPanel
        cPanePro.setBounds(850, 160, 450, 300);
        // Agregamos a nuestra pestaña el ChartPanel con nuestro gráfico
        Pest3.add(cPanePro); 
        
        
        getContentPane().add(tabbedPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(25, 25, 1350, 700);
        this.setResizable(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDoctor){
            RegistroDoc vtn_registrodoc= new RegistroDoc();
            this.dispose();
    }
        if (e.getSource() == btn_actualizar_doctor){
            int idInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario: ")); 
            
            //Recorrer todo el arraylist de los estudiantes 
            for(int i = 0; i < Proyecto1.listaDoctores.size() ; i++){
                
                //comparar si el elemento de la posicion actual es igual al que el usuario ingreso
                if (Proyecto1.listaDoctores.get(i).getCódigo()  == idInput){
                    
                   actualizarDoctores(Proyecto1.listaDoctores.get(i));
                   
             }else{
                    JOptionPane.showMessageDialog(this, "No existe el doctor", "Error con el doctor",   JOptionPane.ERROR_MESSAGE);
                                                
                }
            }
            // Cierra la ventana actual
            this.dispose();
            VentanaAdmin nuevaVentana = new VentanaAdmin();
            nuevaVentana.setVisible(true);
    }
        if (e.getSource() == btn_eliminar) {
            
            //Metodo para eliminar un estudiante segun su codigo
            //Pedirle al usuario un codigo y parsearlo a int 
            //showInputDialog es el cuadro de texto
            int idInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario: ")); 
            
            //Recorrer todo el arraylist de los estudiantes 
            for(int i = 0; i < Proyecto1.listaDoctores.size() ; i++){
                
                //comparar si el elemento de la posicion actual es igual al que el usuario ingreso
                if (Proyecto1.listaDoctores.get(i).getCódigo()  == idInput){
                    //Eliminar de la lista (se le envia el indice del elemento que se quiere eliminar)
                    Proyecto1.listaDoctores.remove(i);
                }else{
                    JOptionPane.showMessageDialog(this, "No existe el doctor", "Error con el doctor",   JOptionPane.ERROR_MESSAGE);
                                                
                }
            }
            // Cierra la ventana actual
            this.dispose();

            // Crea y muestra una nueva instancia de la ventana Administrador
            VentanaAdmin nuevaVentana = new VentanaAdmin();
            nuevaVentana.setVisible(true);
            
            
        }
        
        //--------------------------Paciente-----------------------------------------------------
        if (e.getSource() == btn_CrearPac){
            RegistroPac vtn_registroPac= new RegistroPac();
            this.dispose();
    }
        
       if (e.getSource() == btn_ActualizarPac){
            int idInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario: ")); 
            
            //Recorrer todo el arraylist de los estudiantes 
            for(int i = 0; i < Proyecto1.listaPacientes.size() ; i++){
                
                //comparar si el elemento de la posicion actual es igual al que el usuario ingreso
                if (Proyecto1.listaPacientes.get(i).getCodigos()== idInput){
                    
                   actualizarPacientes(Proyecto1.listaPacientes.get(i));                

                }else{
                    JOptionPane.showMessageDialog(this, "No existe el paciente", "Error con el Paciente",   JOptionPane.ERROR_MESSAGE);
                                                
                }
            }
            // Cierra la ventana actual
            this.dispose();
    } 
       
       if (e.getSource() == btn_EliminarPac) {
            
            //Metodo para eliminar un estudiante segun su codigo
            //Pedirle al usuario un codigo y parsearlo a int 
            //showInputDialog es el cuadro de texto
            int idInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario: ")); 
            
            //Recorrer todo el arraylist de los estudiantes 
            for(int i = 0; i < Proyecto1.listaPacientes.size() ; i++){
                
                //comparar si el elemento de la posicion actual es igual al que el usuario ingreso
                if (Proyecto1.listaPacientes.get(i).getCodigos()== idInput){
                    //Eliminar de la lista (se le envia el indice del elemento que se quiere eliminar)
                    Proyecto1.listaPacientes.remove(i);
                }else{
                    JOptionPane.showMessageDialog(this, "No existe el paciente", "Error con el Paciente",   JOptionPane.ERROR_MESSAGE);
                                                
                }
            }
            // Cierra la ventana actual
            this.dispose();

            // Crea y muestra una nueva instancia de la ventana Administrador
            VentanaAdmin nuevaVentana = new VentanaAdmin();
            nuevaVentana.setVisible(true);
            
            
        }      
       
       
       if (e.getSource() == btn_CrearPro){
            RegistroPro vtn_registropro= new RegistroPro();
            this.dispose();              
       }
       
       if (e.getSource() == btn_ActualizarPro){
            int idInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto: ")); 
            
            //Recorrer todo el arraylist de los estudiantes 
            for(int i = 0; i < Proyecto1.listaProducto.size() ; i++){
                
                //comparar si el elemento de la posicion actual es igual al que el usuario ingreso
                if (Proyecto1.listaProducto.get(i).getCodigo()== idInput){
                    
                   ActualizarProductos(Proyecto1.listaProducto.get(i));  

                }else{
                    JOptionPane.showMessageDialog(this, "No existe el paciente", "Error con el Paciente",   JOptionPane.ERROR_MESSAGE);
                                                
                }
            }
            // Cierra la ventana actual
            this.dispose();
    }
       if (e.getSource() == btn_EliminarPro) {
            
            //Metodo para eliminar un estudiante segun su codigo
            //Pedirle al usuario un codigo y parsearlo a int 
            //showInputDialog es el cuadro de texto
            int idInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario: ")); 
            
            //Recorrer todo el arraylist de los estudiantes 
            for(int i = 0; i < Proyecto1.listaProducto.size() ; i++){
                
                //comparar si el elemento de la posicion actual es igual al que el usuario ingreso
                if (Proyecto1.listaProducto.get(i).getCodigo()== idInput){
                    //Eliminar de la lista (se le envia el indice del elemento que se quiere eliminar)
                    Proyecto1.listaProducto.remove(i);
                }else {
                JOptionPane.showMessageDialog(this, "El producto no existe", "Error con el producto",   JOptionPane.ERROR_MESSAGE);
                }
            }
            // Cierra la ventana actual
            this.dispose();

            // Crea y muestra una nueva instancia de la ventana Administrador
            VentanaAdmin nuevaVentana = new VentanaAdmin();
            nuevaVentana.setVisible(true);
            
            
        
       
        
       }
  }
    
    private void actualizarPacientes(Pacientes paciente) {
        ActualizarPac actualizador1 = new ActualizarPac(paciente);
        actualizador1.setVisible(true);  
    }
    
    
    private void actualizarDoctores(Doctores Doctor) {
        ActualizarDoc actualizador = new ActualizarDoc(Doctor);
        actualizador.setVisible(true);  
    }
    
    
    private void ActualizarProductos(Producto Productos) {
        ActualizarPro actualizador2 = new ActualizarPro(Productos);
        actualizador2.setVisible(true);  
    }
}
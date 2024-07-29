package practica2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Ventana extends JFrame implements ActionListener{
    private JTable Rutas1;
    JTable Historial;
    private JButton btn_Cargar_rutas, btnEditarRUtas, GenerarBoton, InicTo;
    private JButton InicMot1, InicMot2, InicMot3, InicTuc1, InicTuc2, InicTuc3, InicCar1, InicCar2, InicCar3, regresarmot,regresarmot2,regresarmot3, regresartuc, regresartuc2, regresartuc3, regresarcar, regresarcar2, regresarcar3;
    JButton GassMot,GassMot2,GassMot3, GassTuc, GassTuc2, GassTuc3, GassCar,GassCar2,GassCar3;
    private JComboBox<String> PuntInic, PuntFIn, Vehículos;
    JLabel PuntMot1, PuntFMot1, DisMot1, NomMot1, labelImagen, PuntMot2, PuntFMot2, DisMot2, NomMot2, labelImagen2, PuntMot3, PuntFMot3, DisMot3, NomMot3, labelImagen3;
    JLabel PuntTuc1, PuntFTuc1, DisTuc1, NomTuc1, labeltuc, PuntTuc2, PuntFTuc2, DisTuc2, NomTuc2, labeltuc2, PuntTuc3, PuntFTuc3, DisTuc3, NomTuc3, labeltuc3;
    JLabel PuntCar1, PuntFCar1, DisCar1, NomCar1, labelcar, PuntCar2, PuntFCar2, DisCar2, NomCar2, labelcar2, PuntCar3, PuntFCar3, DisCar3, NomCar3, labelcar3;   
    JLabel Distanciamot, Gasmot,Distanciamot2, Gasmot2,Distanciamot3, Gasmot3, distanTuc, GasTuc, distanTuc2, GasTuc2, distanTuc3, GasTuc3, DistanCar, GarCar, DistanCar2, GarCar2, DistanCar3, GarCar3;
    private int contadorGenerarViaje = 0;
    public static final int INICIO_LABEL_X = 120;
    
    public Ventana(){
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JPanel Pest1 = new JPanel(null);
        JPanel Pest2 = new JPanel(null);
        JPanel Pest3 = new JPanel(null);
        JPanel Pest4 = new JPanel(null);
        
        tabbedPane.addTab("Rutas", Pest1);
        tabbedPane.addTab("Generar Viaje", Pest2);
        tabbedPane.addTab("Recorridos", Pest3);
        tabbedPane.addTab("Historial", Pest4);
        
        btn_Cargar_rutas = new JButton("Cargar Rutas (.CSV)");
        btn_Cargar_rutas.setBounds(50, 25, 200, 50);
        btn_Cargar_rutas.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        btn_Cargar_rutas.setVisible(true);
        btn_Cargar_rutas.setEnabled(true);
        btn_Cargar_rutas.addActionListener(this);
        Pest1.add(btn_Cargar_rutas);
        
        btnEditarRUtas = new JButton("Editar Distancia");
        btnEditarRUtas.setBounds(1100, 25, 150, 50);
        btnEditarRUtas.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        btnEditarRUtas.setVisible(true);
        btnEditarRUtas.setEnabled(true);
        btnEditarRUtas.addActionListener(this);
        Pest1.add(btnEditarRUtas);
        
        JLabel Transporte = new JLabel("Seleccionar tipo de transporte");
        Transporte.setBounds(1000, 35, 300, 25);
        Transporte.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        Pest2.add(Transporte);
               
        String[] vehiculos = {"Motocicleta 1","Motocicleta 2","Motocicleta 3", "Vehículo estandar 1", "Vehículo estandar 2", "Vehículo estandar 3", "Vehículo Premium 1", "Vehículo Premium 2", "Vehículo Premium 3"};
        Vehículos = new JComboBox<>(vehiculos);
        Vehículos.setBounds(1000, 80, 175, 25);
        Vehículos.setVisible(true);
        Vehículos.setEnabled(true);
        Pest2.add(Vehículos);
        
        InicTo = new JButton("Iniciar Todos");
        InicTo.setBounds(1100, 25, 150, 35);
        InicTo.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        InicTo.setVisible(true);
        InicTo.setEnabled(true);
        InicTo.addActionListener(this);
        Pest3.add(InicTo);
        
        GenerarBoton = new JButton("Generar Viaje");
        GenerarBoton.setBounds(1100, 550, 150, 50);
        GenerarBoton.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GenerarBoton.setVisible(true);
        GenerarBoton.setEnabled(true);
        GenerarBoton.addActionListener(this);
        Pest2.add(GenerarBoton);
        
        String[] columnasNames = {"Id", "Inicio", "Fin", "Distancia"};
        Rutas1 = new JTable(new DefaultTableModel(columnasNames, 0));
        JScrollPane scrollsPane2 = new JScrollPane(Rutas1);
        scrollsPane2.setBounds(25, 80, 1200, 500);
        Pest1.add(scrollsPane2);
        
        String[] columnasNames2 = {"Id", "Fecha y Hora Inicio", "Fecha y Hora Fin", "Distancia (Km)", "Vehículo", "Gasolina consumida"};
        Historial = new JTable(new DefaultTableModel(columnasNames2, 0));
        JScrollPane scrollsPane3 = new JScrollPane(Historial);
        scrollsPane3.setBounds(25, 80, 1200, 500);
        Pest4.add(scrollsPane3);
        
        JLabel inic = new JLabel("Seleccionar Punto de Inicio");
        inic.setBounds(50, 35, 300, 25);
        inic.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        Pest2.add(inic);
               
        String[] INicio = obtenerPuntosDeInicio();
        PuntInic = new JComboBox<>(INicio);
        PuntInic.setBounds(50, 60, 175, 25);
        PuntInic.setVisible(true);
        PuntInic.setEnabled(true);
        Pest2.add(PuntInic);
                    
        JLabel finic = new JLabel("Seleccionar Punto de FIn");
        finic.setBounds(50, 90, 300, 25);
        finic.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        Pest2.add(finic);
        
        PuntFIn = new JComboBox<>();
        PuntFIn.setBounds(50, 120, 175, 25);
        PuntFIn.setVisible(true);
        PuntFIn.setEnabled(true);
        Pest2.add(PuntFIn);
        
        InicMot1 = new JButton("Iniciar");
        InicMot1.setBounds(25, 135, 75, 25);
        InicMot1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicMot1.setVisible(false);
        InicMot1.setEnabled(true);
        InicMot1.addActionListener(this);
        Pest3.add(InicMot1);
        
        regresarmot = new JButton("Regresar");
        regresarmot.setBounds(1100, 135, 120, 25);
        regresarmot.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresarmot.setVisible(false);
        regresarmot.setEnabled(true);
        regresarmot.addActionListener(this);
        Pest3.add(regresarmot);
        
        PuntMot1 = new JLabel("Inicio");
        PuntMot1.setBounds(25, 105, 150, 25);
        PuntMot1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntMot1.setVisible(false);
        Pest3.add(PuntMot1);
        
        PuntFMot1 = new JLabel("Destino");
        PuntFMot1.setBounds(1100, 105, 150, 25);
        PuntFMot1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFMot1.setVisible(false);
        Pest3.add(PuntFMot1);
        
        DisMot1 = new JLabel("Distancia");
        DisMot1.setBounds(25, 80, 150, 25);
        DisMot1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisMot1.setVisible(false);
        Pest3.add(DisMot1);
        
        NomMot1 = new JLabel("Motocicleta 1");
        NomMot1.setBounds(25, 55, 120, 25);
        NomMot1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomMot1.setVisible(false);
        Pest3.add(NomMot1);
        
        GassMot = new JButton("Recargar");
        GassMot.setBounds(1100, 25, 100, 25);
        GassMot.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassMot.setVisible(false);
        GassMot.setEnabled(true);
        GassMot.addActionListener(this);
        Pest3.add(GassMot);
        
        Distanciamot = new JLabel();
        Distanciamot.setBounds(25, 105, 150, 25);
        Distanciamot.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        Distanciamot.setVisible(false);
        Pest3.add(Distanciamot);
        
        Gasmot = new JLabel();
        Gasmot.setBounds(25, 105, 150, 25);
        Gasmot.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        Gasmot.setVisible(false);
        Pest3.add(Gasmot);
        
        ImageIcon mot = new ImageIcon(getClass().getResource("/Imagen/motis1.png"));
        labelImagen = new JLabel(mot);
        labelImagen.setBounds(125, 50, 200, 120); // Puedes ajustar las coordenadas y el tamaño según tus necesidades
        labelImagen.setVisible(false);
        Pest3.add(labelImagen); 
        
        InicMot2 = new JButton("Iniciar");
        InicMot2.setBounds(25, 135, 75, 25);
        InicMot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicMot2.setVisible(false);
        InicMot2.setEnabled(true);
        InicMot2.addActionListener(this);
        Pest3.add(InicMot2);
        
        regresarmot2 = new JButton("Regresar");
        regresarmot2.setBounds(1100, 135, 120, 25);
        regresarmot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresarmot2.setVisible(false);
        regresarmot2.setEnabled(true);
        regresarmot2.addActionListener(this);
        Pest3.add(regresarmot2);
        
        PuntMot2 = new JLabel("Inicio");
        PuntMot2.setBounds(25, 105, 150, 25);
        PuntMot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntMot2.setVisible(false);
        Pest3.add(PuntMot2);
        
        PuntFMot2 = new JLabel("Destino");
        PuntFMot2.setBounds(1100, 105, 150, 25);
        PuntFMot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFMot2.setVisible(false);
        Pest3.add(PuntFMot2);
        
        DisMot2 = new JLabel("Distancia");
        DisMot2.setBounds(25, 80, 150, 25);
        DisMot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisMot2.setVisible(false);
        Pest3.add(DisMot2);
        
        NomMot2 = new JLabel("Motocicleta 2");
        NomMot2.setBounds(25, 55, 120, 25);
        NomMot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomMot2.setVisible(false);
        Pest3.add(NomMot2);
        
        GassMot2 = new JButton("Recargar");
        GassMot2.setBounds(1100, 25, 100, 25);
        GassMot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassMot2.setVisible(false);
        GassMot2.setEnabled(true);
        GassMot2.addActionListener(this);
        Pest3.add(GassMot2);
        
        Distanciamot2 = new JLabel();
        Distanciamot2.setBounds(25, 105, 150, 25);
        Distanciamot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        Distanciamot2.setVisible(false);
        Pest3.add(Distanciamot2);
        
        Gasmot2 = new JLabel();
        Gasmot2.setBounds(25, 105, 150, 25);
        Gasmot2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        Gasmot2.setVisible(false);
        Pest3.add(Gasmot2);
        
        ImageIcon mot2 = new ImageIcon(getClass().getResource("/Imagen/motis1.png"));
        labelImagen2 = new JLabel(mot2);
        labelImagen2.setBounds(125, 50, 200, 120); 
        labelImagen2.setVisible(false);
        Pest3.add(labelImagen2); 
        
        InicMot3 = new JButton("Iniciar");
        InicMot3.setBounds(25, 135, 75, 25);
        InicMot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicMot3.setVisible(false);
        InicMot3.setEnabled(true);
        InicMot3.addActionListener(this);
        Pest3.add(InicMot3);
        
        regresarmot3 = new JButton("Regresar");
        regresarmot3.setBounds(1100, 135, 120, 25);
        regresarmot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresarmot3.setVisible(false);
        regresarmot3.setEnabled(true);
        regresarmot3.addActionListener(this);
        Pest3.add(regresarmot3);
        
        PuntMot3 = new JLabel("Inicio");
        PuntMot3.setBounds(25, 105, 150, 25);
        PuntMot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntMot3.setVisible(false);
        Pest3.add(PuntMot3);
        
        PuntFMot3 = new JLabel("Destino");
        PuntFMot3.setBounds(1100, 105, 150, 25);
        PuntFMot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFMot3.setVisible(false);
        Pest3.add(PuntFMot3);
        
        DisMot3 = new JLabel("Distancia");
        DisMot3.setBounds(25, 80, 150, 25);
        DisMot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisMot3.setVisible(false);
        Pest3.add(DisMot3);
        
        NomMot3 = new JLabel("Motocicleta 3");
        NomMot3.setBounds(25, 55, 120, 25);
        NomMot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomMot3.setVisible(false);
        Pest3.add(NomMot3);
        
        GassMot3 = new JButton("Recargar");
        GassMot3.setBounds(1100, 25, 100, 25);
        GassMot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassMot3.setVisible(false);
        GassMot3.setEnabled(true);
        GassMot3.addActionListener(this);
        Pest3.add(GassMot3);
        
        Distanciamot3 = new JLabel();
        Distanciamot3.setBounds(25, 105, 150, 25);
        Distanciamot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        Distanciamot3.setVisible(false);
        Pest3.add(Distanciamot3);
        
        Gasmot3= new JLabel();
        Gasmot3.setBounds(25, 105, 150, 25);
        Gasmot3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        Gasmot3.setVisible(false);
        Pest3.add(Gasmot3);
        
        ImageIcon mot3 = new ImageIcon(getClass().getResource("/Imagen/motis1.png"));
        labelImagen3 = new JLabel(mot3);
        labelImagen3.setBounds(125, 50, 200, 120);
        labelImagen3.setVisible(false);
        Pest3.add(labelImagen3); 
        
        InicTuc1 = new JButton("Iniciar");
        InicTuc1.setBounds(25, 340, 75, 25);
        InicTuc1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicTuc1.setVisible(false);
        InicTuc1.setEnabled(true);
        InicTuc1.addActionListener(this);
        Pest3.add(InicTuc1);
        
        regresartuc = new JButton("Regresar");
        regresartuc.setBounds(1100, 340, 75, 25);
        regresartuc.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresartuc.setVisible(false);
        regresartuc.setEnabled(true);
        regresartuc.addActionListener(this);
        Pest3.add(regresartuc);
        
        PuntTuc1 = new JLabel("Inicio");
        PuntTuc1.setBounds(25, 315, 150, 25);
        PuntTuc1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntTuc1.setVisible(false);
        Pest3.add(PuntTuc1);
        
        PuntFTuc1 = new JLabel("Destino");
        PuntFTuc1.setBounds(1100, 315, 150, 25);
        PuntFTuc1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFTuc1.setVisible(false);
        Pest3.add(PuntFTuc1);
        
        DisTuc1 = new JLabel("Distancia");
        DisTuc1.setBounds(25, 290, 150, 25);
        DisTuc1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisTuc1.setVisible(false);
        Pest3.add(DisTuc1);
        
        NomTuc1 = new JLabel("Vehículo Estandar 1");
        NomTuc1.setBounds(25, 265, 120, 25);
        NomTuc1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomTuc1.setVisible(false);
        Pest3.add(NomTuc1);
        
        GassTuc = new JButton("Recargar");
        GassTuc.setBounds(1100, 25, 100, 25);
        GassTuc.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassTuc.setVisible(false);
        GassTuc.setEnabled(true);
        GassTuc.addActionListener(this);
        Pest3.add(GassTuc);
        
        distanTuc = new JLabel();
        distanTuc.setBounds(25, 105, 150, 25);
        distanTuc.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        distanTuc.setVisible(false);
        Pest3.add(distanTuc);
        
        GasTuc = new JLabel();
        GasTuc.setBounds(25, 105, 150, 25);
        GasTuc.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        GasTuc.setVisible(false);
        Pest3.add(GasTuc);
        
        ImageIcon tuc = new ImageIcon(getClass().getResource("/Imagen/tuc.png"));
        labeltuc = new JLabel(tuc);
        labeltuc.setBounds(125, 220, 150, 150); // Puedes ajustar las coordenadas y el tamaño según tus necesidades
        labeltuc.setVisible(false);
        Pest3.add(labeltuc); 
        
        InicTuc2 = new JButton("Iniciar");
        InicTuc2.setBounds(25, 340, 75, 25);
        InicTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicTuc2.setVisible(false);
        InicTuc2.setEnabled(true);
        InicTuc2.addActionListener(this);
        Pest3.add(InicTuc2);
        
        regresartuc2 = new JButton("Regresar");
        regresartuc2.setBounds(1100, 340, 75, 25);
        regresartuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresartuc2.setVisible(false);
        regresartuc2.setEnabled(true);
        regresartuc2.addActionListener(this);
        Pest3.add(regresartuc2);
        
        PuntTuc2 = new JLabel("Inicio");
        PuntTuc2.setBounds(25, 315, 150, 25);
        PuntTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntTuc2.setVisible(false);
        Pest3.add(PuntTuc2);
        
        PuntFTuc2 = new JLabel("Destino");
        PuntFTuc2.setBounds(1100, 315, 150, 25);
        PuntFTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFTuc2.setVisible(false);
        Pest3.add(PuntFTuc2);
        
        DisTuc2 = new JLabel("Distancia");
        DisTuc2.setBounds(25, 290, 150, 25);
        DisTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisTuc2.setVisible(false);
        Pest3.add(DisTuc2);
        
        NomTuc2 = new JLabel("Vehículo Estandar 2");
        NomTuc2.setBounds(25, 265, 120, 25);
        NomTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomTuc2.setVisible(false);
        Pest3.add(NomTuc2);
        
        GassTuc2 = new JButton("Recargar");
        GassTuc2.setBounds(1100, 25, 100, 25);
        GassTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassTuc2.setVisible(false);
        GassTuc2.setEnabled(true);
        GassTuc2.addActionListener(this);
        Pest3.add(GassTuc2);
        
        distanTuc2 = new JLabel();
        distanTuc2.setBounds(25, 105, 150, 25);
        distanTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        distanTuc2.setVisible(false);
        Pest3.add(distanTuc2);
        
        GasTuc2 = new JLabel();
        GasTuc2.setBounds(25, 105, 150, 25);
        GasTuc2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        GasTuc2.setVisible(false);
        Pest3.add(GasTuc2);
        
        ImageIcon tuc2 = new ImageIcon(getClass().getResource("/Imagen/tuc.png"));
        labeltuc2 = new JLabel(tuc2);
        labeltuc2.setBounds(125, 220, 150, 150);
        labeltuc2.setVisible(false);
        Pest3.add(labeltuc2); 
        
        InicTuc3 = new JButton("Iniciar");
        InicTuc3.setBounds(25, 340, 75, 25);
        InicTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicTuc3.setVisible(false);
        InicTuc3.setEnabled(true);
        InicTuc3.addActionListener(this);
        Pest3.add(InicTuc3);
        
        regresartuc3 = new JButton("Regresar");
        regresartuc3.setBounds(1100, 340, 75, 25);
        regresartuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresartuc3.setVisible(false);
        regresartuc3.setEnabled(true);
        regresartuc3.addActionListener(this);
        Pest3.add(regresartuc3);
        
        PuntTuc3 = new JLabel("Inicio");
        PuntTuc3.setBounds(25, 315, 150, 25);
        PuntTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntTuc3.setVisible(false);
        Pest3.add(PuntTuc3);
        
        PuntFTuc3 = new JLabel("Destino");
        PuntFTuc3.setBounds(1100, 315, 150, 25);
        PuntFTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFTuc3.setVisible(false);
        Pest3.add(PuntFTuc3);
        
        DisTuc3 = new JLabel("Distancia");
        DisTuc3.setBounds(25, 290, 150, 25);
        DisTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisTuc3.setVisible(false);
        Pest3.add(DisTuc3);
        
        NomTuc3 = new JLabel("Vehículo Estandar 3");
        NomTuc3.setBounds(25, 265, 120, 25);
        NomTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomTuc3.setVisible(false);
        Pest3.add(NomTuc3);
        
        GassTuc3 = new JButton("Recargar");
        GassTuc3.setBounds(1100, 25, 100, 25);
        GassTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassTuc3.setVisible(false);
        GassTuc3.setEnabled(true);
        GassTuc3.addActionListener(this);
        Pest3.add(GassTuc3);
        
        distanTuc3 = new JLabel();
        distanTuc3.setBounds(25, 105, 150, 25);
        distanTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        distanTuc3.setVisible(false);
        Pest3.add(distanTuc3);
        
        GasTuc3 = new JLabel();
        GasTuc3.setBounds(25, 105, 150, 25);
        GasTuc3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        GasTuc3.setVisible(false);
        Pest3.add(GasTuc3);
        
        ImageIcon tuc3 = new ImageIcon(getClass().getResource("/Imagen/tuc.png"));
        labeltuc3 = new JLabel(tuc3);
        labeltuc3.setBounds(125, 220, 150, 150);
        labeltuc3.setVisible(false);
        Pest3.add(labeltuc3); 
        
        InicCar1 = new JButton("Iniciar");
        InicCar1.setBounds(25, 500, 75, 25);
        InicCar1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicCar1.setVisible(false);
        InicCar1.setEnabled(true);
        InicCar1.addActionListener(this);
        Pest3.add(InicCar1);
        
        regresarcar = new JButton("Regresar");
        regresarcar.setBounds(1100, 500, 75, 25);
        regresarcar.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresarcar.setVisible(false);
        regresarcar.setEnabled(true);
        regresarcar.addActionListener(this);
        Pest3.add(regresarcar);
        
        PuntCar1 = new JLabel("Inicio");
        PuntCar1.setBounds(25, 475, 150, 25);
        PuntCar1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntCar1.setVisible(false);
        Pest3.add(PuntCar1);
        
        PuntFCar1 = new JLabel("Destino");
        PuntFCar1.setBounds(1100, 475, 150, 25);
        PuntFCar1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFCar1.setVisible(false);
        Pest3.add(PuntFCar1);
        
        DisCar1 = new JLabel("Distancia");
        DisCar1.setBounds(25, 450, 150, 25);
        DisCar1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisCar1.setVisible(false);
        Pest3.add(DisCar1);
        
        NomCar1 = new JLabel("Vehículo Premiun 1");
        NomCar1.setBounds(25, 425, 120, 25);
        NomCar1.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomCar1.setVisible(false);
        Pest3.add(NomCar1);
        
        GassCar = new JButton("Recargar");
        GassCar.setBounds(1100, 25, 100, 25);
        GassCar.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassCar.setVisible(false);
        GassCar.setEnabled(true);
        GassCar.addActionListener(this);
        Pest3.add(GassCar);
        
        DistanCar = new JLabel();
        DistanCar.setBounds(25, 105, 150, 25);
        DistanCar.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DistanCar.setVisible(false);
        Pest3.add(DistanCar);
        
        GarCar = new JLabel();
        GarCar.setBounds(25, 105, 150, 25);
        GarCar.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        GarCar.setVisible(false);
        Pest3.add(GarCar);
        
        ImageIcon car = new ImageIcon(getClass().getResource("/Imagen/carro.png"));
        labelcar = new JLabel(car);
        labelcar.setBounds(125, 450, 200, 80); // Puedes ajustar las coordenadas y el tamaño según tus necesidades
        labelcar.setVisible(false);
        Pest3.add(labelcar); 
        
        InicCar2 = new JButton("Iniciar");
        InicCar2.setBounds(25, 500, 75, 25);
        InicCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicCar2.setVisible(false);
        InicCar2.setEnabled(true);
        InicCar2.addActionListener(this);
        Pest3.add(InicCar2);
        
        regresarcar2 = new JButton("Regresar");
        regresarcar2.setBounds(1100, 500, 75, 25);
        regresarcar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresarcar2.setVisible(false);
        regresarcar2.setEnabled(true);
        regresarcar2.addActionListener(this);
        Pest3.add(regresarcar2);
        
        PuntCar2 = new JLabel("Inicio");
        PuntCar2.setBounds(25, 475, 150, 25);
        PuntCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntCar2.setVisible(false);
        Pest3.add(PuntCar2);
        
        PuntFCar2 = new JLabel("Destino");
        PuntFCar2.setBounds(1100, 475, 150, 25);
        PuntFCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFCar2.setVisible(false);
        Pest3.add(PuntFCar2);
        
        DisCar2 = new JLabel("Distancia");
        DisCar2.setBounds(25, 450, 150, 25);
        DisCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisCar2.setVisible(false);
        Pest3.add(DisCar2);
        
        NomCar2 = new JLabel("Vehículo Premiun 2");
        NomCar2.setBounds(25, 425, 120, 25);
        NomCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomCar2.setVisible(false);
        Pest3.add(NomCar2);
        
        GassCar2 = new JButton("Recargar");
        GassCar2.setBounds(1100, 25, 100, 25);
        GassCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassCar2.setVisible(false);
        GassCar2.setEnabled(true);
        GassCar2.addActionListener(this);
        Pest3.add(GassCar2);
        
        DistanCar2 = new JLabel();
        DistanCar2.setBounds(25, 105, 150, 25);
        DistanCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DistanCar2.setVisible(false);
        Pest3.add(DistanCar2);
        
        GarCar2 = new JLabel();
        GarCar2.setBounds(25, 105, 150, 25);
        GarCar2.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        GarCar2.setVisible(false);
        Pest3.add(GarCar2);
        
        ImageIcon car2 = new ImageIcon(getClass().getResource("/Imagen/carro.png"));
        labelcar2 = new JLabel(car2);
        labelcar2.setBounds(125, 450, 200, 80);
        labelcar2.setVisible(false);
        Pest3.add(labelcar2); 
        
        InicCar3 = new JButton("Iniciar");
        InicCar3.setBounds(25, 500, 75, 25);
        InicCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        InicCar3.setVisible(false);
        InicCar3.setEnabled(true);
        InicCar3.addActionListener(this);
        Pest3.add(InicCar3);
        
        regresarcar3 = new JButton("Regresar");
        regresarcar3.setBounds(1100, 500, 75, 25);
        regresarcar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        regresarcar3.setVisible(false);
        regresarcar3.setEnabled(true);
        regresarcar3.addActionListener(this);
        Pest3.add(regresarcar3);
        
        PuntCar3 = new JLabel("Inicio");
        PuntCar3.setBounds(25, 475, 150, 25);
        PuntCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntCar3.setVisible(false);
        Pest3.add(PuntCar3);
        
        PuntFCar3 = new JLabel("Destino");
        PuntFCar3.setBounds(1100, 475, 150, 25);
        PuntFCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        PuntFCar3.setVisible(false);
        Pest3.add(PuntFCar3);
        
        DisCar3 = new JLabel("Distancia");
        DisCar3.setBounds(25, 450, 150, 25);
        DisCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DisCar3.setVisible(false);
        Pest3.add(DisCar3);
        
        NomCar3 = new JLabel("Vehículo Premiun 3");
        NomCar3.setBounds(25, 425, 120, 25);
        NomCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        NomCar3.setVisible(false);
        Pest3.add(NomCar3);
        
        GassCar3 = new JButton("Recargar");
        GassCar3.setBounds(1100, 25, 100, 25);
        GassCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 15));
        GassCar3.setVisible(false);
        GassCar3.setEnabled(true);
        GassCar3.addActionListener(this);
        Pest3.add(GassCar2);
        
        DistanCar3 = new JLabel();
        DistanCar3.setBounds(25, 105, 150, 25);
        DistanCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        DistanCar3.setVisible(false);
        Pest3.add(DistanCar3);
        
        GarCar3 = new JLabel();
        GarCar3.setBounds(25, 105, 150, 25);
        GarCar3.setFont(new Font("Trebuchet MS",  Font.BOLD, 12));
        GarCar3.setVisible(false);
        Pest3.add(GarCar3);
        
        ImageIcon car3 = new ImageIcon(getClass().getResource("/Imagen/carro.png"));
        labelcar3 = new JLabel(car3);
        labelcar3.setBounds(125, 450, 200, 80);
        labelcar3.setVisible(false);
        Pest3.add(labelcar3);
        
         GenerarBoton.addActionListener(this);
                       
         PuntInic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String puntoInicioSeleccionado = (String) PuntInic.getSelectedItem();
                ArrayList<String> puntosFinales = obtenerPuntosFinales(puntoInicioSeleccionado);
                actualizarPuntosFinalesComboBox(puntosFinales);
            }
        });         
        
        getContentPane().add(tabbedPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(15, 25, 1350, 700);
        this.setResizable(true);
        this.setVisible(true);      
        imprimirDatosSerializados(Historial);
    }   
    
    
    public void lecturaCSV(Ventana ventana) {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(ventana);

    if (result == JFileChooser.APPROVE_OPTION) {
        File archivo_seleccionado = fileChooser.getSelectedFile();
        System.out.println("Ruta del archivo: " + archivo_seleccionado.getAbsolutePath());

        try {
            Scanner scanner = new Scanner(archivo_seleccionado);
            DefaultTableModel modeloTabla = (DefaultTableModel) ventana.Rutas1.getModel(); // Obtener el modelo existente

            int cont = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] partes = line.split(",");
                // Agregar los datos a la tabla
                Object elemento[] = {partes[0].trim(), partes[1], partes[2], partes[3].trim()};
                modeloTabla.addRow(elemento);
                int id = Integer.parseInt(partes[0].trim());
                int distancia = Integer.parseInt(partes[3].trim());
                Practica2.CSV(id, partes[1], partes[2], distancia);
                System.out.println("ID " + partes[0] + " raza: " + partes[1] + " nombre: " + partes[2]);
                cont++;
            }
            scanner.close();
            // Actualizar la tabla con el nuevo modelo
            ventana.Rutas1.setModel(modeloTabla);
            ventana.actualizarPuntosDeInicio();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

  }

public void imprimirDatosSerializados(JTable tabla) {
        try {
            File archivo = new File("./Archivos/historias.bin");

            if (archivo.exists()) {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo));
                ArrayList<Vehículos> datos = (ArrayList<Vehículos>) inputStream.readObject();
                inputStream.close();

                DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();

                // Limpiar la tabla antes de agregar nuevos datos
                modeloTabla.setRowCount(0);

                // Agregar cada fila de los datos de vehículos a la tabla
                for (Vehículos data : datos) {
                    Object[] fila = {
                            data.id,
                            data.fechaHoraInicio,
                            data.fechaHoraFin,
                            data.distanciaTotalRecorrida,
                            data.vehiculo,
                            data.gasolinaUtilizada
                    };
                    modeloTabla.addRow(fila);
                }
            } else {
                System.out.println("El archivo historias.bin no existe.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarPuntosDeInicio() {
        String[] INicio = obtenerPuntosDeInicio();
        PuntInic.removeAllItems(); // Limpiar los elementos anteriores del JComboBox
        for (String puntoInicio : INicio) {
            PuntInic.addItem(puntoInicio); // Agregar los nuevos elementos al JComboBox
        }
    }
    
    
    
    private String[] obtenerPuntosDeInicio() {
    DefaultTableModel modeloTabla = (DefaultTableModel) Rutas1.getModel();
    int rowCount = modeloTabla.getRowCount();
    ArrayList<String> puntosDeInicio = new ArrayList<>();

    for (int i = 0; i < rowCount; i++) {
        String inicio = (String) modeloTabla.getValueAt(i, 1); // Obtener el valor de la columna "Inicio"
        if (!puntosDeInicio.contains(inicio)) {
            puntosDeInicio.add(inicio);
        }
    }// Convertir ArrayList a un array de Strings y devolverlo
    return puntosDeInicio.toArray(new String[0]);
}
    
    private ArrayList<String> obtenerPuntosFinales(String puntoInicio) {
    DefaultTableModel modeloTabla = (DefaultTableModel) Rutas1.getModel();
    int rowCount = modeloTabla.getRowCount();
    ArrayList<String> puntosFinales = new ArrayList<>();
    // Recorrer la tabla para encontrar las filas que coincidan con el punto de inicio
    for (int i = 0; i < rowCount; i++) {
        String inicio = (String) modeloTabla.getValueAt(i, 1); // Obtener el punto de inicio de la fila
        String fin = (String) modeloTabla.getValueAt(i, 2); // Obtener el punto final de la fila
        if (inicio.equals(puntoInicio) && !puntosFinales.contains(fin)) {
            puntosFinales.add(fin); // Agregar el punto final a la lista si no está presente
        }
    }

    return puntosFinales;
}
    private void actualizarPuntosFinalesComboBox(ArrayList<String> puntosFinales) {
        PuntFIn.removeAllItems(); // Limpiar los elementos anteriores del JComboBox
        for (String puntoFinal : puntosFinales) {
            PuntFIn.addItem(puntoFinal); // Agregar los nuevos elementos al JComboBox
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cargar Rutas (.CSV)")){
            lecturaCSV(this);   
        }
        if(e.getActionCommand().equals("Editar Distancia")){
            EditDist dista = new EditDist(this);
        }
         if (e.getSource()== GenerarBoton) {
            generarViaje();
            mostrarComponentesSegunViaje();
            if (contadorGenerarViaje > 3) {
            GenerarBoton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "<html><font color='red'>No hay pilotos disponibles en este momento.</font></html>", "Aviso", JOptionPane.WARNING_MESSAGE);
    } contadorGenerarViaje++;
        }
         if(e.getSource() == InicMot1){
             Motocicleta motocicleta = new Motocicleta(this); 
             motocicleta.start();
         }
         if(e.getSource() == GassMot){
             Motocicleta nes = new Motocicleta(this);
             nes.start();
         }
         if(e.getSource() == regresarmot){
             Motocicleta nes = new Motocicleta(this);
             Practica2.serializarDatosMotocicleta(nes);
             Practica2.imprimirDatosSerializados();
             nes.start();
             imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicMot2){
             Motocicleta2 mes = new Motocicleta2(this);
            mes.start();
         }
         if(e.getSource() == GassMot2){
             Motocicleta2 mes = new Motocicleta2(this);
             mes.start();
         }
         if(e.getSource() == regresarmot2){
             Motocicleta2 mes = new Motocicleta2(this);
             Practica2.serializarDatosMotocicleta(mes);
             Practica2.imprimirDatosSerializados();
             mes.start();
             imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicMot3){
             Motocicleta3 mes9 = new Motocicleta3(this);
            mes9.start();
         }
         if(e.getSource() == GassMot3){
             Motocicleta3 mes9 = new Motocicleta3(this);
             mes9.start();
         }
         if(e.getSource() == regresarmot3){
             Motocicleta3 mes9 = new Motocicleta3(this);
             Practica2.serializarDatosMotocicleta(mes9);
             Practica2.imprimirDatosSerializados();
             mes9.start();
             imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicTuc1){
             Tuc mesTuc = new Tuc(this);
            mesTuc.start();
         }
         if(e.getSource() == GassTuc){
             Tuc mesTuc = new Tuc(this);
            mesTuc.start();
         }
         if(e.getSource() == regresartuc){
             Tuc mesTuc = new Tuc(this);
             Practica2.serializarDatosMotocicleta(mesTuc);
             Practica2.imprimirDatosSerializados();
            mesTuc.start();
            imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicTuc2){
             Tuc2 mesTuc2 = new Tuc2(this);
            mesTuc2.start();
         }
         if(e.getSource() == GassTuc2){
             Tuc2 mesTuc2 = new Tuc2(this);
            mesTuc2.start();
         }
         if(e.getSource() == regresartuc2){
             Tuc2 mesTuc2 = new Tuc2(this);
             Practica2.serializarDatosMotocicleta(mesTuc2);
             Practica2.imprimirDatosSerializados();
            mesTuc2.start();
            imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicTuc3){
             Tuc3 mesTuc3 = new Tuc3(this);
            mesTuc3.start();
         }
         if(e.getSource() == GassTuc3){
             Tuc3 mesTuc3 = new Tuc3(this);
            mesTuc3.start();
         }
         if(e.getSource() == regresartuc3){
             Tuc3 mesTuc3 = new Tuc3(this);
             Practica2.serializarDatosMotocicleta(mesTuc3);
             Practica2.imprimirDatosSerializados();
            mesTuc3.start();
            imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicCar1){
             Car mesCar = new Car(this);
            mesCar.start();
         }
         if(e.getSource() == GassCar){
             Car mesCar = new Car(this);
            mesCar.start();
         }
         if(e.getSource() == regresarcar){
             Car mesCar = new Car(this);
             Practica2.serializarDatosMotocicleta(mesCar);
             Practica2.imprimirDatosSerializados();
            mesCar.start();
            imprimirDatosSerializados(Historial);
         } 
         if(e.getSource() == InicCar2){
             Car2 mesCar2 = new Car2(this);
            mesCar2.start();
         }
         if(e.getSource() == GassCar2){
             Car2 mesCar2 = new Car2(this);
            mesCar2.start();
         }
         if(e.getSource() == regresarcar2){
             Car2 mesCar2 = new Car2(this);
             Practica2.serializarDatosMotocicleta(mesCar2);
             Practica2.imprimirDatosSerializados();
            mesCar2.start();
            imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicCar3){
             Car3 mesCar3 = new Car3(this);
             mesCar3.start();
         }
         if(e.getSource() == GassCar3){
             Car3 mesCar3 = new Car3(this);
            mesCar3.start();
         }
         if(e.getSource() == regresarcar3){
             Car3 mesCar3 = new Car3(this);
             Practica2.serializarDatosMotocicleta(mesCar3);
             Practica2.imprimirDatosSerializados();
             mesCar3.start();
             imprimirDatosSerializados(Historial);
         }
         if(e.getSource() == InicTo){
             if (labelImagen.isVisible()) {
        Motocicleta motocicleta = new Motocicleta(this);
        motocicleta.start();
    }
    if (labelImagen2.isVisible()) {
        Motocicleta2 mes = new Motocicleta2(this);
        mes.start();
    }
    if (labelImagen3.isVisible()) {
        Motocicleta3 mes9 = new Motocicleta3(this);
        mes9.start();
    }
    if (labeltuc.isVisible()) {
        Tuc mesTuc = new Tuc(this);
        mesTuc.start();
    }
    if (labeltuc2.isVisible()) {
        Tuc2 mesTuc2 = new Tuc2(this);
        mesTuc2.start();
    }
    if (labeltuc3.isVisible()) {
        Tuc3 mesTuc3 = new Tuc3(this);
        mesTuc3.start();
    }
    if (labelcar.isVisible()) {
        Car mesCar = new Car(this);
        mesCar.start();
    }
    if (labelcar2.isVisible()) {
        Car2 mesCar2 = new Car2(this);
        mesCar2.start();
    }
    if (labelcar3.isVisible()) {
        Car3 mesCar3 = new Car3(this);
        mesCar3.start();
    }
         }
    }
    
      private void generarViaje() {
        String tipoTransporte = (String) Vehículos.getSelectedItem();
        String puntoInicio = (String) PuntInic.getSelectedItem();
        String puntoFin = (String) PuntFIn.getSelectedItem();
        int distancia = obtenerDistancia(puntoInicio, puntoFin);

        Practica2.Viaje(tipoTransporte, puntoInicio, puntoFin, distancia);
        
        switch (tipoTransporte) {
            case "Motocicleta 1":
                PuntMot1.setText("Inicio " + puntoInicio);
                PuntFMot1.setText("Destino " + puntoFin);
                DisMot1.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Motocicleta 2":
                PuntMot2.setText("Inicio " + puntoInicio);
                PuntFMot2.setText("Destino " + puntoFin);
                DisMot2.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Motocicleta 3":
                PuntMot3.setText("Inicio " + puntoInicio);
                PuntFMot3.setText("Destino " + puntoFin);
                DisMot3.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Vehículo estandar 1":
                PuntTuc1.setText("Inicio " + puntoInicio);
                PuntFTuc1.setText("Destino " + puntoFin);
                DisTuc1.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Vehículo estandar 2":
                PuntTuc2.setText("Inicio " + puntoInicio);
                PuntFTuc2.setText("Destino " + puntoFin);
                DisTuc2.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Vehículo estandar 3":
                PuntTuc3.setText("Inicio " + puntoInicio);
                PuntFTuc3.setText("Destino " + puntoFin);
                DisTuc3.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Vehículo Premium 1":
                PuntCar1.setText("Inicio " + puntoInicio);
                PuntFCar1.setText("Destino " + puntoFin);
                DisCar1.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Vehículo Premium 2":
                PuntCar2.setText("Inicio " + puntoInicio);
                PuntFCar2.setText("Destino " + puntoFin);
                DisCar2.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            case "Vehículo Premium 3":
                PuntCar3.setText("Inicio " + puntoInicio);
                PuntFCar3.setText("Destino " + puntoFin);
                DisCar3.setText(String.valueOf("Distancia " + distancia + "km"));
                break;
            default:
                break;
        }
        
        
        
    }
    
private int obtenerDistancia(String puntoInicio, String puntoFin) {
    for (CSV csv : Practica2.ListaCSV) {
        if (csv.getInicio().equals(puntoInicio) && csv.getFin().equals(puntoFin)) {
            return csv.getDistancia();
        }
    }
    return -1; // Si no se encuentra la distancia, devolver un valor indicativo de error
}

public void actualizarDistancia(int id, int nuevaDistancia) {
    boolean encontrado = false; // Indica si se ha encontrado el ID en la lista

    for (int i = 0; i < Practica2.ListaCSV.size(); i++) {
        CSV csv = Practica2.ListaCSV.get(i);
        if (csv.getId() == id) {
            encontrado = true; // Marca como encontrado si se encuentra el ID
            csv.setDistancia(nuevaDistancia);
            Practica2.ListaCSV.set(i, csv); // Actualiza el objeto en el ArrayList

            // Ahora, actualiza la tabla Rutas1
            DefaultTableModel modeloTabla = (DefaultTableModel) Rutas1.getModel();
            modeloTabla.setValueAt(nuevaDistancia, i, 3); // Actualiza la distancia en la tabla
            break;
        }
    }
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "El ID que escogiste no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

 private void mostrarComponentesSegunViaje() {
        Viaje ultimoViaje = Practica2.listaViajes.get(Practica2.listaViajes.size() - 1);
        String tipoTransporte = ultimoViaje.getTipoTransportem();
        if (tipoTransporte.equals("Motocicleta 1")) {
            InicMot1.setVisible(true);
            PuntMot1.setVisible(true);
            PuntFMot1.setVisible(true);
            DisMot1.setVisible(true);
            NomMot1.setVisible(true);
            labelImagen.setVisible(true);
            Distanciamot.setVisible(true);
            Gasmot.setVisible(true);
            regresarmot.setVisible(true);
        } else if (tipoTransporte.equals("Motocicleta 2")) {
            InicMot2.setVisible(true);
            PuntMot2.setVisible(true);
            PuntFMot2.setVisible(true);
            DisMot2.setVisible(true);
            NomMot2.setVisible(true);
            labelImagen2.setVisible(true);
            Distanciamot2.setVisible(true);
            Gasmot2.setVisible(true);
            regresarmot2.setVisible(true);
        } else if (tipoTransporte.equals("Motocicleta 3")) {
            InicMot3.setVisible(true);
            PuntMot3.setVisible(true);
            PuntFMot3.setVisible(true);
            DisMot3.setVisible(true);
            NomMot3.setVisible(true);
            labelImagen3.setVisible(true);
            Distanciamot3.setVisible(true);
            Gasmot3.setVisible(true);
            regresarmot3.setVisible(true);
        } else if (tipoTransporte.equals("Vehículo estandar 1")) {
            InicTuc1.setVisible(true);
            PuntTuc1.setVisible(true);
            PuntFTuc1.setVisible(true);
            DisTuc1.setVisible(true);
            NomTuc1.setVisible(true);
            labeltuc.setVisible(true);
            distanTuc.setVisible(true);
            GasTuc.setVisible(true);
            regresartuc.setVisible(true);
        } else if (tipoTransporte.equals("Vehículo estandar 2")) {
            InicTuc2.setVisible(true);
            PuntTuc2.setVisible(true);
            PuntFTuc2.setVisible(true);
            DisTuc2.setVisible(true);
            NomTuc2.setVisible(true);
            labeltuc2.setVisible(true);
            distanTuc2.setVisible(true);
            GasTuc2.setVisible(true);
            regresartuc2.setVisible(true);
        } else if (tipoTransporte.equals("Vehículo estandar 3")) {
            InicTuc3.setVisible(true);
            PuntTuc3.setVisible(true);
            PuntFTuc3.setVisible(true);
            DisTuc3.setVisible(true);
            NomTuc3.setVisible(true);
            labeltuc3.setVisible(true);
            distanTuc3.setVisible(true);
            GasTuc3.setVisible(true);
            regresartuc3.setVisible(true);
        } else if (tipoTransporte.equals("Vehículo Premium 1")) {
            InicCar1.setVisible(true);
            PuntCar1.setVisible(true);
            PuntFCar1.setVisible(true);
            DisCar1.setVisible(true);
            NomCar1.setVisible(true);
            labelcar.setVisible(true);
            DistanCar.setVisible(true);
            GarCar.setVisible(true);
            regresarcar.setVisible(true);
        } else if (tipoTransporte.equals("Vehículo Premium 2")) {
            InicCar2.setVisible(true);
            PuntCar2.setVisible(true);
            PuntFCar2.setVisible(true);
            DisCar2.setVisible(true);
            NomCar2.setVisible(true);
            labelcar2.setVisible(true);
            DistanCar2.setVisible(true);
            GarCar2.setVisible(true);
            regresarcar2.setVisible(true);
        } else if (tipoTransporte.equals("Vehículo Premium 3")) {
            InicCar3.setVisible(true);
            PuntCar3.setVisible(true);
            PuntFCar3.setVisible(true);
            DisCar3.setVisible(true);
            NomCar3.setVisible(true);
            labelcar3.setVisible(true);
            DistanCar3.setVisible(true);
            GarCar3.setVisible(true);
            regresarcar3.setVisible(true);
        }
    }
 private int distanciaActual = 0;
    // Método para obtener la distancia actual
    public int getDistanciaActual() {
        return distanciaActual;
    }
    public void setDistanciaActual(int nuevaDistancia2) {
    this.distanciaActual = nuevaDistancia2;
}
    private int distanciaActual2 = 0;
        public int getDistanciaActual2() {
        return distanciaActual2;
    }
    public void setDistanciaActual2(int nuevaDistancia2) {
    this.distanciaActual2 = nuevaDistancia2;
}
       private int distanciaActual3 = 0;
        public int getDistanciaActual3() {
        return distanciaActual3;
    }
    public void setDistanciaActual3(int nuevaDistancia3) {
    this.distanciaActual3 = nuevaDistancia3;
}
  private int distanciaActualTuc = 0;
        public int getDistanciaActualTuc() {
        return distanciaActualTuc;
    }
    public void setDistanciaActualTuc(int nuevaDistanciaTuc) {
    this.distanciaActualTuc = nuevaDistanciaTuc;
}  
    private int distanciaActualTuc2 = 0;
        public int getDistanciaActualTuc2() {
        return distanciaActualTuc2;
    }
    public void setDistanciaActualTuc2(int nuevaDistanciaTuc2) {
    this.distanciaActualTuc2 = nuevaDistanciaTuc2;
}  
    private int distanciaActualTuc3 = 0;
        public int getDistanciaActualTuc3() {
        return distanciaActualTuc3;
    }
    public void setDistanciaActualTuc3(int nuevaDistanciaTuc3) {
    this.distanciaActualTuc3 = nuevaDistanciaTuc3;
}  
     private int distanciaActualCar = 0;
        public int getDistanciaActualCar() {
        return distanciaActualCar;
    }
    public void setDistanciaActualCar(int nuevaDistanciaCar) {
    this.distanciaActualCar = nuevaDistanciaCar;
}  
    private int distanciaActualCar2 = 0;
        public int getDistanciaActualCar2() {
        return distanciaActualCar2;
    }
    public void setDistanciaActualCar2(int nuevaDistanciaCar2) {
    this.distanciaActualCar2 = nuevaDistanciaCar2;
}  
    private int distanciaActualCar3 = 0;
        public int getDistanciaActualCar3() {
        return distanciaActualCar3;
    }
    public void setDistanciaActualCar3(int nuevaDistanciaCar3) {
    this.distanciaActualCar3 = nuevaDistanciaCar3;
}  
}

package practica2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Practica2 {
    public static ArrayList<CSV> ListaCSV = new ArrayList<>();
    public static ArrayList<Viaje> listaViajes = new ArrayList<>();
    public static ArrayList<Vehículos> Listahistoria = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        cargarIdCounter();
        EscribirCSV();
        Ventana ventana = new Ventana();
    }   
    
    public static void EscribirCSV(){
        String file = "/Archivos/Rutas.csv";
        
        try(PrintWriter writer =  new PrintWriter(new File(file))){
            StringBuilder sb = new StringBuilder();
            int id = 1;
            
            sb.append(id++).append(" ,");
            sb.append("Santa Cruz del Quiche").append(",");
            sb.append("Jocotenango").append(",");
            sb.append(35).append("\n");
            
            sb.append(id++).append(" ,");
            sb.append("Barberena").append(",");
            sb.append("El palmar").append(",");
            sb.append(13).append("\n");
           
            sb.append(id++).append(" ,");
            sb.append("Flores").append(",");
            sb.append("Tiquisate").append(",");
            sb.append(5).append("\n");
            
            sb.append(id++).append(" ,");
            sb.append("Amatitlan").append(",");
            sb.append("Mixco").append(",");
            sb.append(20).append("\n");
            
            sb.append(id++).append(" ,");
            sb.append("Salamá").append(",");
            sb.append("Poptún").append(",");
            sb.append(27).append("\n");
                       
            writer.write(sb.toString());
            System.out.println("El archivo ha sido creado exitosamente");                                             
        }catch(Exception e){
            System.out.println(e);                                 
        }            
    }
    
    public static void CSV(int id, String Inicio, String Fin, int distancia){
        CSV Noae = new CSV(id, Inicio, Fin, distancia);
        ListaCSV.add(Noae);
    }
    
    public static Object[][] convertirDatosCSV_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = ListaCSV.size();
        Object[][] arreglo = new Object[filas][6];

        for (int i = 0; i < filas; i++) {
            CSV CSV1 = ListaCSV.get(i);
            arreglo[i][0] = CSV1.getId();
            arreglo[i][1] = CSV1.getInicio();
            arreglo[i][2] = CSV1.getFin();
            arreglo[i][3] = CSV1.getDistancia();
        }     
        return arreglo;
    }
    
    public static void Vehículos(int id, String fechaHoraInicio, String fechaHoraFin, int distanciaTotalRecorrida, String vehiculo, double gasolinaUtilizada){
        Vehículos Noae = new Vehículos(id, fechaHoraInicio, fechaHoraFin, distanciaTotalRecorrida, vehiculo, gasolinaUtilizada);
        Listahistoria.add(Noae);
    }
    
    public static Object[][] convertirDatosHistorias_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = Listahistoria.size();
        Object[][] arreglo = new Object[filas][6];

        for (int i = 0; i < filas; i++) {
            Vehículos history = Listahistoria.get(i);
            arreglo[i][0] = history.getId();
            arreglo[i][1] = history.getFechaHoraInicio();
            arreglo[i][2] = history.getFechaHoraFin();
            arreglo[i][3] = history.getDistanciaTotalRecorrida();
            arreglo[i][4] = history.getVehiculo();
            arreglo[i][5] = history.getGasolinaUtilizada();
            
        }     
        return arreglo;
    }
    
    public static void Viaje(String tipoTransportem, String puntoIniciom, String puntoFinm, int distanciam){
        Viaje Noaes = new Viaje(tipoTransportem, puntoIniciom, puntoFinm, distanciam);
        listaViajes.add(Noaes);
    }
    
    public static void serializarDatosMotocicleta(Object vehiculo) {
        try {
            // Obtener la fecha y hora de inicio
            Date fechaHoraInicio = new Date();

            // Simular una fecha y hora de fin aleatoria posterior a la de inicio
            Date fechaHoraFin = generarFechaHoraFin(fechaHoraInicio);
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaInicioFormateada = formatoFecha.format(fechaHoraInicio);
            String fechaFinFormateada = formatoFecha.format(fechaHoraFin);

            // Generar el ID único (incrementar el contador de IDs)
            int id = idCounter++;

            // Calcular la distancia del vehículo
            int distanciaViaje = 0;
            double totalGasolinaUtilizada = 0;
            String tipoVehiculo = "";

            if (vehiculo instanceof Motocicleta) {
                Motocicleta motocicleta = (Motocicleta) vehiculo;
                distanciaViaje = motocicleta.distanciaViaje;
                totalGasolinaUtilizada = motocicleta.totalGasolinaUtilizada;
                tipoVehiculo = "Motocicleta";
            } else if (vehiculo instanceof Motocicleta2) {
                Motocicleta2 mot = (Motocicleta2) vehiculo;
                distanciaViaje = mot.distanciaViaje;
                totalGasolinaUtilizada = mot.totalGasolinaUtilizada2;
                tipoVehiculo = "Motocicleta";
            } else if (vehiculo instanceof Motocicleta3) {
                Motocicleta3 mot = (Motocicleta3) vehiculo;
                distanciaViaje = mot.distanciaViaje;
                totalGasolinaUtilizada = mot.totalGasolinaUtilizada3;
                tipoVehiculo = "Motocicleta";
            } else if (vehiculo instanceof Tuc) {
                Tuc tuc = (Tuc) vehiculo;
                distanciaViaje = tuc.distanciaViaje;
                totalGasolinaUtilizada = tuc.totalGasolinaUtilizada4;
                tipoVehiculo = "Estandar";
            } else if (vehiculo instanceof Tuc2) {
                Tuc2 tuc = (Tuc2) vehiculo;
                distanciaViaje = tuc.distanciaViaje;
                totalGasolinaUtilizada = tuc.totalGasolinaUtilizada5;
                tipoVehiculo = "Estandar";
            } else if (vehiculo instanceof Tuc3) {
                Tuc3 tuc = (Tuc3) vehiculo;
                distanciaViaje = tuc.distanciaViaje;
                totalGasolinaUtilizada = tuc.totalGasolinaUtilizada6;
                tipoVehiculo = "Estandar";
            } else if (vehiculo instanceof Car) {
                Car tuc = (Car) vehiculo;
                distanciaViaje = tuc.distanciaViaje;
                totalGasolinaUtilizada = tuc.totalGasolinaUtilizada7;
                tipoVehiculo = "Premium";
            } else if (vehiculo instanceof Car2) {
                Car2 tuc = (Car2) vehiculo;
                distanciaViaje = tuc.distanciaViaje;
                totalGasolinaUtilizada = tuc.totalGasolinaUtilizada8;
                tipoVehiculo = "Premium";
            }  else if (vehiculo instanceof Car3) {
                Car3 tuc = (Car3) vehiculo;
                distanciaViaje = tuc.distanciaViaje;
                totalGasolinaUtilizada = tuc.totalGasolinaUtilizada9;
                tipoVehiculo = "Premium";
            }

            // Crear un objeto VehiculoData con los datos necesarios
            Vehículos vehiculoData = new Vehículos(
                    id,
                    fechaInicioFormateada,
                    fechaFinFormateada,
                    distanciaViaje,
                    tipoVehiculo,
                    totalGasolinaUtilizada
            );

            File archivo = new File("./Archivos/historias.bin");

            // Si el archivo existe, leer los datos existentes
            ArrayList<Vehículos> macaco = new ArrayList<>();
            if (archivo.exists()) {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo));
                macaco = (ArrayList<Vehículos>) inputStream.readObject();
                inputStream.close();
            }

            // Agregar el nuevo objeto al ArrayList existente
            macaco.add(vehiculoData);

            // Crear un ObjectOutputStream para escribir el objeto en un archivo
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo));

            // Escribir el ArrayList actualizado en el archivo
            outputStream.writeObject(macaco);

            // Cerrar el ObjectOutputStream
            outputStream.close();

            System.out.println("Datos del vehículo serializados y agregados al archivo historias.bin");
            guardarIdCounter();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }    
}
    
    private static void cargarIdCounter() {
        File archivoIdCounter = new File("./Archivos/idCounter.bin");
        if (archivoIdCounter.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoIdCounter))) {
                idCounter = (int) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void guardarIdCounter() {
        File archivoIdCounter = new File("./Archivos/idCounter.bin");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoIdCounter))) {
            outputStream.writeObject(idCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Date generarFechaHoraFin(Date fechaHoraInicio) {
        long diferenciaHoras = (long) (Math.random() * 5 + 1) * 3600 * 1000;

        // Calcular la fecha y hora de fin sumando la diferencia de horas a la fecha y hora de inicio
        return new Date(fechaHoraInicio.getTime() + diferenciaHoras);
    }
    
    public static void imprimirDatosSerializados() {
        try {
            File archivo = new File("./Archivos/historias.bin");

            if (archivo.exists()) {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo));
                ArrayList<Vehículos> datos = (ArrayList<Vehículos>) inputStream.readObject();
                inputStream.close();

               System.out.printf("%-5s %-25s %-25s %-25s %-15s %-15s\n",
                    "ID", "Fecha y hora de inicio", "Fecha y hora de fin", "Distancia total recorrida", "Tipo de vehículo", "Gasolina utilizada");
               
            for (Vehículos data : datos) {
                Vehículos vehiculo = new Vehículos(data.id, data.fechaHoraInicio, data.fechaHoraFin,
                                                    data.distanciaTotalRecorrida, data.vehiculo, data.gasolinaUtilizada);
                Listahistoria.add(vehiculo);
                System.out.printf("%-5d %-25s %-25s %-25d %-15s %-15.2f\n",
                        data.id, data.fechaHoraInicio, data.fechaHoraFin, data.distanciaTotalRecorrida, data.vehiculo, data.gasolinaUtilizada);
                }
            } else {
                System.out.println("El archivo historias.bin no existe.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Vehículos> leerDatosVehiculos() {
    ArrayList<Vehículos> listaVehiculos = new ArrayList<>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./Archivos/historias.bin"))) {
        // Leer el objeto del archivo y agregarlo a la lista, mientras haya objetos disponibles
        while (true) {
            Object obj = ois.readObject();
            if (obj instanceof Vehículos) {
                Vehículos vehiculo = (Vehículos) obj;
                listaVehiculos.add(vehiculo);
            }
        }
    } catch (EOFException e) {
        // Se alcanzó el final del archivo
    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }

    return listaVehiculos;
}

}

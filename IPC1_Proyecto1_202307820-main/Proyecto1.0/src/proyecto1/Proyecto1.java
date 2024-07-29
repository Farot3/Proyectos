
package proyecto1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Proyecto1 {
    public static int Codigos1 =500;
    public static int codigo=200;
    public static int Nomero = 1;
    public static int códigos=1;
    public static int CódigoDoc;
    public static int CódigoPac;
    
    public static ArrayList<Doctores> listaDoctores = new ArrayList<>();
    public static ArrayList<Doctores> listaDocHora = new ArrayList<>();
    public static ArrayList<Pacientes> listaPacientes = new ArrayList<>();
    public static ArrayList<Producto> listaProducto = new ArrayList<>();
    public static ArrayList<CitasContudoctor> listaHorarioCitas2 = new ArrayList<>();
    
    private static Map<Integer, List<String>> horariosPorDoctor = new HashMap<>();

    public static void main(String[] args) {
        Login ventana = new Login();
       
    }

    
    public static void Agregar_Doctores(int Código, String Nombre_Completo, String Género, int Edad, String Especialidad, String Teléfono, String Password){
        Doctores new_date= new Doctores(Código, Nombre_Completo, Género, Edad, Especialidad, Teléfono, Password);
        listaDoctores.add(new_date);
        Código++;
        
    }
    
        public static Object[][] convertirDatosDoctores_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = listaDoctores.size();
        Object[][] arreglo = new Object[filas][6];

        for (int i = 0; i < filas; i++) {
            Doctores doctor = listaDoctores.get(i);
            arreglo[i][0] = doctor.getCódigo();
            arreglo[i][1] = doctor.getNombre_Completo();
            arreglo[i][2] = doctor.getGénero();
            arreglo[i][3] = doctor.getEdad();
            arreglo[i][4] = doctor.getEspecialidad();
            arreglo[i][5] = doctor.getTeléfono();
        }

        
        
        return arreglo;
    }
        
        //Para la grafica
        public static ArrayList<Doctores> bubblesortEdadDoctores() {
        // Crear una copia de la lista para no modificar la lista original
        ArrayList<Doctores> copiaLista = new ArrayList<>(listaDoctores);

        // Obtener la cantidad de elementos en la lista
        int n = copiaLista.size();

        // Variable para controlar si se ha realizado algún intercambio en la iteración
        boolean cambiado;
        
        // Ciclo principal del algoritmo de ordenamiento burbuja
        do {
            // Inicializar la variable 'cambiado' en falso al principio de cada iteración
            cambiado = false;

            // Iterar a través de la lista
            for (int i = 1; i < n; i++) {
                // Comparar elementos adyacentes en la lista por sus notas
                if (copiaLista.get(i - 1).getEdad() < copiaLista.get(i).getEdad()) {
                    // Intercambiar los elementos si el elemento anterior tiene una nota menor que el siguiente
                    Doctores temp = copiaLista.get(i - 1);
                    copiaLista.set(i - 1, copiaLista.get(i));
                    copiaLista.set(i, temp);

                    // Marcar que se ha realizado un intercambio en esta iteración
                    cambiado = true;
                }
            }

            // Decrementar el valor de 'n' para reducir el rango de la lista en cada iteración
            n--;
        } while (cambiado); // Continuar el ciclo mientras se sigan realizando intercambios

        // Devolver la lista ordenada
        return copiaLista;
    }
        
        public static void Agregar_Pacientes(int Codigos, String Nombres, String Apellidos, String password, int Edad, String Género){
        Pacientes new_date= new Pacientes(Codigos, Nombres, Apellidos, password, Edad, Género);
        listaPacientes.add(new_date);     
        
        
    }
        
        
         public static Object[][] convertirDatosPacientes_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = listaPacientes.size();
        Object[][] arreglo = new Object[filas][5];

        for (int i = 0; i < filas; i++) {
            Pacientes paciente = listaPacientes.get(i);
            arreglo[i][0] = paciente.getCodigos();
            arreglo[i][1] = paciente.getNombres();
            arreglo[i][2] = paciente.getApellidos();
            arreglo[i][3] = paciente.getEdad();
            arreglo[i][4] = paciente.getGénero();
           
        }

        
        
        return arreglo;
    }
         
         public static void Agregar_Productos(int Codigo, String Nombre, int Cantidad, String Descripción, double Precio){
        Producto new_date= new Producto(Codigo, Nombre, Cantidad, Descripción, Precio);
        listaProducto.add(new_date);
    }
                
         
         
         public static Object[][] convertirDatosProducto_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = listaProducto.size();
        Object[][] arreglo = new Object[filas][5];

        for (int i = 0; i < filas; i++) {
            Producto produc = listaProducto.get(i);
            arreglo[i][0] = produc.getCodigo();
            arreglo[i][1] = produc.getNombre();
            arreglo[i][2] = produc.getCantidad();
            arreglo[i][3] = produc.getDescripción();
            arreglo[i][4] = produc.getPrecio();
           
        }

        
        
        return arreglo;
    }
         
         
         public static ArrayList<Producto> bubblesortCantidadProducto() {
        // Crear una copia de la lista para no modificar la lista original
        ArrayList<Producto> copiaLista1 = new ArrayList<>(listaProducto);

        // Obtener la cantidad de elementos en la lista
        int n = copiaLista1.size();

        // Variable para controlar si se ha realizado algún intercambio en la iteración
        boolean cambiado;
        
        // Ciclo principal del algoritmo de ordenamiento burbuja
        do {
            // Inicializar la variable 'cambiado' en falso al principio de cada iteración
            cambiado = false;

            // Iterar a través de la lista
            for (int i = 1; i < n; i++) {
                // Comparar elementos adyacentes en la lista por sus notas
                if (copiaLista1.get(i - 1).getCantidad()< copiaLista1.get(i).getCantidad()) {
                    // Intercambiar los elementos si el elemento anterior tiene una nota menor que el siguiente
                    Producto temp = copiaLista1.get(i - 1);
                    copiaLista1.set(i - 1, copiaLista1.get(i));
                    copiaLista1.set(i, temp);

                    // Marcar que se ha realizado un intercambio en esta iteración
                    cambiado = true;
                }
            }

            // Decrementar el valor de 'n' para reducir el rango de la lista en cada iteración
            n--;
        } while (cambiado); // Continuar el ciclo mientras se sigan realizando intercambios

        // Devolver la lista ordenada
        return copiaLista1;
    }
         
         public static void Agregar_horarios1(String horario, int Nomero ){
        Doctores new_date5= new Doctores(horario, Nomero);
        listaDocHora.add(new_date5);
         }
         
         
         
         public static Object[][] convertirHorarioDoc_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = listaDocHora.size();
        Object[][] arreglo = new Object[filas][2];

        for (int i = 0; i < filas; i++) {
            Doctores asigna = listaDocHora.get(i);
            arreglo[i][0] = asigna.getNomero();
            arreglo[i][1] = asigna.getHorario();
           
        }
    
        return arreglo;
    }
         
         public static Object[][] convertirDatosCitas_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = listaHorarioCitas2.size();
        Object[][] arreglo = new Object[filas][7];

        for (int i = 0; i < filas; i++) {
            CitasContudoctor cita = listaHorarioCitas2.get(i);
            arreglo[i][0] = cita.getPACNombre();
            arreglo[i][1] = cita.getHora();
            arreglo[i][2] = cita.getFecha();
            arreglo[i][3] = cita.getVermas();
            arreglo[i][4] = cita.getDoctor();
            arreglo[i][5] = cita.getCambio();
        }

        return arreglo;
 
         
    }
   
    public static void Agregar_cita(String vermas, String hora, String fecha, String cambio, String PACNombre, String Doctor) {
        CitasContudoctor new_date = new CitasContudoctor(vermas, hora, fecha, cambio, PACNombre, Doctor);
        listaHorarioCitas2.add(new_date);

    }
    
         
}
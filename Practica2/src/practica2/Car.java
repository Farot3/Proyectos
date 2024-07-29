package practica2;

import java.io.Serializable;
import java.util.ArrayList;

public class Car extends Thread implements Serializable{
    private static final long serialVersionUID = 1L; 
    boolean detenida = false; 
    Ventana ventana;
    int posmotx;
    int posmoty;
    private int distanciaTotal = 910; // La distancia total que deseas que la imagen se mueva
    private int paso = 2; // La cantidad de píxeles que la imagen se moverá en cada paso
    private int delay = 15; // El tiempo de espera entre cada movimiento en milisegundos
    private double gastoCombu = 0.45;
    private int captank = 12;
    private double totalcam = captank/gastoCombu;
    private int cami = (int) Math.round(totalcam);
    int distanciaViaje = obtenerDistanciaViaje("Vehículo Premium 1");
    private double macaco = cami * ((double) distanciaTotal / distanciaViaje);
    private int mac = (int) Math.round(macaco);
    private int distanciaActual = 0;
    public int totalGasolinaUtilizada7 = (int) (distanciaViaje * gastoCombu);
    
    public Car(Ventana ventana) {
        this.ventana = ventana;
        this.posmotx = this.ventana.labelcar.getX();
        this.posmoty = this.ventana.labelcar.getY();
        this.distanciaActual = ventana.getDistanciaActualCar();
        
    }

    @Override
    public void run() { // La distancia actual recorrida por la imagen
        int distanciaActuals = 0;
if(posmotx<910){
        while (distanciaActuals < mac) {   
            System.out.println(mac);
            if (posmotx >= distanciaTotal) {
            break; // Salir del bucle si se alcanza la posición límite
        }             
            distanciaActuals += paso;
            distanciaActual +=2;
            moveRight(paso);
            double a = ((double) distanciaActual / 840) * distanciaViaje;
            System.out.println(a);
            long aRedondeado = Math.round(a);
            int aEntero = (int) aRedondeado;
            double b = captank - gastoCombu*(((double)distanciaActuals*(distanciaViaje/840.0)));
            System.out.println(b);
            long bRedondeado = Math.round(b);
            int bEntero = (int) bRedondeado;
            ventana.GarCar.setLocation(posmotx + 160, posmoty + 20);
            ventana.GarCar.setText("Gasolina actual: " + bEntero);
            ventana.DistanCar.setLocation(posmotx + 20, posmoty);
            ventana.DistanCar.setText("Recorrido: " + aEntero + " km");
            try {
                Thread.sleep(delay); // Esperar antes de mover la imagen nuevamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (b <= 0) {
                detenida = true;
                break;
            }
        }
                    if (detenida) {
            ventana.GassCar.setVisible(true);
            ventana.GassCar.setLocation(posmotx + 150, posmoty);
            }
                    ventana.setDistanciaActualCar(distanciaActual);
    }else if(posmotx >= 910){
    int retroceso = posmotx - ventana.INICIO_LABEL_X;

    while (posmotx > ventana.INICIO_LABEL_X) {
        int movimiento = Math.min(paso, retroceso); // Determina cuánto puede retroceder en este paso
        moveLeft(movimiento); // Mueve la motocicleta hacia la izquierda
        System.out.println(movimiento);
        retroceso -= movimiento; // Actualiza la distancia de retroceso restante
        distanciaActual -= movimiento; // Disminuye la distancia actual
        try {
            Thread.sleep(delay); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    posmotx = ventana.INICIO_LABEL_X;
    ventana.labelcar.setLocation(posmotx, posmoty);

    distanciaActual = 0;
    ventana.setDistanciaActualCar(distanciaActual);
}}
    
    // Método para mover la imagen hacia la derecha
    private void moveRight(int pixels) {
        ventana.GassCar.setVisible(false);

        int x = posmotx;
        int y = posmoty;

        x += pixels;

        ventana.labelcar.setLocation(x, y);       
        ventana.GarCar.setLocation(posmotx + 160, posmoty + 20);
        ventana.DistanCar.setLocation(posmotx + 20, posmoty);

        posmotx = x;
    }
    
 private int obtenerDistanciaViaje(String tipoMotocicleta) {
        for (Viaje viaje : Practica2.listaViajes) {
            if (viaje.getTipoTransportem().equals(tipoMotocicleta)) {
                return viaje.getDistanciam();
            }
        }
        return 500;
    }
 
 private void moveLeft(int pixels) {
    ventana.GassCar.setVisible(false);

    int x = posmotx;
    int y = posmoty;

    x -= pixels;
     System.out.println(x);

    ventana.labelcar.setLocation(x, y);       
    ventana.GarCar.setLocation(posmotx + 160, posmoty + 20);
    ventana.DistanCar.setLocation(posmotx + 20, posmoty);

    posmotx = x;
}
}

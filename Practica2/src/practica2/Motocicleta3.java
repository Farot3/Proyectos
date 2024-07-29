package practica2;

import java.io.Serializable;
import java.util.ArrayList;

public class Motocicleta3 extends Thread implements Serializable{
    private static final long serialVersionUID = 1L; 
    boolean detenida = false; 
    Ventana ventana;
    int posmotx;
    int posmoty;
    private int distanciaTotal = 910; // La distancia total que deseas que la imagen se mueva
    private int paso = 2; // La cantidad de píxeles que la imagen se moverá en cada paso
    private int delay = 15; // El tiempo de espera entre cada movimiento en milisegundos
    private double gastoCombu = 0.1;
    private int captank = 6;
    private double totalcam = captank/gastoCombu;
    private int cami = (int) Math.round(totalcam);
    int distanciaViaje = obtenerDistanciaViaje("Motocicleta 3");
    private double macaco = cami * ((double) distanciaTotal / distanciaViaje);
    private int mac = (int) Math.round(macaco);
    private int distanciaActual = 0;
    public int totalGasolinaUtilizada3 = (int) (distanciaViaje * gastoCombu);    
    
    public Motocicleta3(Ventana ventana) {
        this.ventana = ventana;
        this.posmotx = this.ventana.labelImagen3.getX();
        this.posmoty = this.ventana.labelImagen3.getY();
        this.distanciaActual = ventana.getDistanciaActual3();
        
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
            double a = ((double) distanciaActual / 786.79) * distanciaViaje;
            System.out.println(a);
            long aRedondeado = Math.round(a);
            int aEntero = (int) aRedondeado;
            double b = captank - gastoCombu*(((double)distanciaActuals*(distanciaViaje/790.0)));
            System.out.println(b);
            long bRedondeado = Math.round(b);
            int bEntero = (int) bRedondeado;
            ventana.Gasmot3.setLocation(posmotx + 160, posmoty + 20);
            ventana.Gasmot3.setText("Gasolina actual: " + bEntero);
            ventana.Distanciamot3.setLocation(posmotx + 20, posmoty);
            ventana.Distanciamot3.setText("Recorrido: " + aEntero + " km");
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
            ventana.GassMot3.setVisible(true);
            ventana.GassMot3.setLocation(posmotx + 150, posmoty);
            }
                    ventana.setDistanciaActual3(distanciaActual);
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
    ventana.labelImagen3.setLocation(posmotx, posmoty);

    distanciaActual = 0;
    ventana.setDistanciaActual3(distanciaActual);
}
    }
    
    // Método para mover la imagen hacia la derecha
    private void moveRight(int pixels) {
        ventana.GassMot3.setVisible(false);

        int x = posmotx;
        int y = posmoty;

        x += pixels;

        ventana.labelImagen3.setLocation(x, y);       
        ventana.Gasmot3.setLocation(posmotx + 160, posmoty + 20);
        ventana.Distanciamot3.setLocation(posmotx + 20, posmoty);

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
    ventana.GassMot3.setVisible(false);

    int x = posmotx;
    int y = posmoty;

    x -= pixels;
     System.out.println(x);

    ventana.labelImagen3.setLocation(x, y); 
    ventana.Gasmot3.setLocation(posmotx + 160, posmoty + 20);
    ventana.Distanciamot3.setLocation(posmotx + 20, posmoty);

    posmotx = x;
}
}

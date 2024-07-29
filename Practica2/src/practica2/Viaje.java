
package practica2;

public class Viaje {
    private String tipoTransportem;
    private String puntoIniciom;
    private String puntoFinm;
    private int distanciam;

    public Viaje(String tipoTransportem, String puntoIniciom, String puntoFinm, int distanciam) {
        this.tipoTransportem = tipoTransportem;
        this.puntoIniciom = puntoIniciom;
        this.puntoFinm = puntoFinm;
        this.distanciam = distanciam;
    }

    public String getTipoTransportem() {
        return tipoTransportem;
    }

    public void setTipoTransportem(String tipoTransportem) {
        this.tipoTransportem = tipoTransportem;
    }

    public String getPuntoIniciom() {
        return puntoIniciom;
    }

    public void setPuntoIniciom(String puntoIniciom) {
        this.puntoIniciom = puntoIniciom;
    }

    public String getPuntoFinm() {
        return puntoFinm;
    }

    public void setPuntoFinm(String puntoFinm) {
        this.puntoFinm = puntoFinm;
    }

    public int getDistanciam() {
        return distanciam;
    }

    public void setDistanciam(int distanciam) {
        this.distanciam = distanciam;
    }
    
    
}

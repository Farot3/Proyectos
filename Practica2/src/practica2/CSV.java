
package practica2;

public class CSV {
    private int id;
    private String Inicio;
    private String Fin;
    private int distancia;

    public CSV(int id, String Inicio, String Fin, int distancia) {
        this.id = id;
        this.Inicio = Inicio;
        this.Fin = Fin;
        this.distancia = distancia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInicio() {
        return Inicio;
    }

    public void setInicio(String Inicio) {
        this.Inicio = Inicio;
    }

    public String getFin() {
        return Fin;
    }

    public void setFin(String Fin) {
        this.Fin = Fin;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}

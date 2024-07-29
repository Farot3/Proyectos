
package proyecto1;


public class CitasContudoctor {
    private String vermas;
    private String hora;
    private String fecha;
    private String cambio;
    private String PACNombre;
    private String Doctor;

    public CitasContudoctor(String vermas, String hora, String fecha, String cambio, String PACNombre, String Doctor) {
        this.vermas = vermas;
        this.hora = hora;
        this.fecha = fecha;
        this.cambio = cambio;
        this.PACNombre = PACNombre;
        this.Doctor = Doctor;
    }

    public String getVermas() {
        return vermas;
    }

    public void setVermas(String vermas) {
        this.vermas = vermas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getPACNombre() {
        return PACNombre;
    }

    public void setPACNombre(String PACNombre) {
        this.PACNombre = PACNombre;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }
}



package proyecto1;


public class Doctores {
    private int Código;
    private String Nombre_Completo;
    private String Género;
    private int Edad;
    private String Especialidad;
    private String Teléfono;
    private String Password;
    private String horario;
    private int Nomero;

    public Doctores(String horario, int Nomero) {
        this.horario = horario;
        this.Nomero = Nomero;
    }

    public int getNomero() {
        return Nomero;
    }

    public void setNomero(int Nomero) {
        this.Nomero = Nomero;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
 
    public Doctores(int Código, String Nombre_Completo, String Género, int Edad, String Especialidad, String Teléfono, String Password) {
        this.Código = Código;
        this.Nombre_Completo = Nombre_Completo;
        this.Género = Género;
        this.Edad = Edad;
        this.Especialidad = Especialidad;
        this.Teléfono = Teléfono;
        this.Password = Password;

    }

    public int getCódigo() {
        return Código;
    }

    public void setCódigo(int Código) {
        this.Código = Código;
    }

    public String getNombre_Completo() {
        return Nombre_Completo;
    }

    public void setNombre_Completo(String Nombre_Completo) {
        this.Nombre_Completo = Nombre_Completo;
    }

    public String getGénero() {
        return Género;
    }

    public void setGénero(String Género) {
        this.Género = Género;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getTeléfono() {
        return Teléfono;
    }

    public void setTeléfono(String Teléfono) {
        this.Teléfono = Teléfono;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

   
}
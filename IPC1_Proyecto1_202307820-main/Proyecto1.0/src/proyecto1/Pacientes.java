

package proyecto1;


public class Pacientes {
   private int Codigos;
    private String Nombres;
    private String Apellidos;
    private String Password;
    private int Edad;
    private String Género;
    private String Estado;
    private String Fecha;
    

    public Pacientes(int Codigos, String Nombres, String Apellidos, String Password, int Edad, String Género) {
        this.Codigos = Codigos;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Password = Password;
        this.Edad = Edad;
        this.Género = Género;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    public int getCodigos() {
        return Codigos;
    }

    public void setCodigos(int Codigos) {
        this.Codigos = Codigos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getGénero() {
        return Género;
    }

    public void setGénero(String Género) {
        this.Género = Género;
    }
  
    
}
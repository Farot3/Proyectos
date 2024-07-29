class Usuario {

    constructor(carnet, nombre, apellidos, genero, correo, facultad, carrera, password, confirmar){
        this.carnet = carnet
        this.nombre = nombre
        this.apellidos = apellidos
        this.genero = genero
        this.facultad = facultad
        this.correo = correo
        this.carrera = carrera
        this.password = password
        this.confirmar = confirmar

    }

}

module.exports = Usuario;
const { list_users } = require("../datalist/list");
const Usuario = require("../objetos/Usuario");



function Registro(req, res){
    try{
        const data = req.body;
        const newUser = new Usuario(data.carnet, data.nombre, data.apellidos, data.genero, data.correo, data.facultad, data.carrera, data.password, data.confirmar);

        list_users.push(newUser);

        res.json({mensaje : "Usuario registrado."})

    }catch (error){
        console.log(error)
        res.json({mensaje : "Ocurrio un error al registrarse"})


    }
}

function  Login(req, res){
    try{
        const {carnet, password} = req.body;
        const usuario = list_users.find(find_user => find_user.carnet == carnet && find_user.password == password)

        if(usuario){
            res.json({mensaje : "Usuario ha iniciado sesión", 
            user: {
                carnet: usuario.carnet,
                nombre: usuario.nombre,
                apellidos: usuario.apellidos,
                genero: usuario.genero,
                correo: usuario.correo,
                facultad: usuario.facultad,
                carrera: usuario.carrera,
                confirmar: usuario.confirmar
            }, 
            error : false})
        }else{
            res.json({mensaje : "Usuario no esta en el sistema", error : true})
        }
    }catch (error){
        console.log(error)
        res.json({mensaje : "Ocurrio un error al registrarse"})


    }
}


function GetUsers(req, res){
    try{
        res.json({mensaje : "Exito", usuarios: list_users})

    }catch (error){
        console.log(error)
        res.json({mensaje : "Ocurrio un error al hacer el registro"})

    }

}

function calficacion(req, res){
    try{
        const {nombre} = req.body
        const usuario = nombre;

        if(usuario){
            res.json({mensaje: "Hola",  usuario})
        }else{
            res.json({mensaje : "este nombre no esta en el sistema", error : true})
        }
    }catch{
        console.log(error)
        res.json({mensaje : "Ocurrio un error al escribir"})
    }

}


module.exports = {
    Registro,
    GetUsers,
    Login,
    calficacion
}
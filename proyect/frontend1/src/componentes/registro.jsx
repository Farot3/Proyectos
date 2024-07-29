import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';

const Registro = () => {

    const [carnet, setCarnet] = useState('');
    const [password, setPass] = useState('');
    const [nombre, setNombre] = useState('');
    const [apellidos, setApellidos] = useState('');
    const [facultad, setFacultad] = useState('');
    const [genero, setGenero] = useState('');
    const [correo, setCorreo] = useState('');
    const [carrera, setCarrera] = useState('');
    const [confirmar, setConfirmar] = useState('');

    const navigate = useNavigate(); 

    const handleSubmit = async (event) => {
        event.preventDefault();

        try{
            if (password != confirmar){
                alert("La contraseña no coincide con confirmar contraseña");
                return;
            }
            const response = await fetch('http://localhost:5000/Registro', {
                method : "Post",
                headers : {
                    'Content-Type' : 'application/json'
                },
                body: JSON.stringify({carnet, password, nombre, apellidos, facultad, genero, correo, carrera, confirmar}),
                
        })

        const data = await response.json();

        console.log(data)
            alert(data.mensaje)



        }catch(error){

            console.log('Error en la solicitud', error)
        }

    };

    return (
        <div className = 'd-flex align-items-center justify-content-center' style={{minHeight : '102vh'}}>
            <div className="form-signin p-3 mb-2 bg-transparent border border-danger row g-2" style={{width: '100%', maxWidth: '700px', borderRadius: '10%'}}>

            <form onSubmit={handleSubmit}>
                <img className="mb-4" src="https://cdn-icons-png.flaticon.com/512/5087/5087579.png" alt="" width="72" height="72" />
                <h1 className="text-warning h3 mb-3 fw-normal">USocial-Registro</h1>

                    <div className="form-floating mb-2">
                        <input required type="text" className="form-control" id="floatingInput" placeholder="name@example.com" value={carnet} onChange={(e) => setCarnet(e.target.value)}/>
                        <label for="floatingInput">Carné</label>
                    </div>

            <div className="row">
                <div class="col">
                    <div className="form-floating mb-2">
                        <input required type="text" className="form-control" id="floatingNombre" placeholder="nombre" value={nombre} onChange={(e) => setNombre(e.target.value)}/>
                        <label for="floatingNombre">Nombre</label>
                    </div>

                    <div className="form-floating mb-2">
                        <input required type="text" className="form-control" id="floatingGenero" placeholder="Genero" value={genero} onChange={(e) => setGenero(e.target.value)}/>
                        <label for="floatingGenero">Ingrese su Genero en M/F</label>
                    </div>

                    <div className="form-floating mb-2">
                        <input required type="text" className="form-control" id="floatingFacultad" placeholder="Facultad" value={facultad} onChange={(e) => setFacultad(e.target.value)}/>
                        <label for="floatingFacultad">Ingrese su facultad</label>
                    </div>

                    <div className="form-floating mb-2">
                        <input required type="password" className="form-control" id="floatingPassword" placeholder="Password" value={password} onChange={(e) => setPass(e.target.value)}/>
                        <label for="floatingPassword">Contraseña</label>
                    </div> 
                </div>

                <div className="col">
                    <div className="form-floating mb-2">
                        <input required type="text" className="form-control" id="floatingApellidos" placeholder="Apellidos" value={apellidos} onChange={(e) => setApellidos(e.target.value)}/>
                        <label for="floatingApellidos">Apellidos</label>
                    </div>

                    <div className="form-floating mb-2">
                        <input required type="text" className="form-control" id="floatingCorreo" placeholder="name@example.com" value={correo} onChange={(e) => setCorreo(e.target.value)}/>
                        <label for="floatingCorreo">Correo electrónico</label>
                    </div>

                    <div className="form-floating mb-2">
                        <input required type="text" className="form-control" id="floatingCarrera" placeholder="Carrera" value={carrera} onChange={(e) => setCarrera(e.target.value)}/>
                        <label for="floatingCarrera">Ingrese su carrera</label>
                    </div>

                    <div className="form-floating mb-2">
                        <input required type="password" className="form-control" id="floatingConfirmar" placeholder="Confirmar" value={confirmar} onChange={(e) => setConfirmar(e.target.value)}/>
                        <label for="floatingConfirmar">Confirmar contraseña</label>
                    </div>
                </div>
            </div>

                <button className="btn btn-success w-100 py-2" type="submit">Registro</button>
            </form>

            <p className="mt-3 mb-0 text-center">
                    ¿Ya tienes una cuenta? <button className="btn btn-secondary  btn-sm" onClick={() => navigate('/Principal')}>Inicia sesion aquí</button>.
                </p>

            </div>
        </div>

    );
};
export default Registro;
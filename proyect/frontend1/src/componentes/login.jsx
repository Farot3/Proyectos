import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import Cookies from 'js-cookie';

const Login = () => {

    const [carnet, setCarnet] = useState('');
    const [pass, setPass] = useState('');
    const navigate = useNavigate();


    const handleSubmit = async (event) => {
        event.preventDefault();
if(carnet == "12024" && pass == "@dminIPC1"){
    alert("Bienvenido Admin")
    navigate('/admin')
}else{
        try{
            const response = await fetch('http://localhost:5000/Login', {
                method : "Post",
                headers : {
                    'Content-Type' : 'application/json'
                },
                body: JSON.stringify({carnet : carnet, password : pass}),
        })

        const data = await response.json();

        console.log(data)
        if(!data.error){
            alert(data.mensaje)
            Cookies.set('usuario', data.user.carnet)
            navigate('/create')
        }else{
            alert(data.mensaje)
        }


        }catch(error){

            console.log('Error en la solicitud', error)
        }
    }
    };

    return (
        <div className = 'd-flex align-items-center justify-content-center' style={{minHeight : '100vh'}}>
            <div className="form-signin p-3 mb-2 bg-transparent border border-danger" style={{width: '100%', maxWidth: '400px', borderRadius: '10%'}}>

            <form onSubmit={handleSubmit}>
                <img className="mb-4" src="https://cdn-icons-png.flaticon.com/512/5087/5087579.png" alt="" width="72" height="72" />
                <h1 className="text-warning h3 mb-3 fw-normal">USocial-Inicio de sesión</h1>
                <div className= "macaco">
                <div className="form-floating">
                    <input required type="text" className="form-control" id="floatingInput" placeholder="name@example.com" value={carnet} onChange={(e) => setCarnet(e.target.value)}/>
                    <label for="floatingInput">Carné</label>
                </div>
                
                <div className="b-example-divider"></div>

                <div className="form-floating">
                    <input required type="password" className="form-control" id="floatingPassword" placeholder="Password" value={pass} onChange={(e) => setPass(e.target.value)}/>
                    <label for="floatingPassword">Contraseña</label>
                </div>
                </div>
                <button className="btn btn-success w-100 py-2" type="submit">Iniciar sesión</button>
            </form>

            <p className="mt-3 mb-0 text-center">
                    ¿Aun no tienes una cuenta? <button className="btn btn-secondary  btn-sm" onClick={() => navigate('/Registro')}>Registrate aquí</button>.
                </p>

            </div>
        </div>
    );

};
export default Login
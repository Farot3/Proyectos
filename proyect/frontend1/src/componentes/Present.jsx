import React from 'react';
import { useNavigate } from 'react-router-dom';
import Logo from '../Imagenes/Logo.png';
import logos from '../Imagenes/logos.png';

function Principal ({ activeWindow }) {
    const navigate = useNavigate();
  return (  
    

    <div>
             <svg xmlns="http://www.w3.org/2000/svg" className="d-none">
      <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
      </symbol>
    </svg>

    <div className='imagen'>
    <img width= '300' height='300'src={Logo} alt="Logo" />
    </div>

    <div className='imagens'>
    <img width= '300' height='300'src={logos} alt="logos" />
    </div>

<div className = "Titulo">
<h1 className='display-1'><strong>Usocial</strong></h1>
</div>

<div className='texto1'>
 <p className='border border-success rounded p-2 mb-2 f s-3'>Bienvenidos a League of USocial</p>   
</div>

<div className='DescripcionTitulo border border-success rounded p-2 mb-2'>
  <h2 className=' fs-2'>
    Descripción de la web
  </h2>
</div>

<div className='Descripción border border-success rounded '>
<p className='fs-3 text-center fw-bold'>
Funcionalidades del foro
</p>
<p className=' fs-4 '>
  Esta pagina se trata en poder tener comunicación con todos,
  en sí es una red social
  en la cual todos podrán comunicarse entre unos y otros y así poder compartir,
  pero esta pagina más que todo lo unico que se puede hacer, es poder publicar post,
  ¿Cómo es eso de post? Pues es donde se pueden publicar imagenes o un texto, también se
  puede comentar en ese post que se publican.
</p>
<p className='fs-3 text-center fw-bold'>
  Registro de Inicio de sesión
</p>
<p className='fs-4' >
  En este apartado podras ver como registrarte con tus datos.
</p>
<p className='fs-3 text-center fw-bold'>
  Pagina de inicio
</p>
<p className='fs-4'>
  En este apartado veremos como iniciar sesión tus datos que sería carné y contraseña.
</p>
<p className='fs-3 text-center fw-bold'>
  Edición de perfil
</p>
<p className='fs-4'>
  En este apartado veremos como editar tu perfil, en el cual se puede cambiar tus datos de perfil.
</p>
<p className='fs-3 text-center fw-bold'>
  Creación de posts
</p>
<p className='fs-4'>
  Todos los usuario pueden crear un post que es una publicación, con la cual puede ser de imagen o 
  también algo escrito que quieran publicar en el posts. Estas publicaciones estarán subidas en el
  apartado de posts o publicaciones, en la cual esas publicaciones estan para todos los usuarios.
</p>
<p className='fs-3 text-center fw-bold'>
  Administrador
</p>
<p className='fs-4'>
  En esta ventana es un usuario único en la cual este usuario podra ver todos los usuarios
  que se han registrado en la U-social o en la red social, también este usuario en la cual
  es el administrador puede eliminar usuario y también poder ver los datos de todos los usuarios
  en la cual se han registrado en la pagina.
</p>
</div>
<div className='DescripcionTitulo2 border border-success rounded p-2 mb-2'>
  <h2 className=' fs-2'>
    Acerca de 
  </h2>
</div>

<div className='Descripción2 border border-success rounded '>
<p className='fs-4'>Nuestra misión primordial consiste en fomentar la unión, la cooperación y el intercambio de ideas 
  en la comunidad estudiantil.

  Concebido por y para estudiantes, nuestro propósito es proporcionar un entorno seguro y estimulante 
  donde puedas expresarte sin restricciones, compartir tus vivencias, debatir sobre temas relevantes y 
  mantenerte informado acerca de los últimos acontecimientos en el campus.

  Independientemente de si deseas compartir tus reflexiones, participar en conversaciones, hallar compañeros 
  de estudio o simplemente estar al tanto de las novedades y tendencias universitarias, en USocial encontrarás 
  todas las herramientas que necesitas.
</p>
</div>
<div className='ContactoSop border border-success rounded p-2 mb-2'>
  <h2 className=' fs-2'>
    Contacto de Soporte
  </h2>
</div>

<div className='Soporte border border-success rounded '>
<p className='fs-4'>
  Celular: 35764052
</p>
<p className='fs-4'>
  Correo: 3057983670301@ingenieria.usac.edu.gt
</p>
<p className='fs-4'>
  Instagram: vasquez_pf
</p>
<p className='fs-4'>
  Facebook: Ottoniel Vásquez
</p>
</div>

<div className='Datos border border-success rounded p-2 mb-2'>
  <h2 className=' fs-2'>
    Información del creador
  </h2>
</div>

<div className='DatosDescripción border border-success rounded '>
<p className='fs-4'>
  Nombre: Ottoniel Fabricio Vásquez Pineda  
</p>
<p className='fs-4'>
  Carné: 202307820
</p>
<p className='fs-4'>
  Carrera: ingeniería en Ciencias y Sistemas
</p>
<p className='fs-4'>
  Sección: D
</p>
<p className='fs-4'>
  Edad: 18 años
</p>
<p className='fs-4'>
  Celular: 35764052
</p>
<p className='fs-4'>
  Correo: attuniel12@gmail.com
</p>
</div>

    <div className="container">
    <header className="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <ul className="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0 fs-4">        
      </ul>

      <div className="col-md-3 text-end">
        <button type="button" className="btn btn-outline-primary me-2" onClick={() => navigate('/Principal')}>Iniciar sesión</button>
        <button type="button" className="btn btn-primary" onClick={() => navigate('/Registro')}>Registrarse</button>
      </div>
    </header>
  </div>
    </div>
  );
};

export default Principal;

import React from 'react';
import { Link,  } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

function Header({ activeWindow }) {
    const navigate = useNavigate();
    return (
        <nav className="navbar navbar-expand-lg">
        <div className="container-fluid">
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarText">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link to="/admin" className={`nav-link active ${activeWindow === 'admin' && 'active'}`} aria-current="page" ><strong>Usuarios</strong>
                </Link>
              </li>
              <li className="nav-item">
              <Link to="/adminPost" className={`nav-link active ${activeWindow === 'adminPost' && 'active'}`} aria-current="page"><strong>Publicaciones</strong>
              </Link>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#"><strong>UsuarioMasivo</strong></a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#"><strong>PublicaciónMasiva</strong></a>
              </li>
              <div className="col-md-3 text-end">
                <button type="button" className="btn btn-outline-primary me-2" onClick={() => navigate('/')}>Inicio</button>
            </div>
            </ul>
          </div>
        </div>
      </nav>
    );


}

export default Header;
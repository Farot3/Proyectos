import './App.css';
import Login from './componentes/login';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Registro from './componentes/registro';
import Administrador from './componentes/admin';
import CreatePosts from './componentes/create';
import Posts from './componentes/posts';
import EjemploLineas from './componentes/Barras';
import Reportes from './componentes/reportes';
import Present from './componentes/Present';
import Edicion from './componentes/Edicion';
import AdministradorPost from './componentes/adminPost';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/Principal" element ={<Login/>} />    
        <Route path='/edición' element ={<Edicion/>}/>  
        <Route path="/" element ={<Present />} />
        <Route path="/registro" element ={<Registro />} />
        <Route path="/admin" element ={<Administrador />} />
        <Route path="/adminPost" element ={<AdministradorPost />} />
        <Route path="/create" element ={<CreatePosts />} />
        <Route path="/list" element ={<Posts />} />
        <Route path="/barras" element ={<EjemploLineas />} />
        <Route path="/reportes" element ={<Reportes />} />
      </Routes>
    </Router>
  );
}

export default App;

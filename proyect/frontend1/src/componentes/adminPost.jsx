import React, { useState, useEffect } from 'react'; // Importa React, el hook useState y el hook useEffect 
import { Modal, Button } from 'react-bootstrap'; // Importa componentes de React Bootstrap
import Header from './header';

function AdministradorPost  ()  {
    const [posts, setPosts] = useState([]); // Declara el estado 'users' para almacenar la lista de usuarios
    const [selectedPost, setSelectedPost] = useState(null); // Declara el estado 'selectedUser' para almacenar el usuario seleccionado
    const [validarEliminacion, setValidarEliminacion] = useState(false); // Declara el estado 'validarEliminacion' para controlar la eliminación de usuarios


    useEffect(() => {
        //  setPosts(exampleData);
    
          const fetchData = async () => {
          try {
              const response = await fetch('http://localhost:5000/posts', {
              method: 'GET',
            });
            if (response.ok) {
              const data = await response.json();
              setPosts(data.posts);
             }
             } catch (error) {
           console.error('Error al realizar la solicitud:', error);
          }
      };
    
    fetchData();
    }, [validarEliminacion]);


    const deletePost = async (carnet) => { // Define una función para eliminar un usuario
        try {
            const response = await fetch('http://localhost:5000/delete_post', {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ carnet: carnet }),
            });

            const data = await response.json();
            console.log(data)

            if (! data.error) {
                alert(data.msj)
                setValidarEliminacion(!validarEliminacion);
            } else {
                alert(data.msj);                
            }
        } catch (error) {
            console.error('Error al realizar la solicitud:', error);
        }
        
    };

    const viewPost = (post) => { // Define una función para mostrar los detalles de un usuario
        setSelectedPost(post); // Actualiza el estado 'selectedUser' con el usuario seleccionado
    };

    const handleClose = () => { // Define una función para cerrar el modal
        setSelectedPost(null); // Actualiza el estado 'selectedUser' para que no haya ningún usuario seleccionado
    };



    return ( // Devuelve el contenido JSX que representa el componente
    <div className = 'App'>

        <Header activeWindow = "adminPost"/>
        <div className='UsocialTitulo p-3'>
            <h2 className=' fs-2'>
                Posts de USocial
            </h2>
        </div>
         <div className = 'content' style={{width: '145ch',height: '60vh'}}> 

         <div className="table-container"> {/* Contenedor de la tabla */}
        <table className="table table-bordered text-center"> {/* Tabla con bordes y alineación centrada */}
            <thead className="table-dark">
                <tr> 
                    <th>Carnet</th> 
                    <th>Descripcion</th> 
                    <th>Categoría</th> 
                    <th>Anonimo</th> 
                    <th>Acciones</th> 
                </tr>
            </thead>
            <tbody>
                {posts.map(post => ( // Mapea cada usuario en la lista 'users' y renderiza una fila de la tabla para cada usuario
                    <tr key={post.id}> {/* Fila de la tabla con clave única basada en el carnet del usuario */}
                        <td>{post.carnet}</td> {/* Celda con el carnet del usuario */}
                        <td>{post.text}</td> {/* Celda con el nombre del usuario */}
                        <td>{post.anonimo}</td>
                        <td>{post.apellidos}</td>
                        <td>
                            <button className="btn btn-danger" onClick={() => deletePost(post.carnet)}>Eliminar</button> {/* Botón para eliminar el usuario */}
                            <button className="btn btn-primary" onClick={() => viewPost(post)}>Ver</button> {/* Botón para ver los detalles del usuario */}
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
        {selectedPost && ( /* Renderiza un modal si hay un usuario seleccionado */
            <Modal show={true} onHide={handleClose}> {/* Modal que se muestra si 'selectedUser' es verdadero y se cierra al hacer clic fuera de él */}
                <Modal.Header closeButton> {/* Cabecera del modal con un botón para cerrar */}
                    <Modal.Title>Detalles del Usuario</Modal.Title> {/* Título del modal */}
                </Modal.Header>
                <Modal.Body> {/* Cuerpo del modal */}
                    <p><strong>Carnet:</strong> {selectedPost.carnet}</p> {/* Muestra el carnet del usuario */}
                    <p><strong>Nombre:</strong> {selectedPost.nombre}</p> {/* Muestra el nombre del usuario */}
                    <p><strong>Apellidos:</strong> {selectedPost.apellidos}</p> {/* Muestra la edad del usuario */}
                    <p><strong>Género:</strong> {selectedPost.genero}</p>
                    <p><strong>Facultad:</strong> {selectedPost.facultad}</p> {/* Muestra la facultad del usuario */}
                    <p><strong>Carrera:</strong> {selectedPost.carrera}</p>                   
                </Modal.Body>
                <Modal.Footer> {/* Pie del modal */}
                    <Button variant="secondary" onClick={handleClose}> {/* Botón para cerrar el modal */}
                        Cerrar
                    </Button>
                </Modal.Footer>
            </Modal>
        )}
          </div>
        </div>
    </div>

);

}

export default AdministradorPost;
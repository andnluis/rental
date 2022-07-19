import React from "react";

const PerfilUsuario = (props) =>{


    return(
        <div>
            <ul class="perfil">
                    {
                        props.data.map(content =>(
                            <li>
                                <span><strong>Nombre: </strong>{content.nombre}</span>
                                <span><strong>Apellido: </strong>{content.apellido}</span>
                            </li>
                        ))
                    }
            </ul>
        </div>
    );
}

export default PerfilUsuario
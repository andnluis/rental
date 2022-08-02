import React from "react";
import '../styles/registro.css'
import { Link } from "react-router-dom";

const Inigoogle = () => {
    return (
        <div class="d-grid gap-2">
                  <Link to="/inicioSesionGoogle" type="button" class="btn btn-warning">Iniciar sesion con Google</Link>
                    
                </div>
      );
    //boton de redireccionamiento al inicio de sesion con google
  };

export default Inigoogle;
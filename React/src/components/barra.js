import { Link } from "react-router-dom";
import React from "react";

const Barra = () => {
  return (
    <nav class="navbar navbar-dark bg-dark">
      <a class="navbar-brand">
        <img
          src={process.env.PUBLIC_URL + "logo.png"}
          height="86px"
          width="320px"
        ></img>
      </a>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <Link to="/" type="button" class='btn btn-warning me-md-2'>Ver Catalogo</Link>
        <Link to="/Registro" type="button" class='btn btn-warning me-md-2'>Registrarse</Link>
        <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'>Iniciar sesion</Link>
        <Link to="/Carro" type="button" class='btn btn-warning me-md-2'>Carrito</Link>
      </div>
    </nav>
  );
  //coment
};

export default Barra;

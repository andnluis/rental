import { Link } from "react-router-dom";
import React from "react";

const Barra = () => {

  const cliente = (
  <>
  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <Link to="/" type="button" class='btn btn-warning me-md-2'>Ver Catalogo</Link>
        <Link to="/Carro" type="button" class='btn btn-warning me-md-2'><img src={process.env.PUBLIC_URL + "cart.svg"} width="20px" height={"20px"}></img></Link>
        <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'><img src={process.env.PUBLIC_URL + "profile.svg"} width="20px" height={"20px"}></img></Link>
        <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'><img src={process.env.PUBLIC_URL + "out.svg"} width="20px" height={"20px"}></img></Link>
    </div>
  </>
  );
  
  const propietario = (
    <>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
          <Link to="/" type="button" class='btn btn-warning me-md-2'>Ver Catalogo</Link>
          <Link to="/Carro" type="button" class='btn btn-warning me-md-2'><img src={process.env.PUBLIC_URL + "plus.svg"} width="20px" height={"20px"}></img></Link>
          <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'>Dashboard</Link>
          <Link to="/Carro" type="button" class='btn btn-warning me-md-2'><img src={process.env.PUBLIC_URL + "cart.svg"} width="20px" height={"20px"}></img></Link>
    <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'><img src={process.env.PUBLIC_URL + "profile.svg"} width="20px" height={"20px"}></img></Link>
          <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'><img src={process.env.PUBLIC_URL + "out.svg"} width="20px" height={"20px"}></img></Link>
      </div>
    </>
    );
    const invitado = (
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <Link to="/" type="button" class='btn btn-warning me-md-2'>Ver Catalogo</Link>
        <Link to="/Registro" type="button" class='btn btn-warning me-md-2'>Registrarse</Link>
        <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'>Iniciar sesion</Link>
      </div>
    
  );

  return (
    <nav class="navbar navbar-dark bg-dark">
      <a class="navbar-brand">
        <img
          src={process.env.PUBLIC_URL + "logo.png"}
          height="86px"
          width="320px"
        ></img>
      </a>
        {invitado}
    </nav>
  );
  //coment
};

export default Barra;

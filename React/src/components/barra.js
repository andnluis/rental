import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import React from "react";

const Barra = () => {

    
    const linksInvitado = (<>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <Link to="/Registro" type="button" class='btn btn-warning me-md-2'>Registrarse</Link>
        <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2'>Iniciar sesion</Link>
        </div>
    </>);

    const linksCli = (<>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <Link to="/Registro" type="button" class='btn btn-warning me-md-2'>Ver Catalogo</Link>
            <div class="btn-group" role="group" aria-label="Basic example">
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "notification.svg"} height="25px" width="25px"></img></button>
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "cart.svg"} height="25px" width="25px"></img></button>
            </div>
            <div class="btn-group" role="group" aria-label="Basic example">
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "profile.svg"} height="25px" width="25px"></img></button>
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "out.svg"} height="25px" width="25px"></img></button>
            </div>
        </div>
    </>);
    const linksProp = (<>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <Link to="/Registro" type="button" class='btn btn-warning me-md-2'>Ver Catalogo</Link>
            <div class="btn-group" role="group" aria-label="Basic example">
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "plus.svg"} height="25px" width="25px"></img></button>
              <button type="button" class="btn btn-warning me-md-2">Dashboard</button>
            </div>
            
            <div class="btn-group" role="group" aria-label="Basic example">
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "notification.svg"} height="25px" width="25px"></img></button>
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "cart.svg"} height="25px" width="25px"></img></button>
            </div>
            <div class="btn-group" role="group" aria-label="Basic example">
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "profile.svg"} height="25px" width="25px"></img></button>
              <button type="button" class="btn btn-warning me-md-2"><img src={process.env.PUBLIC_URL + "out.svg"} height="25px" width="25px"></img></button>
            </div>
            </div>
    </>);
    


  return (
    <div>

    <nav class="navbar navbar-dark bg-dark">
      <a class="navbar-brand">
        <img
          src={process.env.PUBLIC_URL + "logo.png"}
          height="86px"
          width="320px"
          ></img>
      </a>
          {linksInvitado}
    </nav>
          </div>
  );
};

export default Barra;

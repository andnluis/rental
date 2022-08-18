import React, { useState, useContext } from "react";
import axios from "axios";
import "../styles/registro.css";
import { UsuarioContext } from "../context/UsuarioContext";
import { Link } from "react-router-dom";

const Verificacion = () => {
  const { userData, userRenta } =
    useContext(UsuarioContext);
  const { username, clave, email, nombre, telefono, tipo } = userData;

  const inicial = {
    imagen: ""

  };

  console.log(userRenta)

  const handleInputChange = (event) => {

  };

  const enviarVerificacion = (event) => {
    
  };

  return (
    <div class="centrado">
      <div class="container text-center">
        <div class="row">
          <div class="col">
            <h1 class="display-6 text-center">
              Ingresar recibo
            </h1>
          </div>
        </div>
        <div class="row">
          <div class="centrado">
            <p class="lead">
              Estimado/a Señor/a {username},<br></br>debe ingresar una foto del recibo 
            </p>
          </div>
        </div>
        <div class="row">
          <div class="col"></div>
          <div class="col">
            <div class="form-floating is-invalid">
               
              <div class="centrado">
                <Link to="/InicioSesion" type="button" class='btn btn-warning me-md-2' onClick={enviarVerificacion}>Verificar Cuenta</Link>
              </div>
            </div>
          </div>

          <div class="col"></div>
        </div>
      </div>
    </div>
  );
};

export default Verificacion;

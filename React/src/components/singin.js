import React from "react";
import "../styles/registro.css";
import Inigoogle from "./Inigoogle";

const SingIN = () => {
    return(

        <div class="d-flex justify-content-center">
            <div class="centrado">
            <h1 class="display-6 text-center">Inicia Sesión</h1>
        <form class="centrado">

  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example1">Email</label>
    <input type="email" id="form2Example1" class="form-control" />
  </div>


  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">Contraseña</label>
    <input type="password" id="form2Example2" class="form-control" />
  </div>

  <div class="row mb-4">
    <div class="col d-flex justify-content-center">
    
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> Recordarme </label>
      </div>
    </div>

    <div class="col">
     
      <a href="#!">¿Olvidaste tu contraseña?</a>
    </div>
  </div>

  <button type="button" class="btn btn-warning btn-block mb-4">Iniciar Sesión</button>

  <div class="text-center">
    <p>¿Aún no eres miembro? <a href="#!">Registrate</a></p>
    <p>o ingresa con:</p>
    <Inigoogle></Inigoogle>
    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-facebook-f"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-google"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-twitter"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-github"></i>
    </button>
  </div>
</form>
  
            </div>
        </div>
    );
};

export default SingIN;
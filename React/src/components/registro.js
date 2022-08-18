import axios from "axios";
import React, { Fragment, useState, useContext } from "react";
import "../styles/registro.css";
import Inigoogle from "./Inigoogle";
import { UsuarioContext } from "../context/UsuarioContext";
import { useHistory, Link } from "react-router-dom";


export default function Registro() {

  const { setUserVer} = useContext(UsuarioContext);
  const history = useHistory();
  

  const inicial = {
    nombre: "",
    apellido: "",
    telefono: "",
    email: "",
    clave: "",
    rol:"prop"
  }
  
  const [datos, setDatos] = useState(inicial);
  var ver=false;

  const handleInputChange = (event) => {
    setDatos({
      ...datos,
      [event.target.name]: event.target.value,
    });
  };

  const enviarDatos = (event) => {
    setUserVer(datos);
    
   axios
      .post("http://localhost:8080/usr/registro", datos)
      .then((response) => history.push("/verificacion"))
      .catch((err) => {console.log(err)
        alert("Datos mal ingresados")
      });
      
  };

  return (
    
    <div class="d-flex justify-content-center">
      <div class="centrado">
        <h1 class="display-6 text-center">Registro</h1>
        <div class="centrado">
          <div class="row">
            <div class="col">
              <label class="form-label">Nombre</label>
              <input
                type="text"
                class="form-control"
                placeholder="Aureliano"
                aria-label="First name"
                maxLength="25"
                onChange={handleInputChange}
                name="nombre"
                required
              />
            </div>
            <div class="col">
              <label class="form-label">Apellido</label>
              <input
                type="text"
                class="form-control"
                placeholder="Buendía"
                aria-label="Last name"
                maxLength="25"
                onChange={handleInputChange}
                name="apellido"
              />
            </div>
          </div>
          <div class="row">
            <div class="col">
              <label class="form-label">Teléfono</label>
              <input
                type="text"
                class="form-control"
                placeholder="99XX88XX"
                aria-label="First name"
                maxLength="8"
                onChange={handleInputChange}
                name="telefono"
              />
            </div>
          </div>
          <div class="row">
            <div class="col">
              <label class="form-label">Email</label>
              <input
                type="text"
                class="form-control"
                placeholder="aureliano@buendia.com"
                aria-label="First name"
                name="email"
                onChange={handleInputChange}
              />
            </div>
            <div class="col">
              <label class="form-label">Contraseña</label>
              <input
                type="password"
                class="form-control"
                placeholder=""
                aria-label="First name"
                name="clave"
                onChange={handleInputChange}
              />
            </div>
          </div>
          <div class="switchpad">
            <div class="form-check form-switch">
              <input
                defaultChecked="false"
                class="form-check-input"
                type="checkbox"
                role="switch"
                id="flexSwitchCheckDefault"
                name="prop"
              />
              <label class="form-check-label" for="flexSwitchCheckDefault">
                ¿Rentara su maquinaria en la página?
              </label>
            </div>
          </div>

          <div class="centrado">
            <div class="d-grid gap-2">
              <button type="button" class='btn btn-warning me-md-2' onClick={enviarDatos}>Registrarse</button>
            </div>
            <div>
              <br></br>
            </div>

            <Inigoogle></Inigoogle>
          </div>
        </div>
      </div>
    </div>
  
  );
}



import axios from "axios";
import React, { Fragment, useState, useContext } from "react";
import { UsuarioContext } from "../context/UsuarioContext";
import "../styles/registro.css";
import Login from "./Login";


export default function InicioSesionGoogle(props) {

  const { setUserVer} = useContext(UsuarioContext);

    const [datos, setDatos] = useState({
      telefono:"",
    });
  
    const handleInputChange = (event) => {
      console.log(event.target.value);
      setDatos({
        ...datos,
        [event.target.name]: event.target.value,
      });
    };
    
    const enviarDatos = (event) => {
    document.createElement("rolUser");

        console.log(document.getElementById("flexSwitchCheckDefaultGoogle").checked)
        if(document.getElementById("flexSwitchCheckDefaultGoogle").checked===true){
          
          document.getElementsByName("rolUser").values="prop";
          
        }else{
          document.getElementsByName("rolUser").values="cli";
        }

        const newDatos = {
          ...datos,
          nombre: document.getElementsByName("nombre_google").values,
          apellido: document.getElementsByName("apellido_google").values,
          email: document.getElementsByName("email_google").values,
          clave: document.getElementsByName("clave_google").values,
          rol:document.getElementsByName("rolUser").values,
      };
        setUserVer(newDatos);
        axios
        .post("http://localhost:8080/usr/google/add", newDatos)
        .then((response) => console.log(response))
        .catch((err) => console.log(err.message));
        window.location = '/';

    };
  
    return (
      <div class="d-flex justify-content-center"  >
        <div class="centrado">
            <div id="inicioGoogle_h1">
            <h1 class="display-4 text-center">Inicio de sesion con Google</h1>
            </div>
            <div class="contenedor" id="completeFormulario_h1" >
            <h1 class="display-4 text-center">Complete el Formulario</h1>
            </div>
            
            <div class="centrado">
              <div class="contenedor" id="telefono">
                <div class="row">
                  <label class="form-label"  >Teléfono</label>
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
            <div>
                <br></br>
            </div>
            <div class="contenedor" id="if_check">
              <div class="switchpad">
                <div class="form-check form-switch"  >
                  <input
                  defaultChecked="false"
                  class="form-check-input"
                  type="checkbox"
                  role="switch"
                  id="flexSwitchCheckDefaultGoogle"
                  name="propietario"
                  />
                  <label class="form-check-label" for="flexSwitchCheckDefault">
                  ¿Rentara su maquinaria en la página?
                  </label>
                </div>
              </div>
            </div>
            
            <div class="centrado">
              <div class="contenedor" id="continuar">
                <div class="d-grid gap-2">
                  <button
                    class="btn btn-warning"
                    type="button"
                    onClick={enviarDatos}
                    >
                    Continuar
                  </button>
                </div>
              </div>
            <div >
              <br></br>
            </div >
            <Login ></Login>
            </div>
          </div>
        </div>
      </div>
    );
  }
<<<<<<< HEAD
import axios from "axios";
import React, { useState } from "react";
import "../styles/registro.css";
import Login from "./Login";
import Inigoogle from "./Inigoogle";
=======
import React,{useState} from "react";
import "../styles/registro.css";
import Login from "./Login";
import { useDispatch } from "react-redux";
import {registroUsuario} from "../service/index"
>>>>>>> login

const Registro = (props) => {
  
  const inicial = {
    nombre: "",
    apellido: "",
    telefono: "",
    email: "",
//<<<<<<< HEAD
    clave: "",
<<<<<<< HEAD
//=======
    //clave: "",
//>>>>>>> 263350b506fb54d2cec402c72bbcc12846703147
  });
=======
    tipo: "false"
  }
>>>>>>> login

  const [user, setUser] = useState(inicial);

  const cambio = (event) => {
    const { name, value } = event.target;
    setUser({...user,[name]:value});
  }

  
  const dispatch = useDispatch();
  
  const guardar = () => {
   dispatch(registroUsuario(user))
   .then((response)=>{
    resetear();
   })
   .catch((error) => {
    console.log(error);
   }) 
  };

<<<<<<< HEAD
  const enviarDatos = (event) => {
    const params = new URLSearchParams(datos);

    axios
      .post("http://localhost:8080/usuario/cliente/add", params)
      .then((response) => console.log(response))
      .catch((err) => console.log(err.message));
  };
=======
  const resetear = () => {
    setUser(inicial);
  }
>>>>>>> login

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
                value={user.nombre}
                onChange={cambio}
                name="nombre"
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
                value={user.apellido}
                onChange={cambio}
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
                value={user.telefono}
                onChange={cambio}
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
                placeholder="aureliano@macondo.com"
                aria-label="First name"
                name="email"
                value={user.email}
                onChange={cambio}
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
                value={user.clave}
                onChange={cambio}
              />
            </div>
          </div>
          <div class="switchpad">
            <div class="form-check form-switch">
              <input
                checked={false
                }
                class="form-check-input"
                type="checkbox"
                role="switch"
                id="flexSwitchCheckDefault"
                name="tipo"
                value={user.tipo}
                onChange={cambio}
              />
              <label class="form-check-label" for="flexSwitchCheckDefault">
                ¿Rentará su maquinaria en la página?
              </label>
            </div>
          </div>

          <div class="centrado">
            <div class="d-grid gap-2">
              <button
                class="btn btn-warning"
                type="button"
                onClick={guardar}
              >
                Registrarse
              </button>
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

export default Registro;

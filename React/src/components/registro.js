import React,{useState} from "react";
import "../styles/registro.css";
import Login from "./Login";
import { useDispatch } from "react-redux";
import {registroUsuario} from "../service/index"

const Registro = (props) => {
  
  const inicial = {
    nombre: "",
    apellido: "",
    telefono: "",
    email: "",
    clave: "",
    tipo: "false"
  }

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

  const resetear = () => {
    setUser(inicial);
  }

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

            <Login></Login>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Registro;

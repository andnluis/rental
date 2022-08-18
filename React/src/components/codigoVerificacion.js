import React, { useState, useContext } from "react";
import axios from "axios";
import "../styles/registro.css";
import { useHistory } from "react-router-dom";
import { UsuarioContext } from "../context/UsuarioContext";
import { Link } from "react-router-dom";

const Verificacion = () => {
  const { userData, setUserData, setUserVer, userVer } =
    useContext(UsuarioContext);
  const { apellido, clave, email, nombre, telefono, tipo } = userVer;
  const history = useHistory();
  const inicial = {
    email: email,
    codigo: "",
  };

  const [ver, setVer] = useState(inicial);

  const handleInputChange = (event) => {
    setVer({
      ...ver,
      [event.target.name]: event.target.value,
    });
  };

  const enviarVerificacion = (event) => {

    const params = new URLSearchParams(ver);
    axios
      .put("http://localhost:8080/usr/verificar", params)
      .then((response) => {if(response.data=="verificacion fallida"){
        alert("Codigo incorrecto")
      }else{
        history.push("/InicioSesion")
        alert("Registrado exitosamente")}})
      .catch((err) => {
        
      });
    
  };

  return (
    <div class="centrado">
      <div class="container text-center">
        <div class="row">
          <div class="col">
            <h1 class="display-6 text-center">
              Ingresar código de verificación
            </h1>
          </div>
        </div>
        <div class="row">
          <div class="centrado">
            <p class="lead">
              Estimado/a Señor/a {nombre + " " + apellido},<br></br>Su código de
              verificación ha sido enviado a su correo {email}
            </p>
          </div>
        </div>
        <div class="row">
          <div class="col"></div>
          <div class="col">
            <div class="form-floating is-invalid">
              <input
                type="text"
                class="form-control "
                id="floatingInputGroup2"
                required
                maxLength={6}
                onChange={handleInputChange}
                name="codigo"
              />
              <label for="floatingInputGroup2">Código de Verificación</label>

              <div class="centrado">
                <button type="button" class='btn btn-warning me-md-2' onClick={enviarVerificacion}>Verificar Cuenta</button>
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

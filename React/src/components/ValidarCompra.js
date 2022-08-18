import React, { useState, useContext } from "react";
import axios from "axios";
import "../styles/registro.css";
import { UsuarioContext } from "../context/UsuarioContext";
import { useHistory } from "react-router-dom";

const Verificacion = () => {
  const { userData, userRenta } =
    useContext(UsuarioContext);
  const { username} = userData;
  const history = useHistory();

  const imagen = {
    file : "",
    id : "",
  }

  const [datosImagen, setDatosImagen] = useState(imagen);

  const handleFileChange = (e) => setDatosImagen({...datosImagen, [e.target.name]: e.target.files[0]})

  const enviarVerificacion = (event) => {
    const data = new FormData();
    data.append('file', datosImagen.file);
    data.append('id' , userRenta.id_renta);
    const params = new URLSearchParams(datosImagen);
    axios
      .post("http://localhost:8070/renta/up", data)
      .then((response) => {history.push("/")
      alert("Compra exitosa")})
      .catch((err) => {console.log(err)
        alert("Datos mal ingresados")
      });
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
          <div class="centrado">
            <input class="form-control" type="file" id="formFile" onChange={handleFileChange} name="file"></input>
          </div>
        </div>
        <div class="row">
          <div class="col"></div>
          <div class="col">
            <div class="form-floating is-invalid">
               
              <div class="centrado">
                <button to="/InicioSesion" type="button" class='btn btn-warning me-md-2' onClick={enviarVerificacion}>Verificar Cuenta</button>
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

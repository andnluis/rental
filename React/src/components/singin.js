import React, { Fragment, useState, useContext } from "react";
import "../styles/registro.css";
import Inigoogle from "./Inigoogle";
import { useHistory } from "react-router-dom";
import { UsuarioContext } from "../context/UsuarioContext";
import axios from "axios";


const SingIN = () => {

  const { userData,setUserData, setLocal, setUserRenta,userRenta} = useContext(UsuarioContext);
  const history = useHistory();
  const inicial = {
    email: "",
    clave: ""
  }

  const [datos, setDatos] = useState(inicial);

  const handleInputChange = (event) => {
    
    setDatos({
      ...datos,
      [event.target.name]: event.target.value,
    });
  };

  const enviarDatos = () => {
    axios
      .post("http://localhost:8080/usr/login", datos)
      .then((response) => { 
        setUserData(response.data)
        setLocal(response.data) 
        const datosId = {
          id_arr : response.data.id
        }
        const params = new URLSearchParams(datosId);
        axios
        .get("http://localhost:8060/renta", {params})
        .then((res) => { 
          setUserRenta(res.data) 
          history.push("/")
      }).catch((err) => {console.log(err)
        alert("Datos mal ingresados")
      });
      })
      .catch((err) => {console.log(err)
        alert("Datos mal ingresados")
      });
      
  };

  return (
    <div class="d-flex justify-content-center">
      <div class="centrado">
        <h1 class="display-6 text-center">Inicia Sesión</h1>
        <form class="centrado">
          <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">
              Email
            </label>
            <input type="email" id="form2Example1" class="form-control" onChange={handleInputChange} name="email"/>
          </div>

          <div class="form-outline mb-4">
            <label class="form-label" for="form2Example2">
              Contraseña
            </label>
            <input type="password" id="form2Example2" class="form-control" onChange={handleInputChange} name="clave"/>
          </div>

          
          
          <button type="button" class="btn btn-warning btn-block mb-4" onClick={enviarDatos}>Iniciar Sesión</button>

          <div class="text-center">
            <p>
              ¿Aún no eres miembro? <a href="/Registro">Registrate</a>
            </p>
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

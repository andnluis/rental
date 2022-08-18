
import React, { Fragment, useState, useContext } from "react";
import "../styles/registro.css";
import Inigoogle from "./Inigoogle";
import { useHistory } from "react-router-dom";
import { UsuarioContext } from "../context/UsuarioContext";
import axios from "axios";

const SingIN = () => {
  const { userData, setUserData, setLocal, setUserRenta, userRenta } =
    useContext(UsuarioContext);

  const inicial = {
    usr : userData.id
  }

  

  const [datosGanancias, setDatosGanancias] = useState(null);
  const [maquinas, setMaquinas] = useState(null);

  

  const totalGanancias = () => {
    const params = new URLSearchParams(inicial)
    
    axios
        .get("http://localhost:8060/stat/usr/ganancia", {params})
        .then((res) => {setDatosGanancias(res.data)})
        .catch((err) => {setDatosGanancias(0)});
  };

  const maquinasAlquiladas = () => {
    axios
        .get("http://localhost:8060/stat/top")
        .then((res) => {
            for (let i = 0; i < 3; i++) {
                let datos = {
                    id : res.data[i]
                  }
                  console.log(res.data[i])
            const params2 = new URLSearchParams({id : res.data[i]});
            console.log(params2)
            axios
            .get("http://localhost:8060/stat/maquina/nombre", params2)
            .then((response) => {console.log(response.data)})
            .catch((err) => {setMaquinas(0)});
        }
        })
        .catch((err) => {setMaquinas(0)});

        
  };
  

  return (
    <div class="d-flex justify-content-center mt-5">
      <div >
        <h5 class="display-6 text-center">Dashboard</h5>
        <br></br>
        <h1 class="display-6 text-center">Total ganancias</h1>
        <table class="table ml-5 mr-5">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Evento</th>
              <th scope="col">Valor</th>
              
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>Total ganancias</td>
              <td>{totalGanancias}{datosGanancias}</td>
              
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>Maquinas mas alquiladas</td>
              <td>{maquinasAlquiladas}{console.log(maquinas)}</td>
              
            </tr>
            <tr>
              <th scope="row">3</th>
              <td colspan="2">Larry the Bird</td>
              
            </tr>
          </tbody>
        </table>
        <button onClick={maquinasAlquiladas}>ver</button>
      </div>
    </div>
  );
};

export default SingIN;


import React, { Fragment, useState, useContext, useEffect } from "react";
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

  const [listNombre, setListNombre] = useState(null);
  const [datosGanancias, setDatosGanancias] = useState(null);
  const [maquinas, setMaquinas] = useState(null);
  const [dineroMaquina, setDineroMaquina] = useState(null);

 

  const funciones = () =>{
    totalGanancias();
    maquinasAlquiladas();
    dineroAlquiladas();
  }

  const totalGanancias = () => {
    const params = new URLSearchParams(inicial)
    
    axios
        .get("http://localhost:8060/stat/usr/ganancia", {params})
        .then((res) => {setDatosGanancias(res.data)})
        .catch((err) => {setDatosGanancias(0)});
  };

  const maquinasAlquiladas = () => {
    let test = []
    axios
        .get("http://localhost:8060/stat/top")
        .then((res) => {
            for (let i = 0; i < 3; i++) {
                let datos = {
                    id : res.data[i]
                }
                const params = new URLSearchParams(datos);
                axios
                .get("http://localhost:8060/stat/maquina/nombre", {params})
                .then((response) => {
                    let nombre=""
                    nombre = response.data.toString()
                    test.push("  "+nombre)
                    console.log(test)
                    setListNombre(test.toString())
                })
                .catch((err) => {console.log("efe")});
            }
        })
        .catch((err) => {setMaquinas(0)});
    console.log(dineroMaquina)
  };
 

  const dineroAlquiladas = () => {
    let test = []
    axios
        .get("http://localhost:8060/stat/top")
        .then((res) => {
            for (let i = 0; i < 3; i++) { 
                let datos = {
                    maquina : res.data[i]
                }
                const params = new URLSearchParams(datos);
                axios
                .get("http://localhost:8060/stat/maquina/total", {params})
                .then((response) => {
                    let nombre=0
                    nombre = response.data
                    test.push("  "+nombre)
                    console.log(test.toString()) 
                    setDineroMaquina(test.toString())
                    })
                .catch((err) => {console.log("efe")});
            }
        })
        .catch((err) => {setMaquinas(0)});
    console.log(dineroMaquina)
  };

  useEffect(funciones, []);
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
              <td>{datosGanancias}</td>
              
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>Maquinas mas rentadas</td>
              <td>{listNombre}</td>
              
            </tr>
            <tr>
              <th scope="row">3</th>
              <td >Ganancia de Maquinas mas rentadas</td>
              <td>{dineroMaquina}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default SingIN;

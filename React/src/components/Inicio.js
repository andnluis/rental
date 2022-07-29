import axios from "axios";
import React, { Fragment, useState } from "react";
import "../styles/registro.css";
import Cards from "./Cards";

export default function Inicio(props) {
  const [datos, setDatos] = useState({
    filtro1: "",
    filtro2: "",
  });

  const handleInputChange = (event) => {
    console.log(event.target.value);
    setDatos({
      ...datos,
      [event.target.name]: event.target.value,
    });
  };

  const enviarDatos = (event) => {};

  return (
    <div class="d-flex justify-content-center ">
      <div className="centrado">
        <div className="row">
          <div className="col">
            <select
              class="form-select"
              aria-label="Default select example"
              onChange={handleInputChange}
              name="filtro1"
            >
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
          <div className="col">
            <select
              class="form-select"
              aria-label="Default select example"
              onChange={handleInputChange}
              name="filtro2"
            >
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
        </div>
        <div className="centrado">
          <div className="row">
            <div className="col">
              <Cards></Cards>
            </div>
          </div>
        </div>



        
      </div>
    </div>
  );
}

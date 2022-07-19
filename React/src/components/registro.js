import React, {Fragment, useState} from "react";
import '../styles/registro.css';
import axios from 'axios';


const Registro = () => {

    const [inputs, setInputs] = useState({});

    const api = "http://localhost:8080/usuario"

    const [data, setData] = useState({
        n_id : "",
        nombre: "",
        apellido: "",
        telefono: "",
        direccion: "",
        ciudad: "",
        email: "",
        clave: "",
        f_nac: "",
        propietario: "",
    })

    function handle(e){

    }


        return(
           <div class="d-flex justify-content-center">
            <div class="centrado">
            
            <div class="col text-center">
            <h1 class="display-4">Registro</h1>

            </div>
        
        <div class="centrado">

        <div class="row">
        <div class="col">
            <label class="form-label">Nombre</label>
            <input onChange={(e)=>handle(e)} id="nombre" value={data.nombre} type="text" class="form-control" placeholder="Aureliano" aria-label="First name" maxLength="25"/>
        </div>
        <div class="col">
            <label class="form-label">Apellido</label>
            <input onChange={(e)=>handle(e)} id="apellido" value={data.apellido} type="text" class="form-control" placeholder="Buendía" aria-label="Last name" maxLength="25"/>
        </div>
        </div>
        <div class="row">
        <div class="col">
            <label class="form-label">Número de Identidad</label>
            <input onChange={(e)=>handle(e)} id="n_id" value={data.n_id} type="text" class="form-control" placeholder="0801-19XX-00XXX" aria-label="First name" maxLength="13"/>
        </div>
        <div class="col">
            <label class="form-label">Teléfono</label>
            <input onChange={(e)=>handle(e)} id="telefono" value={data.telefono} type="text" class="form-control" placeholder="99XX88XX" aria-label="First name" maxLength="8"/>
        </div>
        </div>
        <div class="row">
        <div class="col">
            <label class="form-label">Dirección</label>
            <input onChange={(e)=>handle(e)} id="direccion" value={data.direccion} type="text" class="form-control" placeholder="Col. Macondo" aria-label="First name" maxLength="128"/>
        </div>
        </div>
        <div class="row">
        <div class="col">
        <label for="inputState" class="form-label">Departamento</label>
    <select id="inputState" class="form-select">
      <option selected>Choose...</option>
      <option>...</option>
    </select>
        </div>
        <div class="col">
        <label for="inputState" class="form-label">Ciudad</label>
    <select id="inputState" class="form-select">
      <option selected>Choose...</option>
      <option>...</option>
    </select>

        </div>
        </div>
        <div class="row">
        <div class="col">
            <label class="form-label">Email</label>
            <input onChange={(e)=>handle(e)} id="email" value={data.email} type="text" class="form-control" placeholder="aureliano@buendia.com" aria-label="First name"/>
        </div>
        <div class="col">
            <label class="form-label">Contraseña</label>
            <input onChange={(e)=>handle(e)} id="clave" value={data.clave} type="password" class="form-control" placeholder="" aria-label="First name"/>
        </div>
        </div>
        <div class="row">
        <div class="col">
            <label class="form-label">Fecha de Nacimiento</label>
            <input onChange={(e)=>handle(e)} id="f_nac" value={data.f_nac} type="date" class="form-control" placeholder="aureliano@buendia.com" aria-label="First name"/>
        </div>
        </div>
        <div class="switchpad">
        
        <div class="form-check form-switch">
         <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault"/>
        <label class="form-check-label" for="flexSwitchCheckDefault">¿Rentara su maquinaria en la página?</label>
        </div>
        </div>

        <div class="centrado">
        <div class="d-grid gap-2">
        <button class="btn btn-warning" type="button">Registrarse</button>
        </div>
        </div>


        </div> 
            </div>


           </div>
        )
}

export default Registro
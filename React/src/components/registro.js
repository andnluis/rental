import React, {Fragment, useState} from "react";
import '../styles/registro.css'

const Registro = () => {

        return(
           <div class="d-flex justify-content-center">
            <div class="centrado">
        <h1 class="display-4 text-center">Registro</h1>
        <div class="centrado">

        <div class="row">
        <div class="col">
            <label class="form-label">Nombre</label>
            <input type="text" class="form-control" placeholder="Aureliano" aria-label="First name" maxLength="25"/>
        </div>
        <div class="col">
            <label class="form-label">Apellido</label>
            <input type="text" class="form-control" placeholder="Buendía" aria-label="Last name" maxLength="25"/>
        </div>
        </div>
        <div class="row">
        <div class="col">
            <label class="form-label">Número de Identidad</label>
            <input type="text" class="form-control" placeholder="0801-19XX-00XXX" aria-label="First name" maxLength="13"/>
        </div>
        <div class="col">
            <label class="form-label">Teléfono</label>
            <input type="text" class="form-control" placeholder="99XX88XX" aria-label="First name" maxLength="8"/>
        </div>
        </div>
        <div class="row">
        <div class="col">
            <label class="form-label">Dirección</label>
            <input type="text" class="form-control" placeholder="Col. Macondo" aria-label="First name" maxLength="128"/>
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
            <input type="text" class="form-control" placeholder="aureliano@buendia.com" aria-label="First name"/>
        </div>
        <div class="col">
            <label class="form-label">Contraseña</label>
            <input type="password" class="form-control" placeholder="" aria-label="First name"/>
        </div>
        </div>
        <div class="row">
        <div class="col">
            <label class="form-label">Fecha de Nacimiento</label>
            <input type="date" class="form-control" placeholder="aureliano@buendia.com" aria-label="First name"/>
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
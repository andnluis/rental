import axios from 'axios';
import React, {Fragment, useState} from "react";
import '../styles/registro.css';
import Login from './Login';

export default function Registro(props) {

    const [datos, setDatos] = useState({
        
            n_id : "",
            nombre: "",
            apellido: "",
            telefono: "",
            direccion: "",
            id_ciudad: "",
            email: "",
            clave: "",
            f_nac: ""
        
      })
    
      const handleInputChange = (event) => {
        console.log(event.target.value)
        setDatos({
          ...datos,
          [event.target.name] : event.target.value
        })
      }
    
      const enviarDatos = (event) => {
       const fecha = new Date(datos.f_nac)
        const parseToString = (date) => {
            return `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`
        }
        const newDatos = {
            ...datos,
            f_nac: parseToString(fecha)
        }
        const params = new URLSearchParams(newDatos);
        
        axios.post(
            'http://localhost:8080/usuario/cliente/add',
            params
          )
            .then((response) => console.log(response))
            .catch((err) => console.log(err.message));
      }

        return(
        
                <div class="d-flex justify-content-center">
                    <div class="centrado">
                <h1 class="display-4 text-center">Registro</h1>
                <div class="centrado">

                <div class="row">
                <div class="col">
                    <label class="form-label">Nombre</label>
                    <input type="text" class="form-control" placeholder="Aureliano" aria-label="First name" maxLength="25" onChange={handleInputChange} name="nombre"/>
                </div>
                <div class="col">
                    <label class="form-label">Apellido</label>
                    <input type="text" class="form-control" placeholder="Buendía" aria-label="Last name" maxLength="25" onChange={handleInputChange} name="apellido"/>
                </div>
                </div>
                <div class="row">
                <div class="col">
                    <label class="form-label">Número de Identidad</label>
                    <input type="text" class="form-control" placeholder="0801-19XX-00XXX" aria-label="First name" maxLength="13" onChange={handleInputChange} name="n_id"/>
                </div>
                <div class="col">
                    <label class="form-label">Teléfono</label>
                    <input type="text" class="form-control" placeholder="99XX88XX" aria-label="First name" maxLength="8" onChange={handleInputChange} name="telefono"/>
                </div>
                </div>
                <div class="row">
                <div class="col">
                    <label class="form-label">Dirección</label>
                    <input type="text" class="form-control" placeholder="Col. Macondo" aria-label="First name" maxLength="128" onChange={handleInputChange} name="direccion"/>
                </div>
                </div>
                <div class="row">
                <div class="col">
                    <label class="form-label">Ciudad</label>
                    <input type="number" class="form-control" min="0" max="65"  placeholder="24" aria-label="First name" maxLength="128" onChange={handleInputChange} name="id_ciudad"/>
                </div>
                
                </div>
                <div class="row">
                <div class="col">
                    <label class="form-label">Email</label>
                    <input type="text" class="form-control" placeholder="aureliano@buendia.com" aria-label="First name" name="email" onChange={handleInputChange}/>
                </div>
                <div class="col">
                    <label class="form-label">Contraseña</label>
                    <input type="password" class="form-control" placeholder="" aria-label="First name" name="clave" onChange={handleInputChange}/>
                </div>
                </div>
                <div class="row">
                <div class="col">
                    <label class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" placeholder="aureliano@buendia.com" aria-label="First name" name="f_nac" onChange={handleInputChange}/>
                </div>
                </div>
                <div class="switchpad">
                
                <div class="form-check form-switch">
                <input defaultChecked="false" class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault" name="propietario"/>
                <label class="form-check-label" for="flexSwitchCheckDefault">¿Rentara su maquinaria en la página?</label>
                </div>
                </div>

                <div class="centrado">
                <div class="d-grid gap-2">
                <button class="btn btn-warning" type="button" onClick={enviarDatos}>Registrarse</button>
                </div>
                <div><br></br></div>

                <Login></Login>

                </div>


                </div> 
                    </div>


                </div>
        
        )
}


import React, {useState} from "react";
import axios from "axios";
import '../styles/registro.css'
const Verificacion = ({dato}) => {

    const datos = {dato};

    const inicial = {
        email: datos.email,
        codigo: "",
    };

    const [ver, setVer] = useState(inicial);


   
    const enviarVerificacion = (event) => {
        const params = URLSearchParams(ver);
        axios
        .put('http://localhost:8080/usr/verificar', params)
        .then((response) => console.log(response))
      .catch((err) => console.log(err.message));
      console.log(ver);
    }

    const cambio = (event) => {
        const {name, value} = event.target;
    };
    

    return(
        <div class="centrado">

        <div class="container text-center">
            <div class="row">
            <div class="col">
            <h1 class="display-6 text-center">Ingresar código de verificación</h1>
            </div>
            </div>
            <div class="row">

                    <div class="centrado">

            <p class="lead">Estimado/a Señor/a {datos.nombre},<br></br>Su código de verificación ha sido enviado a su correo {ver.email}</p>
                    </div>
            </div>
                <div class="row">
                    <div class="col"></div>
                    <div class="col">


              
                <div class="form-floating is-invalid">

                   
                    <input type="text" class="form-control " id="floatingInputGroup2" required maxLength={6}/>
                    <label for="floatingInputGroup2">Código de Verificación</label>
                    
                    <div class="centrado">
                    <button type="button" class="btn btn-warning" onClick={enviarVerificacion}>Verificar Cuenta</button>
                    </div>
                </div>
                </div>
               

                
                    <div class="col"></div>
                </div>

            </div>
        </div>
    );
}

export default Verificacion;
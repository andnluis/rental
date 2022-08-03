import React from "react";

const Verificacion = (prop) => {

    return(
        <div class="d-flex justify-content-center">
            <h1 class="display-6 text-center">Ingresar código de verificación</h1>
            <p class="lead">El código de verificación ha sido enviado a su correo.</p>
            <div class="input-group has-validation">
                <span class="input-group-text">Código</span>
                <div class="form-floating is-invalid">
                    <input type="text" class="form-control is-invalid" id="floatingInputGroup2" placeholder="Username" required/>
                    <label for="floatingInputGroup2">Username</label>
                </div>
            </div>
        </div>
    );
}

export default Verificacion;
import React from "react";


const Barra = () => {
    return(
        
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand">
                <img src={process.env.PUBLIC_URL+'logo.png'} height="86px" width="320px"></img>
            </a>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-warning me-md-2" type="button">Registrarse</button>
            <button class="btn btn-warning" type="button">Ver Catalogo</button>
</div>
      </nav>
      
    )
}

export default Barra
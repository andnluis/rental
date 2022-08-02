import axios from "axios";
import React, { Fragment, useState } from "react";
import '../styles/registro.css'
import { GoogleLogin } from 'react-google-login';
// refresh token
//import { refreshTokenSetup } from '../utils/refreshToken';

const clientId =
  '707788443358-u05p46nssla3l8tmn58tpo9r5sommgks.apps.googleusercontent.com';

function Login() {

  const [datos, setDatos] = useState({
    nombre: "",
    apellido: "",
    email: "",
    clave: "",
    
  });

  const onSuccess = (res) => {
    //console.log('Login Success: currentUser:', res.profileObj);
    //alert(
    //  `Bienvenido ${res.profileObj.name} . \n`
    //);

    //refreshTokenSetup(res);
    setDatos({
      ...datos,
      nombre: res.profileObj.givenName,
      apellido: res.profileObj.familyName,
      email: res.profileObj.email,
      clave:res.profileObj.googleId,
    });
    const newDatosgoogle = {
      ...datos,
    };
    const params = new URLSearchParams(newDatosgoogle);

    axios
      .post("http://localhost:8080/usr/google/ask", params)
      .then((response) => {if (response.data) {
        console.log(response);
        window.location = '/';
      }else{
        document.getElementById("GoogleLoginButton").style.visibility = "hidden";
        document.getElementById("inicioGoogle_h1").style.visibility = "hidden";
        document.getElementById("completeFormulario_h1").style.display= "block";
        document.getElementById("telefono").style.display= "block";
        document.getElementById("if_check").style.display= "block";
        document.getElementById("continuar").style.display= "block";
        document.createElement("nombre_google");
        document.createElement("apellido_google");
        document.createElement("email_google");
        document.createElement("clave_google");
        document.getElementsByName("nombre_google").values=res.profileObj.givenName;
        document.getElementsByName("apellido_google").values=res.profileObj.familyName;
        document.getElementsByName("email_google").values=res.profileObj.email;
        document.getElementsByName("clave_google").values=res.profileObj.googleId;
        console.log(document.getElementsByName("nombre_google").values);
        console.log(document.getElementsByName("apellido_google").values);
        console.log(document.getElementsByName("email_google").values);
        console.log(document.getElementsByName("clave_google").values);
      }
      

    })
      .catch((err) => console.log(err.message));

  };

  const onFailure = (res) => {
    console.log('Login failed: res:', res);
    alert(
      `Failed to login.`
    );
  
  };

  return (
    <div align= "center" id="GoogleLoginButton" >
      <GoogleLogin
        clientId={clientId}
        buttonText="Inicia sesión con Google"
        onSuccess={onSuccess}
        onFailure={onFailure}
        cookiePolicy={'single_host_origin'}
        style={{ marginTop: '100px' }}
        theme="dark"
        isSignedIn={true}
        
      />
    </div>
  );
}

export default Login;

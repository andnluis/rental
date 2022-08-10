import React from "react";
import "./App.css";
import { UsuarioProvider } from "./context/UsuarioContext";
import Barra from "./components/barra";
import Registro from "./components/registro";
import Inicio from "./components/Inicio";
import SingIN from "./components/singin";
import InicioSesionGoogle from "./components/InicioSesionGoogle";
import Maquinaria from "./components/maquinaria";
import Verificacion from "./components/codigoVerificacion";
import Perfil from "./components/perfil";
import Footer from "./components/footer";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  return (
<<<<<<< HEAD
    <Router>
      <div className='App'>
        <Barra/>
        <img src='http://localhost:8070/downloadFile/Dise%C3%B1o%20sin%20t%C3%ADtulo(2).png' width='800px' height='500px'></img>
        <div className='content'>
          <Switch>
            <Route exact path={'/'}>
              <Inicio/>
            </Route>
            <Route path={'/Registro'}>
              <Registro/>
            </Route>
            <Route path={'/InicioSesion'}>
              <SingIN/>
            </Route>
            <Route path={'/Inicio'}>
              <Inicio/>
            </Route>
            <Route path={'/verificacion'}>
              <Verificacion/>
            </Route>
            <Route path={'/inicioGoogle'}>
              <InicioSesionGoogle/>
            </Route>
          </Switch>
          <Footer/>
=======
    <UsuarioProvider>
      <Router>
        <div className="App">
          <Barra />
          <div className="content">
            <Switch>
              <Route exact path={"/"}>
                <Inicio />
              </Route>
              <Route path={"/Registro"}>
                <Registro />
              </Route>
              <Route path={"/InicioSesion"}>
                <SingIN />
              </Route>
              <Route path={"/Inicio"}>
                <Inicio />
              </Route>
              <Route path={"/verificacion"}>
                <Verificacion />
              </Route>
              <Route path={"/inicioGoogle"}>
                <InicioSesionGoogle />
              </Route>
              <Route path={"/maquinaria"}>
                <Maquinaria />
              </Route>
              <Route path={"/perfil"}>
                <Perfil />
              </Route>
            </Switch>
            <Footer />
          </div>
>>>>>>> 1695f77eadce52b0123a55af055f44f62b8237c3
        </div>
      </Router>
    </UsuarioProvider>
  );
}

export default App;

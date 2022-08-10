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
        </div>
      </Router>
    </UsuarioProvider>
  );
}

export default App;

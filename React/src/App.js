import React from "react";
import "./App.css";
import { UsuarioProvider } from "./context/UsuarioContext";
import { CartProvider } from "react-use-cart";
import Barra from "./components/barra";
import Registro from "./components/registro";
import Inicio from "./components/Inicio";
import SingIN from "./components/singin";
import InicioSesionGoogle from "./components/InicioSesionGoogle";
import Maquinaria from "./components/maquinaria";
import Verificacion from "./components/codigoVerificacion";
import Perfil from "./components/perfil";
import Footer from "./components/footer";
import Carrito from "./components/Carrito";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  return (
    
    <UsuarioProvider>
      <CartProvider>
      <Router>
        <div className="App">
          <Barra />
          <div className="content">
            <Switch>
              <Route exact path={"/"}>
                <Inicio />
              </Route>
              <Route exact path={"/Carrito"}>
                <Carrito />
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
      </CartProvider>
    </UsuarioProvider>
  );
}

export default App;

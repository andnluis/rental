import axios from "axios";
import React, { Fragment, useState, useContext } from "react";
import "../styles/registro.css";
import Inigoogle from "./Inigoogle";
import { UsuarioContext } from "../context/UsuarioContext";
import { Link } from "react-router-dom";

export default function Registro() {

  const { userData} = useContext(UsuarioContext);
  
  const imagen = {
    file : "",
    id : 3,
  }

  const inicial = {
    man : "",
    prop : userData.id,
    nserie : "", 
    tdm : "",
    pph : "",
    ubi : "",
    mdm : "",
    pot : "",
    peso : ""
  }
  const [datosImagen, setDatosImagen] = useState(imagen);
  const [datos, setDatos] = useState(inicial);
  console.log(datosImagen);

  

  const handleFileChange = (e) => setDatosImagen({...datosImagen, [e.target.name]: e.target.files[0]})

  const handleInputChange = (event) => {
    setDatos({
      ...datos,
      [event.target.name]: event.target.value,
    });
  };

  const enviarDatos = () => {
    const data = new FormData();
    data.append('file', datosImagen.file);
    data.append('id' , datosImagen.id);

    const params = new URLSearchParams(datosImagen);
    axios
      .post("http://localhost:8070/maquina/up", data)
      .then((response) => console.log(response))
      .catch((err) => console.log(err.message));
      
  };

  return (
    <div class="d-flex justify-content-center">
      <div class="centrado">
        <h1 class="display-6 text-center">Nueva Maquinaria</h1>
        <div class="centrado">
          <div class="row">
            <div class="col">
              <label class="form-label">Numero de serie</label>
              <input
                type="text"
                class="form-control"
                placeholder="XX-XXX-XXXX"
                aria-label="First name"
                maxLength="25"
                onChange={handleInputChange}
                name="nserie"
              />
            </div>
            <div class="col">
              <label class="form-label">Precio por hora</label>
              <input
                type="number"
                class="form-control"
                placeholder="5908.51"
                aria-label="Last name"
                maxLength="25"
                onChange={handleInputChange}
                name="pph"
              />
            </div>
            <div class="col">
              <label class="form-label">Marca</label>
              <select
              id="resetMarca"
              class="form-select"
              aria-label="Default select example"
              onChange={handleInputChange}
              name="man"
            >
              <option selected value="-1">Marca</option>
              <option value="1">Caterpillar</option>
              <option value="2">John Deere</option>
              <option value="3">Volvo CE</option>
              <option value="4">Hitachi</option>
              <option value="5">Hyundai</option>
            </select>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <label class="form-label">Modelo del motor</label>
              <input
                type="text"
                class="form-control"
                placeholder="S-Typ-342"
                aria-label="First name"
                maxLength="8"
                onChange={handleInputChange}
                name="mdm"
              />
            </div>
            <div class="col">
              <label class="form-label">ID tipo</label>
              <select
              id="resetMarca"
              class="form-select"
              aria-label="Default select example"
              onChange={handleInputChange}
              name="tdm"
            >
              <option selected value="-1">Tipo de ID</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>
              <option value="19">19</option>
              <option value="20">20</option>
              <option value="21">21</option>
              <option value="22">22</option>
              <option value="23">23</option>
              <option value="24">24</option>
              <option value="25">25</option>
              <option value="26">26</option>
              <option value="27">27</option>
              <option value="28">28</option>
              <option value="29">29</option>
              <option value="30">30</option>
              <option value="31">31</option>
              <option value="32">32</option>
              <option value="33">33</option>
              <option value="34">34</option>
              <option value="35">35</option>
            </select>
            </div>
            <div class="col">
            <label class="form-label">Ubicacion</label>
            <select
              id="resetCiudad"
              class="form-select "
              aria-label="Default select example"
              onChange={handleInputChange}
              name="ubi"
            >
              <option selected value="-1">Ciudad</option>
              <option value="1 ">La Ceiba</option>
              <option value="2 ">Tela</option>
              <option value="3 ">El Porvenir</option>
              <option value="4 ">Trujillo</option>
              <option value="5 ">Saba</option>
              <option value="6 ">Tocoa</option>
              <option value="7 ">Sonaguera</option>
              <option value="8 ">Comayagua</option>
              <option value="9 ">Esquías</option>
              <option value="10">Siguatepeque</option>
              <option value="11">Taulabe</option>
              <option value="12">Santa_Rosa_de_Copan</option>
              <option value="13">Copan_Ruinas</option>
              <option value="14">San_Pedro_Sula</option>
              <option value="15">Choloma</option>
              <option value="16">Omoa</option>
              <option value="17">Puerto_Cortes</option>
              <option value="18">La_Lima</option>
              <option value="19">Villanueva</option>
              <option value="20">Choluteca</option>
              <option value="21">El_triunfo</option>
              <option value="22">Marcovia</option>
              <option value="23">San_Marcos_de_Colón</option>
              <option value="24">Yuscarán</option>
              <option value="25">Danlí</option>
              <option value="26">Texiguat</option>
              <option value="27">Trojes</option>
              <option value="28">Morocelí</option>
              <option value="29">Distrito</option>
              <option value="30">Ojojona</option>
              <option value="31">Sabanagrande</option>
              <option value="32">Santa_Ana</option>
              <option value="33">Tatumbla</option>
              <option value="34">Guaimaca</option>
              <option value="35">Valle_de_Ángeles</option>
              <option value="36">Puerto_Lempira</option>
              <option value="37">Brus_Laguna</option>
              <option value="38">La_Esperanza</option>
              <option value="39">Intibuca</option>
              <option value="40">Yamaranguila</option>
              <option value="41">Roata</option>
              <option value="42">Guanaja</option>
              <option value="43">Utila</option>
              <option value="44">La_Paz</option>
              <option value="45">Marcala</option>
              <option value="46">Gracias</option>
              <option value="47">Belen</option>
              <option value="48">La_Campa</option>
              <option value="49">Ocotepeque</option>
              <option value="50">Belén_Gualcho</option>
              <option value="51">Juticalpa</option>
              <option value="52">Campamento</option>
              <option value="53">Catacamas</option>
              <option value="54">San_Esteban</option>
              <option value="55">Patuca</option>
              <option value="56">Santa</option>
              <option value="57">Ilama</option>
              <option value="58">San_Luis</option>
              <option value="59">Nacaome</option>
              <option value="60">San_Lorenzo</option>
              <option value="61">Langue</option>
              <option value="62">Amapala</option>
              <option value="63">Yoro</option>
              <option value="64">El_Progreso</option>
              <option value="65">Olanchito</option>
            </select>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <label class="form-label">Potencia</label>
              <input
                type="number"
                class="form-control"
                placeholder="xxx"
                aria-label="First name"
                name="pot"
                onChange={handleInputChange}
              />
            </div>
            <div class="col">
              <label class="form-label">Peso</label>
              <input
                type="number"
                class="form-control"
                placeholder="XX.XX"
                aria-label="First name"
                name="peso"
                onChange={handleInputChange}
              />
            </div>
          </div>
          <div class="row">
            <div class="col">
              <div class="mb-3">
                <label for="formFile" class="form-label">Insertar imagen</label>
                <input class="form-control" type="file" id="formFile" onChange={handleFileChange} name="file"></input>
              </div>
            </div>
          </div>

          <div class="centrado">
            <div class="d-grid gap-2">
              <Link to="/" type="button" class='btn btn-warning me-md-2' onClick={enviarDatos}>Registrar Maquinaria</Link>
            </div>
            <div>
              <br></br>
            </div>

          </div>
        </div>
      </div>
    </div>
  );
}



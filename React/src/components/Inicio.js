import axios from "axios";
import React, { useState, useEffect } from "react";
import "../styles/registro.css";
import Cards from "./Cards";

export default function Inicio(props) {

  const [datos, setDatos] = useState({
    ciudad: "-1",
    man: "-1",
    cat: "-1",
  });
  const [datoscurrent, setDatoscurrente] = useState({
    ciudad: "-1",
    man: "-1",
    cat: "-1",
  });

  const [cartas, setCartas] = useState([]);

  const [currentPage, setCurrentPage] = useState(0)

  const nextPage = () => {
    setCurrentPage(currentPage + 12);

  }
  const previousPage = () => {
    if (currentPage >= 12) {
      setCurrentPage(currentPage - 12)
    }
  }

  const mostrarCartas = () => {
    console.log(datos);
    if (datoscurrent.cat !== datos.cat || datoscurrent.man !== datos.man || datoscurrent.ciudad !== datos.ciudad) {
      setCurrentPage(0);
      setDatoscurrente({
        ...datoscurrent,
        ciudad: datos.ciudad,
        cat: datos.cat,
        man: datos.man,
      });
    }

    const params = { ciudad: datos.ciudad, man: datos.man, cat: datos.cat }

    axios
      .get("http://localhost:8090/maquina/dinamico", { params })
      .then((res) => { setCartas(res.data.slice(currentPage, currentPage + 12)); })
      .catch((err) => console.log(err.message));

  };

  const handleInputChange = (event) => {

    console.log(event.target.value);
    setDatos({
      ...datos,
      [event.target.name]: event.target.value,
    });
  };

  useEffect(mostrarCartas, [currentPage, datos]);

  return (
    <div class="d-flex justify-content-center ">
      <div className="centrado">
        <div className="row">
          <div className="col">
            <select
              id="resetCiudad"
              class="form-select "
              aria-label="Default select example"
              onChange={handleInputChange}
              name="ciudad"
            >
              <option selected>Ciudad</option>
              <option value="1 ">La_CeibaLa Ceiba</option>
              <option value="2 ">TelaTela</option>
              <option value="3 ">El_PorvenirEl Porvenir</option>
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
          <div className="col">
            <select
              id="resetMarca"
              class="form-select"
              aria-label="Default select example"
              onChange={handleInputChange}
              name="man"
            >
              <option selected>Marca</option>
              <option value="1">Caterpillar</option>
              <option value="2">John Deere</option>
              <option value="3">Volvo CE</option>
              <option value="4">Hitachi</option>
              <option value="5">Hyundai</option>
            </select>
          </div>
          <div className="col">
            <select
              id="resetCat"
              class="form-select"
              aria-label="Default select example"
              onChange={handleInputChange}
              name="cat"
            >
              <option selected>Categoria</option>
              <option value="1">Equipo de movimiento de tierras</option>
              <option value="2">Equipo de hormigado</option>
              <option value="3">Equipo de elevacion de materiales</option>
              <option value="2">Equipo de uso especial</option>
              <option value="3">Equipo de soporte</option>
            </select>
          </div>
        </div>
        <div className="centrado">
          <div className="row">
            <div className="col">
              <Cards cartas={cartas} ></Cards>
            </div>
          </div>
        </div>
        <div className="centrado d-flex justify-content-center ">
          <div className="row">
            <div className="col ">
              <button className="btn btn-warning me-md-2" onClick={previousPage}>
                Anterior
              </button>
              <button className="btn btn-warning me-md-2" onClick={nextPage}>
                Siguiente
              </button>
            </div>
          </div>
        </div>

      </div>
    </div>
  );
}

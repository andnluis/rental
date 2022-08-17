import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import axios from "axios";
import { CartProvider, useCart } from "react-use-cart";
import "../styles/Card.css";

function Card({carta}) {

  const { addItem } = useCart();
  const inicial={foto : ''}
  const { id_maq, id_man, id_prop, n_serie, disponible,id_tipo, pph, ubicacion, modelo_motor, potencia, peso } = carta
  const [imagen, setImagen] = useState(inicial);
  

  const mostrarCartas = () => {
    
    const params = { id: id_maq}

    axios
      .get("http://localhost:8070/maquina/get", { params })
      .then((res) => { setImagen(res.data); })
      .catch((err) => console.log(err.message));
    
    return imagen;

  };


  const tiposDeMaquina = {
    1 : "Bulldozer",
    2 : "Motoniveladora",
    3 : "Cargador frontal",
    4 : "Retroexcavadora",
    5 : "Dragalina",
    6 : "Excavadora",
    7 : "Cargadora",
    8 : "Camión",
    9 : "Camión Articulado",
    10 : "Volqueta",
    11 : "Rodillo de neutomatico",
    12 : "Compactadores de placa",
    13 : "Rodillo de rueda lisa",
    14 : "Planta de hormigon",
    15 : "Mezcladora",
    16 : "Hormigonera",
    17 : "Volquetas de concreto",
    18 : "Bombas de hormigon",
    19 : "Elevadores",
    20 : "Equipo de inyeccion",
    21 : "Elevador fijo",
    22 : "Elevador móvil",
    23 : "Carretilla elevadora",
    24 : "Grua de neutomatico",
    25 : "Grua sobra camión",
    26 : "Grua montada en oruga",
    27 : "Grua estacionaria",
    28 : "Grua para transporte",
    29 : "Acabados hormigón",
    30 : "Plantas de asfalto",
    31 : "Pavimentadora de asfalto",
    32 : "Equipos de transporte de escombro",
    33 : "Tuneladoras",
    34 : "Generadores",
    35 : "Equipo de soldadura",
    36 : "Equipos de bombeo y deshidratación",
    37 : "Equipos de colocación de tubería"
  }

  const ciudad = {
    1 : "La Ceiba",
    2 : "Tela",
    3 : "El Porvenir",
    4 : "Trujillo",
    5 : "Saba",
    6 : "Tocoa",
    7 : "Sonaguera",
    8 : "Comayagua",
    9 : "Esquías",
    10 : "Siguatepeque",
    11 : "Taulabe",
    12 : "Santa Rosa de Copan",
    13 : "Copan Ruinas",
    14 : "San Pedro Sula",
    15 : "Choloma",
    16 : "Omoa",
    17 : "Puerto Cortes",
    18 : "La Lima",
    19 : "Villanueva",
    20 : "Choluteca",
    21 : "El triunfo",
    22 : "Marcovia",
    23 : "San Marcos de Colón",
    24 : "Yuscarán",
    25 : "Danlí",
    26 : "Texiguat",
    27 : "Trojes",
    28 : "Morocelí",
    29 : "Distrito Central",
    30 : "Ojojona",
    31 : "Sabanagrande",
    32 : "Santa Ana",
    33 : "Tatumbla",
    34 : "Guaimaca",
    35 : "Valle de Ángeles",
    36 : "Puerto Lempira",
    37 : "Brus Laguna",
    38 : "La Esperanza",
    39 : "Intibuca",
    40 : "Yamaranguila",
    41 : "Roata",
    42 : "Guanaja",
    43 : "Utila",
    44 : "La Paz",
    45 : "Marcala",
    46 : "Gracias",
    47 : "Belen",
    48 : "La Campa",
    49 : "Ocotepeque ",
    50 : "Belén Gualcho",
    51 : "Juticalpa",
    52 : "Campamento",
    53 : "Catacamas",
    54 : "San Esteban",
    55 : "Patuca",
    56 : "Santa Barbara",
    57 : "Ilama",
    58 : "San Luis",
    59 : "Nacaome",
    60 : "San Lorenzo",
    61 : "Langue",
    62 : "Amapala",
    63 : "Yoro",
    64 : "El Progreso",
    65 : "Olanchito"
  }

  const tipoDeMarca = {
    1 : "Caterpillar",
    2 : "John Deere",
    3 : "Volvo CE",
    4 : "Hitachi",
    5 : "Hyundai"
  }

  const car = {
    id : id_maq,
    nombre :  tiposDeMaquina[id_tipo],
    cantidad : 1,
    imagen : mostrarCartas(),
    price : 0
  }
  
  const add = () => {
    console.log(car)
    addItem(car)
  }

  return (
    <div className="card text-center bg-dark animate__animated animate__fadeInUp">
      <div className="overflow">
        <img src={mostrarCartas()} alt="a wallpaper" className="card-img-top" />
      </div>
      <div className="card-body text-white">
        <h4 className="card-title">{tiposDeMaquina[id_tipo]}</h4>
        <p className="card-text text-white">
          <p>Marca: {tipoDeMarca[id_man]}</p>
          <p >Numero de serie: {n_serie}</p>
          <p >Precio por hora: {pph} lps </p>
          <p >Ubicacion: {ciudad[ubicacion]}</p>
          <p >Modelo del motor: {modelo_motor}</p>
          <p >Potencia: {potencia} Hp</p>
          <p >Peso: {peso} toneladas</p>
        </p>
        <button className="btn btn-warning border-0" onClick={add}>Añadir al carrito</button>
      </div>
    </div>
    
  );
}



export default Card

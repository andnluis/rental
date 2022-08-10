import axios from "axios";
import React, { Fragment, useState, useContext } from "react";
import "../styles/perfil.css";
import Inigoogle from "./Inigoogle";
import { UsuarioContext } from "../context/UsuarioContext";
import { Link } from "react-router-dom";


export default function Registro() {
  const { userData, setUserData, setLocal, token } = useContext(UsuarioContext);

  return (
    <section class="seccion-perfil-usuario">
    <div class="perfil-usuario-header">
        <div class="perfil-usuario-portada">
            <div class="perfil-usuario-avatar">
                <img src="https://w7.pngwing.com/pngs/1021/108/png-transparent-builder-helmet-worker-avatars-xmas-giveaway-icon-thumbnail.png" alt="img-avatar"></img>
                <button type="button" class="boton-avatar">
                    <i class="far fa-image"></i>
                </button>
            </div>
        </div>
    </div>
    <div class="perfil-usuario-body">
        <div class="perfil-usuario-bio">
            <h3 class="titulo">{userData.username}</h3>
            <p class="texto"></p>
        </div>
        <div class="perfil-usuario-footer">
            <ul class="lista-datos">
                <li><i class="icono fas fa-map-signs"></i> ID del usuario: {userData.id}</li>
                <li><i class="icono fas fa-phone-alt"></i> email: {userData.email}</li>
                
            </ul>
            <ul class="lista-datos">
                <li><i class="icono fas fa-map-marker-alt"></i> Rol del usuario: {userData.rol}</li>
                <li><i class="icono fas fa-calendar-alt"></i> type: {userData.type}</li>
                
            </ul>
        </div>
        
    </div>
</section>
  );
}

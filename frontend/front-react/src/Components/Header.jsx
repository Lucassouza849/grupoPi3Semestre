import React from "react";
import logoImg from '../assets2/img/logo/logo.png';
import '../styles/header-footer.css';
import { Link } from 'react-router-dom';



function Header(){
    return(
       
        <header>
        <a href="">
            <Link to="/">
            <img src={logoImg} class="logo" alt="" />
            </Link>
        </a>
        <ul>
            <Link to="/quemsomos">
            <li><a class="menu">Quem Somos</a></li>
            </Link>

            <Link to="/planos">
            <li><a class="menu">Planos</a></li>
            </Link>
 
            <Link to="/cadastro">
            <li><a class="menu">Cadastre-se</a></li>
            </Link>

            <div class="pipe"></div>

            <Link to="/login">
            <li><a class="menu" path="/login">
            <li class="active">Acesse
            </li></a></li>
            </Link>
        </ul>
    </header>
    
    );
}

export default Header;
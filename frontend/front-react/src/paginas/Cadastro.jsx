import React from "react";
import setaBack from '../assets2/img/login e cadastro/66822.png'
import Footer from "../Components/Footer";
import '../styles/cadastro.css';
import { Link } from 'react-router-dom';


function Cadastro(){
    return(
        <>
        <div class="container-cadastro">
        <div class="button-back">
            <a href="">
                <Link to="/">
                <img src={setaBack} alt="return" />
                </Link>
            </a>
        </div>

        <div class="centro">
            <h1>Cadastro</h1>

            <form method="post">
                <div class="text_fild">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Usuário" required />
                </div>
                <div class="text_fild">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Senha" required />
                </div>
                <div class="text_fild">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Confirme a senha" required />
                </div>
                <div class="pass-div">
                    <input type="submit" value="Cadastrar" />
                    <div class="signup_link">
                        Já possui cadastro? <br />
                        <a class="aa" href="./login.html">Ir para login</a>
                    </div>
                </div>

            </form>
        </div>
    </div>
    <Footer />
    </>
    );
}

export default Cadastro;
import React from "react";
import loginImg from '../assets2/img/login e cadastro/66822.png';
import Footer from "../Components/Footer";
import '../styles/login.css';
import { Link } from 'react-router-dom';


function Login(){

    return(
        <>

        <div class="container-login">
        <div class="button-back">
            <a href="">
                <Link to="/">
                <img src={loginImg} alt="return" />
                </Link>
            </a>
        </div>

        <div class="centro">
            <h1>Login</h1>

            <form method="post">
                <div class="text_fild">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Usuário" required />
                </div>
                <div class="text_fild">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Senha" required />
                </div>
                <div class="pass-div">
                    <input type="submit" value="Entrar" />
                    <div class="signup_link">
                        Ainda não possui cadastro? <br />
                        <a class="aa">Cadastrar-se</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <Footer />
    </>
    );
}

export default Login;
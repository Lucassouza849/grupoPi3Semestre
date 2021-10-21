import React, { useState } from "react";
import loginImg from '../assets2/img/login e cadastro/66822.png';
import Footer from "../Components/Footer";
import '../styles/login.css';
import { Link, useHistory } from 'react-router-dom';
import api from '../Services/api';


const initialValues = {
    login: '',
    senha: '',
}

function Login(){

    const[values, setValues] = useState(initialValues);
    const history = useHistory();
    
    function onChange(ev){
        const { name, value } = ev.target;

        setValues({
            ...values,
            [name]: value
        });
    }

    async function onSubmit(ev){
        ev.preventDefault();

        api.post('/usuarios/autenticacoes', values)
        .then((response) => {
            history.push('/configuracoes')
        })
    }


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

            <form onSubmit={onSubmit}>
                <div class="text_fild">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Usuário" id="login" name="login" onChange={onChange} />
                </div>
                <div class="text_fild">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Senha" id="senha" name="senha" onChange={onChange} />
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
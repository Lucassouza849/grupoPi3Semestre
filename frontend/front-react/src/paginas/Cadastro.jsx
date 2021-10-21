import React, { useState } from "react";
import setaBack from '../assets2/img/login e cadastro/66822.png'
import Footer from "../Components/Footer";
import '../styles/cadastro.css';
import { Link, useHistory } from 'react-router-dom';
import api from '../Services/api';

const initialValues = {
    nomeUsuario: '',
    senhaUsuario: '',
    emailUsuario: ''

}


function Cadastro(){

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

        api.post('/usuarios/cadastros', values)
        .then((response) => {
            history.push('/login')
        })
    }


    return(
        <>
        <div className="container-cadastro">
        <div className="button-back">
            <a href="">
                <Link to="/">
                <img src={setaBack} alt="return" />
                </Link>
            </a>
        </div>

        <div className="centro">
            <h1>Cadastro</h1>

            <form onSubmit={onSubmit}>
                <div className="text_fild">
                    <i className="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Nome" name="nomeUsuario" id="nomeUsuario" onChange={onChange} />
                </div>
                <div className="text_fild">
                    <i className="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Senha" name="senhaUsuario" id="senhaUsuario" onChange={onChange} />
                </div>
                <div className="text_fild">
                    <i className="fa fa-lock" aria-hidden="true"></i>
                    <input type="text" placeholder="E-mail" name="emailUsuario" id="emailUsuario" onChange={onChange} />
                </div>
                <div className="pass-div">
                    <input type="submit" value="Cadastrar" />
                    <div className="signup_link">
                        Já possui cadastro? <br />
                        <a className="aa">Ir para login</a>
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
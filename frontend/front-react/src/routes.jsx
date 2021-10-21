import React from "react";
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Cadastro from "./paginas/Cadastro";
import Home from './paginas/Home';
import Login from './paginas/Login';
import Planos from './paginas/Planos';
import QuemSomos from './paginas/QuemSomos';
import Configuracoes from "./paginas/Configuracoes";

function Routes(){
    return(
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/planos" exact component={Planos} />
                <Route path="/quemsomos" exact component={QuemSomos} />
                <Route path="/cadastro" exact component={Cadastro} />
                <Route path="/login" exact component={Login} />
                <Route path="/configuracoes" exact component={Configuracoes} />


            </Switch>
        </BrowserRouter>
    );
}

export default Routes;
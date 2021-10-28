import React from "react";
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Cadastro from "./paginas/Cadastro";
import Home from './paginas/Home';
import Login from './paginas/Login';
import Planos from './paginas/Planos';
import QuemSomos from './paginas/QuemSomos';
import Dashboard from './paginas/Dashboard';
import CadastroVeiculo from './paginas/CadastroVeiculo';

function Routes(){
    return(
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/planos" exact component={Planos} />
                <Route path="/quemsomos" exact component={QuemSomos} />
                <Route path="/cadastro" exact component={Cadastro} />
                <Route path="/login" exact component={Login} />
                <Route path="/dashboard" exact component={Dashboard} />
                <Route path="/veiculos" exact component={CadastroVeiculo} />
                
                


            </Switch>
        </BrowserRouter>
    );
}

export default Routes;

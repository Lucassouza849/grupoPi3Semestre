import React from "react";
import '../styles/plano.css';
import imgAvatarPlanos from '../assets2/img/planos/boneco-sifrao-planos.png';
import imgTabelaPlanos from "../assets2/img/planos/Group 196-1.png";
import Header from "../Components/Header";
import Footer from '../Components/Footer';


function Planos(){
    return(
       <>
       <Header />
        <div class="arrow">
            <a href="#" title="Back to Top"><span class="fas fa-angle-up"></span></a>
        </div>
       
    
    
        <section class="section-text">
            <div class="container-1">
                <div class="content-right">
                    <h1>Conheça nossos planos por assinatura</h1>
                    <p>Sem taxa de inscrição. Sem contrato de longo prazo.
                        Sem multa por rescisão contratual.
                    </p>
                </div>
            </div>
        </section>
        <section class="secao-um">
            <div class="container-2">
                <div class="content-image">
              
                    <img src={imgAvatarPlanos} alt="" />
                  
    
                </div>
                <div class="content-text">
                    <h1>Com planos que cabem no orçamento da sua oficina</h1>
    
                </div>
            </div>
            <div class="linha"></div>
        </section>
    
        <div class="secao-tabela">
            <div class="container-tabela">
                <img src={imgTabelaPlanos} alt="" />
            </div>
        </div>
    
        <div class="agrupamento-cards">
            <div class="content-cards">
                <div class="cards">
                    <div class="container-cards">
                        <div class="cards-title">
                            <h1>Básico</h1>
                            <span>R$29,90/mês</span>
                        </div>
    
                        <div class="cards-descriptions">
                            <h5>Descrição</h5>
                            <span>Uma breve descricao sobre o produto aqui...
                                Uma breve descricao sobre o produto aqui...Uma breve descricao sobre o produto aqui</span>
                        </div>
    
                        <div class="cards-button">
                            <button>Adquira já</button>
                        </div>
                    </div>
                </div>
    
                <div class="cards">
                    <div class="container-cards">
                        <div class="cards-title">
                            <h1>Premium</h1>
                            <span>R$59,90/mês</span>
                        </div>
    
                        <div class="cards-descriptions">
                            <h5>Descrição</h5>
                            <span>Uma breve descricao sobre o produto aqui...
                                Uma breve descricao sobre o produto aqui...Uma breve descricao sobre o produto aqui</span>
                        </div>
    
                        <div class="cards-button">
                            <button>Adquira já</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <Footer />
        </>
    );
}

export default Planos;
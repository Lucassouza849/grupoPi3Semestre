import React from "react";
import '../styles/about.css';
import avatarQuemSomos from '../assets2/img/quem somos/boneco-pilha-de-moedas-quem-somos.png';
import bonecoAnotando from "../assets2/img/quem somos/boneco-anotando-quem-somos.png";
import card1 from '../assets2/img/quem somos/card1.jpeg';
import card2 from '../assets2/img/quem somos/card2.jpeg';
import card3 from '../assets2/img/quem somos/card3.jpeg';
import pedro from '../assets2/img/quem somos/pedro.png';
import lucas from '../assets2/img/quem somos/lucas.png';
import vini from '../assets2/img/quem somos/cano.png';
import nich from '../assets2/img/quem somos/nicholas.png';
import bruna from '../assets2/img/quem somos/bruna.png';
import Header from "../Components/Header";
import Footer from "../Components/Footer";

function QuemSomos(){
    return(
        <>
        <Header />
        <div className="arrow">
            <a href="#" title="Back to Top"><span className="fas fa-angle-up">^</span></a>
        </div>
  


    <section className="section-one">
        <div className="container-one">
            <div className="texto-h2">
                <h2>Muito além de uma simples gestão</h2>
                <button className="button">Como Assim ?</button>
            </div>


            <div className="img-about">
                <img src={avatarQuemSomos} alt="" />
            </div>

        </div>


    </section>
    <div className="section-linha">
        <div className="linha"></div>
    </div>

    <section className="section-two">
        <div className="container-two">

            <div className="img-anotacao">
                <img src={bonecoAnotando} alt="" />
            </div>

            <div className="texto-anotacao">
                <h2>Quem quer resultado precisa de organização financeira!</h2>
                <p>A primeira tarefa é analisar a essência da sua empresa, feito isso, estaremos pronto para colocar em
                    ordem de negócio.</p>

            </div>
        </div>



    </section>
    <div className="section-linha">
        <div className="linha"></div>
    </div>

    <section className="section-three">

        <div className="mensagem">
            <div className="content1">
                <h2>Nossa Proposta</h2>
                <p>Empenhamos o bom funcionamento da sua gestão sem complicações diárias, e tudo completo</p>
            </div>

            <div className="pipe-quemSomos">

            </div>

            <div className="content2">
                <h2>Nosso método</h2>
                <p>Empenhamos o bom funcionamento da sua gestão sem complicações diárias, e tudo completo</p>
            </div>

        </div>


    </section>



    <div className="imag-box">
        <div className="content-img">
            <img src={card1} alt="" />
            <img src={card2} alt="" />
            <img src={card3} alt="" />
        </div>
    </div>



    <div className="section-time">
        <h1>Nosso Time</h1>
    </div>

    <div className="container-time">
        <div className="time">

            <div className="integrante1">
                <p>Lucas Souza</p>
                <img src={lucas} alt="" />
            </div>

            <div className="integrante2">
                <p>Bruna Brito</p>
                <img src={bruna} alt="" />

            </div>

            <div className="integrante3">
                <p>Pedro Gimenez</p>
                <img src={pedro} alt="" />                
            </div>

            <div className="integrante4">
                <p>Vinicius cano</p>
                <img src={vini} alt="" />

            </div>

            <div className="integrante5">
                <p>Nicholas Forte</p>
                <img src={nich} alt="" />

            </div>

        </div>

    </div>


    <Footer />
    </>
    );
}

export default QuemSomos;
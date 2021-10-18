import React from "react";
import '../styles/quemSomos.css';
import avatarQuemSomos from '../assets2/img/quem somos/boneco-pilha-de-moedas-quem-somos.png';
import bonecoAnotando from "../assets2/img/quem somos/boneco-anotando-quem-somos.png";
import card1 from '../assets2/img/quem somos/card1.jpeg';
import card2 from '../assets2/img/quem somos/card2.jpeg';
import card3 from '../assets2/img/quem somos/card3.jpeg';
import pedro from '../assets2/img/quem somos/lucas.jpeg';
import lucas from '../assets2/img/quem somos/bruna.jpeg';
import vini from '../assets2/img/quem somos/pedro.jpeg';
import nich from '../assets2/img/quem somos/cano.jpeg';
import bruna from '../assets2/img/quem somos/nicholas.jpeg';
import Header from "../Components/Header";
import Footer from "../Components/Footer";

function QuemSomos(){
    return(
        <>
        <Header />
        <div class="arrow">
            <a href="#" title="Back to Top"><span class="fas fa-angle-up"></span></a>
        </div>
  


    <section class="section">
        <div class="container">
            <div class="texto-h2">
                <h2>Muito além de uma simples gestão</h2>
                <button class="button">Como Assim ?</button>
            </div>


            <div class="img">
                <img src={avatarQuemSomos} alt="" />
            </div>

        </div>


    </section>
    <div class="section-linha">
        <div class="linha"></div>
    </div>

    <section class="section">
        <div class="container">

            <div class="img-anotacao">
                <img src={bonecoAnotando} alt="" />
            </div>

            <div class="texto-anotacao">
                <h2>Quem quer resultado precisa de organização financeira!</h2>
                <p>A primeira tarefa é analisar a essência da sua empresa, feito isso, estaremos pronto para colocar em
                    ordem de negócio.</p>

            </div>
        </div>



    </section>
    <div class="section-linha">
        <div class="linha"></div>
    </div>

    <section class="section">

        <div class="mensagem">
            <div class="content1">
                <h2>Nossa Proposta</h2>
                <p>Empenhamos o bom funcionamento da sua gestão sem complicações diárias, e tudo completo</p>
            </div>

            <div class="pipe-quemSomos">

            </div>

            <div class="content2">
                <h2>Nosso método</h2>
                <p>Empenhamos o bom funcionamento da sua gestão sem complicações diárias, e tudo completo</p>
            </div>

        </div>


    </section>



    <div class="imag-box">
        <div class="content-img">
            <img src={card1} alt="" />
            <img src={card2} alt="" />
            <img src={card3} alt="" />
        </div>
    </div>



    <div class="section-time">
        <h1>Nosso Time</h1>
    </div>

    <div class="container-time">
        <div class="time">

            <div class="integrante1">
                <img src={lucas} alt="" />
                <p>Lucas Souza</p>
            </div>

            <div class="integrante2">
                <p>Bruna Brito</p>
                <img src={bruna} alt="" />

            </div>




        </div>

    </div>


    <div class="container-time">
        <div class="time">

            <div class="integrante1">
                <img src={pedro} alt="" />
                <p>Pedro Gimenez</p>
            </div>

            <div class="integrante2">
                <p>Vinicius cano</p>
                <img src={vini} alt="" />

            </div>




        </div>

    </div>

    <div class="container-time">
        <div class="time">


            <div class="integrante5">
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
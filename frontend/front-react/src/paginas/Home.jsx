import React from "react";
import bonecoBanner from '../assets2/img/home/boneco-sentado-home.png';
import hldImg from '../assets2/img/home/mapa.png';
import Footer from "../Components/Footer";
import Header from "../Components/Header";
import '../styles/index.css';


function Home(){
    return(
        <>
        <Header />
        <section class="section-one">
            <div class="container">
                <div class="content-left">
                    <div class="img">
                        <img src={bonecoBanner} alt="" />
                    </div>
                    <div class="botao">
                        <button>Conheça mais sobre nossos planos</button>
                    </div>
                </div>
                <div class="content-right">
                    <h1>O Lugar onde a gestão é mais simples!</h1>
                    <p>A liberdade e o controle que você precisava!</p>
                </div>
            </div>
        </section>
 
        <div class="arrow">
            <a href="#" title="Back to Top"><span class="fas fa-angle-up"></span></a>
        </div>
    
        <div class="carrousel">
            <div class="titulo-carrousel">
                <h1>Aqui você encontra...</h1>
            </div>
            <div id="itens-carrousel">
                <div id="item">
                    <div class="itens"><img src={bonecoBanner} alt="" /></div>
                    <div class="itens"><img src={bonecoBanner} alt="" /></div>
                    <div class="itens"><img src={bonecoBanner} alt="" /></div>
                    <div class="itens"><img src={bonecoBanner} alt="" /></div>
                </div>
            </div>
            <div class="linha"></div>
        </div>
   
        <div class="section-mapa">
            <div class="container-mapa">
                <div class="title-mapa">
                    <h1>Está perdido? Vamos te explicar o passo a passo:</h1>
                </div>
                <div class="img-mapa">
                    <img src={hldImg} alt="" />
                </div>
            </div>
        </div>
        <Footer />
        </>
    );
}

export default Home;
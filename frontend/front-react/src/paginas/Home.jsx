import React from "react";
import bonecoBanner from '../assets2/img/home/boneco-sentado-home.png';
import hldImg from '../assets2/img/home/mapa.png';
import Footer from "../Components/Footer";
import Header from "../Components/Header";
import bannerOne from '../assets2/img/1.png';
import bannerTwo from '../assets2/img/2.png';
import bannerThree from '../assets2/img/3.png';
import '../styles/index.css';


function Home(){
    return(
        <>
        <Header />
       
        <section className="section-one">
            <div className="container">
                <div className="content-left">
                    <div className="img">
                        <img src={bonecoBanner} alt="" />
                    </div>
                    <div className="botao">
                        <button>Conheça mais sobre nossos planos</button>
                    </div>
                </div>
                <div className="content-right">
                    <h1>O Lugar onde a gestão é mais simples!</h1>
                    <p>A liberdade e o controle que você precisava!</p>
                </div>
            </div>
        </section>
 
        <div className="arrow">
            <a href="#" title="Back to Top"><span classNameName="fas fa-angle-up">^</span></a>
        </div>
    
        <div className="carrousel">
            <div className="titulo-carrousel">
                <h1>Aqui você encontra...</h1>
            </div>
            <div id="itens-carrousel">
                <div id="item">
                    <div className="itens"><img src={bannerOne} alt="" /></div>
                    <div className="itens"><img src={bannerTwo} alt="" /></div>
                    <div className="itens"><img src={bannerThree} alt="" /></div>
                </div>
            </div>
            <div className="linha"></div>
        </div>
   
        <div className="section-mapa">
            <div className="container-mapa">
                <div className="title-mapa">
                    <h1>Está perdido? Vamos te explicar o passo a passo:</h1>
                </div>
                <div className="img-mapa">
                    <img src={hldImg} alt="" />
                </div>
            </div>
        </div>
        <Footer />
        </>
    );
}

export default Home;
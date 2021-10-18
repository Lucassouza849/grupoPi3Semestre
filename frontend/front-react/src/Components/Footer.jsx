import React from "react";
import imgLocal from '../assets2/img/heander e footer/localizacao-footer.png';
import imgEmail from '../assets2/img/heander e footer/email-footer.png';
import imgTel from '../assets2/img/heander e footer/telefone-footer.png';
import imgFace from '../assets2/img/heander e footer/facebook-footer.png';
import imgInsta from '../assets2/img/heander e footer/instagram-footer.png';
import imgLinkedin from '../assets2/img/heander e footer/linkedin-footer.png';
import imgLogoFooter from '../assets2/img/logo/logo.png';

function Footer(){
    return(

        <footer>
        <div class="container">

            <div class="container-coluna1">
                <div class="coluna">
                    <img src={imgLocal} alt="" />
                    <p>Rua Haddock Lobo, 595 São Paulo SP</p>
                </div>

                <div class="coluna">
                    <img src={imgEmail} alt="" />
                    <p>contato@smarttools.com.br</p>
                </div>

                <div class="coluna">
                    <img src={imgTel} alt="" />
                    <p>(11) 2543 - 3434</p>
                </div>
            </div>

            <div class="container-coluna2">
                <div class="coluna2">
                    <p>Siga nossas redes sociais</p>
                    <img src={imgFace} alt="" />
                    <img src={imgInsta} alt="" />
                    <img src={imgLinkedin} alt="" />
                </div>
            </div>

            <div class="container-coluna3">
                <div class="coluna3">
                    <img src={imgLogoFooter} alt="" />
                </div>
            </div>
        </div>
        <div class="container-footer">
            <div class="footer">
                <div class="copyright">
                    © 2021 Site desenvolvidos por Alunos Bandtec | <a href="#">Smart Tools</a>
                </div>

                <div class="information">
                    <a href="#">Mais Informações</a> | <a href="#">Politica de privacidade</a> | <a href="#">Termos e
                        condições</a>
                </div>
            </div>

        </div>
    </footer>

    );
}

export default Footer;
window.onload = function(){
    function iniciaModal(modalID){
    const modal = document.getElementById(modalID);
    modal.classList.add('mostrar');
    modal.addEventListener('click', (evento) =>{
        if(evento.target.id == 'fechar'){
            modal.classList.remove('mostrar');
        }
    });
}
const btn_mais = document.querySelector('.btn_mais');
btn_mais.addEventListener('click', () => iniciaModal('modal-side'));
}

function entrada_mostrar(){
    entrada.style.display = 'block'
    saida.style.display = 'none'
}
function saida_mostrar(){
    entrada.style.display = 'none'
    saida.style.display = 'block'
}



String.prototype.reverse = function(){
    return this.split('').reverse().join(''); 
  };
  
  function mascaraMoeda(campo,evento){
    var tecla = (!evento) ? window.event.keyCode : evento.which;
    var valor  =  campo.value.replace(/[^\d]+/gi,'').reverse();
    var resultado  = "";
    var mascara = "##.###.###,##".reverse();
    for (var x=0, y=0; x<mascara.length && y<valor.length;) {
      if (mascara.charAt(x) != '#') {
        resultado += mascara.charAt(x);
        x++;
      } else {
        resultado += valor.charAt(y);
        y++;
        x++;
      }
    }
    campo.value = resultado.reverse();
  }


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

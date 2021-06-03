const btnS = document.getElementById('btnS');

function toggleMenu(){
    const Menu = document.getElementById('Menu');
    Menu.classList.toggle('active');
    btnS.classList.toggle('active');
}

btnS.addEventListener('click', toggleMenu);
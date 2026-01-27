window.addEventListener('scroll', () => {
    const header = document.querySelector('header');
    header.classList.toggle('desplazada', window.scrollY > 10);
});
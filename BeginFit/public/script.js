var ele = document.querySelector('.hamburger-button');
console.log(ele);
ele.addEventListener('click',()=>{
    console.log('clicked');
    ele.classList.add('toggle');
    let remove_none = document.querySelector('#navigation');
    remove_none.style.display = 'initial';
    console.log(remove_none);
    
}
    );


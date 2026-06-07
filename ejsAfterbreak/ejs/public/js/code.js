let btns = document.querySelectorAll('button');

for(b of btns){
    b.addEventListener('click' , () => {
        console.log('btn was clicked');
    })
}
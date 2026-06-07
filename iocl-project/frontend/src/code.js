const btn = document.querySelector('#btn-res');
console.log(btn);
btn.addEventListener('click', (e) => {
   
    let obj = [];
    const arr = ['a','b'];
    let iDstorage = [];
    for(let i = 1;i <= 2;i++){
        for(let j = 0;j < arr.length;j++){
            iDstorage.push(`${arr[j]}${i}`)
        }
    }
    for(let i = 0;i < 4;i++){
        
        let opt = document.getElementById(`d${i}`);
        var options = opt.options[opt.selectedIndex].text;
        
        let a1 = document.getElementById(`${iDstorage[i]}-1`).value;
        let a2 = document.getElementById(`${iDstorage[i]}-2`).value;
        let result = parseFloat(a2-a1).toPrecision(2);
       
        // console.log(`${options} ${a1} ${a2} ${result}`);
        let tempObj = {
            id:i,
            type: options,
            readingYesterday : a1,
            readingToday: a2,
            result : result
        }
       
        obj.push(tempObj);
    }
    
   
})
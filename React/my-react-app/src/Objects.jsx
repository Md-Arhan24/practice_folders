import React,{useState} from 'react';
function Object(){

    const [car,setcar] = useState({year:2024,
                             company:"ford",
                             model:"mustang"});
        function changeYear(e){
        //setcar(car.year,car.company,car.model,e.target.value)
            setcar({...car,year:e.target.value});//the ...car called ternary operator use to set the value with the previous one
        }
        //mistakes
        //1-forgotten to type {} barackets at setcar(...car,year:e.target.value)
        //2-forgotten to mention the which property to change setcar({...car,e.target.value})
        function changeCompany(e){
            setcar({...car,company:e.target.value});
        }
        function changeModel(e){
            setcar({...car,model:e.target.value});
        }
    return(<div>
        <input type="number" value={car.year} onChange={changeYear} />
        <input type="text" value={car.company} onChange={changeCompany} />
        <input type="text" value={car.model} onChange={changeModel} />
        <p>your faviroute car is {car.year} {car.company} {car.model}</p>

    </div>)
}
export default Object;
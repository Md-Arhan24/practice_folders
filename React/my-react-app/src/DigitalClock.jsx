import {useState,useEffect} from 'react';
//how to make a timer feature in it
//how to make an alaram feature


function DigitalClock(){
    const[time,setTime] = useState(new Date ());
   useEffect(()=>{
       const intervalled =  setInterval(() => {
            setTime(new Date ());
        }, 1000);
        return () =>{
            clearInterval(intervalled);
            console.log("cleared");
        }
       
   },[])
   function watch(){
    let hour = time.getHours();
    const minute = time.getMinutes();
    const second = time.getSeconds();
    const meridian = hour >= 12 ? "pm" : "am";
    hour = hour - 12 || 12;
    return(`${propernumber(hour)}:${propernumber(minute)}:${propernumber(second)}${meridian}`)
   }
   function calender(){
    let days = ['sunday','monday','tuesday','thursday','friday','saturday']
    let months = ['jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','dec']
    let index = time.getDay();
    let day = days[index];
    console.log(day);
    let date = time.getDate();
    let month = months[time.getMonth()];
    let year = time.getFullYear();
    return(`${day} ${date} ${month} ${year}`);
   }
   function propernumber(num){
       return( num < 9 ? "0" + num : num);
   }
    return(
    <div className='container' >
        <div className="clock">
            <span  >{watch()}</span>
        </div>
        <div className="date" >{calender()}</div>
    </div>
    );
}

export default DigitalClock;
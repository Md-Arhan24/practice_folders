import './Card.css';
export default function Card({title,img,desc,cutoff,price}){
    let data = desc.map((e) => <li>{e}</li>);
    return(
        <div className="card">
            <h3>{title}</h3>
            <img src={img} alt="image" />
            <p>{data}</p>
            <b className='price'><del>{cutoff}</del> <b>{price}</b></b>
            
        </div>
    );

}
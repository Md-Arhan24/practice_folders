import "./Product.css";
import Price from "./Price";
function Product({array,idx}) {

  return(
    <div className="product">
      <p>title</p>
      <p>{array[idx]}</p>
      <Price />
    </div>
   
  );
 
}
export default Product;

import "./App.css";
import Base from "./Base";
import Login from "./Login";
import Singup from "./Singup";
import Home from "./Home";
import { useRoutes } from 'react-router-dom';

function App() {
 
  const paths = useRoutes([
    {path:"/login",element:<Login/>},
     {path:"/singup",element:<Singup/>},
    {path:"/main",element:<Base/>},
    {index:true,element:<Home/>}
    ]);
  return paths;
 
}

export default App;

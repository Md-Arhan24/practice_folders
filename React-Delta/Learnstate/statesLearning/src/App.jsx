import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Card from './Card';
import Counter from './Counter';
import LikeButton from './LikeButton';
import Lottery from './Lottery';


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <Lottery/>
    <h1>hellow</h1>
    </>
  )
}

export default App

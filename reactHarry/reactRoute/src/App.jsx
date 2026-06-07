import { useState } from 'react'
import Navtag from './components/Navtag'
import {createBrowserRouter , RouterProvider} from 'react-router-dom'
import Home from './components/Home'
import Resource from './components/Resource'
import User from './components/User'
import About from './components/About'
function App() {
  const [count, setCount] = useState(0)
  const router = createBrowserRouter([
    {
      path:'/about',
      element: <><Navtag/><About/></>
    },
    {
      path:'/home',
      element: <><Navtag/><Home/></>
    },
    {
      path:'/resource',
      element:<><Navtag/><Resource/></>
    },
    {
      path: '/user/:username',
      element:<><Navtag/><User/></> 
    },
  ])
  return (
    <>
      
      <RouterProvider router={router} />
    </>
  )
}

export default App

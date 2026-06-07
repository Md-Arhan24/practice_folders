import React from 'react'
import { Link } from 'react-router-dom'
const Navtag = () => {
  return (
    <div>
        <nav>
            <ul>
                <li><Link to="/home">home</Link></li>
                <li><Link to="/about">about</Link></li>
                <li><Link to="/resource">resource</Link></li>
                <li><Link to="/user">user</Link></li>
            </ul>
        </nav>
    </div>
  )
}

export default Navtag
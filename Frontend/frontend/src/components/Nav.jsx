import React from 'react'

function Nav({children}) {
  return (
    <nav className='w-9/12 max-w-7xl flex justify-between mx-auto bg-slate-800/[.8] rounded-b-lg h-16 place-items-center'>{children}</nav>
  )
}

export default Nav
import React, {Children} from 'react'
import Link from "./Link.jsx";

function ContainerNav({children}) {
  return (
      <div className="flex flex-row bg-slate-800/[.8] rounded-3xl">
        <div className="basis-1/3 text-3xl italic content-center pl-3">
          {children}
        </div>
        <div className = "basis-2/3">
          <nav className='flex justify-between mx-auto bg-slate-800/[.8] h-16 place-items-center rounded-3xl'>
            <Link href="/">Homepage</Link>
            <Link href="./appointment">Időpontjaim</Link>
            <Link href="./services">Szolgáltatások</Link>
          </nav>
        </div>
      </div>
        )
        }

        export default ContainerNav
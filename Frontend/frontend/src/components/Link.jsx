function Link({children, href}) {
  return (
    <a href={href} className="w-1/4 bg-slate-900/[.9] text-white text-center h-10 rounded-lg mx-2">{children}</a>
  )
}

export default Link
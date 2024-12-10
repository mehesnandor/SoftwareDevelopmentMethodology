import React from "react";

function Container({ children }) {
  return (
    <div className="place-items-center self-center bg-gradient-to-br from-slate-900 to-slate-500  rounded-3xl w-3/5 h-auto min-h-80 text-white mx-auto">
      {children}
    </div>
  );
}

export default Container;

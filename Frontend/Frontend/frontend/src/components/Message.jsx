
function Message(props) {
  return  true ?(
      <div className={"bg-white w-screen h-screen grid place-content-center"}>
        <div className={props.found ?"bg-red-200 place-items-center text-center self-center rounded-3xl  p-10 text-5xl" :"bg-green-200 place-items-center text-center self-center rounded-3xl  p-10 text-5xl"}>
            <p>{props.found ? "Az időpont már le van foglalva" : "Sikeresen foglaltál"}</p>
            <button onClick={()=>props.setMessage(false)}  className={props.found ?"bg-red-500 p-5 rounded-2xl mt-10" :"bg-green-500 p-5 rounded-2xl mt-10"}>OK</button>
        </div>
      </div>
  ) : ""
}

export default Message
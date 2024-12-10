import { useState } from "react";
import Message from "./Message";

function Form(props) {
  const [user, setUser] = useState({ vnev: "", knev: "", email: "", tel: "" });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser((prevUser) => ({ ...prevUser, [name]: value }));
  };

  async function getAppointments(email, phoneNumber) {
    const baseUrl = "http://localhost:8080/api/v1/list";

    // Opcionális paraméterek hozzáadása az URL-hez
    const params = new URLSearchParams();
    if (email) params.append("email", email);
    if (phoneNumber) params.append("phone", phoneNumber);

    const url = `${baseUrl}?${params.toString()}`;

    try {
      const response = await fetch(url, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!response.ok) {
        throw new Error(`Hiba történt: ${response.status}`);
      }

      const result = await response.json();
      console.log("Kapott adatok:");
      let arr = [];
      result.map((e) => {
        arr.push(e.idopont);
      });
      props.setAppointments(arr);
      props.setFound(true);
      return result;
    } catch (error) {
      console.error("Hiba a GET kérés során:", error);
    }
  }

  async function addAppointment(idopont, nev, email, phoneNumber) {
    const url = "http://localhost:8080/api/v1/add";

    const body = {
      id: null, // Mindig null
      idopont: idopont, // LocalDateTime formátumban, például: "2024-11-27T14:00:00"
      nev: nev,
      email: email,
      phoneNumber: phoneNumber,
    };

    console.log(body);

    try {
      const response = await fetch(url, {
        method: "POST", // HTTP-módszer
        headers: {
          "Content-Type": "application/json", // Adatok JSON-ként küldése
        },
        body: JSON.stringify(body), // A body JSON formátumba alakítása
      });

      if (!response.ok) {
        props.setTrigger(false);
        throw new Error(`Hiba történt: ${response.status}`);
        if (response.status == "asd") {
          setMessage(true);
          <Message trigger={message} found={true} setMessage={setMessage} />;
        }
      }
      console.log("Sikeres válasz:", result);
      props.setTrigger(false);
      setMessage(true);
      <Message trigger={message} found={false} setMessage={setMessage} />;
      const result = await response.json(); // Sikeres válasz feldolgozása
      return result;
    } catch (error) {
      console.error("Hiba a POST kérés során:", error);
    }
  }
  const [message, setMessage] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    var name = user.vnev + " " + user.knev;
    addAppointment(props.idopont, name, user.email, user.tel);
  };
  const requestData = (e) => {
    e.preventDefault();
    props.setAppointments(getAppointments(user.email, user.tel));
    props.setFound(true);
  };

  function handleTriger() {
    props.setTrigger(false);
  }

  return props.trigger ? (
    <div
      className={
        props.foglal
          ? "fixed top-0 left-0 w-screen h-screen flex justify-center items-center bg-neutral-400/[.5]"
          : "fixed top-0 left-0 w-screen h-screen flex justify-center items-center bg-neutral-400"
      }
    >
      <div className="  w-fit h-fit bg-gradient-to-br from-neutral-800 to-neutral-400 rounded-lg">
        {props.foglal ? (
          <div>
            <div className=" bg-slate-800/[.8] rounded-3xl">
              <p className="text-center text-xl p-3">{props.ido}</p>
            </div>

            <div className="grid grid-cols-2 gap-x-2 p-6">
              <div className="sm:col-span-1">
                <label>Vezetéknév*</label>
                <div className="pt-2">
                  <input
                    type="text"
                    name="vnev"
                    className="block text-black min-w-full"
                    onChange={handleChange}
                  ></input>
                </div>
              </div>
              <div className="sm:col-span-1">
                <label>Keresztnév*</label>
                <div className="pt-2">
                  <input
                    type="text"
                    name="knev"
                    className="block text-black min-w-full"
                    onChange={handleChange}
                  ></input>
                </div>
              </div>
              <div className="col-span-full pt-4">
                <label>E-mail*</label>
                <div className="pt-2">
                  <input
                    type="text"
                    name="email"
                    className="block text-black min-w-full"
                    onChange={handleChange}
                  ></input>
                </div>
              </div>
              <div className="col-span-full pt-4">
                <label>Telefonszám</label>
                <div className="pt-2">
                  <input
                    type="text"
                    name="tel"
                    className="block text-black min-w-full"
                    onChange={handleChange}
                  ></input>
                </div>
              </div>
            </div>
          </div>
        ) : (
          <div>
            <p className="italic text-sm pt-8 px-8 text-white">
              Kérjük adja meg adatait, hogy lekérhessük a hozzá tartozó
              időpontokat, ha foglalt már rendszerünkben!
            </p>
            <div className="grid grid-cols-2 gap-x-2 p-6 text-white">
              <div className="sm:col-span-1">
                <label>Vezetéknév*</label>
                <div className="pt-2">
                  <input
                    name="vnev"
                    onChange={handleChange}
                    type="text"
                    className="block text-black min-w-full"
                  ></input>
                </div>
              </div>
              <div className="sm:col-span-1">
                <label>Keresztnév*</label>
                <div className="pt-2">
                  <input
                    name="knev"
                    onChange={handleChange}
                    type="text"
                    className="block text-black min-w-full"
                  ></input>
                </div>
              </div>
              <div className="col-span-full pt-4">
                <label>E-mail*</label>
                <div className="pt-2">
                  <input
                    name="email"
                    onChange={handleChange}
                    type="text"
                    className="block text-black min-w-full"
                  ></input>
                </div>
              </div>
            </div>
          </div>
        )}

        <div className="flex justify-around mb-2">
          <button
            className="bg-red-700 rounded-lg w-fit p-2"
            onClick={
              props.foglal
                ? handleTriger
                : () => {
                    props.setFound(true);
                    props.setAppointments([""]);
                  }
            }
          >
            Mégse
          </button>
          <button
            type="submit"
            disabled={user.vnev == "" || user.knev == "" || user.email == ""}
            className="bg-green-700 rounded-lg w-fit p-2"
            onClick={props.foglal ? handleSubmit : requestData}
          >
            {props.foglal ? "Foglalás" : "Lekérdezés"}
          </button>
        </div>
      </div>
    </div>
  ) : (
    ""
  );
}

export default Form;

import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import Container from "../src/components/Container";
import ContainerNav from "../src/components/ContainerNav";

function Book() {
  const idopontok = [
    "08:00 - 09:00",
    "09:00 - 10:00",
    "10:00 - 11:00",
    "11:00 - 12:00",
    "12:00 - 13:00",
  ];
  const idopontok1 = [
    "13:00 - 14:00",
    "14:00 - 15:00",
    "15:00 - 16:00",
    "16:00 - 17:00",
    "17:00 - 18:00",
  ];
  const [user, setUser] = useState({ nev: "", email: "" });

  const handleSubmit = (event) => {
    console.log(user);
    event.preventDefault();
    fetch("http://localhost:5172/api/v1/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(user),
    })
      .then((response) => response.json())
      .catch((error) => console.error("Error creating user:", error));
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setUser((prevUser) => ({ ...prevUser, [name]: value }));
  };
  const location = useLocation();
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear(),
    today.getMonth() + location.state.monthOffset,
    1
  );

  const month = targetDate.toLocaleString("hu", { month: "long" });

  return (
    <div className="grid justify-items-center bg-gradient-to-br from-neutral-800 to-neutral-400 h-screen">
      <Container>
        <ContainerNav> Időpontfoglalás</ContainerNav>
        <div>
          <h1 className="my-15 text-center text-4xl font-semibold capitalize mt-5 mb-5">{month + " " + location.state.day}</h1>
        </div>
        <div className="flex justify-around text-3xl font-semibold leading-10 mb-5 tabular-nums">
          <div>
            {idopontok.map((idopont) => (
              <p className="my-5 hover:text-cyan-200">{idopont}</p>
            ))}
          </div>
          <div>
            <div>
              {idopontok1.map((idopont) => (
                <p className = "my-5 hover:text-cyan-200">{idopont}</p>
              ))}
            </div>
          </div>
        </div>
      </Container>
    </div>
  );
}

export default Book;

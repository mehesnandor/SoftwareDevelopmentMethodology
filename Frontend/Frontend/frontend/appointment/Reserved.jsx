import { useState } from "react";
import Container from "../src/components/Container";
import ContainerNav from "../src/components/ContainerNav";
import Form from "../src/components/Form";

function Reserved() {
  const [appointments, setAppointments] = useState([null]);
  const [found, setFound] = useState(false);

  function handleSubmit() {
    console.log(appointments);
  }

  return (
    <>
      {!found ? (
        <Form
          trigger={true}
          foglal={false}
          setAppointments={setAppointments}
          setFound={setFound}
          onSubmit={handleSubmit}
        />
      ) : (
        <div className="grid justify-items-center bg-gradient-to-br from-neutral-800 to-neutral-400 h-screen">
          <Container>
            <ContainerNav>Időpontjaim</ContainerNav>
            <div className="flex justify-around text-3xl font-semibold leading-10 mb-5 tabular-nums">
              {
                console.log(appointments)
                /* miután megkaptuk az appointmentseket végig kell rajta menni a mappel és elhelyezni a design szerint az adatokat */
              }
            </div>
          </Container>
        </div>
      )}
    </>
  );
}

export default Reserved;

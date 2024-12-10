import React from "react";
import Container from "../src/components/Container.jsx";
import ContainerNav from "../src/components/ContainerNav.jsx";

function Services() {
  return (
    <div className="grid justify-items-center bg-gradient-to-br from-neutral-800 to-neutral-400 h-screen">
      <Container>
        <ContainerNav>Szolgáltatásaink</ContainerNav>
        <div className="flex flex-row place-self-center content-center text-white mt-10">
          <div className="basis-1/2 text-center m-2">
            <div className="font-bold text-3xl mb-4">Nyitvatartás:</div>
            <div className="grid justify-items-center">
              <table className="text-center border border-white text-1xl font-sans w-3/4">
                <tbody>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Hétfő</td> <td>8:00 - 18:00</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Kedd</td> <td>8:00 - 18:00</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Szerda</td> <td>8:00 - 18:00</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Csütörtök</td> <td>8:00 - 18:00</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Péntek</td> <td>8:00 - 18:00</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Szo - Vas</td> <td>ZÁRVA</td>{" "}
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <div className="basis-1/2 text-center m-2">
            <div className="font-bold text-3xl mb-4">Szolgáltatások:</div>
            <div className="grid justify-items-center">
              <table className="text-center border border-white text-1xl font-sans w-3/4">
                <tbody>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Hajvágás</td> <td>4990 HUF</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Hosszú Hajvágás</td> <td>5990 HUF</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Hajfestés</td> <td>3990 HUF</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Melírozás</td> <td>8000 HUF</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Göndörítés</td> <td>5000 HUF</td>{" "}
                  </tr>
                  <tr className="*:border *:border-white *:p-5">
                    {" "}
                    <td>Hajvasalás</td> <td>2990 HUF</td>{" "}
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </Container>
    </div>
  );
}

export default Services;

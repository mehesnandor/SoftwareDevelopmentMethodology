import Calendar from "./components/Calendar";
import Link from "./components/Link";
import Nav from "./components/Nav";
import fetchedUrl from "./assets/background.png"

export default function App() {
  return (
    <div style={{'--image-url': `url(${fetchedUrl})`}} 
    className='bg-[image:var(--image-url)] h-screen'>
      <Nav>
      <Link href="/">Homepage</Link>
        <Link href="./appointment">Időpontjaim</Link>
        <Link href="./services">Szolgáltatások</Link>
      </Nav>
      <div className="flex flex-row mx-20">
        <div className="basis-4/6 bg-slate-800/[.8] text-white my-20 py-10 px-20">
          <div className="flex justify-center italic text-3xl font-sans pb-10">
            <ul className="list-inside list-disc">
              <li>Képzettség:</li>
              <ul className="list-inside list-disc ml-10">
                <li>Cerified Hair Stylist, London Collage of Beauty</li>
                <li>Advenced Cutting Techniques, Beauty Academy Liverpool</li>
              </ul>

              <li>Licensed Hair Braider</li>
              <li>Email: john.doe@example.com</li>
            </ul>
          </div>
          <div className="flex flex-row">
            <div className="basis-1/3 m-2 bg-slate-800">
              <Calendar monthOffset={0} />
            </div>
            <div className="basis-1/3 m-2 bg-slate-800">
              <Calendar monthOffset={1} />
            </div>
            <div className="basis-1/3 m-2 bg-slate-800">
              <Calendar monthOffset={2} />
            </div>
          </div>
        </div>
        <div className="flex flex-col basis-2/6 m-10 mt-20 text-center text-white text-3xl italic">
          <div className={"bg-slate-800/[.8] mb-5 rounded-lg"}>John Doe</div>
          <img
            src="/src/assets/hairdresser.png"
            alt="Picture of the hairdresser"
            className="rounded-lg"
          />
        </div>
      </div>
    </div>
  );
}

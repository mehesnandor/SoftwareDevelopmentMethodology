import * as React from "react";
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import "./index.css";
import App from "./App";
import Reserved from "../appointment/Reserved"
import Services from "../services/Services"
import Book from "../book/Book"
import Message from "./components/Message";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
  },
  {
    path: "/appointment",
    element: <Reserved/>,
  },
  {
    path: "/services",
    element: <Services/>,
  },
  {
    path: "/book",
    element: <Book/>,
  },
  {
    path: "/message",
    element: <Message/>,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
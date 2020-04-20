import "bootstrap/dist/css/bootstrap.min.css";

import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import { ContextProvider } from "./container/Context";
import App from "./container/App";

ReactDOM.render(
  <React.StrictMode>
    <ContextProvider>
      <App></App>
    </ContextProvider>
  </React.StrictMode>,
  document.getElementById("root")
);

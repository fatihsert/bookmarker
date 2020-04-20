import React, { Component } from "react";
import ContextConsumer from "./Context";
import Login from './Login'
export default class App extends Component {
  render() {
    return <div>
      <ContextConsumer>
        {({userInfo})=>{
          if(userInfo===null)
          {
            return <Login></Login>
          }
          else {
           return <div>Ana Sayfa</div> 
          }
        }}
      </ContextConsumer>
    </div>;
  }
}

import React, { Component } from "react";
const applicationContext = React.createContext("bookmarker");

export class ContextProvider extends Component {
  state = {
    userInfo: null
  };
  render() {
    return (
      <applicationContext.Provider value={this.state}>
        {this.props.children}
      </applicationContext.Provider>
    );
  }
}

const ContextConsumer = applicationContext.Consumer;

export default ContextConsumer;

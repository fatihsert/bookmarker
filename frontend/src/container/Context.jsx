import React, { Component } from "react";
const applicationContext = React.createContext("bookmarker");

const reducer = (state, action) => {
  switch (action.type) {
    case "Login":
      debugger;


      return {...state,userInfo:{jwt:action.payload}};
    default:
      return state;
  }
};

export class ContextProvider extends Component {
  state = {
    userInfo: null,
    dispatch: (action) => {
      this.setState((state) => reducer(state, action));
    },
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

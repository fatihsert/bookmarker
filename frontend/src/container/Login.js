import React, { Component } from "react";
import "./Login.css";
import { Form, Input, Button } from "reactstrap";
import axios from "axios";
import ContextConsumer from "./Context";

class Login extends Component {
  constructor(props) {
    super(props);

    this.onChange = this.onChange.bind(this);
    this.state = {
      username: "",
      password: "",
      validation: "",
    };
  }

  onChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };
  onSubmit = (dispatch,e) => {
    debugger;
    e.preventDefault();
    if (this.state.username.length === 0 || this.state.password.lengt === 0) {
      this.setState({ validation: "User name or password incorrect" });
      return;
    }

    axios
      .post(
        "http://bookmarker-bookmarker.apps.ca-central-1.starter.openshift-online.com/users/login",
        {
          username: this.state.username,
          password: this.state.password,
        }
      )//.then(JSON.parse)
      .then((data) => {
        dispatch({type:"Login",payload:data.data});
      })
      .catch((e) => {
        console.log(e);
      });
  };
  render() {
    return (
      <ContextConsumer>
        {({ dispatch }) => {
          return (
            <div className="text-center">
              <h2>Welcome to bookmarker </h2>
              <Form className="form-signin" onSubmit={this.onSubmit.bind(this,dispatch)}>
                {this.state.validation.length > 0 ? (
                  <div>{this.state.validation}</div>
                ) : null}
                <Input
                  type="text"
                  name="username"
                  placeholder="User Name"
                  onChange={this.onChange}
                />
                <Input
                  type="password"
                  name="password"
                  placeholder="Password"
                  onChange={this.onChange}
                />
                <Button outline color="primary" size="lg">
                  Sign in
                </Button>
              </Form>
            </div>
          );
        }}
      </ContextConsumer>
    );
  }
}

export default Login;

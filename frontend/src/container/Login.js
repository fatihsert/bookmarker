import React, { Component } from "react";
import "./Login.css";
import { Form, Input, Button } from "reactstrap";
import axios from "axios";

class Login extends Component {
  constructor(props) {
    super(props);

    this.onSubmit = this.onSubmit.bind(this);
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
  onSubmit = (e) => {
    e.preventDefault();
    if (this.state.username.length === 0 || this.state.password.lengt === 0) {
      this.setState({ validation: "User name or password incorrect" });
      return;
    }

    axios
      .post("", {
        username: this.state.username,
        password: this.state.password,
      })
      .then((res) => {});
  };

  render() {
    return (
      <div className="text-center">
        <h2>Welcome to bookmarker </h2>
        <Form className="form-signin" onSubmit={this.onSubmit}>
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
  }
}

export default Login;

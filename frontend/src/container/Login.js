import React, { Component } from "react";
import "./Login.css";
import { Form, Input, Button } from "reactstrap";

class Login extends Component {
  render() {
    return (
      <div className="text-center">
        <h2>Welcome to bookmarker </h2>
        <Form className="form-signin ">
          <Input type="text" placeholder="User Name" />
          <Input type="password" placeholder="Password" />
          <Button outline color="primary" size="lg">
            Sign in
          </Button>
        </Form>
      </div>
    );
  }
}

export default Login;

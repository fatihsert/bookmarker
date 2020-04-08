import React, { Component } from 'react';
import TextBox from '../component/TextBox'
import './Login.css';
import Button from '../component/Button'
import Password from '../component/Password'
import Label from '../component/Label'
import H from '../component/H'
import Form from '../component/Form'


class Login extends Component
{
    render()
    {
        return (
            <Form className="form-signin">
                <H className="h3 mb-3 font-weight-normal" text="Please sign in"/>
                <Label forId="inputUserName" className="sr-only" text="User name"></Label>
                <TextBox className="form-control" placeholder="User Name" id="inputUserName"></TextBox>
                <Label forId="inputPasssword" className="sr-only" text="Password"></Label>
                <Password className="form-control" placeholder="Password" id="inputPasssword"></Password>
                <Button className="btn btn-lg btn-primary btn-block" text="Sign in"/>            
          </Form>
        );
    }

}

export default Login;
import React from 'react'

const Form=(props)=>{
    return (
        <form className={props.className}>  {props.children}</form>
    );
};

export default Form;
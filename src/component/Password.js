import React from 'react'
import Input from './Input'

const Password=({placeholder,className,id})=>{

    return (
        <Input type="password" id={id} className={className} placeholder={placeholder}/>
    );
};

export default Password;
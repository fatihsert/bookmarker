import React from 'react'
import Input from './Input'

const TextBox=({placeholder,className,id})=>{

    return (
        <Input type="text" id={id} className={className} placeholder={placeholder}/>
    );
};

export default TextBox;
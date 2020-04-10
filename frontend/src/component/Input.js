import React from 'react'
import './Input'
const Input=({placeholder,type,className,id})=>{

    return (
        <input type={type} id={id} className={className} placeholder={placeholder}/>
    );
};

export default Input;
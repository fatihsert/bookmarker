import React from 'react'

const Button=({text,className})=>{

    return (
        <button className={`${className}`} type="submit">{text}</button>
    );
};

export default Button;
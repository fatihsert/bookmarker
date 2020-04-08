import React from 'react'

const Label=({forId,className,text})=>{

    return (
        <label for={forId} className={className}>{text}</label>
    );
};

export default Label;
import React from 'react';
import { useState } from 'react';
import './Register.css';

const initialState = {
    fullname: '',
    username: '',
    email: '',
    password: '',
    confirmPassword: ''
}


function Register() {

    const [formValues, setFormValues] = useState(initialState);
    const [error, setError] = useState({
        fullnameErr: false,
        usernameErr: false,
        emailErr: false,
        passwordErr: false,
        confirmPasswordErr: false
    })

    const submitHandler = (event) => {
        event.preventDefault();
        console.log(formValues)

    }

    const inputHandler = (event) => {

        setFormValues(
            (prevState) => {
                return {
                    ...prevState,
                    [event.target.name]: event.target.value
                }
            }
        );

    }

    const handleFocus = () => {
        setFocus(true)
    }

    const Inputs = [
        {
            id: 1,
            type: "text",
            placeholder: "Full Name",
            name: "fullname",
            errorMsg: "This field cannot be empty !",
            required: true,
        },
        {
            id: 2,
            type: "text",
            placeholder: "Username",
            name: "username",
            errorMsg: "Username should be more than 3 letters !",
            required: true,
            pattern: "^[A-Za-z0-9]{3,16}$"
        },
        {
            id: 3,
            type: "email",
            placeholder: "Email",
            name: "email",
            errorMsg: "Enter a valid email address !",
            required: true,
        },
        {
            id: 4,
            type: "password",
            placeholder: "Password",
            name: "password",
            errorMsg: "Password should be more than 8 charecters and should include atleast one number,special charecter,uppercase charecter !",
            required: true,
            pattern: `^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$`
        },
        {
            id: 5,
            type: "password",
            placeholder: "Confirm Password",
            name: "confirmPassword",
            errorMsg: "Does not match with the above Password !",
            required: true,
            pattern: formValues.password
        }
    ]


    return (
        <>
            <div className="reg-wrapper text-center">
                <div className='inner my-5'>
                    <div className="icon-div">
                        <i class="fa-solid fa-user-plus"></i>
                    </div>
                    <h1>Welcome To BlogSpot !</h1>
                    <p className='tagline mt-2'>Create your user and start sharing your ideas !</p>
                    <form action="POST" onSubmit={submitHandler}>
                        <div className="mt-3">
                            {
                                Inputs.map(formInputs => {
                                    const { errorMsg, ...attributes } = formInputs;
                                    return (
                                        <div className='form-fields d-flex flex-column align-items-center' key={formInputs.id} >
                                            <input {...attributes} onChange={inputHandler} value={formValues[formInputs.name]} onBlur={handleFocus} focused={focused.toString()} />
                                            <span className='mt-1 error-span'>{errorMsg}</span>
                                        </div>
                                    )
                                })
                            }
                            <button className='register-btn'>Register Now</button>
                        </div>
                    </form>
                    <p className='my-4'>Already have an Account ? <a href="/login">Sign In</a></p>
                </div>
            </div>
        </>
    )
}

export default Register;
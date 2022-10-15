import React from 'react'
import './Login.css'

function Login() {
    return (
        <>
            <div className="reg-wrapper text-center">
                <div className='inner my-5'>
                    <div className="icon-div">
                        <i class="fa-solid fa-user-plus"></i>
                    </div>
                    <h1>Welcome Back!</h1>
                    <p className='tagline mt-2'>Log in and start sharing your ideas !</p>
                    <form action="POST">
                        <div className="mt-3 form-fields d-flex flex-column align-items-center">
                            <input type="text" name='username' placeholder='Username' />
                            <input type="password" name='password' placeholder='Password' />
                            <button type="submit" className='register-btn'>Sign In</button>
                        </div>
                    </form>
                    <p className='my-4'>New Here ? <a href="/register">Register</a></p>
                </div>
            </div>
        </>
    )
}

export default Login
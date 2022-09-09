import React from 'react'
import './Landing.css'

function Landing() {
    return (
        <>
            <div className="container-fluid">
                <div className="headline text-center mt-5">
                    <h1>Connecting ideas and people</h1>
                    <h4 className='tagline mt-4'>Discover stories, thinking, and expertise <br /> from writers on any topic.</h4>
                </div>
                <div className="register-now text-center mt-5">
                    <button className='primary-btn'>Let's Go</button>
                </div>
            </div>
        </>
    )
}

export default Landing;
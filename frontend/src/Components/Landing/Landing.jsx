import React from 'react'
import PopularPosts from '../PopularPosts/PopularPosts';
import Trending from '../Trending/Trending';
import './Landing.css'

function Landing() {
    return (
        <>
            <div className="container-fluid">
                <div className="headline text-center mt-5 pt-5">
                    <h1>Connecting ideas and people</h1>
                    <h4 className='tagline mt-5'>Discover stories, thinking, and expertise <br /> from writers on any topic.</h4>
                </div>
                <div className="register-now text-center mt-5">
                    <button className='primary-btn'>New Post <i class="mx-2 fa-solid fa-plus"></i></button>
                </div>
                <Trending />
                <PopularPosts />
            </div>
        </>
    )
}

export default Landing;
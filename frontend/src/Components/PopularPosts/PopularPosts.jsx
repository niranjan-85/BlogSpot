import React from 'react'
import UserPosts from '../UserPosts/UserPosts';
import './PopularPosts.css';

function PopularPosts() {
    return (
        <>
            <div className="container-fluid">
                <h1 className='text-center my-5'>Most Popular Posts</h1>
                <div className="wrapper">
                    <UserPosts />
                    <UserPosts />
                    <UserPosts />
                    <UserPosts />
                </div>
            </div>
        </>
    )
}

export default PopularPosts;
import React from 'react'
import logo from '../Images/landing-logo.jpg'
import './UserPosts.css'


function UserPosts() {
    return (
        <div className='Card'>
            <div className="card__body">
                <img className='card__image' src={logo} alt="" />
                <h2 className='card__title'>JavaScript : Internals</h2>
                <p className="card__description">Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Suscipit esse velit dolorum natus libero maxime optio reprehenderit quia, id, enim ipsum modi.
                    Reprehenderit eveniet ratione delectus? Culpa natus rem vero.</p>
            </div>
            <button className='card__btn'>Read More</button>
        </div>
    )
}

export default UserPosts
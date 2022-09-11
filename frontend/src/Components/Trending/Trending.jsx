import React from 'react'
import './Trending.css';
import Trend from '../Images/trend.jpg'



function Trending() {
    return (
        <>
            <div className="trending-post my-5 py-5">
                <h1 className='text-center mt-5'>Most Trending Post </h1>
                <div className="container-fluid trending-card">
                    <div className='trending row d-flex'>
                        <div className="col-6 text-center post-logo">
                            <img src={Trend} alt="" />
                        </div>
                        <div className="col-6 post-info">
                            <h1>The 300 Sparks Milestone</h1>
                            <p className='mt-2'>&#128293; Trending </p>
                            <p className='mt-2 date'>SEPTEMBER 7, 2022</p>
                            <div className='my-4'>
                                We just recently published the 300th CodePen Spark. Marie joins me on the show, as she leads
                                up the creation of the vast majority of Spark newsletters.
                                We get into things like why we do it, how we create it,
                                how we send it, and things we’ve learned along the way sending a newsletter of […]
                            </div>

                            <a className='read-post' href={'#'}>Read More</a>

                            <p className='mt-3'>
                                &#128151; 21
                            </p>

                            <div className='mt-2 creator'>
                                Creator : Niranjan Raje
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Trending;
import './Navbar.css';
import LandingLogo from '../Images/landing-logo.jpg';

function Navbar() {
    return (
        <>
            <div className="navigation">
                <div className="logo"><img src={LandingLogo} alt="" /></div>
                {/* checkbox - controls menu click */}
                <input type="checkbox" id="click" />
                <label htmlFor="click" className='menu'>
                    <i className="menu fa-solid fa-bars"></i>
                </label>
                <ul className='navigation-links'>
                    <li><a href='#'>Home</a></li>
                    <li><a href='#'>Contact-Us</a></li>
                    <li><a href='#'>About-Us</a></li>
                    <li className='mx-4'>
                        <a href='#' className='sign-up-link'>
                            Sign Up
                        </a>
                    </li>
                </ul>
            </div>
        </>
    )
}

export default Navbar;
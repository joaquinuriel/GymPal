// WelcomeScreen.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './WelcomeScreen.css';
import ModoFitnessON from './ModoFitnessON.png';

function WelcomeScreen() {
    const [fadeOut, setFadeOut] = useState(false);
    const navigate = useNavigate();

    const handleToggleClick = () => {
        setFadeOut(true);
        setTimeout(() => {
            navigate('/home');
        }, 1500);
    };

    return (
        <div className={`welcome-screen ${fadeOut ? 'fade-out' : ''}`}>
            <img src={ModoFitnessON} alt="Modo Fitness On" className="fitness-image" />
            <div className="toggle-switch">
                <input
                    type="checkbox"
                    id="fitness-toggle"
                    onClick={handleToggleClick}
                />
                <label htmlFor="fitness-toggle"></label>
            </div>
            <div className="pattern-corner top-left"></div>
            <div className="pattern-corner top-right"></div>
            <div className="pattern-corner bottom-left"></div>
            <div className="pattern-corner bottom-right"></div>
        </div>
    );
}

export default WelcomeScreen;

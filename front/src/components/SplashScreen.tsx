import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './SplashScreen.css';
import FitnessImage from './ModoFitnessON.png'; // Asegúrate de usar la ruta correcta

function SplashScreen() {
    const [isActivated, setIsActivated] = useState(false);
    const navigate = useNavigate();

    const handleToggle = () => {
        setIsActivated(true);
        setTimeout(() => {
            navigate('/home');
        }, 1500);
    };

    return (
        <div className={`splash-screen ${isActivated ? 'fade-out' : ''}`}>
            <h1>GYMPAL</h1>
            <img src={FitnessImage} alt="Modo Fitness On" className="fitness-image" />
            <label className="toggle-switch">
                <input type="checkbox" onChange={handleToggle} />
                <span className="slider"></span>
            </label>
        </div>
    );
}

export default SplashScreen;

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./SplashScreen.css";
import ModoFitnessON from "./ModoFitnessON.png";

const SplashScreen: React.FC = () => {
    const [fadeOut, setFadeOut] = useState(false);
    const navigate = useNavigate();

    const handleToggle = () => {
        setFadeOut(true); // Inicia el desvanecimiento
        setTimeout(() => {
            navigate("/login"); // Navega después del desvanecimiento
        }, 1500); // Duración del desvanecimiento
    };

    return (
        <div className={`splash-screen ${fadeOut ? "fade-out" : ""}`}>
            <img src={ModoFitnessON} alt="Modo Fitness ON" className="fitness-image" />
            <label className="toggle-switch">
                <input type="checkbox" onClick={handleToggle} />
                <span className="slider"></span>
            </label>
        </div>
    );
};

export default SplashScreen;

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./SplashScreen.css";
import ModoFitnessON from "./ModoFitnessON.png";

const SplashScreen: React.FC = () => {
    const [fadeOut, setFadeOut] = useState(false);
    const navigate = useNavigate();

    const handleToggle = () => {
        setFadeOut(true);
        setTimeout(() => {
            navigate("/login"); // Navega a la pantalla de inicio de sesión
        }, 1500); // Tiempo de animación antes de redirigir
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

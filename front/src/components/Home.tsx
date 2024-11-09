// Home.js
import { useEffect, useState } from 'react';
import './Home.css';

function Home() {
    const [fadeIn, setFadeIn] = useState(false);

    useEffect(() => {
        setTimeout(() => {
            setFadeIn(true);
        }, 100); // Inicia el desvanecimiento al montar el componente
    }, []);

    return (
        <div className={`home-screen ${fadeIn ? 'fade-in' : ''}`}>
            <h1>Bienvenido a GymPal</h1>
            <p>¡Modo fitness activado!</p>
            <div className="home-grid">
                <div className="home-card">Rutina del Día</div>
                <div className="home-card">Registro de Progreso</div>
                <div className="home-card">Trofeos</div>
                <div className="home-card">Mediciones y Objetivos</div>
            </div>
        </div>
    );
}

export default Home;

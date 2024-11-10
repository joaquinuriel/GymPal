import { useEffect, useState } from "react";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import "./Home.css";

function Home() {
    const [fadeIn, setFadeIn] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        setTimeout(() => {
            setFadeIn(true);
        }, 100); // Inicia el desvanecimiento al montar el componente
    }, []);

    return (
        <div className={`home-screen ${fadeIn ? "fade-in" : ""}`}>
            <h1>Bienvenido a GymPal</h1>
            <p>¡Modo fitness activado!</p>
            <div className="home-grid">
                <div className="home-card">
                    Entrenamiento del Día
                </div>
                <div className="home-card">
                    <p>Registro de Progreso</p>
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => navigate("/progress")}
                    >
                        Ver Progreso
                    </Button>
                </div>
                <div className="home-card">Trofeos</div>
                <div className="home-card">Mediciones y Objetivos</div>
            </div>
        </div>
    );
}

export default Home;

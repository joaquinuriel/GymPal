import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Para la redirección
import "./LoginPage.css"; // Importa el CSS ajustado

const LoginPage: React.FC = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = (event: React.FormEvent) => {
        event.preventDefault();
        // Redirigir a la página de selección de objetivos
        navigate("/select-objective");
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h1>Iniciar Sesión</h1>
                <form onSubmit={handleLogin}>
                    <input
                        type="text"
                        placeholder="Usuario"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    <input
                        type="password"
                        placeholder="Contraseña"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <button type="submit">Iniciar Sesión</button>
                </form>
            </div>
        </div>
    );
};

export default LoginPage;

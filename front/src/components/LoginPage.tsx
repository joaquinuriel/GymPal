import React, { useState } from "react";
//import { useNavigate } from "react-router-dom";
import "./LoginPage.css";

const LoginPage: React.FC = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    //const navigate = useNavigate();

    const handleLogin = (event: React.FormEvent) => {
        event.preventDefault();

        if (!username || !password) {
            alert("Por favor, completa todos los campos");
            return;
        }

        //navigate("/select-objective");
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2>Iniciar Sesión</h2>
                <form onSubmit={handleLogin}>
                    <input
                        type="text"
                        placeholder="Usuario"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                    <input
                        type="password"
                        placeholder="Contraseña"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                    <button type="submit" className="login-button">
                        Iniciar Sesión
                    </button>
                </form>
                <div className="login-footer">
                    ¿Primera vez aquí?
                    <a className="register-link" href="/register">
                        Registrarme
                    </a>
                </div>
            </div>
        </div>
    );
};

export default LoginPage;

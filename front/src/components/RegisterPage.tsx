import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios"; // Asegúrate de tener axios instalado
import "./RegisterPage.css";

const RegisterPage: React.FC = () => {
    const [name, setName] = useState("");
    const [surname, setSurname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [age, setAge] = useState("");
    const [weight, setWeight] = useState("");
    const [height, setHeight] = useState("");
    const [sex, setSex] = useState("");

    const navigate = useNavigate();

    const handleRegister = async (event: React.FormEvent) => {
        event.preventDefault();

        // Validar contraseñas
        if (password !== confirmPassword) {
            alert("Las contraseñas no coinciden");
            return;
        }

        // Validar que todos los campos estén completos
        if (!name || !surname || !email || !password || !age || !weight || !height || !sex) {
            alert("Por favor, completa todos los campos");
            return;
        }

        // Crear el objeto de datos para enviar al backend
        const socioData = {
            nombre: name,
            apellido: surname,
            //mail: email,
            //contraseña: password,
            edad: parseInt(age),
            peso: parseFloat(weight),
            altura: parseFloat(height),
            sexo: sex,
        };

        console.log("Datos enviados al backend:", socioData);

        try {
            const response = await axios.post("http://localhost:8080/api/socios/register", socioData);
            if (response.status === 201) {
                alert("Socio registrado exitosamente");
                navigate("/select-objective");
            }
        } catch (error) {
            if (axios.isAxiosError(error)) {
                console.error("Error al registrar el socio:", error.response);
                alert(`Error al registrar el socio: ${error.response?.data || "Error desconocido"}`);
            } else {
                console.error("Error inesperado:", error);
                alert("Ocurrió un error inesperado.");
            }
        }
    };

    return (
        <div className="register-container">
            <h2>Registro</h2>
            <form onSubmit={handleRegister}>
                <input
                    type="text"
                    placeholder="Nombre"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="Apellido"
                    value={surname}
                    onChange={(e) => setSurname(e.target.value)}
                    required
                />
                <select
                    value={sex}
                    onChange={(e) => setSex(e.target.value)}
                    required
                >
                    <option value="" disabled>
                        Selecciona tu sexo
                    </option>
                    <option value="masculino">Masculino</option>
                    <option value="femenino">Femenino</option>
                    <option value="otro">Otro</option>
                </select>
                <input
                    type="number"
                    placeholder="Edad"
                    value={age}
                    onChange={(e) => setAge(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Peso (kg)"
                    value={weight}
                    onChange={(e) => setWeight(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Altura (cm)"
                    value={height}
                    onChange={(e) => setHeight(e.target.value)}
                    required
                />
                <input
                    type="email"
                    placeholder="Correo electrónico"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />

                <input
                    type="password"
                    placeholder="Contraseña"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="Repetir contraseña"
                    value={confirmPassword}
                    onChange={(e) => setConfirmPassword(e.target.value)}
                    required
                />
                <button type="submit" className="register-button">
                    Registrarme
                </button>
            </form>
        </div>
    );
};

export default RegisterPage;

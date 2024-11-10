import React, { useState, useEffect } from "react";
import axios from "axios";
import "./Dashboard.css"; // Si decides agregar estilos personalizados

type UserData = {
    id: number;
    nombre: string;
    edad: number;
    peso: number;
    altura: number;
    objetivo: string;
    rutinasCompletadas: number;
    progresoObjetivo: number;
};

type Trofeo = {
    id: number;
    nombre: string;
    fecha: string;
};

const Dashboard: React.FC = () => {
    const [userData, setUserData] = useState<UserData | null>(null);
    const [trophies, setTrophies] = useState<Trofeo[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const userId = 1; // Simula el ID del usuario autenticado

        const fetchData = async () => {
            try {
                const userResponse = await axios.get(`/api/socios/${userId}`);
                setUserData(userResponse.data);

                const trophiesResponse = await axios.get(`/api/trofeos/${userId}`);
                setTrophies(trophiesResponse.data);
            } catch (error) {
                console.error("Error al cargar los datos:", error);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, []);

    if (loading) {
        return <div>Cargando datos...</div>;
    }

    if (!userData) {
        return <div>No se encontró información del usuario.</div>;
    }

    return (
        <div className="dashboard-container">
            <h1>¡Bienvenido, {userData.nombre}!</h1>
            <div className="user-info">
                <p>Edad: {userData.edad} años</p>
                <p>Peso: {userData.peso} kg</p>
                <p>Altura: {userData.altura} cm</p>
                <p>Objetivo: {userData.objetivo}</p>
                <p>Progreso del objetivo: {userData.progresoObjetivo}%</p>
                <p>Rutinas completadas: {userData.rutinasCompletadas}</p>
            </div>

            <div className="trophies">
                <h2>Trofeos:</h2>
                {trophies.length > 0 ? (
                    <ul>
                        {trophies.map((trofeo) => (
                            <li key={trofeo.id}>
                                🏆 {trofeo.nombre} - {trofeo.fecha}
                            </li>
                        ))}
                    </ul>
                ) : (
                    <p>Aún no has ganado trofeos. ¡Sigue esforzándote!</p>
                )}
            </div>
        </div>
    );
};

export default Dashboard;

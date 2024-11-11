import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";

interface Exercise {
    nombre: string;
    series: number;
    repeticiones: number;
    peso: number;
}

interface Routine {
    [day: string]: Exercise[];
}

const RoutinePage: React.FC = () => {
    const { state } = useLocation();
    const { objective, selectedDays } = state as { objective: string; selectedDays: string[] };

    const [routine, setRoutine] = useState<Routine | null>(null);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchRoutine = async () => {
            try {
                const response = await axios.post<Routine>("http://localhost:8080/api/rutina", {
                    objetivo: objective,
                    dias: selectedDays,
                });
                setRoutine(response.data);
            } catch (error) {
                console.error("Error fetching routine:", error);
                setError("Hubo un problema al cargar la rutina. Intenta nuevamente.");
            } finally {
                setLoading(false);
            }
        };

        fetchRoutine();
    }, [objective, selectedDays]);

    if (loading) return <p>Cargando rutina...</p>;
    if (error) return <p style={{ color: "red" }}>{error}</p>;

    return (
        <div>
            <h1>Tu Rutina Generada</h1>
            {routine ? (
                Object.entries(routine).map(([day, exercises]) => (
                    <div key={day}>
                        <h3>{day}</h3>
                        <ul>
                            {exercises.map((exercise, index) => (
                                <li key={index}>
                                    <strong>{exercise.nombre}</strong>: {exercise.series} series de {exercise.repeticiones} repeticiones con {exercise.peso} kg
                                </li>
                            ))}
                        </ul>
                    </div>
                ))
            ) : (
                <p>No hay rutina disponible.</p>
            )}
        </div>
    );
};

export default RoutinePage;

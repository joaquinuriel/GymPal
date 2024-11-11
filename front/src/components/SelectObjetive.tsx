import React, { useState } from "react";
import "./SelectObjective.css";

const SelectObjective: React.FC = () => {
    const [objective, setObjective] = useState<string>("");
    const [days, setDays] = useState<string[]>([]);

    const availableDays = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];

    const toggleDay = (day: string) => {
        setDays((prev) =>
            prev.includes(day) ? prev.filter((d) => d !== day) : [...prev, day]
        );
    };

    const handleGenerateRoutine = () => {

        // Simulación de guardar datos en el backend
        const socioData = {
            objetivo: objective,
            dias: days,
        };

        console.log("Datos del socio enviados al backend:", socioData);
        alert("Rutina generada correctamente.");
    };

    return (
        <div className="objective-container">


            {/* Recuadro de selección de objetivos */}
            <div className="objective-box">
                <h1>Seleccionar Objetivo</h1>
                <div className="form-group">
                    <label>
                        Objetivo:
                        <select
                            value={objective}
                            onChange={(e) => setObjective(e.target.value)}
                        >
                            <option disabled value="">
                                Selecciona un objetivo
                            </option>
                            <option value="Perder peso">Perder Peso</option>
                            <option value="Mantener figura">Mantener Figura</option>
                            <option value="Tonificar cuerpo">Tonificar Cuerpo</option>
                        </select>
                    </label>
                </div>
                <div className="form-group">
                    <h3>Días de Entrenamiento:</h3>
                    <div className="days-buttons">
                        {availableDays.map((day) => (
                            <button
                                key={day}
                                className={`day-button ${
                                    days.includes(day) ? "selected" : ""
                                }`}
                                onClick={() => toggleDay(day)}
                            >
                                {day}
                            </button>
                        ))}
                    </div>
                </div>
                <button
                    className="generate-routine-button"
                    onClick={handleGenerateRoutine}
                >
                    GENERAR RUTINA
                </button>
            </div>
        </div>
    );
};

export default SelectObjective;

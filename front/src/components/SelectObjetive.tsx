import React, { useState } from "react";
import "./SelectObjective.css";

const SelectObjective: React.FC = () => {
    const [objective, setObjective] = useState<string>("");
    const [days, setDays] = useState<string[]>([]);
    const [weight, setWeight] = useState<string>(""); // Estado para peso
    const [height, setHeight] = useState<string>(""); // Estado para altura
    const [gender, setGender] = useState<string>(""); // Estado para género
    const availableDays = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];

    const toggleDay = (day: string) => {
        setDays((prev) =>
            prev.includes(day) ? prev.filter((d) => d !== day) : [...prev, day]
        );
    };

    const handleGenerateRoutine = () => {
        if (!objective || days.length === 0 || !weight || !height || !gender) {
            alert("Por favor, completa todos los campos antes de generar la rutina.");
            return;
        }

        // Simulación de guardar datos en el backend
        const socioData = {
            peso: weight,
            altura: height,
            sexo: gender,
            objetivo: objective,
            dias: days,
        };

        console.log("Datos del socio enviados al backend:", socioData);
        alert("Rutina generada correctamente.");
    };

    return (
        <div className="objective-container">
            {/* Recuadro de datos personales */}
            <div className="data-box">
                <h1>Mis Datos</h1>
                <div className="form-group">
                    <label>
                        Sexo:
                        <select
                            value={gender}
                            onChange={(e) => setGender(e.target.value)}
                        >
                            <option disabled value="">
                                Selecciona tu sexo
                            </option>
                            <option value="Femenino">Femenino</option>
                            <option value="Masculino">Masculino</option>
                        </select>
                    </label>
                </div>
                <div className="form-group">
                    <label>
                        Peso (kg):
                        <input
                            type="number"
                            value={weight}
                            onChange={(e) => setWeight(e.target.value)}
                            placeholder="Ej. 70"
                        />
                    </label>
                </div>
                <div className="form-group">
                    <label>
                        Altura (cm):
                        <input
                            type="number"
                            value={height}
                            onChange={(e) => setHeight(e.target.value)}
                            placeholder="Ej. 170"
                        />
                    </label>
                </div>
            </div>

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

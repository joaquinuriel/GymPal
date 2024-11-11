import React, { useState } from "react";
import {
    Button,
    Checkbox,
    FormControl,
    FormControlLabel,
    InputLabel,
    MenuItem,
    Select,
    CircularProgress,
    Typography,
    SelectChangeEvent, // Importa este tipo desde Material-UI
} from "@mui/material";

const RoutineGenerator: React.FC = () => {
    const [objective, setObjective] = useState<string>("");
    const [selectedDays, setSelectedDays] = useState<string[]>([]);
    const [loading, setLoading] = useState(false);
    const [routine, setRoutine] = useState<Record<string, string[]> | null>(null);

    // Corrige el tipo del evento aquí
    const handleObjectiveChange = (event: SelectChangeEvent<string>) => {
        setObjective(event.target.value);
    };

    const toggleDay = (day: string) => {
        setSelectedDays((prev) =>
            prev.includes(day) ? prev.filter((d) => d !== day) : [...prev, day]
        );
    };

    const generateRoutine = async () => {
        if (!objective || selectedDays.length === 0) {
            alert("Por favor, selecciona un objetivo y al menos un día.");
            return;
        }

        setLoading(true);
        try {
            const response = await fetch("http://localhost:8080/api/routines", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ objective, days: selectedDays }),
            });

            if (response.ok) {
                const data = await response.json();
                setRoutine(data);
            } else {
                console.error("Error al generar la rutina.");
            }
        } catch (error) {
            console.error("Error de conexión:", error);
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <Typography variant="h4">Generar Rutina</Typography>

            <FormControl fullWidth>
                <InputLabel id="objective-label">Selecciona un objetivo</InputLabel>
                <Select
                    labelId="objective-label"
                    value={objective}
                    onChange={handleObjectiveChange} // Aquí ahora es compatible
                >
                    <MenuItem value="tonificar cuerpo">Tonificar Cuerpo</MenuItem>
                    <MenuItem value="perder peso">Perder Peso</MenuItem>
                    <MenuItem value="mantener figura">Mantener Figura</MenuItem>
                </Select>
            </FormControl>

            <div>
                <Typography variant="h6">Selecciona los días:</Typography>
                {["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"].map(
                    (day) => (
                        <FormControlLabel
                            key={day}
                            control={
                                <Checkbox
                                    checked={selectedDays.includes(day)}
                                    onChange={() => toggleDay(day)}
                                />
                            }
                            label={day}
                        />
                    )
                )}
            </div>

            <Button
                variant="contained"
                color="primary"
                onClick={generateRoutine}
                disabled={loading}
            >
                {loading ? <CircularProgress size={24} /> : "Generar Rutina"}
            </Button>

            {routine && (
                <div>
                    <Typography variant="h6">Tu rutina generada:</Typography>
                    <ul>
                        {Object.entries(routine).map(([day, exercises]) => (
                            <li key={day}>
                                <strong>{day}:</strong> {exercises.join(", ")}
                            </li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
};

export default RoutineGenerator;

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
} from "@mui/material";

const RoutineGenerator: React.FC = () => {
    const [objective, setObjective] = useState("");
    const [selectedDays, setSelectedDays] = useState<string[]>([]);
    const [loading, setLoading] = useState(false);
    const [routine, setRoutine] = useState<any>(null);

    const days = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];

    const toggleDay = (day: string) => {
        setSelectedDays((prev) =>
            prev.includes(day) ? prev.filter((d) => d !== day) : [...prev, day]
        );
    };

    const generateRoutine = async () => {
        if (!objective || selectedDays.length === 0) {
            alert("Por favor, selecciona un objetivo y días de entrenamiento.");
            return;
        }

        setLoading(true);
        try {
            const params = {
                objetivo: objective,
                dias: selectedDays.join(","),
            };
            const response = await fetch(
                "/api/rutina/candidatos?" + new URLSearchParams(params)
            );
            const data = await response.json();
            setRoutine(data);
        } catch (error) {
            console.error("Error al generar la rutina:", error);
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <Typography variant="h4" gutterBottom>
                Generador de Rutinas
            </Typography>
            <FormControl fullWidth margin="normal">
                <InputLabel>Objetivo</InputLabel>
                <Select
                    value={objective}
                    onChange={(e) => setObjective(e.target.value)}
                >
                    <MenuItem value="Bajar de peso">Bajar de peso</MenuItem>
                    <MenuItem value="Tonificar cuerpo">Tonificar cuerpo</MenuItem>
                    <MenuItem value="Mantener la figura">Mantener la figura</MenuItem>
                </Select>
            </FormControl>

            <Typography variant="h6" gutterBottom>
                Días de Entrenamiento
            </Typography>
            {days.map((day) => (
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
            ))}

            <Button
                variant="contained"
                color="primary"
                onClick={generateRoutine}
                disabled={loading}
                style={{ marginTop: "16px" }}
            >
                {loading ? <CircularProgress size={24} /> : "Generar Rutina"}
            </Button>

            {routine && (
                <div>
                    <Typography variant="h5" style={{ marginTop: "16px" }}>
                        Rutina Generada
                    </Typography>
                    <pre>{JSON.stringify(routine, null, 2)}</pre>
                </div>
            )}
        </div>
    );
};

export default RoutineGenerator;

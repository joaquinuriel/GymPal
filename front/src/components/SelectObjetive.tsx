import React, { useState } from "react";
import {
    Button,
    Checkbox,
    FormControl,
    FormControlLabel,
    InputLabel,
    MenuItem,
    Select,
    Typography,
    Container,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

const SelectObjective: React.FC = () => {
    const [objective, setObjective] = useState("");
    const [selectedDays, setSelectedDays] = useState<string[]>([]);
    const navigate = useNavigate();

    const days = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];

    const handleToggleDay = (day: string) => {
        setSelectedDays((prev) =>
            prev.includes(day) ? prev.filter((d) => d !== day) : [...prev, day]
        );
    };

    const handleLoadRoutine = () => {
        // Navegar a la página de rutina con el estado
        navigate("/routine", { state: { objective, selectedDays } });
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Selecciona tu Objetivo
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

            <Typography variant="h6" style={{ marginTop: "16px" }}>
                Días de Entrenamiento
            </Typography>
            {days.map((day) => (
                <FormControlLabel
                    key={day}
                    control={
                        <Checkbox
                            checked={selectedDays.includes(day)}
                            onChange={() => handleToggleDay(day)}
                        />
                    }
                    label={day}
                />
            ))}

            <Button
                variant="contained"
                color="primary"
                fullWidth
                onClick={handleLoadRoutine}
                style={{ marginTop: "16px" }}
                disabled={!objective || selectedDays.length === 0}
            >
                Cargar Rutina
            </Button>
        </Container>
    );
};

export default SelectObjective;

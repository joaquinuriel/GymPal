import React from "react";
import { useLocation } from "react-router-dom";
import { Container, Typography, Card, CardContent, List, ListItem } from "@mui/material";

interface LocationState {
    objective: string;
    selectedDays: string[];
}

const RoutinePage: React.FC = () => {
    const location = useLocation();
    const { objective = "Sin objetivo", selectedDays = [] } = location.state as LocationState || {};

    // Simulación de rutina (esto debería venir del backend)
    const routine = Array.isArray(selectedDays)
        ? selectedDays.map((day) => ({
            day,
            exercises: [
                { name: "Sentadillas", series: 3, repetitions: 12 },
                { name: "Flexiones", series: 3, repetitions: 15 },
            ],
        }))
        : [];

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Rutina Generada
            </Typography>
            <Typography variant="h6">Objetivo: {objective}</Typography>
            {routine.length > 0 ? (
                routine.map((dayRoutine, index) => (
                    <Card key={index} style={{ marginTop: "16px" }}>
                        <CardContent>
                            <Typography variant="h5">{dayRoutine.day}</Typography>
                            <List>
                                {dayRoutine.exercises.map((exercise, idx) => (
                                    <ListItem key={idx}>
                                        {exercise.name} - {exercise.series} series x{" "}
                                        {exercise.repetitions} repeticiones
                                    </ListItem>
                                ))}
                            </List>
                        </CardContent>
                    </Card>
                ))
            ) : (
                <Typography color="error">No hay días seleccionados.</Typography>
            )}
        </Container>
    );
};

export default RoutinePage;

import React, { useEffect, useState } from "react";
import {
    Typography,
    Card,
    CardContent,
    List,
    ListItem,
    ListItemText,
    ListItemSecondaryAction,
    IconButton,
    CircularProgress,
} from "@mui/material";
import CheckCircleOutlineIcon from "@mui/icons-material/CheckCircleOutline";

const ProgressTracker: React.FC = () => {
    const [progress, setProgress] = useState<any[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    // Simula el ID del usuario autenticado (esto normalmente se obtendría de un contexto o autenticación)
    const userId = 1;

    // Función para obtener datos del progreso
    const fetchProgress = async () => {
        try {
            setLoading(true);
            setError(null);

            const response = await fetch(`/api/socios/${userId}/progreso`);
            if (!response.ok) throw new Error("Error al obtener el progreso del usuario");

            const data = await response.json();
            setProgress(data);
        } catch (err: any) {
            setError(err.message || "Error desconocido");
        } finally {
            setLoading(false);
        }
    };

    // Función para marcar un ejercicio como completado
    const markExerciseComplete = async (exerciseId: number) => {
        try {
            const response = await fetch(`/api/progreso/${exerciseId}`, {
                method: "POST",
            });
            if (!response.ok) throw new Error("Error al marcar el ejercicio como completado");

            // Actualiza el progreso después de marcarlo como completado
            fetchProgress();
        } catch (err: any) {
            console.error("Error al marcar ejercicio como completado:", err);
        }
    };

    useEffect(() => {
        fetchProgress();
    }, []);

    if (loading) {
        return <CircularProgress />;
    }

    if (error) {
        return <Typography color="error">{error}</Typography>;
    }

    return (
        <div>
            <Typography variant="h4" gutterBottom>
    Seguimiento de Progreso
    </Typography>

    {progress.length > 0 ? (
            <List>
                {progress.map((exercise) => (
                        <ListItem key={exercise.id}>
                        <ListItemText
                            primary={exercise.nombre}
                    secondary={`Series: ${exercise.series} | Repeticiones: ${exercise.repeticiones} | Peso: ${exercise.peso} kg`}
        />
        <ListItemSecondaryAction>
        <IconButton
            edge="end"
        onClick={() => markExerciseComplete(exercise.id)}
    >
        <CheckCircleOutlineIcon color="primary" />
            </IconButton>
            </ListItemSecondaryAction>
            </ListItem>
    ))}
        </List>
    ) : (
        <Typography>No hay ejercicios registrados aún.</Typography>
    )}

    <Typography variant="h5" style={{ marginTop: "32px" }}>
    Trofeos Obtenidos
    </Typography>
    <Card>
    <CardContent>
        <Typography variant="body1">🏆 Trofeo por 10 rutinas completadas</Typography>
    <Typography variant="body1">🏆 Trofeo por constancia semanal</Typography>
    {/* Aquí podrías agregar más trofeos dinámicamente */}
    </CardContent>
    </Card>
    </div>
);
};

export default ProgressTracker;

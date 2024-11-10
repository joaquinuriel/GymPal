import React from "react";
import { Card, CardContent, Typography, List, ListItem } from "@mui/material";

const RoutineDisplay: React.FC<{ routine: any }> = ({ routine }) => {
    return (
        <Card style={{ marginTop: "16px" }}>
            <CardContent>
                <Typography variant="h5" gutterBottom>
                    Rutina Generada
                </Typography>
                <List>
                    {routine.map((exercise: any, index: number) => (
                        <ListItem key={index}>
                            {exercise.nombre} - {exercise.series} series,{" "}
                            {exercise.repeticiones} repeticiones
                        </ListItem>
                    ))}
                </List>
            </CardContent>
        </Card>
    );
};

export default RoutineDisplay;

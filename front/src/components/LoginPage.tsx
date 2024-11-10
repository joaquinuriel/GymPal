import React from "react";
import { Button, TextField, Container, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";

const LoginPage: React.FC = () => {
    const navigate = useNavigate();

    const handleLogin = () => {
        navigate("/select-objective");
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Iniciar Sesión
            </Typography>
            <TextField
                label="Usuario"
                variant="outlined"
                fullWidth
                margin="normal"
            />
            <TextField
                label="Contraseña"
                type="password"
                variant="outlined"
                fullWidth
                margin="normal"
            />
            <Button
                variant="contained"
                color="primary"
                fullWidth
                onClick={handleLogin}
                style={{ marginTop: "16px" }}
            >
                Iniciar Sesión
            </Button>
        </Container>
    );
};

export default LoginPage;

import { BrowserRouter, Routes, Route } from "react-router-dom";
import SplashScreen from "./components/SplashScreen"; // Pantalla inicial
import LoginPage from "./components/LoginPage"; // Pantalla de inicio de sesión
import SelectObjective from "./components/SelectObjetive"; // Selección de objetivos
import RoutinePage from "./components/RoutinePage"; // Rutina generada

function App() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Pantalla inicial con imagen y toggle */}
                <Route path="/" element={<SplashScreen />} />

                {/* Pantalla de inicio de sesión */}
                <Route path="/login" element={<LoginPage />} />

                {/* Página para seleccionar objetivo y días */}
                <Route path="/select-objective" element={<SelectObjective />} />

                {/* Página para mostrar la rutina generada */}
                <Route path="/routine" element={<RoutinePage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;

import { BrowserRouter, Routes, Route } from "react-router-dom";
import SplashScreen from "./components/SplashScreen"; // Pantalla inicial
import LoginPage from "./components/LoginPage"; // Pantalla de inicio de sesión
import SelectObjective from "./components/SelectObjetive"; // Selección de objetivos
import RoutinePage from "./components/RoutinePage"; // Rutina generada
import RegisterPage from "./components/RegisterPage"; // Página que contiene el formulario

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<SplashScreen />} />
                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="/select-objective" element={<SelectObjective />} />
                <Route path="/routine" element={<RoutinePage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;

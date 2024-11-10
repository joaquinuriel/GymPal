import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./components/LoginPage";
import SelectObjetive from "./components/SelectObjetive"; // Verifica que el nombre coincida con el archivo
import RoutinePage from "./components/RoutinePage";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Página de inicio de sesión */}
                <Route path="/" element={<LoginPage />} />

                {/* Página para seleccionar objetivo y días */}
                <Route path="/select-objective" element={<SelectObjetive />} />

                {/* Página para mostrar la rutina generada */}
                <Route path="/routine" element={<RoutinePage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;

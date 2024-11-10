import { ofetch } from 'ofetch';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { SWRConfig } from 'swr';
import './App.css';
import Home from './components/Home';
import SociosList from './components/SociosList';
import SplashScreen from './components/SplashScreen'; // Asegúrate de importar el nuevo SplashScreen
import WelcomeScreen from './components/WelcomeScreen';

const fetcher = ofetch.create({
  baseURL: "http://localhost:8080"
})

function App() {
  return (
    <div className="app">
      <SWRConfig value={{ fetcher }}>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<SplashScreen />} /> {/* Nueva ruta para SplashScreen */}
            <Route path="/welcome" element={<WelcomeScreen />} /> {/* Ruta opcional para WelcomeScreen */}
            <Route path="/home" element={<Home />} />
            <Route path="/socios" element={<SociosList />} />
          </Routes>
        </BrowserRouter>
      </SWRConfig>
    </div>
  )
}

export default App

import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],
  base: "/", // Usar "/" para servir desde la raíz
  server: {
    proxy: {
      "/api": {
        target: "http://localhost:8080", // Dirección del backend
        changeOrigin: true, // Cambia el origen para evitar problemas de CORS
        secure: false, // Permitir HTTP (no HTTPS)
      },
    },
  },
});

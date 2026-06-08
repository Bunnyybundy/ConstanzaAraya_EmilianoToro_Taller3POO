# 🌟 Taller 3 - Proyecto Integrador de Programación Avanzada (POO 2026-I)

## 📌 Descripción del Proyecto
Este proyecto corresponde al **Taller 3** del curso de Programación Orientada a Objetos (POO 2026-I).  
Se desarrolla un sistema de gestión de **magos y hechizos**, en un mundo donde la magia domina todas las capacidades.  
Cada **mago** posee un repertorio de uno o varios **hechizos**, los cuales tienen propiedades específicas dependiendo del elemento al que pertenecen: **Fuego, Agua, Planta y Tierra**.

El sistema se divide en dos paneles principales:
- **Panel Administrador**: encargado de realizar operaciones CRUD sobre magos y hechizos, reflejando los cambios en los archivos `Magos.txt` y `Hechizos.txt`.
- **Panel Analista**: encargado de generar reportes y rankings basados en las puntuaciones calculadas de magos y hechizos.

---

## 👥 Integrantes
- Constanza Araya — RUT: 21.609.057-8 — GitHub: Bunnyybundy  
- Emiliano Toro — RUT: 21.512.702-8 — GitHub: EmiToro  

---

## 📂 Estructura del Proyecto

El proyecto está organizado en el paquete `taller3` y contiene las siguientes clases principales:

- **Main** → Punto de entrada, carga inicial de archivos y selección de panel.  
- **Mago** → Representa a cada mago con su lista de hechizos.  
- **Hechizo (abstracta)** → Clase base para todos los hechizos.  
  - **HechizoFuego**  
  - **HechizoAgua**  
  - **HechizoPlanta**  
  - **HechizoTierra**  
- **GestorMagos** → Administra la colección de magos.  
- **GestorHechizos** → Administra la colección de hechizos.  
- **MenuAdmin** → Panel CRUD con persistencia en archivos.  
- **MenuAnalista** → Panel de reportes y rankings.  
- **Interfaz Calcular** → Implementada en `Mago` para calcular puntuaciones.  

---

## ⚙️ Instrucciones de Ejecución

1. Clonar el repositorio desde GitHub:  
   ```bash
   git clone https://github.com/Bunnyybundy/taller3-poo.git
2. Abrir el proyecto en Eclipse o cualquier IDE compatible con Java.
3. Asegurarse de que los archivos `Magos.txt` y `Hechizos.txt` esten en la raiz del proyecto.
4. Ejecutar la clase `Main`
5. Seleccionar el panel deseado:
   - **Panel Administrador** → para realizar operaciones CRUD.
   - **Panel Analista** → para visualizar rankings y reportes.  
6. Interactuar con los menus segun las opciones disponibles.

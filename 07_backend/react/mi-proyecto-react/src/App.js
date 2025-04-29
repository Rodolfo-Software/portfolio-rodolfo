import { useState } from 'react';

function App() {
    const [tareas, setTareas] = useState([]);
    const [nuevaTarea, setNuevaTarea] = useState('');

    const agregarTarea = () => {
        if (nuevaTarea.trim() === '') return;
        const tarea = { id: Date.now(), texto: nuevaTarea };
        setTareas([...tareas, tarea]);
        setNuevaTarea('');
    };

    const eliminarTarea = (id) => {
        setTareas(tareas.filter((t) => t.id !== id));
    };

    return (
        <div style={{ padding: '20px' }}>
            <h1>📝 Lista de Tareas</h1>

            <input
                type="text"
                value={nuevaTarea}
                onChange={(e) => setNuevaTarea(e.target.value)}
                placeholder="Nueva tarea"
            />
            <button onClick={agregarTarea}>Agregar</button>

            <ul>
                {tareas.map((tarea) => (
                    <li key={tarea.id}>
                        {tarea.texto}
                        <button onClick={() => eliminarTarea(tarea.id)}>❌</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;

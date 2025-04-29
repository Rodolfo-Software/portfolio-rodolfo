var a = 1;       // forma antigua
let b = 2;       // cambia
const c = 3;     // constante, no cambia


// arrow function
const sumar = (a, b) => a + b;


const nombre = "Rodolfo";
console.log(`Hola, ${nombre}!`);  // "Hola, Rodolfo!"


const persona = { nombre2: "Ana", edad: 30 };
const { nombre2 } = persona;  // usar directamente `nombre`

const arr = [1, 2, 3];
const [x, y] = arr;  // x = 1, y = 2


const numeros = [1, 2, 3, 4];

// map: transforma los valores
const dobles = numeros.map(n => n * 2); // [2, 4, 6, 8]

// filter: filtra valores
const pares = numeros.filter(n => n % 2 === 0); // [2, 4]

// reduce: acumula valores
const suma = numeros.reduce((acc, n) => acc + n, 0); // 10


// declarativa
function saludar() {
    console.log("Hola1");
}

// expresiva (con arrow)
const saludar2 = () => console.log("Hola2");

saludar();
//saludar()2;






let tareas = [];

function agregarTarea(tarea) {
    tareas.push(tarea);
    console.log(`Tarea agregada: ${tarea}`);
}

function mostrarTareas() {
    console.log("Tareas:");
    tareas.forEach((t, i) => console.log(`${i + 1}. ${t}`));
}

agregarTarea("Estudiar JavaScript");
agregarTarea("Hacer ejercicio");
mostrarTareas();

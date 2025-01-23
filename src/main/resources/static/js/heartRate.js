// Variables para almacenar los datos
const heartRateData = [];
const heartRateLabels = [];
const tableBody = document.getElementById('heartRateTableBody');

// Configuración del gráfico
const ctx = document.getElementById('heartRateChart').getContext('2d');
const heartRateChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: heartRateLabels,
        datasets: [{
            label: 'Frecuencia cardíaca (BPM)',
            data: heartRateData,
            borderColor: '#0056b3',
            backgroundColor: 'rgba(0, 86, 179, 0.2)',
            tension: 0.1,
            fill: true,
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            }
        },
        scales: {
            x: {
                title: {
                    display: true,
                    text: 'Tiempo',
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'BPM',
                },
                min: 40,
                max: 180
            }
        }
    }
});

// Función para añadir un nuevo dato
function addHeartRateData(heartRate) {
    const timestamp = new Date().toLocaleTimeString();

    // Añadir datos a la tabla
    const row = document.createElement('tr');
    row.innerHTML = `<td>${timestamp}</td><td>${heartRate}</td>`;
    tableBody.appendChild(row);

    // Añadir datos al gráfico
    heartRateLabels.push(timestamp);
    heartRateData.push(heartRate);
    heartRateChart.update();
}

// Simulación de datos
function simulateHeartRate() {
    const simulatedRate = Math.floor(Math.random() * (180 - 40 + 1)) + 40; // Valor entre 40 y 180
    addHeartRateData(simulatedRate);
}

const data = {
labels: [
    'Janeiro',
    'Fevereiro',
    'Março',
    'Abril',
    'Maio',
    'Junho',
    'Julho',
    'Agosto',
    'Setembro',
    'Outubro',
    'Novembro',
    'Dezembro',
],
datasets: [{
    label: 'Produção durante o ano de 2022',
    backgroundColor: 'rgb(0, 163, 108, 64)',
    borderColor: 'rgb(0, 163, 108, 64)',
    data: [20, 40, 25, 90, 80, 25, 30, 50, 28, 78, 98, 100],
}]
};

const config = {
    type: 'line',
    data: data,
    options: {responsive: true}
};

const myChart = new Chart(
    document.getElementById('myChart'),
    config
);

const data1 = {
labels: [
    'Descartado',
    'Estoque',
    'Utilizado'
],
datasets: [{
    data: [300, 50, 100],
    backgroundColor: [
        'rgb(0, 110, 73, 43)',
        'rgb(0, 163, 108, 64)',
        'rgb(0, 217, 144, 85)'
    ],
    hoverOffset: 4
}]
};

const config1 = {
    type: 'doughnut',
    data: data1,
};

const myChartPizza1 = new Chart(
    document.getElementById('myChartPizza1'),
    config1
);

const data2 = {
labels: [
    'Descartado',
    'Estoque',
    'Utilizado'
],
datasets: [{
    data: [100, 30, 70],
    backgroundColor: [
        'rgb(0, 110, 73, 43)',
        'rgb(0, 163, 108, 64)',
        'rgb(0, 217, 144, 85)'
    ],
    hoverOffset: 4
}]
};

const config2 = {
    type: 'doughnut',
    data: data2,
};

const myChartPizza2 = new Chart(
    document.getElementById('myChartPizza2'),
    config2
);

const data3 = {
labels: [
    'Descartado',
    'Estoque',
    'Utilizado'
],
datasets: [{
    data: [30, 40, 50],
    backgroundColor: [
        'rgb(0, 110, 73, 43)',
        'rgb(0, 163, 108, 64)',
        'rgb(0, 217, 144, 85)'
    ],
    hoverOffset: 4
}]
};

const config3 = {
    type: 'doughnut',
    data: data3,
};

const myChartPizza3 = new Chart(
    document.getElementById('myChartPizza3'),
    config3
);
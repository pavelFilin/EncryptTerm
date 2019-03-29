google.charts.load('current', {packages: ['corechart', 'line']});
// google.charts.setOnLoadCallback(drawCurveTypes);

var dataGlobal;
function drawCurveTypes() {
    // var data = new google.visualization.DataTable();


    var result = { "cols":[ {"type":"string"}, {"type":"number"}], "rows":[ {"c":[{"v":"20-01-13"}, {"v":22}]}, {"c":[{"v":"21-01-13"}, {"v":24}]}, {"c":[{"v":"22-01-13"}, {"v":27}]} ]};

    //
    // var arr =  [[dataGlobal[0].number, dataGlobal[0].x, dataGlobal[0].y], [dataGlobal[1].number, dataGlobal[1].x, dataGlobal[1].y]];
    // data.addRows(arr);

    var options = {
        hAxis: {
            title: 'x'
        },
        vAxis: {
            title: 'y'
        },
        series: {
            1: {curveType: 'function'}
        }
    };

    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
    chart.draw(result, options);
}


function start() {
    $.getJSON('graph/ajax', function(data){
        var arrSales = [['X', 'x', 'y']];    // Define an array and assign columns for the chart.

        // Loop through each data and populate the array.
        $.each(data, function (index, value) {
            arrSales.push([value.number, value.x, value.y]);
        });

        // Set chart Options.
        var options = {
            title: 'Monthly Sales',
            curveType: 'function',
            legend: { position: 'bottom', textStyle: { color: '#555', fontSize: 14} }  // You can position the legend on 'top' or at the 'bottom'.
        };

        // Create DataTable and add the array to it.
        var figures = google.visualization.arrayToDataTable(arrSales);

        // Define the chart type (LineChart) and the container (a DIV in our case).
        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(figures, options);
    });
}

start();

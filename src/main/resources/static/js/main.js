function f1() {

    $.ajax({
        url: "/graph/secantMethod",
        data: { a: leftXInput.val(), b: rightXInput.val(), h: stepInput.val() },
        type: "POST",
        success: function (result) {
            console.log(result);
            this.dat = result;

            var data_chart1 = {
                labels: [],
                series: [
                    [],
                    []
                ]
            };

            for (var i = 0; i < result[0].length; i += 1) {
                data_chart1.series[0].push(result[0][i]);
                data_chart1.series[1].push(result[1][i]);
                data_chart1.labels.push(result[2][i]);
            }


            new Chartist.Line('.ct-chart', data_chart1, {
                axisX: {
                    onlyInteger: true
                }
            });
        }
    });


}

var leftXInput = $("#leftX");
var rightXInput = $("#rightX");
var stepInput = $("#step");
var btnInput = $("#plotBtn");

btnInput.on( "click", function() {
    f1();
});

leftXInput.on("change", function (){
    f1();
});

rightXInput.on("change", function (){
    f1();
});

stepInput.on("change", function (){
    f1();
});

$(document).ready(function () {
    f1();
});
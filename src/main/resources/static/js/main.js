function f1() {

    $.ajax({
        url: "/graph/secantMethod",
        data: {a: leftXInput.val(), b: rightXInput.val(), h: stepInput.val()},
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


function clarifyRoot() {

    $.ajax({
        url: "/graph/secantMethodClarifyRoot",
        data: {a: leftXClarify.val(), b: rightXClarify.val()},
        type: "POST",
        success: function (result) {
            resultClarify.val(result);
        }
    });
}

var leftXInput = $("#leftX");
var rightXInput = $("#rightX");
var stepInput = $("#step");
var btnInput = $("#plotBtn");


var leftXClarify = $("#leftX-clarify");
var rightXClarify = $("#rightX-clarify");
var resultClarify = $("#result-clarify");
var btnClarify = $("#btn-clarify");

btnClarify.on("click", function () {
    clarifyRoot();
});

btnInput.on("click", function () {
    f1();
});

leftXInput.on("change", function () {
    f1();
});

rightXInput.on("change", function () {
    f1();
});

stepInput.on("change", function () {
    f1();
});

$(document).ready(function () {
    f1();
});
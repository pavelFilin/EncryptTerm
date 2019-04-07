var data = {

    // A labels array that can contain any sort of values
    labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri'],
    // Our series array that contains series objects or in this case series data arrays
    series: [
        [5, 2, 4, 2, 0]
    ]
};

// Create a new line chart object where as first parameter we pass in a selector
// that is resolving to our chart container element. The Second parameter
// is the actual data object.

function f1() {
    // new Chartist.Line('.ct-chart', {
    //     labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
    //     series: [
    //         [12, 9, 7, 8, 5],
    //         [2, 1, 3.5, 7, 3],
    //         [1, 3, 4, 5, 6]
    //     ]
    // }, {
    //     fullWidth: true,
    //     chartPadding: {
    //         right: 40
    //     }
    // });
    var dat;
    $.ajax({
        url:"/graph/ajax",
        type:"GET",
        success:function(result){
            console.log(result);
            this.dat = result;

            new Chartist.Line('.ct-chart', {
                series: [result]
            }, {
                axisX: {
                    type: Chartist.AutoScaleAxis,
                    onlyInteger: true
                }
            });
        }
    });



}

$(document).ready(function(){ f1()}) ;
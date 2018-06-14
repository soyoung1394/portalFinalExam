$(document).ready(function () {

var answer;
    $.ajax({
        url: '/answer/list',
        method: 'GET',
        contentType: "application/json"
    }).done(function (answer) {

        var element = {};
        element.mapcard = function (answer) {
            var list = '<tr>' +
                '<td>DAY</td>' +
                '<td>QUESTION</td>' +
                '</tr>';

            for (var i = 0; i < answer.length; i++) {
                list +=
                    '<tr>' +
                    '<td>' + answer[i].day + '<td>' +
                    '<td>' + answer[i].question + '<td>' +
                    '<tr>'
            }
            $('.questionList').html(list);
        }
        element.mapcard(answer);
    });

});
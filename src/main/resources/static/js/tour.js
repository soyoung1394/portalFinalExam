$(document).ready(function () {

var answer;
    $.ajax({
        url: '/answer/list',
        method: 'GET',
        contentType: "application/json"
    }).done(function (answer) {

        var element = {};
        element.mapcard = function (answer) {
            var list = '<table>'+'<tr>' +
                '<td>DAY</td>' +
                '<td>QUESTION</td>' +
                '</tr>';

            for (var i = 0; i <3; i++) {
                list +=
                    '<tr>' +
                    '<td>' + answer[i].day + '</td>' +
                    '<td>' + '<span class="divList" data-href="/detail?num=' + answer[i].num + '">'
                    + answer[i].question + '</span>'+'</td>' +
                    '</tr>';
            }

            $('.questionList').html(list);
        }
        element.mapcard(answer);
        $(".divList").click(function (e) {
            window.location.href=$(this).attr("data-href");
        })
    });

});
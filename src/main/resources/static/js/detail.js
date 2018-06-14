var host = "/answer/list/search?num="
function getUrlParams() {
    var params = {};
    window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (str, key, value) {
        params[key] = value;
    });
    return params;
}

$(document).ready(function () {

    var params = getUrlParams();
    if (params.num) {
        $.get(host  + params.num, function (answer) {
            console.log(answer);
            var element = {};
            element.mapcard = function (answer) {
                var list = '';
                $('.question').text(answer(params.num).question);
                for (var i = 0; i < answer.length; i++) {
                    list +=
                        '<tr>' +
                        // '<td>' + answer[i].day + '</td>' +
                        '<td>' + answer[i].day + '</td>' +
                        '<td>' + answer[i].answer + '</td>' +
                        '</tr>';
                }
                $('.contents').html(list);
            }
            element.mapcard(answer);
        });
    }
});
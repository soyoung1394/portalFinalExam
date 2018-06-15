var host = "/answer/list/search?num="
function getUrlParams() {
    var params = {};
    window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (str, key, value) {
        params[key] = value;
    });
    return params;
}

    var params = getUrlParams();
    if (params.num) {
        $.get(host  + params.num, function (answer) {
            var element = {};
            element.mapcard = function (answer) {
                $('#question').text(params.question);
                var list = '';
                var p='';
                for(var i=0; i<1; i++){
                    p+='<p>'+answer[i].question+'</p>'
                }

                for (var i = 0; i < answer.length; i++) {
                    list +=
                        '<table>'+
                        '<tr>' +
                        '<td class="day">' + answer[i].day + '</td>' +
                        '<td class="answer">' + answer[i].answer + '</td>' +
                        '</tr>';
                }
                $('.question').html(p);

                $('.contents').html(list);
            }
            element.mapcard(answer);
        });
    }

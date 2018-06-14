var today = new Date();
var yy = today.getFullYear();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!

var host="/answer"
var answerId;
if(dd<10) {
    dd='0'+dd
}

if(mm<10) {
    mm='0'+mm
}
today = yy+'-'+mm+'-'+dd;

function save() {
    var answer = {
        id: answerId,
        day: $('#day').text(),
        question: $('#question').text(),
        answer: $('#answer').val()
    };

    var method = 'PUT';
    requestData(method, answer);
    return false;
}

function requestData(method, data) {
    $.ajax({
        url: host,
        method: method,
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(data)
    }).done(function () {
       alert("대답이 등록 되었습니다.");
        window.location.href = '/';
    });
}

$(document).ready(function () {

    document.getElementById("save").addEventListener("click", save);
    $('#day').val(today);

    $.get("/answer/search?day="+yy+"-"+mm+"-"+dd, function (answer) {
        console.log(yy,mm,dd);
        answerId=answer.id;
        $('#day').text(answer.day);
        var que=answer.question;
        $('#question').text(que);
        console.log("answer"+ answer.answer);
    });
});

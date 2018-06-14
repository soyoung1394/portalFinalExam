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
today = yy+'년'+mm+'월'+dd+'일';
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

    $.get("/answer/search?day="+2018+"-"+mm+"-"+dd, function (question) {
        answerId=question.id;
        $('#day').text(question.day);
        var que=question.question;
        $('#question').text(que);
        console.log("answer"+ question.answer);
        if(question.answer != ""){
            alert("이미 대답을 등록하셨습니다.");
            window.location.href = '/';
        }
    });
});

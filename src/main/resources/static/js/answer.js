var today = new Date();
var yy = today.getFullYear();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!

if(dd<10) {
    dd='0'+dd
}

if(mm<10) {
    mm='0'+mm
}

today = yy+'년'+mm+'월'+dd+'일';

$(document).ready(function () {
    console.log(today);
    $('#day').val(today);

    $.get("../question/search?day="+2018+"-"+mm+"-"+dd, function (question) {
        console.log(question);
        console.log(question.question);
        var que=question.question;
        console.log("que=",que);
        $('#question').val(que);
    });
});

var messageRSA = $("#message-RSA");
var textAreaRSA = $("#message-rsa-form");
var addButtonRSA = $("#add-btn-RSA");
var messageTableRSA = $("#message-table-rsa");

addButtonRSA.on("click", function () {
    addNewMessageRSA();
});

function addNewMessageRSA() {
    $.ajax({
        url: "/Encrypts/RsaEncryption/addMessage",
        data: {message: messageRSA.val()},
        type: "POST",
        success: function () {
            console.log("success");
            updateMessagesTableRSA();
        }
    });
}


function updateMessagesTableRSA() {
    $.ajax({
        url: "/Encrypts/RsaEncryption/messages",
        type: "GET",
        success: function (result) {
            console.log(result);

            $.each(result, function(idx, elem){
                messageTableRSA.append("<tr><td>"+elem.id+"</td><td>"+elem.message+"</td><td style='word-wrap: break-word; max-width: 300px'>"+elem.publicKey+"</td><td>"+elem.signature+"</td></tr>");
            });
        }
    });
}

$(document).ready(function () {
    updateMessagesTableRSA();
});
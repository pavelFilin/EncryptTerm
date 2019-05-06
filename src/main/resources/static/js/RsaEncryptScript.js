var messageRSA = $("#message-RSA");
var textAreaRSA = $("#message-rsa-form");
var addButtonRSA = $("#add-btn-RSA");
var messageTableRSA = $("#message-table-rsa");

addButtonRSA.on("click", function () {
    addNewMessageRSA();
});

function addNewMessageRSA() {
    function clarifyRoot() {

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
}


function updateMessagesTableRSA() {
    $.ajax({
        url: "/graph/secantMethod",
        type: "GET",
        success: function (result) {
            console.log(result);

        }
    });
}
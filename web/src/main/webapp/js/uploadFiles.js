;function uploadFiles() {

    var csrfToken = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var type = $(this).attr('typeFile')
    var input = $(this).parent().find("input[type='file']");
    var fd = new FormData();
    fd.append('file', input.prop('files')[0]);
    var object1;
    var $mySpan = $(this).parent().find('span');
    $.ajax({
        type: 'POST',
        url: '/import',
        headers: {
            [header]: csrfToken,
            type: type
        },
        data: fd,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function (data) {
            object1 = new ObjectFromJSON(data.status, data.countUploadRecords, data.sizeFile);
            object1.show();
            var errorMsg = "";
            if (object1.status != "OK") errorMsg = "с ошибкой ";
            $mySpan.text("Загрузка выполнена " + errorMsg + object1.countUploadRecords + " строчек");

            if (object1.status != "OK") {
                $mySpan.css("color", "red");
            }
            else {
                $mySpan.css("color", "green");
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            var msg = textStatus + " " + errorThrown + " " + jqXHR.status;
            $mySpan.css("color", "red");
            $mySpan.text(msg);
        }
    });
}

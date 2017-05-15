;
$(document).ready(function () {
    var $inputFile = $("input[type='file']");
    var $aConvertFile = $('a#aConvertFile');
    $aConvertFile.hide();

    $('div').find("input[type='button']").first().click(convertFiles);

    function convertFiles() {
        var csrfToken = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        var extension = $('input[name="extensionConvert"]:checked').val();
        var type = $('input[name="type"]:checked').val();
        console.log(header + " : " + csrfToken);
        var fd = new FormData();
        fd.append('file', $inputFile.prop('files')[0]);
        $.ajax({
            type: 'POST',
            url: '/convert',
            headers: {
                [header]: csrfToken,
                extensionConvert: extension,
                type: type
            },
            data: fd,
            processData: false,
            contentType: false,
            dataType: 'text',
            success: function (path) {
                var indexOf = path.lastIndexOf('/') + 1;
                $aConvertFile.text(path.substr(indexOf, path.length - indexOf));
                $aConvertFile.attr('href', path);
                $aConvertFile.show();
                alert("Файл создан");
            },
            error: function () {
                alert("Все плохо");
            }
        });
    }
});

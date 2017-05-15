$(document).ready(function () {

    var csrfToken = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    console.log(csrfToken);
    console.log(header);

    $('.autocomplete').each(function () {
        var urlQuery = $(this).data("url");
        console.log(this);
        $(this).autocomplete({
            source: function (request, response) {
                $.ajax({
                    type: 'POST',
                    url: urlQuery,
                    headers:{
                        [header]: csrfToken
                    },
                    data: {
                        maxRows: 12,
                        textStartsWith: request.term
                    },
                    success: function (data) {
                        response($.map(data, function (item) {
                            return {
                                label: item.key,
                                val: item.value
                            }
                        }));
                    },
                    error: function () {
                        alert("error handler!");
                    }
                });
            },
            select: function (event, ui) {
                $(this).parent().find('input[type="text"]').val(ui.item.label);
                $(this).parent().find('input[type="hidden"]').val(ui.item.val);
                return false;
            },
            minLength: 1
        });
    })
});

$(document).ready(function () {

    var $regionSelectDiv = $('div#regionSelectDiv');
    var $showCookieDiv = $('div#showCookie');
    var $elementSpanText = $('#spanNameRegion');
    var errorRegion = 'Регион не выбран';

    $regionSelectDiv.show();
    $showCookieDiv.hide();

    var nameRegion = getCookie("Region");

    if (nameRegion) {
        showCookie(nameRegion);
    }

    $('#addRegionToCookies').click(function () {
        var regionSelectValue = $(this).prev().val();
        if (regionSelectValue == "") {
            alert(errorRegion);
        } else {
            setCookie(regionSelectValue, 1);
            showCookie();
        }
    });

    $('#deleteRegionToCookies').click(function () {
            setCookie("", -1);
            showRegionSelect();
        }
    );

    function showCookie(nameRegion) {
        $regionSelectDiv.hide();
        $showCookieDiv.show();
        if (nameRegion) {
            $elementSpanText.text(nameRegion);
        } else {
            $elementSpanText.text($('div#regionSelectDiv option:selected').val());
        }
    }

    function showRegionSelect() {
        $regionSelectDiv.show();
        $showCookieDiv.hide();
    }

});

function setCookie(value, countDay) {
    if (countDay) {
        var date = new Date;
        date.setDate(date.getDate() + countDay);
        var expires = '; expires=' + date.toUTCString();
    } else {
        expires = "";
    }
    document.cookie ='Region=' + value + expires;
}

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}




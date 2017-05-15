function onSubmit(token) {
    $(":button").attr("disabled", false);
    console.log("onSubmit click")
}
$(document).ready(function(){
    $(":button").attr("disabled", true);
});
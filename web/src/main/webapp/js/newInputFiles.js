;function addInputFile(elem) {
    var $container = $("#template").clone();
    $container.css("marginTop", "10px");
    var $form = elem.closest('form');
    var $button = $container.find("input[type='button']");
    $button.click(uploadFiles);
    if($form.getAttribute('class')=='employer') {
        $button.attr("typeFile","employer");
    } else{
        $button.attr("typeFile","tree");
    }
    $container.appendTo(elem.closest('form'));
    $container.show();
}
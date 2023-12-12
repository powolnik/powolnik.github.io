// This script handles the smooth scroll to sections on the index page

$(document).ready(function() {
    $('a.scrollto').click(function() {
        var target = $(this).attr('href');
        $('html, body').animate({
            scrollTop: $(target).offset().top
        }, 500);
        return false;
    });
});

// This script handles the smooth scroll to the 'Projects' section on the about page

$(document).ready(function() {
    $('a[href="#projects"]').click(function() {
        var target = $(this).attr('href');
        $('html, body').animate({
            scrollTop: $(target).offset().top
        }, 500);
        return false;
    });
});

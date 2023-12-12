// This script adds modals for displaying more information about each project

$(document).ready(function() {
    $('.project').click(function() {
        var modal = $(this).find('.modal');
        modal.show();

        // Get the project image and description
        var image = $(this).find('img').attr('src');
        var description = $(this).find('p').text();

        // Set the modal content
        modal.find('.modal-image').attr('src', image);
        modal.find('.modal-description').text(description);
    });
});

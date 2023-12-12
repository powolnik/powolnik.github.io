// This script handles form validation and submission for the contact form

$(document).ready(function() {
    $('#contactForm').submit(function(e) {
        e.preventDefault();

        // Validate form data
        var name = $('#name').val();
        var email = $('#email').val();
        var message = $('#message').val();

        if (name == '') {
            alert('Please enter your name');
            return false;
        }

        if (email == '') {
            alert('Please enter your email address');
            return false;
        }

        if (!isValidEmail(email)) {
            alert('Please enter a valid email address');
            return false;
        }

        if (message == '') {
            alert('Please enter your message');
            return false;
        }

        // Submit the form data to the server
        $.ajax({
            url: '/contact',
            method: 'POST',
            data: {
                name: name,
                email: email,
                message: message
            },
            success: function(response) {
                if (response.success) {
                    alert('Thank you for your message! I will be in touch shortly.');
                    $('#contactForm').reset();
                } else {
                    alert('There was an error sending your message. Please try again later.');
                }
            }
        });
    });

    function isValidEmail(email) {
        var regex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
        return regex.test(email);
    }
});

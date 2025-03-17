@Composable
fun ContactForm() {
    var message by remember { mutableStateOf("") }
    
    TextField(
        value = message,
        onValueChange = { message = it },
        label = { Text("Message") }
    )
    
    Button(onClick = { sendEmail(message) }) {
        Text("Submit")
    }
}

private fun sendEmail(message: String) {
    // Implement email intent or API call
}

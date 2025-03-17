import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.css.*
import kotlinx.html.*

fun main() {
	// Start the server on port 8080
	embeddedServer(Netty, port = 8080) {
		// Install basic features
		install(DefaultHeaders)
		install(CallLogging)
		install(ContentNegotiation)

		// Configure routing
		routing {
			// Serve static files from resources directory
			static("/static") {
				resources("static")
			}

			// Main route
			get("/") {
				call.respondHtml {
					head {
						title("Kotlin Web App")
						style {
							+"""
                                body {
                                    font-family: 'Arial', sans-serif;
                                    margin: 0;
                                    padding: 20px;
                                    background-color: #f5f5f5;
                                    color: #333;
                                }
                                .container {
                                    max-width: 800px;
                                    margin: 0 auto;
                                    background-color: white;
                                    padding: 20px;
                                    border-radius: 5px;
                                    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                                }
                                h1 {
                                    color: #4285F4;
                                }
                                .counter {
                                    font-size: 24px;
                                    font-weight: bold;
                                    margin: 20px 0;
                                }
                                button {
                                    background-color: #4285F4;
                                    color: white;
                                    border: none;
                                    padding: 10px 15px;
                                    font-size: 16px;
                                    border-radius: 4px;
                                    cursor: pointer;
                                    outline: none;
                                }
                                button:hover {
                                    background-color: #3b78e7;
                                }
                            """
						}
						script {
							+"""
                                let count = 0;
                                
                                function updateCounter() {
                                    document.getElementById('counter').textContent = count;
                                }
                                
                                function incrementCounter() {
                                    count++;
                                    updateCounter();
                                }
                                
                                function resetCounter() {
                                    count = 0;
                                    updateCounter();
                                }
                                
                                document.addEventListener('DOMContentLoaded', () => {
                                    updateCounter();
                                });
                            """
						}
					}
					body {
						div("container") {
							h1 { +"Kotlin Web App" }
							p { +"Welcome to your single-file Kotlin web application!" }

							div("counter") {
								+"Counter: "
								span {
									id = "counter"
									+"0"
								}
							}

							div {
								button {
									onClick = "incrementCounter()"
									+"Increment"
								}
								button {
									style = "margin-left: 10px; background-color: #DB4437;"
									onClick = "resetCounter()"
									+"Reset"
								}
							}

							hr {}

							footer {
								style = "margin-top: 40px; color: #777; font-size: 14px;"
								+"© ${java.time.Year.now().value} - Single File Kotlin Web App"
							}
						}
					}
				}
			}

			// API endpoint example
			get("/api/time") {
				call.respond(hashMapOf("time" to System.currentTimeMillis()))
			}
		}
	}.start(wait = true)
}
html_content = '''<!DOCTYPE html>
<html>
<head>
    <title>My GitHub Pages Website</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            line-height: 1.6;
            max-width: 800px;
            margin: 0 auto;
        }
        h1 {
            color: #333;
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
        }
        .content {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 5px;
        }
        footer {
            margin-top: 30px;
            text-align: center;
            font-size: 0.8em;
            color: #666;
        }
    </style>
</head>
<body>
    <h1>Welcome to My GitHub Pages Website</h1>
    <div class="content">
        <p>This is a static website hosted on GitHub Pages.</p>
        <p>You can modify the HTML and CSS to build your own website.</p>
    </div>
    <footer>
        Hosted on GitHub Pages
    </footer>
</body>
</html>'''

# Write the HTML content to index.html
with open('index.html', 'w') as f:
    f.write(html_content)

print("Successfully created index.html for GitHub Pages")
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File Upload</title>
</head>
<body>
    <h2>Upload File</h2>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <label for="description">Description:</label>
        <input type="text" name="description" id="description"><br><br>

        <label for="file">Select file:</label>
        <input type="file" name="file" id="file" required><br><br>

        <button type="submit">Upload</button>
    </form>
</body>
</html>

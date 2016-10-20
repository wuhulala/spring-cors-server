<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>session</title>
</head>
<body>

    <form action="/login" method="post">
        <div>
            ${error!}
        </div>
        <input type="text" name="username" value="${username!}">
        <input type="text" name="password">
        <input type="submit">
    </form>
</body>
</html>
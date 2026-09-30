<!DOCTYPE html>
<html>

<head>

    <title>Student Login</title>

</head>

<body>

    <h2>Student Login</h2>

    <form action="LoginServlet" method="post">

        <label>Student ID:</label>

        <input type="text"
               name="studentId"
               placeholder="Enter Student ID"
               required>

        <br><br>

        <label>Password:</label>

        <input type="password"
               name="password"
               placeholder="Enter Password"
               required>

        <br><br>

        <button type="submit">
            Login
        </button>

    </form>

    <p>
        New student?
        <a href="register.jsp">
            Register here
        </a>
    </p>

</body>

</html>
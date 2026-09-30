<!DOCTYPE html>
<html>

<head>

    <title>Student Registration</title>

</head>

<body>

    <h2>Student Registration</h2>

    <form action="RegisterServlet" method="post">

        <label>Student Name:</label>
        <input type="text"
               name="studentName"
               placeholder="Enter student name"
               required>

        <br><br>

        <label>Student ID:</label>
        <input type="text"
               name="studentId"
               placeholder="Enter student ID"
               required>

        <br><br>

        <label>Email:</label>
        <input type="email"
               name="email"
               placeholder="Enter email"
               required>

        <br><br>

        <label>Password:</label>
        <input type="password"
               name="password"
               placeholder="Enter password"
               required>

        <br><br>

        <button type="submit">
            Register
        </button>

    </form>

    <p>
        Already registered?
        <a href="login.jsp">Login here</a>
    </p>

</body>

</html>
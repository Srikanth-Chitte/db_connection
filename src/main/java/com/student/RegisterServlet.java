package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

    
        String studentName =
                request.getParameter("studentName");

        String studentId =
                request.getParameter("studentId");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        try {

            
            Connection con =
                    DBConnection.getConnection();

          
            String sql =
                    "INSERT INTO students " +
                    "(student_name, student_id, email, password) " +
                    "VALUES (?, ?, ?, ?)";

           
            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, studentName);
            ps.setString(2, studentId);
            ps.setString(3, email);
            ps.setString(4, password);

       
            int result = ps.executeUpdate();

            if (result > 0) {

                out.println("<h2>Registration Successful!</h2>");

                out.println("<p>Student Name: "
                        + studentName + "</p>");

                out.println("<p>Student ID: "
                        + studentId + "</p>");

                out.println("<p>Email: "
                        + email + "</p>");

                out.println(
                        "<br><a href='login.jsp'>Go to Login</a>"
                );
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            out.println("<h2>Registration Failed</h2>");

            out.println(
                    "<p>" + e.getMessage() + "</p>"
            );

            out.println(
                    "<br><a href='register.jsp'>Try Again</a>"
            );
        }
    }
}
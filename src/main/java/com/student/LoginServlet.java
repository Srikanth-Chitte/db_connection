package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

      
        String studentId =
                request.getParameter("studentId");

        String password =
                request.getParameter("password");

        try {

        
            Connection con =
                    DBConnection.getConnection();


            String sql =
                    "SELECT * FROM students " +
                    "WHERE student_id = ? " +
                    "AND password = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, studentId);
            ps.setString(2, password);

           
            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

              

                request.setAttribute(
                        "studentName",
                        rs.getString("student_name")
                );

                request.setAttribute(
                        "studentId",
                        rs.getString("student_id")
                );

                request.setAttribute(
                        "email",
                        rs.getString("email")
                );

                
                request.getRequestDispatcher(
                        "dashboard.jsp"
                ).forward(request, response);

            } else {

           

                out.println("<html>");
                out.println("<body>");

                out.println(
                        "<h2>Invalid Student ID or Password</h2>"
                );

                out.println(
                        "<a href='login.jsp'>Try Again</a>"
                );

                out.println("</body>");
                out.println("</html>");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            out.println("<h2>Database Error</h2>");

            out.println(
                    "<p>" + e.getMessage() + "</p>"
            );
        }
    }
}
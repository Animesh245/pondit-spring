package com.spring_servlet.addition;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
    super.init(config);
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("hello-servlet.jsp").include(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int i = Integer.parseInt(request.getParameter("n1"));
        int j = Integer.parseInt(request.getParameter("n2"));

        int k = i + j;

//        System.out.println( "The result is "+ k);

//        response.setContentType("text/html");

//        PrintWriter output = response.getWriter();

//        output.print("<h3>The result is </h3>"+ k);

        request.setAttribute("k",k);

        request.getRequestDispatcher("hello-servlet.jsp").include(request, response);

    }

    public void destroy() {
    }
}
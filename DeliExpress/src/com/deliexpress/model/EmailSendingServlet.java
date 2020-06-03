package com.deliexpress.model;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
    private String host = "smtp.gmail.com";
    private String port = "587";
    private String user = "micuentafalsayyo@gmail.com";
    private String pass = "CuentaFalsa9#";

    public void init() {
        // reads SMTP server setting from web.xml file
        //ServletContext context = getServletContext();
        //host = context.getInitParameter("host");
        //port = context.getInitParameter("port");
        //user = context.getInitParameter("user");
        //pass = context.getInitParameter("pass");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        String resultMessage = "";
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
        }
    }

    public void registroRepartidor(String mail) throws ServletException, IOException {
        // reads form fields
        String subject = "Registro Exitoso Deli Express";
        String content = "Le damos la bienvenida al sistema Deli Express.\n";
        content += "Una cuenta de repartidor ha sido creada con su correo y ya puede acceder al sistema.\n";
        content += "\nSi usted no ha creado una cuenta por favor contacte a los administradores en: admin@deliexpress.com";

        String resultMessage = "";

        try {
            EmailUtility.sendEmail(host, port, user, pass, mail, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        }
    }
    
    public void registroCliente(String mail) throws ServletException, IOException {
        // reads form fields
        String subject = "Registro Exitoso Deli Express";
        String content = "Le damos la bienvenida al sistema Deli Express.\n";
        content += "Una cuenta de cliente ha sido creada con su correo y ya puede acceder al sistema.\n";
        content += "\nSi usted no ha creado una cuenta por favor contacte a los administradores en: admin@deliexpress.com";

        String resultMessage = "";

        try {
            EmailUtility.sendEmail(host, port, user, pass, mail, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        }
    }
}

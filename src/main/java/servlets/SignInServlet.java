package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Василевский on 04.05.2016.
 */
public class SignInServlet extends HttpServlet{
        @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) //todo: remove after module 2 home work
        private final AccountService accountService;

        public SignInServlet(AccountService accountService) {
            this.accountService = accountService;
        }

        //get public user profile
        public void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
            //todo: module 2 home work
        }

        //sign up
        public void doPost(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

            String login = request.getParameter("login");
            String pass = request.getParameter("password");

            if (login == null || pass == null) {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            UserProfile profile = accountService.getUserByLogin(login);

            int a=0;
            if (profile == null || !profile.getPass().equals(pass)) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Authorized: "+login);
            response.setStatus(HttpServletResponse.SC_OK);

        }

        //change profile
        public void doPut(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
            //todo: module 2 home work
        }

        //unregister
        public void doDelete(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
            //todo: module 2 home work
        }

    }


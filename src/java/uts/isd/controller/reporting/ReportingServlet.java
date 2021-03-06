package uts.isd.controller.reporting;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.DAOException;
import uts.isd.model.dao.ReportingDAO;
import uts.isd.model.reporting.Report;
import uts.isd.model.Account;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReportingServlet extends HttpServlet {   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HttpSession session = request.getSession();
  
        // Implements logic for retrieving a list of report names and displaying them in the view
        if (accessAllowed(request, session)) {
            try {
                // Clean the session in case an exit was done inproperly
                session.removeAttribute("report");
                session.removeAttribute("error");
    
                ArrayList<String> reportNames = ReportingDAO.getReportNames();
    
                request.setAttribute("reportNames", reportNames);
    
                request.getRequestDispatcher("reporting.jsp").include(request, response);
            } 
            
            catch (DAOException | SQLException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("reporting.jsp").include(request, response);
            }
        }

        else {
            request.setAttribute("error", "Unauthorised Access to Reporting!");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HttpSession session = request.getSession();

        // Implements logic for exiting a report view and cleaning the session correctly
        if (request.getParameter("reportExit") != null && request.getParameter("reportExit").equals("yes")) {
            // Remove all reporting functionality related attributes from the session
            session.removeAttribute("report");

            try {
                // Retrieve a fresh list of report names
                ArrayList<String> reportNames = ReportingDAO.getReportNames();

                // Save to request and forward
                request.setAttribute("reportNames", reportNames);
                request.getRequestDispatcher("reporting.jsp").include(request, response);         
            }

            catch (DAOException | SQLException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("reporting.jsp").include(request, response);
            }
        }

        // Implements logic for opening the view for a sales report
        else if (!request.getParameter("selectedReport").equals("Stock Report")) {
            try {
                // Retrieve the selected report name, and instantiate a new report object from data in the db
                Report r = ReportingDAO.get(request.getParameter("selectedReport"));

                // Save the report to the session
                session.setAttribute("report", r);

                // Redirect to the report view
                request.getRequestDispatcher("reportView.jsp").include(request, response);         
            } 
            
            catch (DAOException | SQLException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("reporting.jsp").include(request, response);
            }
        }

        // Implements logic for opening the view for the stock report
        else {
            try {
                // Instantaiate the report using the specially defined constructor
                Report r = new Report(ReportingDAO.getProductStock(), ReportingDAO.getProductCategories());

                // Save it to the session
                session.setAttribute("report", r);

                // Redirect the view to the stock report view
                response.sendRedirect("stockReport.jsp");
            }

            catch (DAOException | SQLException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("reporting.jsp").include(request, response);
            }
        }
    }

    // Checks if the user is allowed to access the page (i.e. is a staff member)
    private boolean accessAllowed(HttpServletRequest r, HttpSession s) throws DAOException {
        try {
            Account a = (Account) s.getAttribute("user");
            if (a.isStaff()) {
                return true;
            }
        }

        catch (Exception e) {
            r.setAttribute("error", e);
        }

        return false;
    }
}
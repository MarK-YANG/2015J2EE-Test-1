package action;

import DAO.CoursesDAO;
import entity.CourseList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ShowCourses", urlPatterns = "/ShowCourses")
public class ShowCourses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listAllCourse(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listAllCourse(request, response);
    }

    private void listAllCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesDAO dao = new CoursesDAO();

        List<CourseList> list = dao.listCourse();

        request.setAttribute("list", list);
        System.out.println(list.size());

        request.getRequestDispatcher("CourseList.jsp").forward(request, response);
    }
}

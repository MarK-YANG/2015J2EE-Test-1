package action;

import DAO.CoursesDAO;
import entity.CourseList;
import entity.Courses;
import entity.Teachers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowDetail", urlPatterns = "/ShowDetail")
public class ShowDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action == null){
            action = "list";
        }
        System.out.println(action);
        if(action.equals("find")){
            String course = request.getParameter("courseName");
            String operate = request.getParameter("operator");
            String teacher = request.getParameter("teacher");

            if(operate.equals("or")){
                findCourseOr(course, teacher,request, response);
            }else{
                findCourseAnd(course, teacher, request, response);
            }

        }else if (action.equals("teacher")){
            String teacher = request.getParameter("teacher");
            teacherInfo(teacher, request, response);
        }else if (action.equals("course")){
            String course = request.getParameter("course");
            courseInfo(course, request, response);
        }else{

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null){
            action = "list";
        }
        System.out.println(action);
        if(action.equals("find")){
            String course = request.getParameter("courseName");
            String operate = request.getParameter("operator");
            String teacher = request.getParameter("teacher");

            if(operate.equals("or")){
                findCourseOr(course, teacher,request, response);
            }else{
                findCourseAnd(course, teacher, request, response);
            }

        }else if (action.equals("teacher")){
            String teacher = request.getParameter("teacher");
            teacherInfo(teacher, request, response);
        }else if (action.equals("course")){
            String course = request.getParameter("course");
            courseInfo(course, request, response);
        }else{

        }

    }

    private void findCourseAnd(String course, String teacher, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesDAO dao = new CoursesDAO();
        ArrayList<CourseList> list = dao.findAnd(course, teacher);

        request.setAttribute("list", list);
        System.out.println(list.size());
        request.getRequestDispatcher("CourseList.jsp").forward(request, response);
    }

    private void findCourseOr(String course, String teacher, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesDAO dao = new CoursesDAO();
        ArrayList<CourseList> list = dao.findOR(course, teacher);
        System.out.println(list.size());
        request.setAttribute("list", list);
        request.getRequestDispatcher("CourseList.jsp").forward(request, response);
    }

    private void teacherInfo(String teacher, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesDAO dao = new CoursesDAO();
        ArrayList<Teachers> list = dao.getTeacherByName(teacher);
        request.setAttribute("list", list);
        System.out.println(list.size());
        request.getRequestDispatcher("Teacher.jsp").forward(request, response);
    }

    private void courseInfo(String course, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesDAO dao = new CoursesDAO();
        ArrayList<Courses> list = dao.getCourseById(course);
        request.setAttribute("list", list);
        request.getRequestDispatcher("Course.jsp").forward(request, response);
    }
}

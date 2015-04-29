package DAO;

import DBUtil.DBUtil;
import entity.CourseList;
import entity.Courses;
import entity.Teachers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CoursesDAO {

    public ArrayList<Courses> getAll() {
        DBUtil util = new DBUtil();
        ArrayList<Courses> courses = new ArrayList<Courses>();

        Connection con = util.getCon();
        String sql = "SELECT * FROM Courses";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Courses c = new Courses();
                c.setCode(rs.getString(1));
                c.setName(rs.getString(2));
                c.setDescription(rs.getString(3));
                courses.add(c);
            }

            rs.close();
            stmt.close();
            util.closeCon();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public List<CourseList> listCourse() {
        DBUtil util = new DBUtil();
        ArrayList<CourseList> result = new ArrayList<>();

        Connection con = util.getCon();
        String sql = "SELECT TC.course, TC.classid, C.name, T.name, TC.semester, TC.numberOfStudents FROM TaughtCourses AS TC, Courses C , Teachers AS T WHERE TC.course = C.code AND  TC.tid=T.id ORDER BY TC.semester DESC";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CourseList list = new CourseList();
                list.setCourse(rs.getString(1));
                list.setClassid(rs.getString(2));
                list.setCourseName(rs.getString(3));
                list.setTeacherName(rs.getString(4));
                list.setSemester(rs.getInt(5));
                list.setNumberOfStudents(rs.getInt(6));
                result.add(list);
            }

            rs.close();
            stmt.close();
            util.closeCon();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<CourseList> findOR(String course, String teacher) {
        String sql = "SELECT TC.course, TC.classid, C.name, T.name, TC.semester, TC.numberOfStudents FROM TaughtCourses AS TC, Courses C , Teachers AS T WHERE TC.course = C.code AND TC.tid=T.id AND (C.name LIKE ? OR T.name = ?) ORDER BY TC.semester DESC";
        DBUtil util = new DBUtil();
        Connection con = util.getCon();
        ArrayList<CourseList> result = new ArrayList<>();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%"+course+"%");
            pstmt.setString(2, teacher);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CourseList list = new CourseList();
                list.setCourse(rs.getString(1));
                list.setClassid(rs.getString(2));
                list.setCourseName(rs.getString(3));
                list.setTeacherName(rs.getString(4));
                list.setSemester(rs.getInt(5));
                list.setNumberOfStudents(rs.getInt(6));
                result.add(list);
            }

            rs.close();
            pstmt.close();
            util.closeCon();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<CourseList> findAnd(String course, String teacher) {
        String sql = "SELECT TC.course, TC.classid, C.name, T.name, TC.semester, TC.numberOfStudents FROM TaughtCourses AS TC, Courses C , Teachers AS T WHERE TC.course = C.code AND TC.tid=T.id AND (C.name LIKE ? AND T.name = ?) ORDER BY TC.semester DESC";
        DBUtil util = new DBUtil();
        Connection con = util.getCon();
        ArrayList<CourseList> result = new ArrayList<>();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%"+course+"%");
            pstmt.setString(2, teacher);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CourseList list = new CourseList();
                list.setCourse(rs.getString(1));
                list.setClassid(rs.getString(2));
                list.setCourseName(rs.getString(3));
                list.setTeacherName(rs.getString(4));
                list.setSemester(rs.getInt(5));
                list.setNumberOfStudents(rs.getInt(6));
                result.add(list);
            }

            rs.close();
            pstmt.close();
            util.closeCon();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<Courses> getCourseById(String code){
        DBUtil util = new DBUtil();
        ArrayList<Courses> courses = new ArrayList<>();

        Connection con = util.getCon();
        String sql = "SELECT * FROM Courses WHERE code = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, code);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Courses c = new Courses();
                c.setCode(rs.getString(1));
                c.setName(rs.getString(2));
                c.setDescription(rs.getString(3));
                courses.add(c);
            }

            rs.close();
            pstmt.close();
            util.closeCon();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public ArrayList<Teachers> getTeacherByName(String name){
        DBUtil util = new DBUtil();
        ArrayList<Teachers> result = new ArrayList<>();

        Connection con = util.getCon();
        String sql = "SELECT * FROM Teachers WHERE name = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Teachers t = new Teachers();
                t.setId(rs.getString(1));
                t.setName(rs.getString(2));
                t.setTitle(rs.getString(3));
                t.setEmail(rs.getString(4));
                result.add(t);
            }

            rs.close();
            pstmt.close();
            util.closeCon();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/pagestyle.css"/>" rel="stylesheet"/>
<html>
<title>Course List</title>
<body>

<form method="post" action="ShowDetail?action=find">
  <fieldset  >
    <legend><b>Find Courses</b></legend>
    <label>Course Name</label>
    <input type="text" name="courseName" size="30" placeholder="input course name">
    <select name="operator" >
      <option value="and" selected>AND</option>
      <option value="or">OR</option>
    </select>
    <label>Teacher</label>
    <input type="text" size="20" placeholder="input teacher name" name="teacher"/>
    <input type="submit" value="FIND"/>
  </fieldset>
</form>

<table>
  <caption>Course List</caption>
  <thead>
  <tr>
    <th>Code</th>
    <th>Name</th>
    <th>Class</th>
    <th>Semester</th>
    <th>Teacher</th>
    <th>Students</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="var">
    <tr>
      <td>${var.course}</td>
      <td><a href="<c:url value="ShowDetail">
      <c:param name="action" value="course"></c:param>
      <c:param name="course" value="${var.course}"></c:param>
</c:url> ">${var.courseName}</a> </td>
      <td>${var.classid}</td>
      <td>${var.semester}</td>
      <td><a href="<c:url value="ShowDetail">
      <c:param name="action" value="teacher"></c:param>
      <c:param name="teacher" value="${var.teacherName}"></c:param>
</c:url>"> ${var.teacherName}</a></td>
      <td>${var.numberOfStudents}</td>
    </tr>
  </c:forEach>

  </tbody>
</table>
</body>
</html>

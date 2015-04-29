
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/pagestyle.css"/>" rel="stylesheet"/>
<html>
<title>Course List</title>
<body>

<c:forEach items="${list}" var="var">
  <table>
    <caption>${var.name}</caption>
    <thead>
    <tr>
      <th>Title</th>
      <th>E-mail</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>${var.title}</td>
      <td>${var.email}</td>
    </tr>
    </tbody>
  </table>
</c:forEach>

</body>
</html>

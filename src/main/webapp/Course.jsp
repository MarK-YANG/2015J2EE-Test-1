
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
      <th>Code</th>
      <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>${var.code}</td>
      <td>${var.description}</td>
    </tr>
    </tbody>
  </table>
</c:forEach>

</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 30.01.2015
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Department</title>
  <link rel="stylesheet" type="text/css" href="resources/css/semantic.css">
</head>
<body>

<spring:message code="list.department" var="titleForm"/>
<spring:message code="departments.name" var="tName"/>
<spring:message code="departments.description" var="tDescription"/>
<spring:message code="edit.button" var="editButton"/>
<spring:message code="table.option" var="option"/>
<spring:message code="add.button" var="addButton"/>
<spring:message code="cancel"  var="cancelButton"/>

<h3 class="ui block header">
  ${titleForm}
</h3>
<table class="ui table celled striped">
  <thead>
  <tr>
    <th>Id</th>
    <th>${tName}</th>
    <th colspan="2">${tDescription}</th>
    <th>${option}</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${lists}" var="elem">
    <tr>
    <td>${elem.idDepartment}</td>
    <td>${elem.name}</td>
    <td colspan="2">${elem.description}</td>
     <td>
       <a href="editdepartment-id=${elem.idDepartment}.html"><button  class="ui button blue right floated">${editButton}</button></a>
     </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="addDepartment.html"><button class="ui positive submit button">${addButton}</button></a>
<a href="index.html"><button class="ui red button">${cancelButton}</button></a>
</body>
</html>

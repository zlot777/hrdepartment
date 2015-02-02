<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 30.01.2015
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit Department</title>
  <link rel="stylesheet" type="text/css" href="resources/css/semantic.css">

</head>
<body>

<spring:message code="edit.department.title" var="titleForm"/>
<spring:message code="departments.name" var="tName"/>
<spring:message code="departments.description" var="tDescription"/>
<spring:message code="edit.button" var="editButton"/>
<spring:message code="reset.button"  var="resetButton"/>
<spring:message code="cancel"  var="cancelButton"/>


<form:form commandName="currentDepartment" method="post" action="addDepartment.html" class="ui form segment">
  <div class="ui message">
    <div class="header">${titleForm}</div>
  </div>
  <div class="field">
    <label>${tName}</label>
    <form:input path="name"  placeholder="${tName}" type="text"/>
    <form:errors path="name" cssClass="error"/>
  </div>
  <div class="field">
    <label>${tDescription}</label>
    <form:textarea path="description" placeholder="${tDescription}"/>
    <form:errors path="description" cssClass="error"/>
  </div>
  <br>
  <input type="submit" value="${editButton}" class="ui positive submit button"/>
  <input type="reset" value="${resetButton}" class="ui red button"/>
  <a href="index.html"><input type="button" value="${cancelButton}" class="ui red button"/></a>
</form:form>

</body>
</html>

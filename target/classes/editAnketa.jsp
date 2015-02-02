<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 30.01.2015
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Anketa</title>
  <link rel="stylesheet" type="text/css" href="resources/css/semantic.css">
</head>
<body>



<spring:message code="edit.worker.title" var="titleForm"/>
<spring:message code="worker.firstName" var="tFirstName"/>
<spring:message code="worker.lastName" var="tLastName"/>
<spring:message code="worker.salary"   var="tSalary"/>
<spring:message code="worker.birthDay" var="tBirthDay" />
<spring:message code="worker.department" var="tDepartment"/>
<spring:message code="edit.button" var="editButton"/>
<spring:message code="reset.button"  var="resetButton"/>
<spring:message code="cancel"  var="cancelButton"/>
<spring:message code="edit.worker.active"  var="activeCheck"/>



<form:form class="ui form segment" commandName="currentAnket" method="post" action="edit-id=${currentAnket.id}.html">
  <div class="ui message">
    <div class="header">${titleForm}</div>
  </div>
  <div class="two fields">
    <div class="field">

      <label path="firstName">${tFirstName}e</label>
      <form:input path="firstName" value="${currentAnket.firstName}"  placeholder="${tFirstName}" type="text"  readonly="${!currentAnket.active}" />
      <form:errors cssClass="error" path="firstName"/>

    </div>
    <div class="field">
      <label>${tLastName}</label>
      <form:input path="lastName" value="${currentAnket.lastName}" placeholder="${tLastName}" type="text" readonly="${!currentAnket.active}"/>
      <form:errors  cssClass="error" path="lastName"/>
    </div>
  </div>
  <div class="two fields">
    <div class="field">
      <label>${tSalary}</label>
      <form:input path="salary" value="${currentAnket.salary}" placeholder="${tSalary}" type="number" readonly="${!currentAnket.active}"/>
      <form:errors cssClass="error" path="salary"/>
    </div>

    <div class="field">
      <label>${tBirthDay}</label>
      <form:input type="text"  placeholder="example 01-10-2012" path="birthDay" readonly="${!currentAnket.active}"/>
      <form:errors cssClass="error" path="birthDay"/>
    </div>
  </div>
  <div class="field">
  <label>${tDepartment}</label>
  <form:select path="department">
       <c:forEach items="${departmentList}" var="item">
         <form:option value="${item.idDepartment}" label="${item.name}" selected="${currentAnket.department == item.idDepartment ? 'selected' : ''}" />
       </c:forEach>

  </form:select>
</div>
  <div class="inline field">
  <form:checkbox path="active" label="${activeCheck}" value="${currentAnket.active}" />
  </div>
  <input type="submit" value="${editButton}" class="ui positive submit button"/>
  <input type="reset" value="${resetButton}" class="ui red button"/>
  <a href="index.html"><input type="button" value="${cancelButton}" class="ui red button"/></a>
</form:form>
</body>
</html>

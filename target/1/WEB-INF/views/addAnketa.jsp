<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>add Worker</title>
    <link rel="stylesheet" type="text/css" href="resources/css/semantic.css">
</head>

<style>
  .error{
      color: red;
  }
</style>

<body>

<spring:message code="add.worker.title" var="titleForm"/>
<spring:message code="worker.firstName" var="tFirstName"/>
<spring:message code="worker.lastName" var="tLastName"/>
<spring:message code="worker.salary"   var="tSalary"/>
<spring:message code="worker.birthDay" var="tBirthDay" />
<spring:message code="worker.department" var="tDepartment"/>
<spring:message code="add.button" var="addButton"/>
<spring:message code="reset.button"  var="resetButton"/>
<spring:message code="cancel"  var="cancelButton"/>


<form:form class="ui form segment" commandName="currentAnket" method="post" action="addAnketa.html">
    <div class="ui message">
        <div class="header">${titleForm}</div>
    </div>
    <div class="two fields">
        <div class="field">

            <label path="firstName">${tFirstName}</label>
            <form:input path="firstName" placeholder="First Name" type="text"/>
            <form:errors cssClass="error" path="firstName"/>
        </div>
        <div class="field">
            <label>${tLastName}</label>
            <form:input path="lastName" placeholder="Last Name" type="text"/>
            <form:errors  cssClass="error" path="lastName"/>
        </div>
    </div>
    <div class="two fields">
        <div class="field">
            <label>${tSalary}</label>
            <form:input path="salary" placeholder="Salary" type="number"/>
            <form:errors cssClass="error" path="salary"/>
        </div>

        <div class="field">
            <label>${tBirthDay}</label>
            <form:input type="text" placeholder="example 01-10-2012" path="birthDay"/>
            <form:errors cssClass="error" path="birthDay"/>
        </div>
    </div>
    <div class="field">
        <label>${tDepartment}</label>
        <form:select path="department" items = "${departmentList}" itemValue="idDepartment" itemLabel="name" />
    </div>
    <input type="submit" value="${addButton}" class="ui positive submit button"/>
    <input type="reset" value="${resetButton}" class="ui red button"/>
    <a href="index.html"><input type="button" value="${cancelButton}" class="ui red button"/></a>
</form:form>
</body>
</html>
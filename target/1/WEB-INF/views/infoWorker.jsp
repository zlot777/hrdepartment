<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 30.01.2015
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Info</title>
  <link rel="stylesheet" type="text/css" href="resources/css/semantic.css">
</head>
<body>


<spring:message code="worker.names" var="tName"/>
<spring:message code="worker.salary"   var="tSalary"/>
<spring:message code="worker.birthDay" var="tBirthDay" />
<spring:message code="worker.department" var="tDepartment"/>
<spring:message code="info.worker.title" var="titleInfo"/>
<spring:message code="cancel"  var="cancelButton"/>

<h3 class="ui block header">
  ${titleInfo}
</h3>
<div class="ui items">
    <div class="content">
      <p class="header"><b>${tName} :</b>${entity.firstName} ${entity.lastName}</p>
      <p class="meta">
      <p>
        <b>${tBirthDay} :</b> ${entity.birthDay}
      </p>
      <p>
        <b>${tSalary} :</b> ${entity.salary}
      </p>
      <p>
        <b>${tDepartment} :</b> ${department}
      </p>
      </p>
    </div>
  </div>
<a href="index.html"><button  class="ui positive submit button">${cancelButton}</button></a>
</div>

</body>
</html>

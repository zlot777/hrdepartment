<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="resources/css/semantic.css">
</head>

<spring:message code="name.program" var="program"/>
<spring:message code="item.worker" var="worker"/>
<spring:message code="item.hr-depart" var="human_research"/>
<spring:message code="menu.addWorker" var="addWorker"/>
<spring:message code="menu.addDepartment" var="addDepartment"/>
<spring:message code="menu.addDepartment" var="addDepartment"/>
<spring:message code="menu.listDepartment" var="departmentList"/>
<spring:message code="worker.names" var="emploeeName"/>
<spring:message code="table.option" var="option"/>
<spring:message code="edit.button" var="editButton"/>
<spring:message code="search.example" var="searchExample"/>


<body>

	<div class="wrap">
		<header class="ui grid">
			<div class="ten wide column">
				<h2 class="ui inverted header">${program}</h2>
			</div>
			<div class="five wide column">
				<div class="ui buttons right">
					<a href="worker.html"><div class="ui button">${worker}</div></a>
					<div class="or"></div>
					<a href="hr.html"><div class="ui positive button">${human_research}</div></a>
				</div>
			</div>
			<div class="one wide column">
				<a href="?lang=en_EN">
					<i class="united states flag"></i>
				</a>
				<a href="?lang=uk_UA">
					<i class="ukraine flag"></i>
				</a>
			</div>
		</header>


		<div class="ui menu">
			<a href="index.html" class="active item">
				<i class="home icon"></i> Home
			</a>
			<c:if test="${cookie.role.value == 'hr'}">
			<a class="item" href="addAnketa.html">
				<i class="linux icon"></i>
				${addWorker}
			</a>
			<a class="item" href="addDepartment.html">
				<i class="cube icon"></i>
				${addDepartment}
			</a>
			<a href="listOfDepartment.html" class="item">
				<i class="list ul icon"></i>
				${departmentList}
			</a>
			</c:if>
			<div class="right menu">
				<div class="item">
					<div class="ui transparent icon input">
						<form method="get"  class="ui transparent icon input"  action="search.html">
							<input name="criteria" id="criteria" type="text" placeholder="${searchExample}"/>
							<i class="search link icon">
								<input type="submit" value="" class="icon">
							</i>
						</form>
					</div>
				</div>
			</div>
		</div>


		<table class="ui celled striped table">
			 <thead>
				<tr>
					<th>Id</th>
					<th>${emploeeName}</th>
					<c:if test="${cookie.role.value == 'hr'}"><th>${option}</th></c:if>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${lists}">
				<tr>
					<td>${list.id}</td>
					<td><a href="id=${list.id}.html" >${list.firstName} ${list.lastName}</a></td>
					<c:if test="${cookie.role.value == 'hr'}">
						<td class="right aligned">
						<div class="ui buttons">
							<a href="edit-id=${list.id}.html"><button  class="ui button blue right floated">${editButton}</button></a>
						    </div>
					</td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
		</table>



		<%--<div class="ui borderless pagination menu">--%>
			<%--<a class="item">--%>
				<%--<i class="left arrow icon"></i> Попередня--%>
			<%--</a>--%>
			<%--<c:forEach var="i" begin="1" end="${listSize}">--%>
			<%--<a class="item">${i}</a>--%>
			<%--</c:forEach>--%>
			<%--<a class="item">--%>
				<%--Наступна <i class="icon right arrow"></i>--%>
			<%--</a>--%>
		<%--</div>--%>




	</div>
</body>
</html>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<style type="text/css">
ul {
	list-style-type: none;
	padding: 0;
	margin: 0
}
</style>

<body>
	<form:form method="post" modelAttribute="dog">
		Create dog
		<ul>
			<li><form:label path="age">Age</form:label> 
			<form:input
					path="age" />
			<li>
			<li><form:label path="breed">Breed</form:label> <form:input
					path="breed" /></li>

			<li><input type="submit" value="Send" /></li>
		</ul>
	</form:form>

	<ul>
		<c:forEach var="dogg" items="${dogs}" varStatus="status">
		
		<li>${dogg.age}</li>
		<li>${dogg.breed}</li>
		
		<li>&nbsp;</li>

		</c:forEach>
	</ul>

</body>

</html>

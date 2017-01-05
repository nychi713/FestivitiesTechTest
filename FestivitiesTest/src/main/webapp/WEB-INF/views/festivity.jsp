<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Welcome to festivities manager!</title>
        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
            .tg .tg-4eph{background-color:#f9f9f9}
        </style>
    </head>
    <body>
        <h1>
            Welcome to festivities manager!<br>
            Please, add a festivity.
        </h1>


        <c:url var="addAction" value="/festivity/add" ></c:url>
        <form:form action="${addAction}" commandName="festivity">     
            <c:choose>
                <c:when test="${status=='200'}">

                    <table>
                        <c:if test="${!empty festivity.name}">
                            <tr>
                                <td>
                                    <form:label path="id">
                                        <spring:message text="ID"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                                    <form:hidden path="id" />
                                </td> 
                            </tr>
                        </c:if>
                        <tr>
                            <td>
                                <form:label path="name">
                                    <spring:message text="Name"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="name" />
                            </td> 
                        </tr>
                        <tr>
                            <td>
                                <form:label path="place">
                                    <spring:message text="Place"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="place" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="startDate">
                                    <spring:message text="Start date"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="startDate" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="endDate">
                                    <spring:message text="End date"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="endDate" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty festivity.name}">
                                    <input type="submit"
                                           value="<spring:message text="Edit festivity"/>" />
                                </c:if>
                                <c:if test="${empty festivity.name}">
                                    <input type="submit"
                                           value="<spring:message text="Add festivity"/>" />
                                </c:if>
                            </td>
                        </tr>
                    </table>	

                </c:when>    
                <c:otherwise>
                    <h2>${message}  </h2>
                    <br />
                </c:otherwise>
            </c:choose>
        </form:form>
        <br>
        
        <c:if test="${!empty listFestivities}">
            <h3>Festivities List</h3>
            <table class="tg">
                <tr>
                    <th width="80">Festivity ID</th>
                    <th width="120">Festivity Name</th>
                    <th width="120">Festivity Place</th>
                    <th width="120">Festivity start date</th>
                    <th width="120">Festivity end date</th>
                    <th width="60">Edit</th>
                    <th width="60">Delete</th>
                </tr>
                <c:forEach items="${listFestivities}" var="festivity">
                    <tr>
                        <td>${festivity.id}</td>
                        <td>${festivity.name}</td>
                        <td>${festivity.place}</td>
                        <td>${festivity.startDate}</td>
                        <td>${festivity.endDate}</td>
                        <td><a href="<c:url value='/edit/${festivity.id}' />" >Edit</a></td>
                        <td><a href="<c:url value='/remove/${festivity.id}' />" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if> 
        <br />
    </body>
</html>

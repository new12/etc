<%@tag pageEncoding="utf-8" %>
<%@attribute name="title" type="java.lang.String" required="false"%>
<%@attribute name="index" type="java.lang.Boolean" required="false"%>
<%@attribute name="includeTable" type="java.lang.Boolean" required="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>${title}</title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!--basic styles-->
    <%@include file="/WEB-INF/views/common/css.jspf" %>
    <c:if test="${index eq true}">
        <link href="<%=request.getContextPath()%>/assets/bower_components/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/bower_components/metisMenu/dist/metisMenu.min.css">
    </c:if>
    <c:if test="${includeTable eq true}">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/bower_components/datatables/media/css/jquery.dataTables.css"/>
    </c:if>
    <style type="text/css">
        .dataTables_filter, .dataTables_length {
            display: none;
        }
    </style>
</head>
<body>
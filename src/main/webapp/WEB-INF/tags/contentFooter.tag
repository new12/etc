<%@tag pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="includeTable" type="java.lang.Boolean" required="false"%>
</body>
<%@include file="/WEB-INF/views/common/js.jspf"%>
<c:if test="${includeTable eq true}">
    <script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/assets/bower_components/datatables/media/js/jquery.dataTables.min.js"/>
    <script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/assets/bower_components/datatables/media/js/dataTables.Bootstrap.js"></script>
</c:if>
</html>
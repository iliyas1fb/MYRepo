<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="/WEB-INF/taglib/spring.tld"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<c:set var="present" value="<%=request.getAttribute(\"Present\")%>" />
<c:set var="previous" value="<%=request.getAttribute(\"Previous\")%>" />
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<jsp:include page="common/stylesheets.jsp"/>
<jsp:include page="common/scripts.jsp"/>
<%-- <link class="include" rel="stylesheet" type="text/css" href="${contextPath}/system-file/css/jqplot/jquery.jqplot.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${contextPath}/system-file/css/jqplot/jquery.ui.base.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/system-file/css/jqplotjson/css/jquery.jqplot.css" /> --%>
<%-- <script type="text/javascript" src="${contextPath}/system-file/js/jquery/jquery-ui-1.8.6.custom.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jqplot/excanvas.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jqplot/jqplot.trendline.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jqplot/jqplot.canvasTextRenderer.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jqplot/jqplot.canvasAxisLabelRenderer.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jqplot/jqplot.canvasAxisTickRenderer.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jqplot/jqplot.json2.min.js"></script>
<script type="text/javascript" src="${contextPath}/system-file/js/jquery/highcharts.js"></script> --%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title> <spring:message code="title.SystemDashboard"/></title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div class="container_12">
    <div class="grid_12">
        <p class="breadcrumb"><spring:message code="label.Dashboard"/></p>
    </div>
</div>
<div class="container_12">
    <div id="grid_12" style="margin-left: 1%; width: 100%;">
        <div class="box altbox">
        <div class="boxin">
            <div class="header" id="collapse" style=" overflow:hidden;">
                <h3><spring:message code="label.Dashboard"/></h3>
            </div>
        </div>
     </div>
     </div>
    </div>
    <div></div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>

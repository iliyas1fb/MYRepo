<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="java.util.Calendar"%>

<c:set var="isAuthenticated" value="<%=request.getUserPrincipal()%>" />

<c:set var="year" value="<%=Calendar.getInstance().get(Calendar.YEAR)%>" />	
<c:set var="remoteAddress" value="<%=request.getRemoteAddr()%>" />

<div style="clear: both;"></div>
<div id="footer-main"><p>
	<spring:message code="label.Copyright" />&nbsp;&copy;
	<c:out value="${year}"/> <spring:message code="label.PortalFooter" />
</p> </div>
<div style="clear: both;"></div>

<script type="text/javascript">
window.onload = function () {			
    if (typeof history.pushState == "function") {
        history.pushState("kailash", null, null);
        window.onpopstate = function () {
            history.pushState('newkailash', null, null);		            
        };
    }
    else {
    	var ignoreHashChange = false;
        if (("onhashchange" in window)) { 
        	if (!ignoreHashChange) {
                ignoreHashChange = true;
                window.location.href += "#";
					setTimeout("hashAgain()", "50");
            }
            else {
                ignoreHashChange = false;   
            }
           
        }
       
    }
};
function hashAgain(){
	var storedHash = window.location.hash;
	window.setInterval(function () {
	    if (window.location.hash != storedHash) {
	         window.location.hash = storedHash;
	    }		
	}, 50);
}
</script>
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Expires","0");
	response.setDateHeader ("Expires", -1); //prevent caching at the proxy server	
	response.setDateHeader("Last-Modified", System.currentTimeMillis());
%>
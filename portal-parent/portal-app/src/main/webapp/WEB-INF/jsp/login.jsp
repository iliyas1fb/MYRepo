<!DOCTYPE html> 
<%@page import="java.util.Properties"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="/WEB-INF/taglib/spring.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><spring:message code="title.PortalLogin" /></title>
<%-- title icon disable
<link rel="icon" href="${contextPath}/system-file/images/icon.ico" type="image/icon"> --%>
<link href="${contextPath}/system-file/css/main.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/system-file/css/login-box.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/system-file/css/styles.css" rel="stylesheet" type="text/css" />

<script>
	var flag='${error}';
	
</script>

<script type="text/javascript" type="text/javascript" src="${contextPath}/system-file/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript">
    var jq = jQuery.noConflict();
    /* function getip(json){ 
    	document.getElementById("ipAddress").value=json.ip_address; 
    } */
    
</script>

<script type="text/javascript" type="text/javascript" src="${contextPath}/system-file/jquery/jquery-1.8.3.js"></script>
</head>
<body>
	<div class="main">
		<div class="container_login">
			<div class="main_logo">  
		 <div class="error_http"></div>
			</div>
			<div id="login-error" class="displayErrMsg">
				<c:if test="${error =='true' }">
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
				</c:if>
			</div>
			<c:if test="${Success == '1' }">
				<div id="Msg" class="displayErrMsg" style="color: red">
					<spring:message code="label.PasswordSent" />
				</div>
			</c:if>
			<div class="logo">
			<img src="${contextPath}/system-file/images/loginlogo1.png" alt="portal"/>
			</div>
			<div id="login-box">
				<h2><spring:message code="label.Login"/></h2>
				<form:form id="login_form" action="${contextPath}/doc/access/loginSubmit" commandName="loginLogout"  method="post" > <!-- autocomplete="off" -->
					<div id="login-box-name" style="margin-top:20px; width:115px;"><spring:message code="label.Username" />:</div>
					<div id="login-box-field" style="margin-top:20px;">
						<form:input type="text" id="j_username" name="j_username" path="userName"  class="form-login" size="30" placeholder="Username"/>
						<script>
							setTimeout(function() {document.getElementById('j_username').focus();});
						</script>
					</div>
					<div id="login-box-name" style="width:115px;"><spring:message code="label.Password" />:</div>
					<div id="login-box-field">
						<form:input id="j_password" name="j_password" type="password" path="password" class="form-login" size="30" placeholder="Password"/>
					</div>
					<br/>
					<br/>
					<div style="float:left; margin:10px 0px 25px 0px;">
						<span class="login-box-options">
							 <a href="${contextPath}/doc/password/forgot" style="color: #ebebeb;"><font size="2"><spring:message code="label.ForgotPassword" /></font></a>
							 ||||<a href="${contextPath}/doc/signUp/customer" style="color: #ebebeb;"> <font size="2"><spring:message code="label.SignUp" /></font></a>
						</span>
					</div>
					<div style="float:left; margin:10px 0px 25px 30px; width:300px;">
						<input id="ipAddress" name="ipAddress" type="hidden"/>
						<input type="submit" class="loginButton" style="color: #E4F7FD;" value='<spring:message code="button.Login" />'/>
					</div>
					
				
				</form:form>
			</div>
			<br/><br/>
		</div>
	</div>
	<jsp:include page="common/footer.jsp" />
	<script type="text/javascript"> 
	var message="Sorry, right-click has been disabled"; 
	function clickIE(){
		if (document.all){
			(message);return false;
		}
	} 
	function clickNS(e){
		if(document.layers||(document.getElementById&&!document.all)){ 
			if (e.which==2||e.which==3){
				(message);return false;
			}
		}
	} 
	if (document.layers){
		document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;
	} 
	else{
		document.onmouseup=clickNS;document.oncontextmenu=clickIE;
	} 
	document.oncontextmenu=new Function("return false");
	 $(window).keydown(function(event) {
	    if(event.keyCode == 123) { 
	            event.preventDefault(); 
	        }
	    });
	$(document).ready(function(){
	    $(document).keyup(function (e) {
	       var code = (e.keyCode ? e.keyCode : e.which);

	            if(code==123)
	            {
	            	(message);return false;
	            }

	    });
	 }); 
</script>
</body>
</html>

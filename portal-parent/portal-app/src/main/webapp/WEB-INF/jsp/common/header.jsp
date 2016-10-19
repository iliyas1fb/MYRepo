<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="/WEB-INF/taglib/spring.tld"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.authentication.UsernamePasswordAuthenticationToken"%>
<%@ page import="org.common.service.Permission"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="permVOList" value="<%=request.getSession().getAttribute(\"permVOList\")%>" />
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<c:set var="isAuthenticated" value="<%=request.getUserPrincipal()%>" />
<c:set var="secUserVO" value="<%=request.getSession().getAttribute(\"secUserVO\")%>" />
<script>
    function enableDisableConfig(context){
        /*  Manage Merchant Configuration  */
        <c:forEach items="${permVOList}" var="omnypayPermissionVO" varStatus="status">
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Merchants'){
                var configurationflag = false;
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('STORE CONFIGURATION'==('${permissionFunctionalityVO.permissionName}' ) ){
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        //  $("#AddJQ").removeClass('ui-state-disabled');
                        $("#AddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        //  $("#configurationEditJQ").removeClass('ui-state-disabled');
                        $("#configurationEditJQ").show();
                        configurationflag = true;
                    }
                    </c:forEach>
                    return configurationflag;
                }
                </c:forEach>
            }
        </c:forEach>
    }
    function enableDisableConfigView(context){
        /*  Manage Merchant Configuration  */
        <c:forEach items="${permVOList}" var="omnypayPermissionVO" varStatus="status">
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Merchants'){
                var configurationViewflag = false;
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('STORE CONFIGURATION'==('${permissionFunctionalityVO.permissionName}' ) ){
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#AddJQ").show();
                        configurationViewflag = true;
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#configurationEditJQ").show();
                        configurationViewflag = true;
                    }
                    </c:forEach>
                    return configurationViewflag;
                }
                </c:forEach>
            }
            
        </c:forEach>
    }
    
function enableDisableView(context, id){
    	
    	
    	
        var flag = false;
        <c:forEach items="${permVOList}" var="Permission" varStatus="status">
        
        //---------------------------- For ManageCorporates ------------------------------
            if(context==('${Permission.permissionDesc}')){
                <c:forEach items="${Permission.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                
               
                if('MERCHANT LIST'==('${permissionFunctionalityVO.permissionName}' )){
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('VIEW'==('${permissionComponentVO.permissionName}' ) ){
                        $("#"+id).removeClass('ui-state-disabled');
                        flag = true;
                    }
                    </c:forEach>
                }
                </c:forEach>
                console.log(flag);
                console.log("ManageCorporates");
               
            }
        
        // --------------------------------- For ManageRoles ------------------------------
            if(context == ('${Permission.permissionDesc}')){
            	  
                <c:forEach items="${Permission.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
             
                if('USER LIST'==('${permissionFunctionalityVO.permissionName}' ) ){
                	
                  	
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                 
                    if('VIEW'==('${permissionComponentVO.permissionName}' ) ){
                    	
                    
                        $("#ViewJQ").removeClass('ui-state-disabled');
                        flag = true;
                       
                    }
                    </c:forEach>
                }
                console.log(flag);
                console.log("ManageRoles");
                </c:forEach>
                
               
            }
        
        // --------------------------------- For ManageUsers ------------------------------
            /* if(context == ('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Users'){
            	  console.log("inf");
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                    if('USERS'==('${permissionFunctionalityVO.permissionName}')){
                        <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                        if('RESET PASSWORD' == ('${permissionComponentVO.permissionName}')){
                            flag = true;
                        }
                        </c:forEach>
                    }
                </c:forEach>
              
            } */
           
        </c:forEach>
          
           
        return flag;
    
       
    }
    
    
    function enableDisableButton(context,functionality)
    {
        <c:forEach items="${permVOList}" var="omnypayPermissionVO" varStatus="status">
        //---------------------------- For ManageBanks ------------------------------
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Banks'){
                var bankFlag = false;
                var binFlag = false;
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('BANK'==('${permissionFunctionalityVO.permissionName}' ) ){
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#AddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#EditJQ").show();
                        bankFlag = true;
                    }
                    </c:forEach>
                }
                </c:forEach>
                if(functionality=='BANK'){
                    return bankFlag;
                }
            }
        
            //---------------------------- For ManageCorporates ------------------------------
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Pos'){
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('POS'==('${permissionFunctionalityVO.permissionName}' ) ){
                    var flag = false;
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#AddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#EditJQ").show();
                        flag = true;
                    }
                    </c:forEach>
                    return flag;
                }
                </c:forEach>
            }
       
        // --------------------------------- For ManageUsers ------------------------------
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Users'){
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('USERS'==('${permissionFunctionalityVO.permissionName}' ) ){
                    var flag = false;
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#AddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#EditJQ").show();
                        flag = true;
                    }
                    </c:forEach>
                    return flag;
                }
                </c:forEach>
            }
        // --------------------------------- For ManageRoles ------------------------------
            if(context == ('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Roles'){
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('ROLES'==('${permissionFunctionalityVO.permissionName}' ) ){
                    var flag = false;
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#AddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#EditJQ").show();
                        flag = true;
                    }
                    </c:forEach>
                    return flag;
                }
                </c:forEach>
            }
        /*  Manage Merchant  */
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Merchants'){
                var merchantflag = false;
                var configurationflag = false;
                var commissionflag = false;
                var merchantFundFlag = false;
                var fssflag = false;
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('MERCHANT'==('${permissionFunctionalityVO.permissionName}' ) ){
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#MerchantAddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#MerchantEditJQ").show();
                        merchantflag = true;   // MerchantEditJQ
                    }
                    if('APPROVE-REJECT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#ApproveRejectJQ").show();
                    }
                    if('VIEW'==('${permissionComponentVO.permissionName}' ) ){
                        $("#MerchantViewJQ").show();
                    }
                    if('STORE CONFIGURATION'==('${permissionComponentVO.permissionName}' ) ){
                        $("#ManageStoreJQ").show();
                    }
                    </c:forEach>
                }
                else if('STORE CONFIGURATION'==('${permissionFunctionalityVO.permissionName}' ) ){
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('VIEW'==('${permissionComponentVO.permissionName}' ) ){
                        $("#ManageStoreJQ").show();
                        configurationflag = true;
                    }
                    </c:forEach>
                }
               
                </c:forEach>
                if(functionality == 'MERCHANT'){
                    return merchantflag;
                }
            }
        
        /*  STORE CONFIGURATIONs -> MERCHANTS  */
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Manage Merchants'){
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('STORE CONFIGURATION'==('${permissionFunctionalityVO.permissionName}' ) ){
                    var managegBlockflag = false;
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#AddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#EditJQ").show();
                        managegBlockflag = true;
                    }
                    </c:forEach>
                    return managegBlockflag;
                }
                </c:forEach>
            }
        /*  STORE CONFIGURATIONs -> GLOBAL */
            if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'STORE CONFIGURATION'){
                var managegBlockGlobalflag = false;
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('STORE CONFIGURATION'==('${permissionFunctionalityVO.permissionName}' ) ){
                    <c:forEach items="${permissionFunctionalityVO.permissionComponentVO}" var="permissionComponentVO" varStatus="status">
                    if('ADD'==('${permissionComponentVO.permissionName}' ) ){
                        $("#AddJQ").show();
                    }
                    if('EDIT'==('${permissionComponentVO.permissionName}' ) ){
                        $("#EditJQ").show();
                        managegBlockGlobalflag = true;
                    }
                    </c:forEach>
                    return managegBlockGlobalflag;
                }
                </c:forEach>
            }
        
        //---------------------------- For Transaction Search------------------------------
          if(context==('${omnypayPermissionVO.permissionDesc}') && context == 'Transaction Search'){
                <c:forEach items="${omnypayPermissionVO.permissionFunctionalityVO}" var="permissionFunctionalityVO" varStatus="status">
                if('TRANSACTION'==('${permissionFunctionalityVO.permissionName}' ) ){
                }
                </c:forEach>
                
            } 
        </c:forEach>
    }
</script>

<script type="text/javascript">
    function post_to_url(path,params,method) {
        method = method || "POST"; // Set method to post by default, if not specified.
        // The rest of this code assumes you are not using a library.
        // It can be made less wordy if you use one.
        var form = document.createElement("form");
        form.setAttribute("method", method);
        form.setAttribute("action", path);
    
        for(var key in params) {
            if(params.hasOwnProperty(key)) {
                 var hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", key);
                hiddenField.setAttribute("id", key);
                hiddenField.setAttribute("value", params[key]);
    
                form.appendChild(hiddenField);
             }
        }
    
        document.body.appendChild(form);
        form.submit();
    }
    
</script>

<div id="header"> 
  <!-- Header. Status part -->
  <div id="header-status">
    <div class="container_12" style="overflow:hidden;">
      <div class="grid_7"><img src="${contextPath}/system-file/images/headerlogo1.png" alt="DCS" /> </div>
      <div class="grid_4"  >
        <div id="header-text" style=" float:right;">
        <div id="top-navigation">
        <spring:message code="label.Welcome"/> 
         <strong><c:out value="${secUserVO.originalLoginName}"/></strong>
         <a href="${contextPath}/doc/access/logout"><spring:message code="link.Logout"/></a>
        </div> 
          
         <%--  <div id="top-navigation">
                <c:if test="${not empty isAuthenticated}">
                    <sec:authorize ifAnyGranted="ROLE_SYSTEM_ADMIN">
                        <spring:message code="label.Welcome"/> 
                        <strong><c:out value="${secUserVO.originalLoginName}"/></strong>
                    </sec:authorize>
                </c:if>
                <c:if test='${!empty menuList["Support"]}'>
                    <span>|</span>
                    <a href="${contextPath}<c:out value='${menuList["Support"]}' />" ><spring:message code="link.Support"/></a>
                </c:if>
                <span>|</span>
                <c:if test="${not empty isAuthenticated}">
                    <a href="${contextPath}/j_spring_security_logout"><spring:message code="link.Logout"/></a>
                </c:if>
            </div> --%>
        </div>
      </div>
    </div>
    <div style="clear:both;"></div>
  </div>
  <div id="header-main">
    <div class="container_12" >
      <div class="grid_12" style="margin-top:18px;padding-top:1px;">
      <ul id="dropmenu">
         <c:if test='${ ! empty menuList["Dashboard"]}'>
                <li class="tabmainlinks"><a href="${contextPath}<c:out value='${menuList["Dashboard"]}' />">
                <spring:message code="menu_link.Home"/>
                </a>
                </li>
            </c:if>
          
          <li class="tabmainlinks" <c:if test='${
                                        empty menuList["Transaction Report"]
                                        && empty menuList["Token Management"]}'>
                                style="display:none;"
                        </c:if>>
                <a href="#" ><spring:message code="menu_link.Transactions"/></a>
                <ul class="navigate first">
                    
                    <c:if test='${ ! empty menuList["Transaction Report"]}'>
                        <li><a href="${contextPath}<c:out value='${menuList["Transaction Report"]}' />">
                            <spring:message code="menu_link.TransactionReport"/></a>
                        </li>
                    </c:if>

                  
                    
                </ul>
            </li>
          <li class="tabmainlinks" <c:if test='${
                                      empty menuList["Manage Users"] 
                                    && empty menuList["Manage Roles"]
                                    && empty menuList["Manage Merchants"]
                                    }'>
                                style="display:none;"
                        </c:if>>
                <a href="#" ><spring:message code="menu_link.Configuration"/></a>
            <ul class="navigate first">
                <li <c:if test='${empty menuList["Manage Users"] 
                                && empty menuList["Manage Roles"]}'>
                                style="display:none;"
                            </c:if>>
                        <a href="#" class="fly">
                            <spring:message code="menu_link.UserConfiguration"/><div class="right-arrow"></div>
                        </a>
                    <ul class="navigate">
                        <c:if test='${ ! empty menuList["Manage Users"]}'>
                            <li><a href="${contextPath}<c:out value='${menuList["Manage Users"]}' />">
                                <spring:message code="menu_link.ManageUsers"/>
                                </a>
                            </li>
                        </c:if>
                        
                        <c:if test='${ ! empty menuList["Manage Roles"]}'>
                            <li><a href="${contextPath}<c:out value='${menuList["Manage Roles"]}' />">
                                <spring:message code="menu_link.ManageRoles"/></a>
                            </li>
                        </c:if>
                    </ul>
                </li>
                <li <c:if test='${empty menuList["Manage Merchants"]}'>
                                style="display:none;"
                            </c:if>>
                            <!--  && empty menuList["Manage Merchants"] :removed for removing manage bank from merchant config -->
                    <a href="#" class="fly">
                        <spring:message code="menu_link.MerchantConfiguration"/><div class="right-arrow"></div>
                    </a>
                    <ul class="navigate">
                             
                         <c:if test='${ ! empty menuList["Manage Merchants"]}'>
                            <li><a href="${contextPath}<c:out value='${menuList["Manage Merchants"]}' />">
                                <spring:message code="menu_link.ManageMerchants"/>
                                </a>
                            </li>
                        </c:if>
                  
                    </ul>
                </li>
               
                
                
            </ul>
        </li>
      </ul>
        <!-- End. #Logo --> 
      </div>
    </div>
    <!-- End. .container_12 --> 
  </div>
  <!-- End #subnav --> 
</div>
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
    
    $(function () {
        //setup ajax error handling
        $.ajaxSetup({
            error: function (x, status, error) {
                if (x.status == 901) {
                    var url123 = "${contextPath}/dcs/auth/sessionTimeOut";
                    window.location.href = url123;
                }
            }
        });
    });
    
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
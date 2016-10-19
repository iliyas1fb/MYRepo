<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<div id="viewRole" class="popup_block2" style="display: none">
	<div class='header'>
		<span><spring:message code="label.ViewRole" /></span>
		<a href="#" id="close_existing3" style="float: right;" class="close"><img src="${contextPath}/system-file/images/cancel.png" /></a>
	</div>
	<div class='message altbox' style="padding:0 10px 5px 20px;">
		<form action="${contextPath}/dcs/user/updateRole" method="post" name="editRoleForm" id="editRoleForm">
			<table width="100%">
				<tr>
					<td width="10%"><spring:message code="label.Hierarchy" />
					<td>
						<input type="text" name="hierarchyListName1" class="txt_width" id="hierarchyListName1" disabled="disabled" />
						<input type="hidden" name="hierarchyListId" id="hierarchyListId" readonly="readonly" />
					</td>
					<td colspan="4"></td>
				</tr>
			</table>
			<table id="editRoleMainHeaderId" width="100%">
				<tr>
					<td><spring:message code="label.RoleName" /></td>
					<td>
						<input type="text" name="roleNameEdit1" id="roleNameEdit1" value="" class="txt_width" disabled="disabled" />
						<input type="hidden" name="roleIdEdit" id="roleIdEdit" readonly="readonly" />
					</td>
					<td><spring:message code="label.Description" /></td>
					<td>
						<input type="text" name="roleDescEdit1" id="roleDescEdit1" value="" class="txt_width" disabled="disabled" />
						<input type="hidden" name="roleDescIdEdit" id="roleDescIdEdit" readonly="readonly" />
					</td>
					<td><spring:message code="label.Status" /></td>
					<td>
						<input type="text" name="statusEdit1" class="date" id="statusEdit1" disabled="disabled" />
						<input type="hidden" name="statusIdEdit" id="statusIdEdit" readonly="readonly" />
					</td>
				</tr>
			</table>
			<div id="editPemissionDisplay1" style="width: 100%; height: 350px; overflow: auto;"></div>
		</form>
	</div>
</div>


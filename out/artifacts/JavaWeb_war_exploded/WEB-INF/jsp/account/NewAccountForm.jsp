<%@ include file="../common/includeTop.jsp"%>


<div id="Catalog">
	<form action="NewAccount" method="post">
		<h3>User Information</h3>

		<table>
			<tr>
				<td>User ID:</td>
				<td><input type="text" name="username" id="username" value="MAX"
						   onblur="usernameIsExist();"/>
					<div id="usernameMsg"></div>
					<script type="text/javascript"
							src="${pageContext.request.contextPath }/js/IsNameExists.js">
					</script>
				</td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><input type="text" name="password" value="MAX"/></td>
			</tr>
			<tr>
				<td>Repeat password:</td>
				<td><input type="text" name="repeatedPassword" value="MAX"/></td>
			</tr>
			<tr>
				<td>VerificationCode:</td>
			</tr>
		</table>

		<%@ include file="IncludeAccountFields.jsp"%>
		<input type="submit" name="newAccount" value="Save Account Information" />
	</form>
</div>

<%@ include file="../common/includeBottom.jsp"%>
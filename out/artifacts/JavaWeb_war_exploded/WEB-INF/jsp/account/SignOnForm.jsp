<%@ include file="../common/includeTop.jsp"%>
<div id="Content">
	<div id="Catalog">
		<form action="SignOn" method="post">
			<p>Please enter your username and password.</p>
			<p>
				Username:<input type="text" name="username" value="MAX" id="username"
				onblur="usernameIsExist()">
			<div id="usernameMsg"></div>
			<script type="text/javascript"
					src="${pageContext.request.contextPath }/js/SignOn.js">
			</script>
				<br />
				Password:<input type="password" name="password" value="MAX"/><br />
			</p>
			<input type="submit" name="signon" value="Login" />
		</form>
		Need a user name and password?
		<!--newAccountForm-->
		<a href="NewAccountForm">Register Now!</a>
	</div>
	<%@ include file="../common/includeBottom.jsp"%>

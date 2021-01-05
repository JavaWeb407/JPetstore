<%@ include file="../common/includeTop.jsp"%>

<div id="Content">
	<ul class="messages">
		<li>${sessionScope.messageSignOn}</li>
	</ul>

	<div id="Catalog">
		<form action="SignOn" method="post">
			<p>Please enter your username and password.</p>
			<p>
				Username:<input type="text" name="username" value="j2ee"/><br />
				Password:<input type="password" name="password" value="j2ee"/><br />
			</p>
			<input type="submit" name="signon" value="Login" />
		</form>
		Need a user name and password?
		<!--newAccountForm-->
		<a href="NewAccountForm">Register Now!</a>
	</div>

	<%@ include file="../common/includeBottom.jsp"%>

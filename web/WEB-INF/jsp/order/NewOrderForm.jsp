<%@ include file="../common/includeTop.jsp"%>

<div id="Catalog">
	<form action="ConfirmOrderForm" method="post">

	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>
				<select>
					<option value="Visa" selected="selected">Visa</option>
					<option value="MasterCard">MasterCard</option>
					<option value="American Express">American Express</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><stripes:text name="order.creditCard" /> * Use a fake
			number!</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><stripes:text name="order.expiryDate" /></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><stripes:text name="${sessionScope.order.billToFirstName}" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><stripes:text name="${sessionScope.order.billToLastName}" /></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><stripes:text size="40" name="${sessionScope.order.billAddress1}" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><stripes:text size="40" name="${sessionScope.order.billAddress2}" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><stripes:text name="${sessionScope.order.billCity}" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><stripes:text size="4" name="${sessionScope.order.billState}" /></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><stripes:text size="10" name="${sessionScope.order.billZip}" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><stripes:text size="15" name="${sessionScope.order.billCountry}" /></td>
		</tr>

		<tr>
			<td colspan=2><stripes:checkbox name="shippingAddressRequired" />
			Ship to different address...</td>
		</tr>

	</table>
		<input type="submit" name="NewOrder" value="Continue">

	</form>
</div>

<%@ include file="../common/includeBottom.jsp"%>
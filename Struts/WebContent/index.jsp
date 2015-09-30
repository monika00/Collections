<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<STYLE type="text/css">
.errorMessage {
	color: red;
}
</STYLE>
</head>
<body>


	<s:actionerror />
	<s:form action="struts.action" method="post">
		<s:textfield name="id" label="Product Id"></s:textfield>
		<s:textfield name="name" label="Product Name"></s:textfield>
		<s:textfield name="price" label="Product Price"></s:textfield>
		<s:submit value="save"></s:submit>
	</s:form>

</body>
</html>
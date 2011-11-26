<html>
<head>
	<title>Employee Controller Demo</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
</head>

<form action="create" method="post">
	<label for="firstName">First Name</label> <input type="text" name="firstName" />
	<label for="lastName">Last Name</label>	<input type="text" name="lastName" />
	<input type="submit" value="Add Employee"/>
</form>

<div id="employees">
</div>

<script>
$(document).ready(function(){
	$.getJSON("list", function(data) {
		var items = [];

		$.each(data, function(index, value) {
			items.push('<li>' + value.firstName + ' ' + value.lastName + '</li>');
		});
		
		$('<ul/>', {
			'class' : 'employee-list',
			html : items.join('')
		}).appendTo('body');
	});
});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>percentage page</title>
<style type="text/css">
html, body, #container {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

#piechart {
	width: 100%;
	height: 100%;
	margin-top: 100px;
	padding-left: 500px;
	border-radius: 50px;
}
</style>
</head>
<body style="background-color: grey;">
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	<div id="piechart"></div>

	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>

	<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'complated task'],
  ['complate', ${persentage}],
  ['pending', ${(100-persentage)}]
 
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'My task', 'width':600, 'height':500};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}
</script>
</body>
</html>
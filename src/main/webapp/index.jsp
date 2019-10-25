<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0;url=tables.html">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script>
			$(document).ready(function() {
				$("#test").click(function() {
					getAllEmp()
					getAgeAndSal()
					getSexNum()
					getSalSumByDept()
					getNumByDept()
					getIdAndYear()
				})
			})

			function getAllEmp() {
				$.ajax({
					type: "post",
					url: "getAllEmp.do",
					success: function(data) {

						console.log(data)
					},
					error: function(e) {
						alert("联网失败");
						console.log(e);
					}
				})
			}

			function getAgeAndSal() {
				$.ajax({
					type: "post",
					url: "getAgeAndSal.do",
					success: function(data) {

						console.log(data)
					},
					error: function(e) {
						alert("联网失败");
						console.log(e);
					}
				})
			}

			function getSexNum() {
				$.ajax({
					type: "post",
					url: "getSexNum.do",
					success: function(data) {

						console.log(data)
					},
					error: function(e) {
						alert("联网失败");
						console.log(e);
					}
				})
			}

			function getSalSumByDept() {
				$.ajax({
					type: "post",
					url: "getSalSumByDept.do",
					success: function(data) {

						console.log(data)
					},
					error: function(e) {
						alert("联网失败");
						console.log(e);
					}
				})
			}

			function getNumByDept() {
				$.ajax({
					type: "post",
					url: "getNumByDept.do",
					success: function(data) {

						console.log(data)
					},
					error: function(e) {
						alert("联网失败");
						console.log(e);
					}
				})
			}

			function getIdAndYear() {
				$.ajax({
					type: "post",
					url: "getIdAndYear.do",
					success: function(data) {

						console.log(data)
					},
					error: function(e) {
						alert("联网失败");
						console.log(e);
					}
				})
			}
		</script>
	</head>

	<body>
		<input type="button" id="test" value="获取数据" />
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<script>
	function callUserList() {

		var url = "/selectUserList.do";
		var type = "POST";
		var data = "a";

		cfnCallAjax(url, type, true, data, function(jsonData) {
			var list = jsonData.list;
			var html = "";

			$.each(list, function(index, item) {

				html += "ID : " + item.userId;

			});

			$("#testTbl tbody").append(html);

		});

	}
</script>




<h1>HELLO! SEN!</h1>
<a href="javascript:callUserList()">aa</a>
<div>
	<table id="testTbl">
		<tbody>
		</tbody>
	</table>
</div>


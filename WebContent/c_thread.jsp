<%@ page pageEncoding="utf-8"
		 contentType="text/html;charset=utf-8"
		 errorPage="/NoConnection.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
		<link href="c_thread.css" rel="stylesheet" >
    <title></title>
  </head>
  <body>
 <%-- <img src="img/ryu.jpg" width="94px" height="高さ" alt="" /> --%>
		<div id="all">
			<header>
			<img src="img/S__41574403.jpg" width="898px"  />
			</header>

			<div id="sakusei">
    <button onclick="location.href='c_createthread.html'">スレッド作成</button><br><br>
	</div>
	<div id="itiranbutton">
		<button onclick="location.href='Thread_Servlet'">スレッド一覧</button>
	</div>
	<div class="kennsaku">
		<form name="titlesearch" method='post' action='SearchThreadServlet' onSubmit="return check()">
  	 	<p>絞り込みタイトルを入力</p>
    	<input type='text' name='title'>
    	<input type='submit' value='検索！'>
  	</form>
	</div>

	<script language="JavaScript">
		function check(){
			if(document.titlesearch.title.value == ""){
				alert("検索したいタイトルを入力してください");
				return false;
			}
		}
	</script>


    <%-- <from method='post' action='SearchThread_Servlet'>
      <p>絞り込みタイトルを入力</p>
      <input type='text' name='title'>
      <input type='submit' value='検索！'>
      </from> --%>
		<table border="1">
        <tr><th>TITLE</th><th>NAME</th><th>COMMENT</th><th>IMAGE</th><th>TIME</th></tr>
        <c:forEach var="tl" items="${threadList}">
  			<tr><td><a href="Res_Servlet?thread_id=${tl.thread_id}">${tl.title}</td>
				<td>${tl.t_name}</td>
				<td>${tl.t_contents}</td>
				<c:if test="${tl.name != null}" var="flg">
					<td><a href="../Cteam/img/${tl.name}" target="_blank"><img src="../Cteam/img/${tl.name}"width="300" ></a></td>
				</c:if>
				<c:if test="${tl.name == null}" var="flg">
					<td>${tl.name}</td>
				</c:if>
					<td>${tl.thread_time}</td></tr>
  		</c:forEach>
      </table>
		</div>
  </body>
</html>

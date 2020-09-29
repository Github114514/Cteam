<%@ page pageEncoding="utf-8"
  contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="c_res.css">
    <title></title>
  </head>
  <body>
    <div id="all">
      <header>
    <img src="img/S__41574403.jpg" width="898px" />
    </header>
    <div class="scroll_res">
    <button onclick="location.href='#bottom'">レスへ移動</button>
    </div>


    <table border="1" class="threadtable">
      <tr><th>TITLE</th><th>NAME</th><th>COMMENT</th><th>IMAGE</th></tr>
      <c:forEach var="tl" items="${threadList}">
        <tr><td>${tl.title}</td>
        <td>${tl.t_name}</td>
        <td>${tl.t_contents}</td>
        <c:if test="${tl.name != null}" var="flg">
					<td><a href="../Cteam/img/${tl.name}" target="_blank"><img src="../Cteam/img/${tl.name}"width="300" ></a></td>
				</c:if>
      </c:forEach>
    </table>

    <br>


    <table class="res" frame="void">
      <tbody>
        <c:forEach var="rl" items="${resList}" varStatus="rli">

        <tr><th>No.</th><td>${rli.index+1}</td></tr>
         <tr><th>NAME</th><td>${rl.res_name}</td></tr>
         <tr><th>COMMENT</th><td>${rl.res_contents}</td></tr>
         <tr><th>TIME</th><td>${rl.res_time}</td></tr>

        </c:forEach>
      </tbody>
    </table>


    <script language="JavaScript">
      function check(){
        if(document.formR.name.value == ""){
          alert("名前を入力してください");
          return false;
        }
        if(document.formR.contents.value == ""){
          alert("コメントを入力してください");
          return false;
        }
      }
    </script>
  <div id="itiranbutton">
    <button onclick="location.href='Thread_Servlet'">スレッド一覧</button>
  </div>
  <div id="sakuseibutton">
    <button onclick="location.href='c_createthread.html'">スレッド作成</button><br><br>
  </div>
    <div id="bottom"></div>
    <div id="nameform">
    <form name="formR" action ="CreateRes_Servlet" method= "post" onSubmit="return check()">
		  名前<br><input type="text" name="name"><br>
		  <br>内容<br><textarea id="contents" name="contents" cols="80" rows="20" maxlength="500"></textarea><br><br>
      <input type="hidden"name="st_thread_id" value="${thread_id}">
      <input type="submit" value="投稿"id="toukou">
    </form>
    <br>
  </div>
  </div>

  </body>
</html>

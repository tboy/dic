<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="http://localhost/mall/favicon.ico">
<link type="text/css" rel="stylesheet" href="/resources/third/jquery-ui.min.css">
<link type="text/css" rel="stylesheet" href="/resources/third/jquery-ui.theme.min.css">

<title>列表</title>
</head>
<body>
  <form action="${webPath}/stock/stock_list.htm" method="post" id="listForm">
      
      <div id="params">
       <input type="text" name="currentPage" id="currentPage" value="${page.page}" style="display:none;">
       <table>
          <tr>
              <td>规格</td><td><input type="text" name="name" value="${name}"/></td>
              <td>材质:</td><td><input type="text" name="code" value="${code}"/></td>
              <td><input type="submit" value="搜索"/></td>
          </tr>
       </table>
      </div>
      
	  <table style="width:100%;background-color:#ccc;" cellpadding="1" cellspacing="1">
	     <tr style="background-color:#eee;height:38px;text-align:center;">
	           <td style="width:40%;">规格</td>
	           <td style="width:40%;">材质</td>
	           <td style="width:20%;">操作</td>
	     <tr>
	     <c:forEach items="${page.result}" var="item">
	       <tr style="background-color:#fff;">
	           <td>${item.code}</td>
	           <td>${item.name}</td>
	           <td><button id="b">刷新</button>|<button id="v">查看</button></td>
	       </tr>
	     </c:forEach>
	  </table>
	  
	  <div id="fenye">
	   
	  </div>
	  
  </form>
</body>
</html>
<script type="text/javascript" src="/resources/third/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/resources/third/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resources/commUtil/pageUtil.js?1"></script>
<script type="text/javascript">
 $(function(){
	 $( "input[type=submit],#b,#v" ).button();
	 htmlPage($("#fenye"),"${page.pages}","${page.page}");
 });
</script>
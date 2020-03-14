<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/commons/script.jsp"></jsp:include>
</head>
<body>

<div id="menuiconsShow" class="layui-container">
			
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/icon/icons.js"></script>
<script type="text/javascript">


$(function(){
	var pagesie=4;
	var pagenum=(icons.length)%pagesie==0?(icons.length)/pagesie:Math.round((icons.length)/pagesie);
	var nowpage=1;
	var iconhtml="";
	for(var i=0;i<pagenum;i++){
				var start=(nowpage-1)*pagesie;
				var end=0;
				if(nowpage==pagenum){
					end=icons.length;
					}else{
						end=nowpage*pagesie;
						}
				
				var iconrow="";
				iconhtml+="<div class='layui-row'>";
			 	for(var j=start;j<end;j++){
					iconrow+= "<div class='layui-col-md3'><li onclick='setIcon(\""+icons[j].value+"\")'><i class='iconfont'>"+icons[j].code+"</i>"
    	 			+'<div class="name">'+icons[j].name+'</div>'
    	 			+'<div class="code">'+icons[j].value+'</div></li></div>'
				} 
				iconhtml+=(iconrow+"</div>");
				nowpage++;
		}
	$("#menuiconsShow").html(iconhtml);
})
		function setIcon(icon){
			$("#menuEditForm input[name='cIcon']").val(icon);
			parent.layer.close(index);
		}
		
		
</script>
</body>
</html>
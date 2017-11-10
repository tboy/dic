/**
 * 
 * 分页接口
 * 依赖jq
 */
/**
 * @param container 容器
 * @param pages 页数
 * @param page 当前页
 */
function htmlPage(container,pages,page){
	var htmls = [];
	htmls.push("<ul class='pages'>");
	for(var i=0;i<pages;i++) {
		var p = (i+1);
		if(p==page){
			htmls.push("<li class='current' onClick='gotoPage("+p+")'>"+p+"</li>");	
		}else{
			htmls.push("<li onClick='gotoPage("+p+")'>"+p+"</li>");
		}
		
	}
	htmls.push("</ul>");
	$(container).html(htmls.join(""));
}
/**
 * 跳转页面
 * @param val
 */
function gotoPage(val){
	$("#currentPage").val(val);
	$("#listForm").submit();
}
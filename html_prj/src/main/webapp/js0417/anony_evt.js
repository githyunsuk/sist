/**
 * 익명함수로 이벤트를 처리합니다.
 */

window.onload=function(){
	var btnNode = document.getElementById("btn");
	
	//익명함수로 이벤트 처리
	btnNode.onclick=function(){
		var obj = document.frm;
		
		obj.gender[0].checked = true;
		obj.selGender[1].selected = true;
	}
	
	document.getElementById("btn2").onclick=function(){
		var obj = document.frm;
		
		obj.gender[1].checked=true;
		obj.selGender[2].selected=true;
	}
}
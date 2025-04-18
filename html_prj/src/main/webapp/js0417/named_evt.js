/**
 * 기명함수로 이벤트에 등록하여 처리하기
 */
window.onload = function(){
	
	//이벤트를 등록할 태그를 찾아서, 이벤트에 등록
	document.getElementById("subject")
	.addEventListener("change",setInfo)
	//addEventListener함수에서 setInfo 함수를 호출하면서
	//매개변수가 있다면 event 객체를 arguments로 입력해준다.
}

var subjectInfo=["객체지향 언어의 특징 및 코딩법 학습",
				 "SQL문을 사용하여 CRUD 데이터 관리기법 학습",
				 "Java와 DBMS를 연동하는 Application 작성하는 방법 학습",
				 "Front-end언어로 웹페이지의 구조를 만드는 방법 학습",
				 "Front-end언어로 웹페이지의 통일성 있는 디자인을 만드는 방법 학습",
				 "Front-end언어로 웹페이지의 유효성 검증과 화면일부분을 변경하는 방법 학습"];
function setInfo(evt){
	var obj = document.frm;	
	if(obj.subject.selectedIndex != 0){
		obj.info.value = subjectInfo[obj.subject.value];
	}
}
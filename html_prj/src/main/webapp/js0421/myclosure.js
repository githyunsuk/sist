/**
 * 
 */
var clo = function(){
	var name = "이장훈";
	
	function printMsg( msg ){

		alert( name + "의 메시지: " + msg);
	}
	
	//closure를 사용하면 함수 내부의 변수와 함수를 외부에서 사용할 수 있다.
	return { na : name, alertMsg : printMsg };

}();//anonymous function ()때문에 함수도 바로 호출되어 변수에 closure가 할당
function fn_submit_res (){
	var fn = document.frm;
	
	if(fn.resvno.value ==""){
		alert("접종예약번호가 입력되지 않았습니다.");
		fn.resvno.focus();
		return false;
	}
	if(fn.jumin.value ==""){
		alert("주민번호가 입력되지 않았습니다.");
		fn.jumin.focus();
		return false;
	}
	if(fn.vcode.value ==""){
		alert("백신코드가 입력되지 않았습니다.");
		fn.vcode.focus();
		return false;
	}
	if(fn.hospcode.value ==""){
		alert("병원코드가 입력되지 않았습니다.");
		fn.hospcode.focus();
		return false;
	}
	if(fn.resvdate.value ==""){
		alert("예약 일자가 입력되지 않았습니다.");
		fn.resvdate.focus();
		return false;
	}
	if(fn.resvtime.value ==""){
		alert("예약시간이 입력되지 않았습니다.");
		fn.resvtime.focus();
		return false;
	}
	fn.submit();
}

function fn_reset(){
		alert("정보를 지우고 처음부터 다시 입력합니다!");
	}
	
function fn_submit_inq(){
	var fn = document.frm;
	
	if(fn.resvno.value =="" || fn.resvno.value ==null){
		alert("예약번호가 입력되지 않았습니다.");
		fn.resvno.focus();
		return false;
	}
	fn.submit();
}
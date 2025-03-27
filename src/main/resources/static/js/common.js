/**
 * 공통 함수
 */

// ajax callback
function ajaxCallback(url, formData, callback) {
	$.ajax({
		url : url
		,type : 'POST'
		,data : formData
		,cache : false
		,contentType : 'application/x-www-form-urlencoded'
		,success : function( data, textStatus, jqXHR ) {
			return callback(data);
		}
		,error : function(data, jqXHR, textStatus) {
			return callback(data);
		}
	});
}

// FormData -> JSON 변경
function formToJson(formElement) {
    const formData = new FormData(formElement);
    const jsonObject = {};

    formData.forEach((value, key) => {
        jsonObject[key] = value;
    });

    return jsonObject;
}
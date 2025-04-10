/**
 * 공통 함수
 */

// FormData -> JSON 변경
function formToJson(formElement) {
    const formData = new FormData(formElement);
    const jsonObject = {};

    formData.forEach((value, key) => {
        jsonObject[key] = value;
    });

    return jsonObject;
}

// Formdata -> Object 변경
function formToObject(form) {
    const formData = new FormData(form);
    const obj = {};
    for (const [key, value] of formData.entries()) {
        obj[key] = value;
    }
    return obj;
}

// Toast UI grid 라디오버튼 커스텀 렌더러
function customRadioRenderer(radioName) {
    return class {
        constructor(props) {
            const radio = document.createElement('input');
            radio.type = 'radio';
            radio.name = radioName;  // ← name 적용됨
            radio.dataset.rowKey = props.rowKey;
            radio.className = 'form-check-input';

            this.el = radio;
        }

        getElement() {
            return this.el;
        }

        render(props) {
            const selected = document.querySelector(`input[name="${radioName}"]:checked`);
            this.el.checked = selected?.dataset.rowKey == props.rowKey;
        }
    }
}

// Toast UI grid rowData form안에 등록
function setFields(rowData, form, fieldMap) {
    for (const [key, inputName] of Object.entries(fieldMap)) {
        const input = form.querySelector(`[name="${inputName}"]`);
        if (input) {
            input.value = rowData[key] ?? '';
        }
    }
}

// fetch Json 콜백 함수
function apiJsonRequest({ url, method = "GET", body = null }, onSuccess, onFail) {
    const options = {
        method,
        headers: {
            "Content-Type": "application/json"
        }
    };

    if (body) {
        options.body = JSON.stringify(body);
    }

    fetch(url, options)
        .then(res => res.json())
        .then(data => {
            if (data.code === "00") {
                if (onSuccess) onSuccess(data);
            } else {
                if(data.exceptionMessage) {
                    console.error("API 실패:", data.exceptionMessage);
                }
                if (onFail) {
                    onFail(data);
                } else {
                    alert(data.exceptionMessage || '[[#{common.error.request}]]');
                }
            }
        })
        .catch(err => {
            console.error("API 요청 오류:", err);
            alert('[[#{common.error.request}]]');
        });
}

// fetch download 콜백 함수
function apiDownloadRequest({ url, method = "POST", body = null, filename = "download.xlsx" }) {
    fetch(url, {
        method,
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/octet-stream"
        },
        body: body ? JSON.stringify(body) : null
    })
    .then(response => response.blob())
    .then(blob => {
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = filename;
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
    })
    .catch(err => {
        console.error("파일 다운로드 실패:", err);
        alert('[[#{common.error.request}]]');
    });
}
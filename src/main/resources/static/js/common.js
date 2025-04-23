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

function downloadButtonRenderer(downloadHandler) {
    return class {
        constructor(props) {
            const el = document.createElement('button');
            el.type = 'button';
            el.className = 'btn btn-sm btn-primary';
            el.textContent = '다운로드';

            el.addEventListener('click', () => downloadHandler(props.rowKey));
            this.el = el;
        }

        getElement() {
            return this.el;
        }

        render() {}
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
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    };

    if (body) {
        options.body = JSON.stringify(body);
    }

    fetch(url, options)
        .then(async res => {
            const contentType = res.headers.get("Content-Type") || "";
            const isJson = contentType.includes("application/json");
            const data = isJson ? await res.json() : { message: "알 수 없는 오류", result: false };

            if (res.ok) {
                // 200 OK
                if (typeof onSuccess === "function") {
                    onSuccess(data);
                }
            } else if (res.status === 400) {
                // 유효성 검사 오류
                if (typeof onSuccess === "function") {
                    onFail(data);
                }
            } else {
                // 서버 에러
                const code = data.errorCode || "SERVER_ERROR";
                const message = data.errorMessage || "시스템 오류가 발생했습니다.";
                alert(`[${code}] ${message}`);
            }
        })
        .catch(err => {
            console.error("요청 실패:", err);
            alert('[[#{common.error.request}]]');
        });
}

// fetch download 콜백 함수
function apiDownloadRequest({ url, method = "POST", body = null, filename = "download.xlsx" }) {
    fetch(url, {
        method,
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json, application/octet-stream"
        },
        body: body ? JSON.stringify(body) : null
    })
     .then(async (response) => {
          if (!response.ok) {
              const data = await response.json();
              const code = data.errorCode || "SERVER_ERROR";
              const message = data.errorMessage || "시스템 오류가 발생했습니다.";
              throw new Error(`[${code}] ${message}`);
          }
          return response.blob();
     })
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
        console.error(err.message);
        alert(err.message || '[[#{common.error.request}]]');
    });
}
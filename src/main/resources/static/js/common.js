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

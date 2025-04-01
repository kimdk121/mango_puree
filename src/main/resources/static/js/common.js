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

// Toast UI grid 라디오버튼 커스텀 렌더러
class customRadioRenderer {
    constructor(props) {
        const radio = document.createElement('input');
        radio.type = 'radio';
        radio.name = 'rowRadio';
        radio.dataset.rowKey = props.rowKey;
        radio.className = 'form-check-input';

    this.el = radio;
    }

    getElement() {
        return this.el;
    }

    render(props) {
        const selected = document.querySelector('input[name="rowRadio"]:checked');
        this.el.checked = selected?.dataset.rowKey == props.rowKey;
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

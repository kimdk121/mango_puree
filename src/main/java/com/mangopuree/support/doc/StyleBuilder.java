package com.mangopuree.support.doc;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StyleBuilder {
    private final XSSFWorkbook workbook;
    private final XSSFCellStyle style;
    private final XSSFFont font;

    public StyleBuilder(XSSFWorkbook workbook) {
        this.workbook = workbook;
        this.style = workbook.createCellStyle();
        this.font = workbook.createFont();
    }

    // 상단 테두리 설정
    public StyleBuilder borderTop(BorderStyle border) {
        style.setBorderTop(border);
        return this;
    }

    // 하단 테두리 설정
    public StyleBuilder borderBottom(BorderStyle border) {
        style.setBorderBottom(border);
        return this;
    }

    // 왼쪽 테두리 설정
    public StyleBuilder borderLeft(BorderStyle border) {
        style.setBorderLeft(border);
        return this;
    }

    // 오른쪽 테두리 설정
    public StyleBuilder borderRight(BorderStyle border) {
        style.setBorderRight(border);
        return this;
    }

    // 텍스트 줄바꿈 여부 설정
    public StyleBuilder wrapText(boolean wrap) {
        style.setWrapText(wrap);
        return this;
    }

    // 수평/수직 정렬 설정
    public StyleBuilder alignment(HorizontalAlignment hAlign, VerticalAlignment vAlign) {
        style.setAlignment(hAlign);
        style.setVerticalAlignment(vAlign);
        return this;
    }

    // 셀 배경색 설정
    public StyleBuilder fillColor(HSSFColor.HSSFColorPredefined color) {
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return this;
    }

    // 폰트 볼드 설정
    public StyleBuilder fontBold(boolean bold) {
        font.setBold(bold);
        return this;
    }

    // 폰트 크기 설정
    public StyleBuilder fontHeight(int height) {
        font.setFontHeight(height);
        return this;
    }

    // 숫자 콤마(,) 포맷 적용 (#,##0)
    public StyleBuilder commaFormat() {
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
        return this;
    }

    // 최종적으로 스타일 완성 후 반환
    public CellStyle build() {
        style.setFont(font);
        return style;
    }
}
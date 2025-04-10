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

    public StyleBuilder borderTop(BorderStyle border) {
        style.setBorderTop(border);
        return this;
    }

    public StyleBuilder borderBottom(BorderStyle border) {
        style.setBorderBottom(border);
        return this;
    }

    public StyleBuilder borderLeft(BorderStyle border) {
        style.setBorderLeft(border);
        return this;
    }

    public StyleBuilder borderRight(BorderStyle border) {
        style.setBorderRight(border);
        return this;
    }

    public StyleBuilder wrapText(boolean wrap) {
        style.setWrapText(wrap);
        return this;
    }

    public StyleBuilder alignment(HorizontalAlignment hAlign, VerticalAlignment vAlign) {
        style.setAlignment(hAlign);
        style.setVerticalAlignment(vAlign);
        return this;
    }

    public StyleBuilder fillColor(HSSFColor.HSSFColorPredefined color) {
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return this;
    }

    public StyleBuilder fontBold(boolean bold) {
        font.setBold(bold);
        return this;
    }

    public StyleBuilder fontHeight(int height) {
        font.setFontHeight(height);
        return this;
    }

    public StyleBuilder commaFormat() {
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
        return this;
    }

    public CellStyle build() {
        style.setFont(font);
        return style;
    }
}
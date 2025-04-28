package com.mangopuree.support.doc;

import com.mangopuree.estimate.dto.EstimateDto;
import com.mangopuree.estimateitem.dto.EstimateItemDto;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class EstimateExcelBuilder {

    /**
     * 엑셀 다운로드 설정, byte로 생성
     * @param estimateDto
     * @return byte[]
     * @throws IOException
     */
    public byte[] build(EstimateDto estimateDto) throws IOException {

        try (XSSFWorkbook workBook = new XSSFWorkbook();
             ByteArrayOutputStream bos = new ByteArrayOutputStream();) {

            // 시트 생성
            XSSFSheet sheet = workBook.createSheet();

            // 셀 스타일 생성
            Map<String, CellStyle> cellStyles = createCellStyles(workBook);

            configureSheet(workBook, sheet);
            createContent(workBook, sheet, cellStyles, estimateDto);
            workBook.write(bos);

            return bos.toByteArray();
        }
    }

    /**
     * Row 생성
     * @param sheet
     * @param rowNumber
     * @param defaultStyle
     * @param heightInPoints
     * @param cellCount
     * @return XSSFRow
     */
    private XSSFRow createRow(XSSFSheet sheet, int rowNumber, CellStyle defaultStyle, int heightInPoints, int cellCount) {

        XSSFRow row = sheet.createRow(rowNumber);
        row.setHeightInPoints(heightInPoints);
        for (int i = 0; i < cellCount; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(defaultStyle);
            defaultStyle.setWrapText(true);
            cell.setCellStyle(defaultStyle);
        }
        return row;
    }

    /**
     * 견적서에 필요한 셀 스타일 생성
     * @param workBook
     * @return Map<String, CellStyle>
     */
    private Map<String, CellStyle> createCellStyles(XSSFWorkbook workBook) {
        Map<String, CellStyle> styleMap = new HashMap<>();

        styleMap.put("default", new StyleBuilder(workBook)
                .wrapText(true)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .build());

        styleMap.put("title", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(false)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .fillColor(HSSFColorPredefined.GREY_25_PERCENT)
                .fontBold(true)
                .fontHeight(18)
                .build());

        styleMap.put("blank", new StyleBuilder(workBook)
                .wrapText(false)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .build());

        styleMap.put("header", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .fontBold(true).fontHeight(9)
                .fillColor(HSSFColorPredefined.GREY_25_PERCENT)
                .build());

        styleMap.put("leftBorderText", new StyleBuilder(workBook)
                .borderLeft(BorderStyle.THIN)
                .alignment(HorizontalAlignment.LEFT, VerticalAlignment.CENTER)
                .fontHeight(9)
                .build());

        styleMap.put("rightText", new StyleBuilder(workBook)
                .alignment(HorizontalAlignment.LEFT, VerticalAlignment.CENTER)
                .fontHeight(9)
                .build());

        styleMap.put("rightBorder",new StyleBuilder(workBook)
                .borderRight(BorderStyle.THIN)
                .alignment(HorizontalAlignment.LEFT, VerticalAlignment.CENTER)
                .fontHeight(9)
                .build());

        styleMap.put("centerText", new StyleBuilder(workBook)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .fontBold(true).fontHeight(9)
                .build());

        styleMap.put("itemText", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .fontHeight(9)
                .build());

        styleMap.put("itemPrice", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.RIGHT, VerticalAlignment.CENTER)
                .commaFormat()
                .fontHeight(9)
                .build());

        styleMap.put("subTotalText", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .fillColor(HSSFColorPredefined.GREY_25_PERCENT)
                .fontHeight(9)
                .build());

        styleMap.put("totalText", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .fillColor(HSSFColorPredefined.GREY_40_PERCENT)
                .fontBold(true)
                .fontHeight(9)
                .build());

        styleMap.put("subTotalPrice", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.RIGHT, VerticalAlignment.CENTER)
                .fillColor(HSSFColorPredefined.GREY_25_PERCENT)
                .commaFormat()
                .fontHeight(9)
                .build());

        styleMap.put("totalPrice", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.RIGHT, VerticalAlignment.CENTER)
                .fillColor(HSSFColorPredefined.GREY_40_PERCENT)
                .commaFormat()
                .fontBold(true)
                .fontHeight(9)
                .build());

        styleMap.put("rmrk", new StyleBuilder(workBook)
                .borderTop(BorderStyle.THIN)
                .borderBottom(BorderStyle.THIN)
                .borderLeft(BorderStyle.THIN)
                .borderRight(BorderStyle.THIN)
                .wrapText(true)
                .alignment(HorizontalAlignment.LEFT, VerticalAlignment.TOP)
                .fontHeight(10)
                .build());

        return styleMap;
    }

    /**
     * 시트 설정
     * @param workbook
     * @param sheet
     */
    private void configureSheet(XSSFWorkbook workbook, XSSFSheet sheet) {

        // 셀 높이 설정
        sheet.setDefaultRowHeightInPoints(35);
        sheet.setColumnWidth(0, 255 * 1);
        sheet.setColumnWidth(1, 255 * 7);
        sheet.setColumnWidth(2, 255 * 18);
        sheet.setColumnWidth(3, 255 * 8);
        sheet.setColumnWidth(4, 255 * 11);
        sheet.setColumnWidth(5, 255 * 8);
        sheet.setColumnWidth(6, 255 * 8);
        sheet.setColumnWidth(7, 255 * 10);
        sheet.setColumnWidth(8, 255 * 10);
        sheet.setColumnWidth(9, 255 * 10);

        // 인쇄 용지를 A4로 설정
        XSSFPrintSetup print = sheet.getPrintSetup();
        print.setPaperSize(PaperSize.A4_PAPER);

        // 페이지 나누기 미리보기 설정
        //sheet.setDisplayGridlines(false); // 그리드라인 비활성화
        sheet.setFitToPage(true); // 페이지에 맞춤 설정
        sheet.setHorizontallyCenter(true); // 수평 가운데 정렬
    }

    /**
     * 내용 제작
     * @param workBook
     * @param sheet
     * @param cellStyles
     * @param estimateDto
     */
    private void createContent(XSSFWorkbook workBook, XSSFSheet sheet, Map<String, CellStyle> cellStyles, EstimateDto estimateDto) {

        int rownum = 0;

        XSSFRow row = createRow(sheet,rownum, cellStyles.get("blank"), 10, 10); // 상단 공백
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 1, 9));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 40, 10);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 1, 9));
        row.getCell(1).setCellValue("견적서");
        row.forEach(t -> {if(t.getColumnIndex() != 0) t.setCellStyle(cellStyles.get("title"));});

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellValue("견적일자  : " + estimateDto.getEstimateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        row.getCell(6).setCellValue("상        호 : " + estimateDto.getBusinessName());
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(6).setCellStyle(cellStyles.get("rightText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellValue("수        신 : " + estimateDto.getVendorName());
        row.getCell(6).setCellValue("대표이사  : " + estimateDto.getRepresentativeName());
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(6).setCellStyle(cellStyles.get("rightText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellValue("전        화 : " + estimateDto.getVendorTelNo());
        row.getCell(6).setCellValue("주        소 : " + estimateDto.getBusinessAddress());
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(6).setCellStyle(cellStyles.get("rightText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellValue("F    A    X  : " + estimateDto.getVendorFaxNo());
        row.getCell(6).setCellValue("사업자등록번호 : " + estimateDto.getRegistrationNumber());
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(6).setCellStyle(cellStyles.get("rightText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellValue("1. 귀사의 일익번창을 기원합니다.");
        row.getCell(6).setCellValue("전        화 : " + estimateDto.getBusinessTelNo());
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(6).setCellStyle(cellStyles.get("rightText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellValue("2. 상기건 관련 당사에서 아래와 같이 견적하오니 검토바랍니다.");
        row.getCell(6).setCellValue("F    A    X  : " + estimateDto.getBusinessFaxNo());
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(6).setCellStyle(cellStyles.get("rightText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 1, 9));
        row.getCell(1).setCellValue("<< 아     래 >>");
        row.forEach(t -> {if(t.getColumnIndex() != 0) t.setCellStyle(cellStyles.get("centerText"));});

        row = createRow(sheet,++rownum, cellStyles.get("default"), 15, 10);
        row.getCell(1).setCellStyle(cellStyles.get("leftBorderText"));
        row.getCell(9).setCellStyle(cellStyles.get("rightBorder"));

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        row.getCell(1).setCellValue("순번");
        row.getCell(2).setCellValue("품목명");
        row.getCell(3).setCellValue("단위");
        row.getCell(4).setCellValue("납기일");
        row.getCell(5).setCellValue("단가");
        row.getCell(6).setCellValue("수량");
        row.getCell(7).setCellValue("공급가");
        row.getCell(8).setCellValue("부가세");
        row.getCell(9).setCellValue("합계");
        row.forEach(t -> {if(t.getColumnIndex() != 0) t.setCellStyle(cellStyles.get("header"));});

        // ITEM 포문
        for (EstimateItemDto estimateItemDto : estimateDto.getItemList()) {
            row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
            row.getCell(1).setCellValue(rownum);
            row.getCell(2).setCellValue(estimateItemDto.getItemName());
            row.getCell(3).setCellValue(estimateItemDto.getUnitCdName());
            row.getCell(4).setCellValue(estimateItemDto.getDueDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            row.getCell(5).setCellValue(estimateItemDto.getPrice());
            row.getCell(6).setCellValue(estimateItemDto.getQuantity());
            row.getCell(7).setCellValue(estimateItemDto.getSupplyAmount());
            row.getCell(8).setCellValue(estimateItemDto.getVatAmount());
            row.getCell(9).setCellValue(estimateItemDto.getTotalAmount());
            row.forEach(t -> {if(t.getColumnIndex() != 0 && t.getColumnIndex() < 5) t.setCellStyle(cellStyles.get("itemText"));});
            row.forEach(t -> {if(t.getColumnIndex() != 0 && t.getColumnIndex() >= 5) t.setCellStyle(cellStyles.get("itemPrice"));});
        }

        if(estimateDto.getItemList() != null && estimateDto.getItemList().size() < 6) {
            int blankCount = 6- estimateDto.getItemList().size();
            for(int i=0; i<blankCount; i++) {
                row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
                row.forEach(t -> {if(t.getColumnIndex() != 0) t.setCellStyle(cellStyles.get("itemText"));});
            }
        }

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 1, 5));
        row.getCell(1).setCellValue("소계");
        row.getCell(6).setCellValue(estimateDto.getItemList().stream().mapToInt(value -> value.getQuantity()).sum());
        row.getCell(7).setCellValue(estimateDto.getItemList().stream().mapToInt(value -> value.getSupplyAmount()).sum());
        row.getCell(8).setCellValue(estimateDto.getItemList().stream().mapToInt(value -> value.getVatAmount()).sum());
        row.getCell(9).setCellValue(estimateDto.getItemList().stream().mapToInt(value -> value.getTotalAmount()).sum());
        row.forEach(t -> {if(t.getColumnIndex() != 0 && t.getColumnIndex() < 6) t.setCellStyle(cellStyles.get("subTotalText"));});
        row.forEach(t -> {if(t.getColumnIndex() != 0 && t.getColumnIndex() >= 6) t.setCellStyle(cellStyles.get("subTotalPrice"));});

        row = createRow(sheet,++rownum, cellStyles.get("default"), 25, 10);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 1, 7));
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 8, 9));
        row.getCell(1).setCellValue("제안 금액(VAT 포함)");
        row.getCell(8).setCellValue(estimateDto.getItemList().stream().mapToInt(value -> value.getTotalAmount()).sum());
        row.forEach(t -> {if(t.getColumnIndex() != 0 && t.getColumnIndex() < 8) t.setCellStyle(cellStyles.get("totalText"));});
        row.forEach(t -> {if(t.getColumnIndex() != 0 && t.getColumnIndex() >= 8) t.setCellStyle(cellStyles.get("totalPrice"));});

        row = createRow(sheet,++rownum, cellStyles.get("default"), 120, 10);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 1, 9));
        row.getCell(1).setCellValue("[비고] " + estimateDto.getRemark());
        row.forEach(t -> {if(t.getColumnIndex() != 0) t.setCellStyle(cellStyles.get("rmrk"));});

        // 인쇄범위 지정
        workBook.setPrintArea(0, 1, 9, 1, rownum);

    }
}

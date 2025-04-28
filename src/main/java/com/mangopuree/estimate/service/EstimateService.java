package com.mangopuree.estimate.service;

import com.mangopuree.estimate.dto.EstimateDto;
import com.mangopuree.estimate.dto.EstimateGridDto;
import com.mangopuree.estimate.dto.EstimateInsertDto;
import com.mangopuree.estimate.dto.EstimateSearchDto;
import com.mangopuree.estimateitem.service.EstimateItemMapper;
import com.mangopuree.support.converter.ConverterUtil;
import com.mangopuree.support.doc.EstimateExcelBuilder;
import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import com.mangopuree.support.security.LoginUserHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EstimateService {

    private final EstimateMapper estimateMapper;
    private final EstimateItemMapper estimateItemMapper;
    private final EstimateExcelBuilder estimateExcelBuilder;

    /**
     * 견적서와 견적서 품목 등록
     * @param estimateInsertDto
     * @return
     */
    @Transactional
    public int insert(EstimateInsertDto estimateInsertDto) {
        String estimateId = estimateMapper.findNextEstimateId();
        Long regId = LoginUserHolder.getAsLong();
        estimateInsertDto.setEstimateId(estimateId);
        estimateInsertDto.setRegId(regId);

        int result = estimateMapper.insert(estimateInsertDto);

        if (estimateInsertDto.getItemList() != null && !estimateInsertDto.getItemList().isEmpty()) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("estimateId", estimateId);
            paramMap.put("itemList", estimateInsertDto.getItemList());
            paramMap.put("regId", regId);
            estimateItemMapper.bulkInsert(paramMap);
        }
        return result;
    }

    /**
     * 견적서와 견적서 품목 수정
     * @param estimateInsertDto
     * @return
     */
    @Transactional
    public int update(EstimateInsertDto estimateInsertDto) {
        Long updId = LoginUserHolder.getAsLong();
        String estimateId = estimateInsertDto.getEstimateId();
        estimateInsertDto.setUpdId(updId);

        int result = estimateMapper.updateByEstimateId(estimateInsertDto);

        if (estimateInsertDto.getItemList() != null && !estimateInsertDto.getItemList().isEmpty()) {
            estimateItemMapper.deleteByEstimateId(estimateId);

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("estimateId", estimateId);
            paramMap.put("itemList", estimateInsertDto.getItemList());
            paramMap.put("regId", updId);
            estimateItemMapper.bulkInsert(paramMap);
        }
        return result;
    }

    /**
     * 견적서와 견적서 품목 삭제
     * @param estimateId
     * @return
     */
    @Transactional
    public int delete(String estimateId) {
        estimateItemMapper.deleteByEstimateId(estimateId);
        return estimateMapper.deleteByEstimateId(estimateId);
    }

    /**
     * 그리드용 견적서 전체조회
     * @param estimateSearchDto
     * @return List<EstimateGridDto>
     */
    public List<EstimateGridDto> estimateListByGrid(EstimateSearchDto estimateSearchDto) {
        return estimateMapper.estimateListByGrid(estimateSearchDto);
    }

    /**
     * 견적서 상세 조회
     * @param estimateId
     * @return
     */
    @Transactional
    public EstimateDto findEstimateDetail(String estimateId) {
        EstimateDto estimateDto = estimateMapper.findByEstimateId(estimateId);
        if(estimateDto == null) {
            throw new CodeException(ErrorCode.ESTIMATE_NOT_FOUND);
        }
        estimateDto.setItemList(estimateItemMapper.findByEstimateId(estimateId));
        return estimateDto;
    }

    /**
     * 상태코드를 확정으로 변경
     * @param estimateId
     * @return int
     */
    public int confirmEstimateStatus(String estimateId) {
        Long updId = LoginUserHolder.getAsLong();
        return estimateMapper.confirmEstimateStatus(estimateId, updId);
    }

    /**
     * 견적서 엑셀 다운로드
     * @param estimateId
     * @return byte[]
     * @throws IOException
     */
    public byte[] makeEstimateToExcel(String estimateId) throws IOException {
        EstimateDto estimateDto = findEstimateDetail(estimateId);
        return estimateExcelBuilder.build(estimateDto);
    }

    /**
     * 견적서 PDF 다운로드
     * @param estimateId
     * @return byte[]
     * @throws IOException
     */
    public byte[] makeEstimateToPdf(String estimateId) throws IOException {
        EstimateDto estimateDto = findEstimateDetail(estimateId);
        byte[] excelData = estimateExcelBuilder.build(estimateDto);
        return ConverterUtil.excelToPdfConverter(excelData);
    }
}

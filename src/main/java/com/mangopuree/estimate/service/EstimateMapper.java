package com.mangopuree.estimate.service;

import com.mangopuree.estimate.dto.EstimateDto;
import com.mangopuree.estimate.dto.EstimateGridDto;
import com.mangopuree.estimate.dto.EstimateInsertDto;
import com.mangopuree.estimate.dto.EstimateSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EstimateMapper {

    /**
     * 새로 생성할 견적서 번호 조회
     * @return
     */
    String findNextEstimateId();

    /**
     * 등록
     * @param estimateInsertDto
     * @return int
     */
    int insert(EstimateInsertDto estimateInsertDto);

    /**
     * 수정
     * @param estimateUpdateDto
     * @return int
     */
    int updateByEstimateId(EstimateInsertDto estimateUpdateDto);

    /**
     * 삭제
     * @param estimateId
     * @return int
     */
    int deleteByEstimateId(String estimateId);

    /**
     * 견적서 번호로 조회
     * @param EstimateId
     * @return EstimateDto
     */
    EstimateDto findByEstimateId(String EstimateId);

    /**
     * 그리드용 견적서 전체조회
     * @param estimateSearchDto
     * @return List<UserGridDto>
     */
    List<EstimateGridDto> estimateListByGrid(EstimateSearchDto estimateSearchDto);

    /**
     * 상태코드를 확정으로 변경
     * @param estimateId
     * @param updId
     * @return int
     */
    int confirmEstimateStatus(String estimateId, Long updId);
}

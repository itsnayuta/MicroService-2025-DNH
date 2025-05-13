package com.example.result_service.mapper;

import com.example.result_service.dto.ResultDTO;
import com.example.result_service.models.Result;

public class ResultMapper {

    public static ResultDTO mapToResultDTO(Result result) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setId(result.getId());
        resultDTO.setUserId(result.getUserId());
        resultDTO.setQuizId(result.getQuizId());
        resultDTO.setScore(result.getScore());
        resultDTO.setTotalQuestions(result.getTotalQuestions());
        resultDTO.setCreatedAt(result.getCreatedAt());
        return resultDTO;
    }

    public static Result mapToResultEntity(ResultDTO resultDTO) {
        Result result = new Result();
        result.setId(resultDTO.getId());
        result.setUserId(resultDTO.getUserId());
        result.setQuizId(resultDTO.getQuizId());
        result.setScore(resultDTO.getScore());
        result.setTotalQuestions(resultDTO.getTotalQuestions());
        result.setCreatedAt(resultDTO.getCreatedAt());
        return result;
    }
}

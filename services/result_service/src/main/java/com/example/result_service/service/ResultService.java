package com.example.result_service.service;

import com.example.result_service.dto.ResultDTO;
import com.example.result_service.mapper.ResultMapper;
import com.example.result_service.models.Result;
import com.example.result_service.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<ResultDTO> getResultsByUserId(Integer userId) {
        return resultRepository.findByUserId(userId)
                .stream()
                .map(ResultMapper::mapToResultDTO)
                .collect(Collectors.toList());
    }

    public ResultDTO saveResult(ResultDTO resultDTO) {
        Result toSave = ResultMapper.mapToResultEntity(resultDTO);
        Result saved = resultRepository.save(toSave);
        return ResultMapper.mapToResultDTO(saved);

    }

    public ResultDTO updateResult(ResultDTO resultDTO) {
        Optional<Result> resultOptional = resultRepository.findById(resultDTO.getId());

        Result result = resultOptional.get();
        updateResultFromDTO(result, resultDTO);
        resultRepository.save(result);
        return ResultMapper.mapToResultDTO(result);
    }


    private void updateResultFromDTO(Result resultToUpdate, ResultDTO resultDTO) {
        if (resultDTO.getId() != null) {
            resultToUpdate.setId(resultDTO.getId());
        }
        if (resultDTO.getUserId() != null) {
            resultToUpdate.setUserId(resultDTO.getUserId());
        }

        if (resultDTO.getQuizId() != null) {
            resultToUpdate.setQuizId(resultDTO.getQuizId());
        }
        if (resultDTO.getScore() != null) {
            resultToUpdate.setScore(resultDTO.getScore());
        }

        if (resultDTO.getTotalQuestions() != null) {
            resultToUpdate.setTotalQuestions(resultDTO.getTotalQuestions());
        }
        if (resultDTO.getCreatedAt() != null) {
            resultToUpdate.setCreatedAt(resultDTO.getCreatedAt());
        }
    }

}
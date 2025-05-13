package com.example.result_service.service;

import com.example.result_service.dto.ResultDTO;
import com.example.result_service.exception.ResourceNotFoundException;
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

    // Lấy tất cả kết quả của người dùng theo userId
    public List<ResultDTO> getResultsByUserId(Integer userId) {
        return resultRepository.findByUserId(userId)
                .stream()
                .map(ResultMapper::mapToResultDTO)
                .collect(Collectors.toList());
    }

    // Lưu kết quả thi vào cơ sở dữ liệu
    public ResultDTO saveResult(ResultDTO resultDTO) {
        Result toSave = ResultMapper.mapToResultEntity(resultDTO);
        Result saved = resultRepository.save(toSave);
        return ResultMapper.mapToResultDTO(saved);
    }

    // Cập nhật kết quả thi
    public ResultDTO updateResult(ResultDTO resultDTO) {
        Optional<Result> resultOptional = resultRepository.findById(resultDTO.getId());

        if (!resultOptional.isPresent()) {
            throw new ResourceNotFoundException("Result not found for id: " + resultDTO.getId());
        }

        Result result = resultOptional.get();
        updateResultFromDTO(result, resultDTO);
        resultRepository.save(result);
        return ResultMapper.mapToResultDTO(result);
    }

    // Xóa kết quả thi
    public boolean deleteResult(Integer resultId) {
        Optional<Result> resultOptional = resultRepository.findById(resultId);

        if (!resultOptional.isPresent()) {
            return false;
        }

        resultRepository.delete(resultOptional.get());
        return true;
    }

    // Lấy tất cả kết quả (dành cho Admin)
    public List<ResultDTO> getAllResults() {
        return resultRepository.findAll()
                .stream()
                .map(ResultMapper::mapToResultDTO)
                .collect(Collectors.toList());
    }

    // Cập nhật từ DTO vào entity
    private void updateResultFromDTO(Result resultToUpdate, ResultDTO resultDTO) {
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
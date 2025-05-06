package com.example.result_service.controllers;

import com.example.result_service.dto.ResultDTO;
import com.example.result_service.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ResultDTO>> getResultsByUserId(@PathVariable("userId") Integer userId) {
        List<ResultDTO> resultDTOS = new ArrayList<>();
        resultDTOS = resultService.getResultsByUserId(userId);
        return new ResponseEntity<>(resultDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResultDTO> saveResult(@RequestBody ResultDTO dto) {
        return ResponseEntity.ok(resultService.saveResult(dto));
    }

    @PatchMapping("/{resultId}")
    public ResponseEntity<ResultDTO> updateResult(@PathVariable("resultId") Integer resultId, @RequestBody ResultDTO dto) {
        dto.setId(resultId);
        ResultDTO savedResultDTO = resultService.updateResult(dto);
        return new ResponseEntity<>(savedResultDTO, HttpStatus.OK);
    }
}

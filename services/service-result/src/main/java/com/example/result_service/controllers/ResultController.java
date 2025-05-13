package com.example.result_service.controllers;

import com.example.result_service.dto.ResultDTO;
import com.example.result_service.service.ResultService;

import com.example.result_service.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
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

    // Lấy kết quả của người dùng theo userId (chỉ cho user)
    @GetMapping("/{userId}")
    public ResponseEntity<List<ResultDTO>> getResultsByUserId(@PathVariable("userId") Integer userId, HttpServletRequest request) {
        // Kiểm tra phân quyền
        String token = request.getHeader("Authorization");
        String roleUser = JWTUtils.extractRole(token.substring(7));

        if (roleUser.equals("USER") || roleUser.equals("ADMIN")) {
            List<ResultDTO> resultDTOS = resultService.getResultsByUserId(userId);
            return new ResponseEntity<>(resultDTOS, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    // Lưu kết quả (chỉ cho user, admin có thể lưu kết quả của tất cả người dùng)
    @PostMapping()
    public ResponseEntity<ResultDTO> saveResult(@RequestBody ResultDTO dto, HttpServletRequest request) {
        // Kiểm tra phân quyền
        String token = request.getHeader("Authorization");
        String roleUser = JWTUtils.extractRole(token.substring(7));

        if (roleUser.equals("USER") || roleUser.equals("ADMIN")) {
            return ResponseEntity.ok(resultService.saveResult(dto));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    // Cập nhật kết quả (chỉ cho admin hoặc người dùng có quyền chỉnh sửa)
    @PatchMapping("/{resultId}")
    public ResponseEntity<ResultDTO> updateResult(@PathVariable("resultId") Integer resultId, @RequestBody ResultDTO dto, HttpServletRequest request) {
        // Kiểm tra phân quyền
        String token = request.getHeader("Authorization");
        String roleUser = JWTUtils.extractRole(token.substring(7));

        if (roleUser.equals("ADMIN")) {
            dto.setId(resultId);
            ResultDTO savedResultDTO = resultService.updateResult(dto);
            return new ResponseEntity<>(savedResultDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    // Xóa kết quả (chỉ cho admin)
    @DeleteMapping("/{resultId}")
    public ResponseEntity<String> deleteResult(@PathVariable("resultId") Integer resultId, HttpServletRequest request) {
        // Kiểm tra phân quyền
        String token = request.getHeader("Authorization");
        String roleUser = JWTUtils.extractRole(token.substring(7));

        if (roleUser.equals("ADMIN")) {
            boolean isDeleted = resultService.deleteResult(resultId);
            if (isDeleted) {
                return ResponseEntity.ok("Result deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Result not found");
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not allowed");
        }
    }

    // Lấy tất cả kết quả (dành cho ADMIN)
    @GetMapping()
    public ResponseEntity<List<ResultDTO>> getAllResults(HttpServletRequest request) {
        // Kiểm tra phân quyền
        String token = request.getHeader("Authorization");
        String roleUser = JWTUtils.extractRole(token.substring(7));

        if (roleUser.equals("ADMIN")) {
            List<ResultDTO> resultDTOS = resultService.getAllResults();
            return new ResponseEntity<>(resultDTOS, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}

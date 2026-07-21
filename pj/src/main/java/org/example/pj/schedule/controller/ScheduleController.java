package org.example.pj.schedule.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.pj.schedule.dto.*;
import org.example.pj.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<CreateScheduleResponse> create(
            @RequestParam Long userId,
            @Valid @RequestBody CreateScheduleRequest request){
        CreateScheduleResponse result = scheduleService.save(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<List<GetScheduleResponse>> getALL(){
        List<GetScheduleResponse> result = scheduleService.getALL();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOne(@PathVariable Long scheduleId){
        GetScheduleResponse result = scheduleService.getOne(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> update(
            @PathVariable Long scheduleId,
            @Valid @RequestBody UpdateScheduleRequest request

    ) {
        UpdateScheduleResponse result = scheduleService.update(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> delete(@PathVariable Long scheduleId){
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

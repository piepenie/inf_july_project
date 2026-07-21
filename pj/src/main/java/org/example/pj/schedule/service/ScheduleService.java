package org.example.pj.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.pj.schedule.dto.*;
import org.example.pj.schedule.entity.Schedule;
import org.example.pj.schedule.repository.ScheduleRepository;
import org.example.pj.user.entity.User;
import org.example.pj.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 저장용
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request, Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        Schedule schedule = Schedule.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .user(user)
                .build();

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    // 전체 조회용
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getALL() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    // 단건 조회용
    @Transactional(readOnly = true)
    public GetScheduleResponse getOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 게시물입니다.")
        );
        return new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 수정 업데이트용
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 게시물입니다.")
        );
        schedule.update(
                request.getTitle(),
                request.getContents()
        );
        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long scheduleId) {
        boolean existence = scheduleRepository.existsById(scheduleId);
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 게시물입니다.");
        }
        scheduleRepository.deleteById(scheduleId);
    }


}

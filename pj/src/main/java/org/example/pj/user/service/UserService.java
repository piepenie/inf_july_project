package org.example.pj.user.service;

import lombok.RequiredArgsConstructor;
import org.example.pj.schedule.dto.GetScheduleResponse;
import org.example.pj.user.dto.*;
import org.example.pj.user.entity.User;
import org.example.pj.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 생성
    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );
        User saveUser = userRepository.save(user);
        return new CreateUserResponse(
                saveUser.getId(),
                saveUser.getUsername(),
                saveUser.getEmail(),
                saveUser.getCreatedAt(),
                saveUser.getModifiedAt()
        );
    }

    // 전체 유저 조회
    @Transactional(readOnly = true)
    public List<GetUserResponse> getALL(){
        List<User> users = userRepository.findAll();
        List<GetUserResponse> dtos = new ArrayList<>();

        for (User user : users) {
            GetUserResponse dto = new GetUserResponse(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    // 특정 유저 조회
    @Transactional(readOnly = true)
    public GetUserResponse getOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 유저입니다.")
        );
        return new GetUserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    // 유저 수정 업데이트
    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 유저입니다.")
        );
        user.update(
                request.getUsername(),
                request.getEmail()
        );
        return new UpdateUserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    // 유저 삭제
    @Transactional
    public void delete(Long userId) {
        boolean existence = userRepository.existsById(userId);
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 유저입니다.");
        }
        userRepository.deleteById(userId);
    }





}

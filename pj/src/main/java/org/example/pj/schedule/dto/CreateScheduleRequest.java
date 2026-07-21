package org.example.pj.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    @NotBlank(message = "제목은 필수로 작성해주세요.")
    private String title;
    @NotBlank(message = "내용을 적어주세요.")
    private String contents;

}

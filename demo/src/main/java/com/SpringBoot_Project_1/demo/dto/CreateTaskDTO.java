package com.SpringBoot_Project_1.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class CreateTaskDTO {
    String title;
    String description;
    String deadline;
}

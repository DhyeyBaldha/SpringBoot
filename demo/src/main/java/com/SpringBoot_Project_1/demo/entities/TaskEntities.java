package com.SpringBoot_Project_1.demo.entities;

import lombok.Data;

import javax.swing.*;
import java.util.Date;
@Data
public class TaskEntities {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;


}

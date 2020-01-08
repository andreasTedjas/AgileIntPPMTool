package io.agileinteligence.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "project name is required")
    private String projectName;

    @NotBlank(message = "project identifier is required")
    @Size(min=4, max=5, message = "Please use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message = "project description is required")
    private String description;

    @JsonFormat(pattern = "dd-mm-yyy")
    private Date start_date;

    @JsonFormat(pattern = "dd-mm-yyy")
    private Date end_date;

    @JsonFormat(pattern = "dd-mm-yyy")
    private Date created_At;

    @JsonFormat(pattern = "dd-mm-yyy")
    private Date updated_At;
}

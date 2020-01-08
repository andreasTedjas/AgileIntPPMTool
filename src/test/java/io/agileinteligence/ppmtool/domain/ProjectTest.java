package io.agileinteligence.ppmtool.domain;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectTest {

    private Validator validator;

    @Before
    public void setupValidatorInstance() {
         this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenNotEmptyName_thenNoConstraintViolations() {
        Project project =  new Project((long) 1, "asu", "projectIdentifier", "desc", new Date(),  new Date(),  new Date(),  new Date());
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenEmptyName_thenOneConstraintViolation() {
        Project project =  new Project((long) 1, "", "projectIdentifier", "desc", new Date(),  new Date(),  new Date(),  new Date());
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenNullName_thenOneConstraintViolation() {
        Project project =  new Project((long) 1, null, "projectIdentifier", "desc", new Date(),  new Date(),  new Date(),  new Date());
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        assertThat(violations.size()).isEqualTo(1);
    }

    private Project createProject() {
        return new Project((long) 1, "project1", "projectIdentifier", "desc", new Date(),  new Date(),  new Date(),  new Date());
    }

}

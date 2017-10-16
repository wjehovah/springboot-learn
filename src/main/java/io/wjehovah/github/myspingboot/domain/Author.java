package io.wjehovah.github.myspingboot.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author wuyong
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Builder
@Entity(name = "t_author")
@DynamicUpdate
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    @Length(min = 4, max = 20, message = "{author.name}")
    private String name;
    @NotNull
    @Range(min = 18, max = 30, message = "{author.age}")
    private Integer age;
    /**
     * 用户状态标识
     * 1：正常状态
     */
    private Integer state = 1;
}


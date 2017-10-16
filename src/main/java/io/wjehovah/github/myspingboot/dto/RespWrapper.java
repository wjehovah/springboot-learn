package io.wjehovah.github.myspingboot.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author wuyong
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Setter
@Getter
@RequiredArgsConstructor(staticName = "ofCode")
public class RespWrapper<T> {
    @NonNull
    private String code;
    private String msg;
    private T data;
    private Map error;

}

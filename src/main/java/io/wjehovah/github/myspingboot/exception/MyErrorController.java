package io.wjehovah.github.myspingboot.exception;

import io.wjehovah.github.myspingboot.dto.RespWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 先ControllerAdvice 后ErrorController;
 * ControllerAdvice没有捕获的异常，ErrorController会 处理;
 * 重写 /error 参考 https://my.oschina.net/angerbaby/blog/595367
 */
@Controller
public class MyErrorController extends BasicErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    /**
     * 重写错误页面
     */
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        logger.error("errorHtml");
        return super.errorHtml(request, response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        logger.error("error");
        Map<String, Object> body = new HashMap<>(4);
        Map<String, Object> error = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus reWriteStatus = getStatus(request);
        body.put("code", reWriteStatus.toString());
        body.put("msg", error.get("message"));
        body.put("error", error);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}

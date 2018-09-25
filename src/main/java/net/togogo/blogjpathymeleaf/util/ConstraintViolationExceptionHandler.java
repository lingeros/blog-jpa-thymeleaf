package net.togogo.blogjpathymeleaf.util;





import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * bean验证异常处理器
 * @author ling
 * @date 2018/9/20  19:56
 * @function:
 */
public class ConstraintViolationExceptionHandler {


   public static String getMessage(ConstraintViolationException e){
       List<String> msgList = new ArrayList<>();
       for (ConstraintViolation<?> constraintViolation:e.getConstraintViolations()) {
           msgList.add(constraintViolation.getMessage());
       }
       String messages = StringUtils.join(msgList.toArray(),";");
       return messages;
   }



}

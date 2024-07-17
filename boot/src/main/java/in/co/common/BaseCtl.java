package in.co.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseCtl {
public ORSResponse validate(BindingResult bindingResult){
    ORSResponse res  = new ORSResponse(true);
    if (bindingResult.hasErrors()){
    res.setSuccess(false);
        Map<String ,String> errors = new HashMap<String , String>();
        List<FieldError> list  = bindingResult.getFieldErrors();
        list.forEach(e->{
        errors.put(e.getField(),e.getDefaultMessage());

        });
        res.addInputError(errors);
    }
    return  res;

}


}

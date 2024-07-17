package in.co.ctl;

import in.co.common.BaseCtl;
import in.co.common.ORSResponse;
import in.co.dto.UserDTO;
import in.co.form.UserForm;
import in.co.form.UserRegistrationForm;
import in.co.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Date;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl {
    @Autowired
    public UserService service;

    @PostMapping("signUp")
    public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {
        ORSResponse res = validate(bindingResult);
        if (!res.isSuccess()) {
            return res;
        }
        UserDTO dto = new UserDTO();

        dto.setFirstName(form.getFirstName());
        dto.setLastName(form.getLastName());
        dto.setLoginId(form.getLoginId());
        dto.setPassword(form.getPassword());
        dto.setDob((Date) form.getDob());
        dto.setRoleId(2L);

        long pk = service.add(dto);
        res.addData(pk);
        res.addMessage("Data Registered Successfully..!!");
        return res;
    }
}

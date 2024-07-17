package in.co.ctl;

import in.co.common.ORSResponse;
import in.co.common.SpringResponse;
import in.co.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "User")
public class TestCtl {

    @GetMapping("display")
    public SpringResponse display() {

        SpringResponse res = new SpringResponse();

        res.setData("data inserted");
        res.setMessage("successfully");

        Map errors = new HashMap();
        errors.put("firstName", "first name is required");
        errors.put("lastName", "last name is required");
        errors.put("loginId", "login is required");
        errors.put("password", "password is required");
        res.setResult(errors);
        Map map = new HashMap();
        map.put("inputerror", errors);

        res.setResult(map);

        return res;
    }

    @PostMapping("testORSResponse")
    public ORSResponse testORSResponse() {
        ORSResponse res = new ORSResponse();
        Map errors = new HashMap();
        errors.put("firstName", "first name is required");
        errors.put("lastName", "last name is required");
        errors.put("loginId", "login is required");
        errors.put("password", "password is required");
        res.addInputError(errors);
        res.addMessage("data inserted");
        UserDTO dto = new UserDTO();

        dto.setId(1L);
        dto.setFirstName("abc");
        dto.setLastName("xyz");
        dto.setLoginId("abc@gmail.com");
        dto.setPassword("12345");

        res.addData(dto);
        res.addResult("preload", "User list");
        return res;
    }
}

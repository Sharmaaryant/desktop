package in.co.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import in.co.common.BaseDTO;
import in.co.common.BaseForm;
import in.co.dto.UserDTO;

public class UserForm extends BaseForm {

    @NotEmpty(message = "firstName is required")
    private String firstName;

    @NotEmpty(message = "lastName is required")
    private String lastName;

    @NotEmpty(message = "loginId is required")
    private String loginId;

    @NotEmpty(message = "password is required")
    private String password;

    private Date dob;

    private long roleId;

    public UserForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public BaseDTO getDto() {
        UserDTO dto = initDTO(new UserDTO());
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setLoginId(loginId);
        dto.setPassword(password);
        dto.setDob(dob);
        dto.setRoleId(roleId);
        return dto;
    }
}

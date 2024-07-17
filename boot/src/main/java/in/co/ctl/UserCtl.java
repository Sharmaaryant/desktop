package in.co.ctl;

import in.co.common.BaseCtl;
import in.co.common.ORSResponse;
import in.co.dto.AttachmentDTO;
import in.co.dto.UserDTO;
import in.co.form.UserForm;
import in.co.service.AttachmentService;
import in.co.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl {
    @Autowired
    public UserService service;

    @Autowired
    public AttachmentService attachmentService;


    @PostMapping("save")
    public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }

        UserDTO dto = (UserDTO) form.getDto();

        if (dto.getId() != null && dto.getId() > 0) {
            service.update(dto);
            res.addData(dto.getId());
            res.addMessage("Data Updated Successfully..!!");
        } else {
            long pk = service.add(dto);
            res.addData(pk);
            res.addMessage("Data added Successfully..!!");
        }
        return res;
    }


    @GetMapping(value = "get/{id}")
    public ORSResponse get(@PathVariable long id) {
        ORSResponse res = new ORSResponse();
        UserDTO dto = service.findById(id);
        res.addData(dto);
        return res;
    }

    @GetMapping(value = "delete/{ids}")
    public ORSResponse delete(@PathVariable long[] ids) {
        ORSResponse res = new ORSResponse();
        for (long id : ids) {
            service.delete(id);
        }
        res.addMessage("Data Deleted Success");
        return res;

    }

    public ORSResponse search(@RequestBody UserForm form, @PathVariable int pageNo) {
        ORSResponse res = new ORSResponse();

        UserDTO dto = new UserDTO();
        dto.setFirstName(form.getFirstName());

        List list = service.search(dto, pageNo, 5);

        if (list.size() == 0) {
            res.addMessage("Result not Found");
        } else {
            res.addData(list);
        }
        return res;

    }

    @PostMapping("/profilePic/{userId}")
    public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {

        AttachmentDTO attachmentDto = new AttachmentDTO(file);
        attachmentDto.setDescription("profile pic");
        attachmentDto.setUserId(userId);
        UserDTO userDto = service.findById(userId);
        if (userDto.getImageId() != null && userDto.getImageId() > 0) {
            attachmentDto.setId(userDto.getImageId());
        }
        Long imageId = attachmentService.save(attachmentDto);
        if (userDto.getImageId() == null) {
            userDto.setImageId(imageId);
            service.update(userDto);
        }
        ORSResponse res = new ORSResponse();
        res.addResult("imageId", imageId);
        return res;

    }

    @GetMapping("/profilePic/{userId}")
    public @ResponseBody void downloadPic(@PathVariable Long userId, HttpServletResponse response) {
        try {
            UserDTO userDto = service.findById(userId);
            AttachmentDTO attachmentDTO = null;
            if (userDto != null) {
                attachmentDTO = attachmentService.findById(userDto.getImageId());
            }
            if (attachmentDTO != null) {
                response.setContentType(attachmentDTO.getType());
                OutputStream out = response.getOutputStream();
                out.write(attachmentDTO.getDoc());
out.close();
            }else {
            response.getWriter().write("ERROR: File not found");
            }

        }catch (Exception e){
        e.printStackTrace();
        }
    }


}

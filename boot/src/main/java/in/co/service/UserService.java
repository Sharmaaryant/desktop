package in.co.service;

import in.co.dao.UserDAO;
import in.co.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    public UserDAO dao;

    public UserDTO authenticate(String loginId, String password) {
        UserDTO dto = dao.findByUniqueKey("loginId", loginId);
        if (dto != null) {
            if (dto.getPassword().equals(password)) {
                return dto;
            }
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public long add(UserDTO dto) {

        long pk = dao.add(dto);
        return pk;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(UserDTO dto) {
        dao.update(dto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(long id) {
        UserDTO dto = dao.findByPk(id);
        dao.delete(dto);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(long pk) {
        UserDTO dto = dao.findByPk(pk);
        return dto;
    }

    @Transactional(readOnly = true)
    public UserDTO findByLogin(String loginId) {
        UserDTO dto = dao.findByUniqueKey("loginId", loginId);
        return dto;
    }

    @Transactional(readOnly = true)
    public List search(UserDTO dto, int pageNo, int pageSize) {
        List list = dao.search(dto, pageNo, pageSize);
        return list;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public long save(UserDTO dto){

    Long id= dto.getId();
    if (id != null && id>0){
    update(dto);
    }
    else {
        id = add(dto);

    }

    return id;
    }

}

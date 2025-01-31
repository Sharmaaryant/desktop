package in.co.dao;

import in.co.dto.UserDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    @PersistenceContext
    public EntityManager entityManager;

    public Long add(UserDTO dto) {
        entityManager.persist(dto);
        return dto.getId();
    }

    public void update(UserDTO dto) {
        entityManager.merge(dto);
    }

    public void delete(UserDTO dto) {
        entityManager.remove(dto);
    }

    public UserDTO findByPk(Long pk) {
        UserDTO dto = entityManager.find(UserDTO.class, pk);
        return dto;
    }

    public UserDTO findByUniqueKey(String attribute, String value) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);
        Root<UserDTO> qroot = cq.from(UserDTO.class);
        Predicate condition = builder.equal(qroot.get(attribute), value);
        cq.where(condition);
        TypedQuery<UserDTO> tq = entityManager.createQuery(cq);
        List<UserDTO> list = tq.getResultList();
        UserDTO dto = null;
        if (list.size() > 0) {
            dto = list.get(0);
        }
        return dto;
    }

    public List search(UserDTO dto, int pageNo, int pageSize) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);
        Root<UserDTO> qroot = cq.from(UserDTO.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();
        if (dto != null) {
            if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
                predicateList.add(builder.like(qroot.get("firstName"), dto.getFirstName() + "%"));
            }
            if (dto.getLastName() != null && dto.getLastName().length() > 0) {
                predicateList.add(builder.like(qroot.get("lastName"), dto.getLastName() + "%"));
            }
            if (dto.getId() != null && dto.getId() > 0 ){
            predicateList.add(builder.equal(qroot.get("id"),dto.getId()));
            }
            if (dto.getDob() != null && dto.getDob().getTime() > 0 ){
            predicateList.add(builder.equal(qroot.get("dob"),dto.getDob()));
            }
        }
        cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
        TypedQuery<UserDTO > tq = entityManager.createQuery(cq);
        if (pageSize > 0 ){
        tq.setFirstResult(pageNo * pageSize);
        tq.setMaxResults(pageSize);
        }
        List<UserDTO> list = tq.getResultList();

        return  list ;
    }


}

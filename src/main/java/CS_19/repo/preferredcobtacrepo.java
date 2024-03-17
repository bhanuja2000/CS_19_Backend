package CS_19.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CS_19.Entity.preferred_contact;

import java.util.List;

@Repository
public  interface preferredcobtacrepo extends JpaRepository<preferred_contact,Long> {

    List<CS_19.Entity.preferred_contact> findAllByuseremail(String user_email);
}

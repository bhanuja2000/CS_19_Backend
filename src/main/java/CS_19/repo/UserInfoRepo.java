package CS_19.repo;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import CS_19.Entity.UserInfoEntity;

import java.util.List;
import java.util.Optional;
import java.util.Queue;


@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoEntity,Long> {
    Optional<UserInfoEntity> findByEmailId(String emailId);

    @Query(value = "SELECT * FROM user_info WHERE email_id = ?1", nativeQuery = true)
    UserInfoEntity getUserByEmailID(String email);

    boolean existsByemailId(String username);





}

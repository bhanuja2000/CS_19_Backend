package CS_19.repo;

import CS_19.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where id=?1",nativeQuery = true)
    User get_selected_user(String userid);

    @Query(value = "select * from user where Email=?1",nativeQuery = true)
    User get_selected_address_id(String  email);
}

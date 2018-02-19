package cr.model.mapper;

import cr.model.Testuser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 小富 on 2018/1/14.
 */
public interface TestUserMapper {

    //conut测试用例
    public int conut();

    //addUser测试
    public int addUser(Testuser user);

    //userList测试
    public List<Testuser> userList();

}

package shopping.example.models.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shopping.example.models.entity.AdminAccountEntity;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void test() throws Exception{
        // create new user
        adminDao.save(new AdminAccountEntity("aaa","123456"));
        adminDao.save(new AdminAccountEntity("bbb","223344"));
        adminDao.save(new AdminAccountEntity("ccc","556688"));
        adminDao.save(new AdminAccountEntity("ddd","778855"));

        // test findAll
        Assertions.assertEquals(8,adminDao.findAll().size());

        // test findByUsername
        Assertions.assertEquals("223344", adminDao.findByUsername("bbb").getPassword());
    }
}
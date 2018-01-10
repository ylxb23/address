package test.zero.address;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zero.address.app.App;

/**
 * test basic class
 * @date 2018年1月10日 下午10:18:00
 * @author zero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=App.class)
public abstract class TestBasic {

}

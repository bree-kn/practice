package com.example.practice.jdbcTemplate;

import com.example.practice.trycatchpackage.ErrorEnum;
import com.example.practice.trycatchpackage.ResultData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Service("jdbcService")
public class JdbcServiceImpl implements JdbcService {

    protected static final Logger log = Logger.getLogger(JdbcServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public ResultData add(User user) {
        int n = -1;
        try {
            n = userDao.add(user);
        }catch (Exception e){
            log.error("插入user表失败",e);
            e.printStackTrace();
        }
         if(n == -1){
             return new ResultData(ErrorEnum.REQUEST_FAIL,"插入失败");
         }
         return new ResultData(ErrorEnum.REQUEST_SUCCESS,"插入成功");
    }

    /*加了事务竟然不回滚原因：
     * 1.在方法上增加 @Transactional 使其方法开始事务，注意方法是public的，
     * 2.另外方法里面的事务别try cacth 掉，因为你处理了事务，事务就不会自动回滚，如果一定需要try catch 请捕获后throw new RuntimeException();
     * 出来，否则事务也不会生效。
     * 3.要把注解加在service类上
     * 4.回滚的是unchecked（运行时异常）即空指针异常等，不回滚的是checked异常，如fileNotFoundException,sqlException等，即如果代码空指针等问题，则回滚，
     * 如果文件读写，超时等问题，则不回滚。
     * 如果想要所有的异常都回滚则在方法上
     * 加@Transactional(rollbackFor = Exception.class)
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData update(int id, String password) throws FileNotFoundException {
        int n = -1;
        int empcount = -1;
        List<User> userList = userDao.findById(id);
        if(userList == null){
            return new ResultData(ErrorEnum.REQUEST_FAIL,"not found this user");
        }
        try {
            n = userDao.updateUser(userList.get(0).getId(),password);
            empcount =userDao.updateEmp(userList.get(0).getId(),1000);
        }catch (Exception e){
            log.error("修改表失败",e);
            throw e;
        }
        return new ResultData(ErrorEnum.REQUEST_SUCCESS,null);
    }

    @Override
    public ResultData delete(int id) {
        int n = userDao.delete(id);
        if(n == -1){
            return new ResultData(ErrorEnum.REQUEST_FAIL,"delete fail");
        }
        return new ResultData(ErrorEnum.REQUEST_SUCCESS,"delete success");
    }

    @Override
    public ResultData selectValue(int id) {
        int n = userDao.selectValue(id);
        return new ResultData(ErrorEnum.REQUEST_SUCCESS,n);
    }

    @Override
    public ResultData select(int id) {
        User user = userDao.select(id);
        return new ResultData(ErrorEnum.REQUEST_SUCCESS,user);
    }

    @Override
    public ResultData selectAll() {
        List<User> list = userDao.selectAll();
        return new ResultData(ErrorEnum.REQUEST_SUCCESS,list);
    }

    @Override
    public ResultData selectMap(int id) {
        Map map = userDao.selectMap(id);
        return new ResultData(ErrorEnum.REQUEST_SUCCESS,map);
    }

}

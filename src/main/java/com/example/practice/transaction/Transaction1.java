package com.example.practice.transaction;

/**加了事务竟然不回滚原因：
 * 1.在方法上增加 @Transactional 使其方法开始事务，注意方法是public的，
 * 2.另外方法里面的事务别try cacth 掉，因为你处理了事务，事务就不会自动回滚，如果一定需要try catch 请捕获后throw new RuntimeException();
 * 出来，否则事务也不会生效。
 * 3.要把注解加在service类上
 * 4.回滚的是unchecked（运行时异常）即空指针异常等，不回滚的是checked异常，如fileNotFoundException,sqlException等，即如果代码空指针等问题，则回滚，
 * 如果文件读写，超时等问题，则不回滚。
 * 如果想要所有的异常都回滚则在方法上
 * 加@Transactional(rollbackFor = Exception.class)
 */
public class Transaction1 {
}

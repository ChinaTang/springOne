package service;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.support.AbstractTransactionStatus;

@ContextConfiguration
public class UserServiceTest extends AbstractTestNGSpringContextTests{
    public boolean isNewTransaction() {
        return false;
    }
}

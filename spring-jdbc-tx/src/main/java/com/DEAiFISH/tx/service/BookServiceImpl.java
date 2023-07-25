package com.DEAiFISH.tx.service;

import com.DEAiFISH.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    /*
     * @Transactional标识在方法上，则只会影响该方法
     * @Transactional标识的类上，则会影响类中所有的方法
     *
     *
     * 属性设置：
     * 1、readonly：只读，只能查询，不能修改添加删除
     * 2、timeout：超时，在设置时间内没有完成，抛出异常回滚
     * 3、回滚策略：
     *      声明式事务默认只针对运行时异常回滚，编译时异常不回滚。
     *      可以通过@Transactional中相关属性设置回滚策略
     *          - rollbackFor属性：需要设置一个Class类型的对象
     *          - rollbackForClassName属性：需要设置一个字符串类型的全类名
     *          - noRollbackFor属性：需要设置一个Class类型的对象
     *          - rollbackFor属性：需要设置一个字符串类型的全类名
     * 4、隔离级别：
     *      数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题。
     *      一个事务与其他事务隔离的程度称为隔离级别。
     *      SQL标准中规定了多种事务隔离级别，不同隔离级别对应不同的干扰程度，隔离级别越高，数据一致性就越好，但并发性越弱。
     *           隔离级别一共有四种：
     *           - 读未提交：READ UNCOMMITTED允许Transaction01读取Transaction02未提交的修改。
     *           - 读已提交：READ COMMITTED、要求Transaction01只能读取Transaction02已提交的修改。
     *           - 可重复读：REPEATABLE READ确保Transaction01可以多次从一个字段中读取到相同的值，
     *                       即Transaction01执行期间禁止其它事务对这个字段进行更新。
     *           - 串行化：SERIALIZABLE确保Transaction01可以多次从一个表中读取到相同的行，
     *                       在Transaction01执行期间，禁止其它事务对这个表进行添加、更新、删除操作。
     *                       可以避免任何并发问题，但性能十分低下。
     * 5、传播行为：
     *      在service类中有a()方法和b()方法，a()方法上有事务，b()方法上也有事务，当a()方法执行过程中调用了b()方法，事务是如何传递的？
     *      合并到一个事务里？还是开启一个新的事务？这就是事务传播行为。
     *          一共有七种传播行为：
     *            - REQUIRED：支持当前事务，如果不存在就新建一个(默认)【没有就新建，有就加入】
     *            - SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行【有就加入，没有就不管了】
     *            - MANDATORY：必须运行在一个事务中，如果当前没有事务正在发生，将抛出一个异常【有就加入，没有就抛异常】
     *            - REQUIRES_NEW：开启一个新的事务，如果一个事务已经存在，则将这个存在的事务挂起
     *                      【不管有没有，直接开启一个新事务，开启的新事务和之前的事务不存在嵌套关系，之前事务被挂起】
     *            - NOT_SUPPORTED：以非事务方式运行，如果有事务存在，挂起当前事务【不支持事务，存在就挂起】
     *            - NEVER：以非事务方式运行，如果有事务存在，抛出异常【不支持事务，存在就抛异常】
     *            - NESTED：如果当前正有一个事务在进行中，则该方法应当运行在一个嵌套式事务中。
     *                       被嵌套的事务可以独立于外层事务进行提交或回滚。如果外层事务不存在，行为就像REQUIRED一样。
     *                      【有事务的话，就在这个事务里再嵌套一个完全独立的事务，嵌套的事务可以独立的提交和回滚。
     *                       没有事务就和REQUIRED一样。】
     */
    @Transactional(timeout = 1)
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}

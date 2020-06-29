package com.liuencier.csp.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

/**
 * @program: csp
 * @description: 全局事务配置
 * @author: liuenci
 * @create: 2020-06-29 10:31
 **/
@Slf4j
@Aspect
@Configuration
public class TransactionConfig {

    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.liuencier.csp.service.impl.*.*(..))";
    /**
     * 配置多个切入点表达式
     */
    // private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.platform.service.impl.*.*(..))" +
    //         "                     || execution(* com.platform.generator.aspect.*.*(..))";

    private static final int TX_METHOD_TIMEOUT = 5000;

    @Autowired
    private MongoTransactionManager mongoTransactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {
        /*事务管理规则，声明具备事务管理的方法名**/
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        /*只读事务，不做更新操作*/
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        /* transactiondefinition 定义事务的隔离级别 PROPAGATION_NOT_SUPPORTED事务传播级别5，以非事务运行，如果当前存在事务，则把当前事务挂起*/
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        /*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        /*抛出异常后执行切点回滚**/
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        /*PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。 */
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        /*设置事务失效时间，如果超过5秒，则回滚事务*/
        requiredTx.setTimeout(TX_METHOD_TIMEOUT);
        Map<String, TransactionAttribute> txMap = new HashMap<>();

        txMap.put("save*", requiredTx);
        txMap.put("remove*", requiredTx);
        txMap.put("update*", requiredTx);
        txMap.put("batch*", requiredTx);
        txMap.put("clear*", requiredTx);
        txMap.put("add*", requiredTx);
        txMap.put("append*", requiredTx);
        txMap.put("modify*", requiredTx);
        txMap.put("edit*", requiredTx);
        txMap.put("insert*", requiredTx);
        txMap.put("delete*", requiredTx);
        txMap.put("do*", requiredTx);
        txMap.put("create*", requiredTx);
        /*select,count开头的方法,开启只读,提高数据库访问性能*/
        txMap.put("select*", readOnlyTx);
        txMap.put("get*", readOnlyTx);
        txMap.put("valid*", readOnlyTx);
        txMap.put("list*", readOnlyTx);
        txMap.put("count*", readOnlyTx);
        txMap.put("find*", readOnlyTx);
        txMap.put("load*", readOnlyTx);
        txMap.put("search*", readOnlyTx);
        txMap.put("*", requiredTx);

        source.setNameMap(txMap);
        TransactionInterceptor txAdvice = new TransactionInterceptor(mongoTransactionManager, source);
        return txAdvice;
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        /* 声明切点的面：切面就是通知和切入点的结合。通知和切入点共同定义了关于切面的全部内容——它的功能、在何时和何地完成其功能* */
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        /*声明和设置需要拦截的方法,用切点语言描写**/
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        /*设置切面=切点pointcut+通知TxAdvice**/
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
/**
 @Pointcut("execution(* com.platform.service.impl.*.*(..))")
 public void logPointCut() {
 }
 @Around("logPointCut()") public Object around(ProceedingJoinPoint point) throws Throwable {
 //long beginTime = System.currentTimeMillis();
 //执行方法
 // Object result = point.proceed();
 //执行时长(毫秒)
 //  long time = System.currentTimeMillis() - beginTime;
 //保存日志
 log.info(" @Around*******************"+"     dong    "+"********************** @Around");
 return "";
 }
 **/

}

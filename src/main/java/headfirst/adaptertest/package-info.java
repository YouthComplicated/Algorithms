package headfirst.adaptertest;


/**
 *
 *
 * Spring AOP通知适配模式
 * Advice的类型有：MethodBeforeAdvice、AfterReturningAdvice、ThrowsAdvice
 * 在每个类型 Advice 都有对应的拦截器，MethodBeforeAdviceInterceptor、AfterReturningAdviceInterceptor、ThrowsAdviceInterceptor
 *  目标：Advice 都封装成对应的拦截器类型，返回给容器
 *
 *
 *
 *
 *
 */
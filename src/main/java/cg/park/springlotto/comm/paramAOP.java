package cg.park.springlotto.comm;

import cg.park.springlotto.utils.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class paramAOP {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    String sessGuid = "E6F9B4F2A2465CE76D991BF5807AD9E0";

    @Around("execution(* cg.park.springlotto..controllers.*.*(..)) || execution(* cg.park.springlotto..services.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = joinPoint.getSignature().toShortString();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.getParameterMap();
        logger.info("SESS_GUID = {}, ===================START===================", sessGuid);
        logger.info("SESS_GUID = {}, @Around : {} ", sessGuid, type);
        logger.info("SESS_GUID = {}, @Around : {}, param : {} ", sessGuid, type, LogUtil.mapToStr(request.getParameterMap()));
        return joinPoint.proceed();
    }

    @Before("execution(* cg.park.springlotto..controllers.*.*(..)) || execution(* cg.park.springlotto..services.*.*(..))")
    public void before(JoinPoint joinPoint) {
        String type = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (args.length == 0 || args[0] instanceof HttpServletRequest){
            logger.info("SESS_GUID = {}, @Before : {}, param : {}", sessGuid, type, LogUtil.mapToStr(request.getParameterMap()));
        }else{
            logger.info("SESS_GUID = {}, @Before : {}, param : {}", sessGuid, type, LogUtil.setParamParse(args[0].toString(), "="));
        }
    }

    @AfterReturning(pointcut = "execution(* cg.park.springlotto..controllers.*.*(..)) || execution(* cg.park.springlotto..services.*.*(..))", returning="retValue")
    public void after(JoinPoint joinPoint, Object retValue) {
        String type = joinPoint.getSignature().toShortString();
        logger.info("SESS_GUID = {}, @After : {}, result : {}", sessGuid, type, retValue);
        logger.info("SESS_GUID = {}, ===================E N D===================", sessGuid);
    }

    @AfterThrowing(pointcut = "execution(* cg.park.springlotto..controllers.*.*(..)) || execution(* cg.park.springlotto..services.*.*(..))", throwing = "ex")
    public void afterThrowingAnException(JoinPoint joinPoint, Exception ex) {
        logger.info("SESS_GUID = {}, ===================E N D===================", sessGuid);
    }
}

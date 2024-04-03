package com.example.demoapp.component;

import com.example.demoapp.service.AuditLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserActivityAuditAspect {

    private final AuditLogService auditLogService;

    public UserActivityAuditAspect(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @AfterReturning(pointcut = "@annotation(com.example.demoapp.annotation.LogUserActivity)")
    public void logUserActivity(JoinPoint joinPoint) {
        // Extract relevant details from joinPoint, user context.
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = (authentication != null) ? authentication.getName() : "anonymous";*/

        String userId = "anonymous";
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String action = className + "." + methodName;

        // Create an audit log entity and persist it using repository methods
        auditLogService.log(userId, action, "N/A");
    }
}
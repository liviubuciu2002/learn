package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Class that intercepts every call of KickoffPropertyUtil.getPropertyXXX or PropertyLoaderService.getPropertyXXX methods and logs the
 * property name, the property value, the default value, the kickoff filename from what the property is loaded, the signature of method that
 * load the property and the class that made the call of the method.
 *
 * @author Beatrice Rus
 */
@Aspect
public class PropertiesAspect {

    static final String OUTPUT_SEPARATOR = "\u0009";

    /**
     * A JVM parameter that enables/disables the functionality of logging into the properties janitor files.
     */
    private static boolean isEnabled = true;

    @Pointcut("(( call (boolean com.worldpay.gateway.component.properties.KickoffPropertyUtil.getPropertyBoolean(String)) "
            + "|| call (boolean com.worldpay.gateway.component.properties.PropertyLoaderService.getPropertyBoolean(String)) "
            + "|| call (boolean com.worldpay.gateway.component.properties.KickoffPropertyUtil.getPropertyBoolean(String,boolean)) "
            + "|| call (boolean com.worldpay.gateway.component.properties.PropertyLoaderService.getPropertyBoolean(String,boolean)) "
            + "|| call (int com.worldpay.gateway.component.properties.KickoffPropertyUtil.getPropertyInt(String)) "
            + "|| call (int com.worldpay.gateway.component.properties.PropertyLoaderService.getPropertyInt(String)) "
            + "|| call (int com.worldpay.gateway.component.properties.KickoffPropertyUtil.getPropertyInt(String,int)) "
            + "|| call (int com.worldpay.gateway.component.properties.PropertyLoaderService.getPropertyInt(String,int)) "
            + "|| call (long com.worldpay.gateway.component.properties.KickoffPropertyUtil.getPropertyLong(String)) "
            + "|| call (long com.worldpay.gateway.component.properties.PropertyLoaderService.getPropertyLong(String)) "
            + "|| call (long com.worldpay.gateway.component.properties.KickoffPropertyUtil.getPropertyLong(String,long)) "
            + "|| call (long com.worldpay.gateway.component.properties.PropertyLoaderService.getPropertyLong(String,long)) "
            + "|| call (String com.worldpay.gateway.component.properties.KickoffPropertyUtil.getProperty(String)) "
            + "|| call (String com.worldpay.gateway.component.properties.PropertyLoaderService.getProperty(String)) "
            + "|| call (String com.worldpay.gateway.component.properties.KickoffPropertyUtil.getProperty(String,String)) "
            + "|| call (String com.worldpay.gateway.component.properties.PropertyLoaderService.getProperty(String,String))) "
            + "&& !within(com.worldpay.gateway.component.properties.KickoffPropertyUtil)) && if()")
    public static boolean conditionalPointcut() {
        return isEnabled;
    }

    /**
     * The around advice is associated with the pointcut expression and runs at any join point matched by the pointcut. The around advice
     * invokes getPropertyXXX methods that match the signature and logs the information needed in properties janitor files; The around
     * advice has an if() that is evaluated at runtime; If it is true the around advice method is executed, otherwise is skipped. The method
     * will print: the method name, the method that is called by, the property name, the value of the property, the default value and the
     * file name.
     *
     * @param staticPart
     *            the signature at the join point
     * @param joinPoint
     *            the method that matched the signature defined in pointcut expression
     * @return Object the object returned after the getPropertyXXX method is invoked. The object can be String, int, long, boolean.
     * @throws Throwable
     */
    @Around("conditionalPointcut()")
    public Object around(JoinPoint.EnclosingStaticPart staticPart, ProceedingJoinPoint joinPoint) throws Throwable {

        Object returnValue = null;

        // we default this to empty string as we do not want to display
        // sensitive info
        Object propertyValue = null;
        String propertyName = "";
        String defaultValue = null;
        StringBuilder output = new StringBuilder();
        String propLocation = null;

        // we first need to evaluate the params of the joinpoint
        if (joinPoint.getArgs().length > 0) {
            propertyName = (String) joinPoint.getArgs()[0];
        }

        if (joinPoint.getArgs().length > 1) {
            defaultValue = getValueFromObject(joinPoint.getArgs()[1]);
        }

        // we need to get the value of the property
        returnValue = joinPoint.proceed();


        /**
         * Print: the method name, the method that is called by, the property name, the value of the property, the default value and the
         * file name.
         */
        output.append(OUTPUT_SEPARATOR)
                .append(joinPoint).append(OUTPUT_SEPARATOR)
                .append(staticPart.toString()).append(OUTPUT_SEPARATOR)
                .append(propertyName).append(OUTPUT_SEPARATOR)
                .append(propertyValue).append(OUTPUT_SEPARATOR)
                .append(defaultValue).append(OUTPUT_SEPARATOR)
                .append(propLocation).append(OUTPUT_SEPARATOR);

        return returnValue;
    }


    /**
     * Returns the string value of the given {@link Object}.
     *
     * @param object
     *            the object (<i>e.g.</i> {@link Integer}, {@link Boolean}, {@link Long}) to get the value from
     * @return empty string if the object is null, otherwise a string representation of the object.
     */
    private String getValueFromObject(Object object) {
        if (object == null) {
            return "";
        } else {
            return object.toString();
        }
    }

}

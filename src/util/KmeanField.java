package util;  
  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
/** 
 * �ڶ���������ϱ�ע��ע�ͣ� 
 * ��ʾ����kmeans�㷨,��֧����ֵ������ 
 * @author Jayshawn
 */  
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.FIELD)  
public @interface KmeanField {  
} 

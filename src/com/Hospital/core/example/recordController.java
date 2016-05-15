package com.Hospital.core.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.record.recordmodel;
/*
 * @Controller��ǩ��ʾ�����һ�������� ���Խ���·��ӳ��
 * requestmapping ��ʾURLӳ��
 */
@Controller
@RequestMapping(value="/numbergame", produces = {"application/json;charset=UTF-8"})
public class recordController {
	
	@Autowired
	private recordmodel remodel;
     @ResponseBody
     /*
      * 
      */
	@RequestMapping(value="/getAllRecord")
     /*���requestmapping��ʾ��������� /Hospital/numbergame/getAllRecord ���url���д���
      * request��һ���������
      * ����ʹ��@responsebody��ǩ ���򷵻ص�string������Ϊ string.jsp �᷵�ض�Ӧjsp�ļ�
      * һ�������ĳ�Ա����Ҫ������Ӧ��get��set������������е�recordmodel�����Ҫget��set����
      * ʹ��ʱ����Ҫnew
      */
	public String getAllRecord(HttpServletRequest request){
    	       
    	       String result=remodel.handleRequestGetAll();
    	      
    	       return result;
      }
     @ResponseBody
     @RequestMapping(value="/postRecord")
     public String postRecord(HttpServletRequest request){
    	 String username=request.getParameter("username");
	       String record=request.getParameter("record"); 
	       String result=remodel.handlPostRecord(username, Integer.parseInt(record));
    	 return result;
     }
     @ResponseBody
     @RequestMapping(value="/getRecords")
     public String getRecords(HttpServletRequest request){
    	  String result=remodel.handleWebService();
    	  return result;
    	  
    	 
     }
     
     
}

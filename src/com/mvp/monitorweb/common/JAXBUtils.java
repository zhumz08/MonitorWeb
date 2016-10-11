package com.mvp.monitorweb.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * JAXB������
 * 
 * @author vincent
 *
 */
public class JAXBUtils {
	private static final Log log = LogFactory.getLog(JAXBUtils.class);
	//Ĭ��xml����
	private static final String DEFAULT_ENCODING = "UTF-8"; 

	private static Map<Class<?>, JAXBContext> jaxbMap = Collections.synchronizedMap(new HashMap<Class<?>, JAXBContext>());
	
	
	/**
	 * 
	 * @param <T>
	 * @param targetClass
	 * @param xmlValue
	 * @param encoding
	 * @param fragment 
	 * @param formatOutput 
	 * @return
	 */
	public static <T> T toObject(Class<?> targetClass,String xmlValue){
		try {
			StringReader reader = new StringReader(xmlValue);
			T xmlObj = (T) getUnMarshaller(targetClass).unmarshal(reader);
			return xmlObj;
		} catch (Exception e) {
			log.error("toObject error",e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param <T>
	 * @param targetClass
	 * @param xmlValue
	 * @param encoding
	 * @param fragment 
	 * @param formatOutput 
	 * @return
	 */
	public static <T> T toObject(Class<?> targetClass,InputStream xmlStream){
		try {
			StringReader reader = new StringReader(IOUtils.toString(xmlStream));
			T xmlObj = (T) getUnMarshaller(targetClass).unmarshal(reader);
			return xmlObj;
		} catch (Exception e) {
			log.error("toObject error",e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param <T>
	 * @param targetClass
	 * @param xmlValue
	 * @param encoding
	 * @return
	 */
	public static String toXml(Class<?> targetClass,Object xmlObj,String encoding,boolean formatOutput, boolean fragment){
		try {
			StringWriter writer = new StringWriter();
			getMarshaller(targetClass, encoding, formatOutput, fragment).marshal(xmlObj, writer);
			return writer.toString();
		} catch (Exception e) {
			log.error("toObject error",e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param <T>
	 * @param targetClass
	 * @param xmlValue
	 * @param encoding
	 * @return
	 */
	public static String toXml(Class<?> targetClass,Object xmlObj){
		return toXml(targetClass, xmlObj, null,true,true);
	}
	
	/**
	 * 
	 * @param targetClass
	 * @param encoding
	 * @param formatOutput 
	 * @param fragment 
	 * @return
	 * @throws JAXBException
	 */
	public static Unmarshaller getUnMarshaller(Class<?> targetClass) throws JAXBException{
		JAXBContext context = getContext(targetClass);
		return context.createUnmarshaller();
	}
	
	/**
	 * 
	 * @param targetClass
	 * @param encoding
	 * @return
	 * @throws JAXBException
	 */
	public static Marshaller getMarshaller(Class<?> targetClass, String encoding,boolean formatOutput, boolean fragment) throws JAXBException{
		JAXBContext context = getContext(targetClass);
		
		Marshaller marshaller = context.createMarshaller();
		//��ʽ�����  
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatOutput); 
		//���xmlͷ
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, fragment);
		//����  
        encoding = !StringUtils.isNotBlank(encoding) ? DEFAULT_ENCODING : encoding;
        //��������ı����ʽ 
        marshaller.setProperty(Marshaller.JAXB_ENCODING,encoding);
        
        return marshaller;
	}
	
	
	/**
	 * @param targetClass
	 * @return
	 */
	public static JAXBContext getContext(Class<?> targetClass){
		try {
			JAXBContext context = jaxbMap.get(targetClass);
			if(context==null){
				context = JAXBContext.newInstance(targetClass);
				jaxbMap.put(targetClass, context);
			}
			return context;
		} catch (Exception e) {
			log.error("GetContext toObject error",e);
		}
		return null;
	}
	
	
	public static void main(String[] args) throws IOException {
//		FileServer fs = new FileServer();
//		fs.setCarNoEncoding("����");
//		fs.setEnabled(false);	
//		
//		String xmlValue = toXml(FileServer.class, fs, "GBK",true,true);
////		System.out.println(xmlValue);
//		
//		String str = FileUtils.readFileToString(new File("./src/fileserver.xml"), "UTF-8");
//		fs = toObject(FileServer.class, str);
//		System.out.println(fs);
	}
	

}
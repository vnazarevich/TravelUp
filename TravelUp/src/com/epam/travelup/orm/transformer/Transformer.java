package com.epam.travelup.orm.transformer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.DBDictionaryField;
import com.epam.travelup.orm.model.DBField;
import com.epam.travelup.orm.model.DBKey;

public class Transformer <T>{
	private Class<T> type;
	private String language;
	@SuppressWarnings("unchecked")
	public Transformer(Class<T> type, String language){
		this.type=type;
		this.language = language;
	}

	public List<T> getModelList(ResultSet set){
		T model = null;
		List<T> modelList = new ArrayList<T>();
		try {
			while(set.next()){
				try {
					model = type.newInstance();
					Field[] fields = type.getDeclaredFields();
					for(Field field:fields){
						String attr = fieldToAttribute(field.getName());
						String fieldType = field.getType().getSimpleName().toLowerCase();
						field.setAccessible(true);
						if(attr!=null){
//							switch ( fieldType) {
//							case "int":{
//								field.setInt(model,set.getInt(value));
//								break;
//							}
//							case "string":{
//								field.set(model,set.getString(value));
//								break;
//							}
//							case "date":{
//								field.set(model,set.getDate(value));
//								break;
//							}
//							case "boolean":{
//								field.setBoolean(model,set.getBoolean(value));
//								break;
//							}
//							default:
//								break;
//							}
							Annotation annotation = field.getAnnotation(DBDictionaryField.class);
							if(annotation!=null){
								String dictionaryName = (String) DBDictionaryField.class.getMethod("name", null).invoke(annotation, null);
								String value=new Dao(null,language).getDictionaryValue(dictionaryName,set.getInt(attr));
								field.set(model, value);
							}else{
								Object value = set.getObject(attr);
								if(value!=null){
									field.set(model, set.getObject(attr));
								}
							}
						}else{
							Annotation annotation = field.getAnnotation(DBKey.class);
							if(annotation!=null){
								Class fieldClass=field.getType();
								String FK = (String) DBKey.class.getMethod("name", null).invoke(annotation, null);
								String FKValue = set.getString(FK);
								//if there is a null in DB
								if(FKValue!=null){
									fieldClass.getClass();
									System.out.println(fieldClass.getSimpleName());
									Dao dao= new Dao<>(fieldClass, language);
									System.out.println(FKValue);
									List<?> list = dao.selectWhere("id", FKValue, "=");
									field.set(model, list.get(0));
								}

							}
						}
					}

				} catch (InstantiationException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException  e) {

					e.printStackTrace();
				}
				if(model!=null){
					modelList.add(model);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	public Map<String,Object> modelToTable(T model){
		Field[] fields = type.getDeclaredFields();
		Map<String,Object> tableInput = new HashMap<String, Object>();
		for(Field field:fields){
			field.setAccessible(true);
			Annotation annotation = field.getAnnotation(DBKey.class);
			if(field.getName().equals("id")){
				continue;
			}
			//if field is FK
			if(annotation!=null){
				try {
					if(field.get(model)!=null){
						int id = (int)field.getType().getDeclaredMethod("getId", null).invoke(field.get(model), null);
						String attrName = (String) annotation.annotationType().getMethod("name", null).invoke(annotation, null);
						tableInput.put(attrName, id);
					}
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					e.printStackTrace();
				}
			}else{
				String attrName = fieldToAttribute(field.getName());
				if(attrName!=null){
					//if field is dictionary field
					Annotation dictionaryAnnotation = field.getAnnotation(DBDictionaryField.class);
					if(dictionaryAnnotation!=null){
						String dictionaryName;
						try {
							dictionaryName = (String) dictionaryAnnotation.annotationType().getMethod("name", null).invoke(dictionaryAnnotation, null);
							String value = (String) field.get(model);
							int id=new Dao(null,language).getDictionaryValueId(dictionaryName, value);
							tableInput.put(attrName, id);
						} catch (IllegalAccessException | IllegalArgumentException
								| InvocationTargetException | NoSuchMethodException
								| SecurityException e) {
							e.printStackTrace();
						}

					}else{
						try {
							tableInput.put(attrName, field.get(model));
						} catch (IllegalArgumentException
								| IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}
		return tableInput;
	}

	public  String fieldToAttribute(String fieldName){
		try {
			Field field=type.getDeclaredField(fieldName);
			field.setAccessible(true);
			Annotation annotation = field.getAnnotation(DBField.class);
			if(annotation==null){
				return null;
			}

			String attribute=(String)annotation.annotationType().getMethod("name").invoke(annotation, null);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

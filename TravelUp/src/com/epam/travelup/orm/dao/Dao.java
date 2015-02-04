package com.epam.travelup.orm.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.epam.travelup.orm.model.DBTable;
import com.epam.travelup.orm.persistant.ConnectionManager;
import com.epam.travelup.orm.transformer.Transformer;

public class Dao<T> {
	private String tableName;
	private Class<T> type;
	private String language;

	@SuppressWarnings("unchecked")
	public Dao(Class<T> type, String language) {
		this.type = type;
		this.language = language;
		if (type != null) {
			Annotation annotation = type.getAnnotation(DBTable.class);
			try {
				Method annotationAttribute = annotation.annotationType()
						.getDeclaredMethod("name");
				annotationAttribute.setAccessible(true);
				tableName = (String) annotationAttribute.invoke(annotation,
						null);
			} catch (NoSuchMethodException | SecurityException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	// gets the word id from dictionary. If there is no such word returns -1
	public int getDictionaryValueId(String dictionaryName, String value) {
		try (Connection connection = ConnectionManager.getConnection()) {
			String fieldName = language.toLowerCase() + "_" + dictionaryName;
			PreparedStatement statement = connection
					.prepareStatement("Select id From " + dictionaryName
							+ " Where " + fieldName + "=?;");
			statement.setString(1, value);
			ResultSet set = statement.executeQuery();
			set.next();
			int id = set.getInt("id");
			// System.out.println("id: "+id);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String getDictionaryValue(String dictionaryName, int id) {
		try (Connection connection = ConnectionManager.getConnection()) {
			String fieldName = language.toLowerCase() + "_" + dictionaryName;
			PreparedStatement statement = connection.prepareStatement("Select "
					+ fieldName + " From " + dictionaryName + " Where id=?;");
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			set.next();
			String result = set.getString(fieldName);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> selectAll() {
		ResultSet set = null;
		// System.out.println("Tablename: "+tableName);
		try (Connection connection = ConnectionManager.getConnection()) {
			String query = "Select * From " + tableName + ";";
			PreparedStatement statement = connection.prepareStatement(query);
			// System.out.println(query);
			set = statement.executeQuery();
			return new Transformer<T>(type, language).getModelList(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> selectAll(int offset, int rowCount) {
		ResultSet set = null;
		// System.out.println("Tablename: "+tableName);
		try (Connection connection = ConnectionManager.getConnection()) {
			String query = "Select * From " + tableName + " LIMIT " + offset
					+ "," + rowCount + ";";
			PreparedStatement statement = connection.prepareStatement(query);
			System.out.println("");
			set = statement.executeQuery();
			return new Transformer<T>(type, language).getModelList(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> selectWhere(String attr, String value, String equalitySign) {
		ResultSet set = null;
		try (Connection connection = ConnectionManager.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("Select * From " + tableName + " Where "
							+ attr + " " + equalitySign + " ?;");
			statement.setString(1, value);
			// System.out.println(statement.toString());
			set = statement.executeQuery();
			return new Transformer<T>(type, language).getModelList(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> selectWhereOr(List<String> attrs, List<String> values,
			String equalitySign) {
		ResultSet set = null;
		try (Connection connection = ConnectionManager.getConnection()) {
			StringBuilder builder = new StringBuilder("Select * From "
					+ tableName + " Where ");
			for (int i = 0; i < attrs.size(); i++) {
				builder.append(attrs.get(i) + " " + equalitySign + " '"
						+ values.get(i) + "'");
				if (i != attrs.size() - 1) {
					builder.append(" OR ");
				}
			}
			builder.append(" ; ");
			// System.out.println(builder.toString());
			PreparedStatement statement = connection.prepareStatement(builder
					.toString());
			set = statement.executeQuery();
			return new Transformer<T>(type, language).getModelList(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> selectWhereOr(List<String> attrs, List<String> values,
			String equalitySign, int offset, int rowCount) {
		ResultSet set = null;
		try (Connection connection = ConnectionManager.getConnection()) {
			StringBuilder builder = new StringBuilder("Select * From "
					+ tableName + " Where ");
			for (int i = 0; i < attrs.size(); i++) {
				builder.append(attrs.get(i) + " " + equalitySign + " '"
						+ values.get(i) + "'");
				if (i != attrs.size() - 1) {
					builder.append(" OR ");
				}
			}
			builder.append(" LIMIT " + offset + "," + rowCount + "; ");
			PreparedStatement statement = connection.prepareStatement(builder
					.toString());
			// System.out.println(builder);
			set = statement.executeQuery();
			return new Transformer<T>(type, language).getModelList(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> selectWhereAnd(List<String> attrs, List<String> values,
			String equalitySign, int offset, int rowCount) {
		ResultSet set = null;
		try (Connection connection = ConnectionManager.getConnection()) {
			StringBuilder builder = new StringBuilder("Select * From "
					+ tableName + " Where ");
			for (int i = 0; i < attrs.size(); i++) {
				builder.append(attrs.get(i) + " " + equalitySign + " '"
						+ values.get(i) + "'");
				if (i != attrs.size() - 1) {
					builder.append(" AND ");
				}
			}
			builder.append(" LIMIT " + offset + "," + rowCount + "; ");
			PreparedStatement statement = connection.prepareStatement(builder
					.toString());
			// System.out.println(builder);
			set = statement.executeQuery();
			return new Transformer<T>(type, language).getModelList(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(List<String> attrs, List<String> values) {
		try (Connection connection = ConnectionManager.getConnection()) {
			StringBuilder builder = new StringBuilder("Delete From "
					+ tableName + " Where ");
			for (int i = 0; i < attrs.size() - 1; i++) {
				builder.append(attrs.get(i) + "='" + values.get(i) + "' AND ");
			}
			builder.append(attrs.get(attrs.size() - 1) + "='"
					+ values.get(attrs.size() - 1) + "';");
			PreparedStatement statement = connection.prepareStatement(builder
					.toString());
			// System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String attr, String value, String equalitySign) {
		try (Connection connection = ConnectionManager.getConnection()) {
			String query = "Delete From " + tableName + " Where " + attr + " "
					+ equalitySign + " ?;";
			PreparedStatement statement = connection.prepareStatement(query);
			if (value.equals("true") || value.equals("false")) {
				statement.setBoolean(1, Boolean.parseBoolean(value));
			} else {
				statement.setString(1, value);
			}
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// returns generated key
	public int insert(T model) {
		Map<String, Object> inputs = new Transformer<T>(type, language)
				.modelToTable(model);
		List<String> attrs = new ArrayList<String>();
		attrs.addAll(inputs.keySet());
		List<Object> values = new ArrayList<Object>();
		values.addAll(inputs.values());
		int size = attrs.size();
		StringBuilder builder = new StringBuilder("Insert into " + tableName
				+ "(");
		for (int i = 0; i < size - 1; i++) {
			builder.append(attrs.get(i));
			builder.append(", ");
		}
		builder.append(attrs.get(size - 1) + ") Values (");
		for (int i = 0; i < size - 1; i++) {
			Object value = values.get(i);
			if (value != null
					&& value.getClass().getTypeName()
							.equals(Boolean.class.getName())) {
				value = ((boolean) value) ? 1 : 0;
			}
//			if (value != null&& value.getClass().getTypeName().equals(java.util.Date.class.getName())) {
//				value=new java.sql.Date(((java.util.Date)value).getTime());
//				System.out.println("Date insertion!!!");
//			}
			builder.append(value == null ? "" : "'");
			builder.append(value);
			builder.append(value == null ? "" : "'");
			builder.append(", ");
		}
		Object value = values.get(size - 1);
		if (value != null
				&& value.getClass().getTypeName()
						.equals(Boolean.class.getName())) {
			value = ((boolean) value) ? 1 : 0;
		}
		// System.out.println(builder);
		builder.append(value == null ? "" : "'");
		builder.append(value);
		builder.append(value == null ? "" : "'");
		builder.append(");");
		// System.out.println(builder);
		try (Connection connection = ConnectionManager.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					builder.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int count() {
		ResultSet set = null;
		try (Connection connection = ConnectionManager.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("Select COUNT(*) as FULL_COUNT From "
							+ tableName + ";");
			set = statement.executeQuery();
			set.next();
			return set.getInt("FULL_COUNT");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void update(String conditionAttr, String conditionValue,
			String updateAttr, String updateValue) {
		try (Connection connection = ConnectionManager.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("Update "
					+ tableName + " Set " + updateAttr + "=? Where "
					+ conditionAttr + "=?");
			statement.setString(2, conditionValue);
			if (updateValue != null
					&& (updateValue.equals("true") || updateValue
							.equals("false"))) {
				statement.setBoolean(1, Boolean.parseBoolean(updateValue));
			} else {
				statement.setString(1, updateValue);
			}
			// System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(List<String> conditionAttrs,
			List<String> conditionValues, String updateAttr,
			String updateValue, String concatCondition) {
		try (Connection connection = ConnectionManager.getConnection()) {
			StringBuilder builder = new StringBuilder("Update " + tableName
					+ " Set " + updateAttr + "=? Where ");
			for (int i = 0; i < conditionAttrs.size(); i++) {
				builder.append(conditionAttrs.get(i) + " = " + " ?");
				if (i < conditionAttrs.size() - 1) {
					builder.append(" " + concatCondition + " ");
				}
			}
			builder.append(";");
			PreparedStatement statement = connection.prepareStatement(builder
					.toString());
			if (updateValue != null
					&& (updateValue.equals("true") || updateValue
							.equals("false"))) {
				statement.setBoolean(1, Boolean.parseBoolean(updateValue));
			} else {
				statement.setString(1, updateValue);
			}
			for (int i = 0; i < conditionValues.size(); i++) {
				statement.setString(i + 2, conditionValues.get(i));
			}
			// System.err.println(builder);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
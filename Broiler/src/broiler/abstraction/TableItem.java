package broiler.abstraction;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import iconix.database.DatabaseConnect;

public class TableItem {
	
	
	public int update(DatabaseConnect d, Integer ID) throws SQLException, IllegalArgumentException, IllegalAccessException {
		Field[] fields = this.getClass().getDeclaredFields();
		String sql;

		if (ID == null) {
			String sql1 = "Insert into " + getTableName() + "(";
			String sql2 = "values (";
			for (Field field : fields) {
				sql1 += field.getName() + ",";
				sql2 += "?,";
			}
			sql = sql1.substring(0, sql1.length() - 1) + ") " + sql2.substring(0, sql2.length() - 1) + ") ";
		} else {
			String sql1 = "update " + getTableName() + " set ";
			for (Field field : fields) {
				sql1 += field.getName() + "=?,";
			}
			sql = sql1.substring(0, sql1.length() - 1) + " where ID = " + ID;
		}

		PreparedStatement ps = d.openConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		int i = 1;
		for (Field field : fields) {
			// System.out.println(field.getName() + ": " + field.getType().toString() + ": "
			// + field.get(this));

			if (field.get(this) != null) {
				switch (field.getType().toString()) {

				case "class java.lang.String":
					ps.setString(i, (String) field.get(this));
					break;
				case "class java.lang.Integer":
					ps.setInt(i, (Integer) field.get(this));
					break;
				case "class java.lang.Double":
					ps.setDouble(i, (Double) field.get(this));
					break;
				case "boolean":
					ps.setBoolean(i, (Boolean) field.get(this));
					break;
				default:
					ps.setObject(i, field.get(this));
				}
			} else {
				ps.setNull(i, i);
			}
			i++;
		}

		if (ID != null) {
			ps.executeUpdate();
			d.closeConnection();
			return ID;
		} else {
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			ID = rs.getInt(1);
			d.closeConnection();
			return ID;
		}
	}
	
	public String getTableName() {
		return getClass().getSimpleName();
	}
	public String getUpdate() {
		return getTableName();
	}

}

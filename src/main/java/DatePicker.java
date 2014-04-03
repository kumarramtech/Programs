
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DatePicker {
  public static Connection getMySQLConnection() throws Exception {
    String driver = "org.gjt.mm.mysql.Driver";
    String url = "jdbc:mysql://localhost/waltairclub";
    String username = "root";
    String password = "root";
    Class.forName(driver);
    return DriverManager.getConnection(url, username, password);
  }

  public static void main(String args[]) {
	System.out.println("Long date : " + new Date(new Date().getTime()));
	Long i = new Date().getTime();
	System.out.println(i);
    ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = getMySQLConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select expire_on from member_login");
      while (rs.next()) {
    	    System.out.println(rs.getString(1));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
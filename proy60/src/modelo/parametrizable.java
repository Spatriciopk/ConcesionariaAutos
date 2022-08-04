package modelo;

public interface parametrizable {
	
	public final String ip="localhost",
						port="3306",
						user="root",
						psw="Kastor2345",
						bbdd="concesionario",
						driver="com.mysql.cj.jdbc.Driver";
	
	public default String getURL() {
		return "jdbc:mysql://" + ip + ":" 
				+ port + "/"+bbdd+"?user="
				+user+"&password="+psw
				+"&useSSL=false&serverTimezone=UTC";
	}
}

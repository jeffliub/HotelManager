package net.davebish.hotelmanager;

public class Login {
	private LoginDB ldb;

	public Login() throws Exception {
		ldb = new LoginDB();
	}

	public boolean IsvalidUser(String UName, String Pwd) throws Exception {
		return ldb.isValidUser(UName, Pwd);
	}
}

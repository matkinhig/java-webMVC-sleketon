/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conn;

import Utils.ConfigUtil;
import Utils.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luc Nguyen by Matkinhig <lucnguyen.hcmut@gmail.com>
 */
public class OracleConnUtils {

    public static Connection getOracleConnection() {
        String host = ConfigUtil.getDB_URL();
        String sid = ConfigUtil.getSID_NAME();
        String user = ConfigUtil.getUSERNAME();
        String pass = ConfigUtil.getPASSWORD();

        return getOracleConnection(host, sid, user, pass);
    }

    private static Connection getOracleConnection(String host, String sid, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName(ConfigUtil.getDriverClassName());
            String url = "jdbc:oracle:thin:@" + host + ":1521/" + sid;
            conn = DriverManager.getConnection(url, user, pass);
            Log.topupInfo("Thông tin kết nối server : " + conn.toString());
        } catch (ClassNotFoundException ex) {
            Log.topupError("Không tìm thấy ", ex, "Driver class name");
        } catch (SQLException ex) {
            Log.topupError("Không tìm thấy ", ex, "Driver class name");
        }
        return conn;
    }
}

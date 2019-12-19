/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conn;

import Utils.Log;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Luc Nguyen by Matkinhig <lucnguyen.hcmut@gmail.com>
 */
public class ConnectionUtils {

    public static Connection getConnection() {
        return OracleConnUtils.getOracleConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            Log.topupError("Lỗi ở ConnectionUtils func closeQuietly", e, "");
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            Log.topupError("Lỗi ở ConnectionUtils func rollbackQuietly", e, "");
        }
    }

}

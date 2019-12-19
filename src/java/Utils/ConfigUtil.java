/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luc Nguyen by Matkinhig <lucnguyen.hcmut@gmail.com>
 */
public class ConfigUtil {

    private static String driverClassName;
    private static String DB_URL = "";
    private static String USERNAME;
    private static String PASSWORD;
    private static String SID_NAME;

    public static String getDriverClassName() {
        return driverClassName;
    }

    public static String getDB_URL() {
        return DB_URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getSID_NAME() {
        return SID_NAME;
    }
    
    static {
        Properties prop = new Properties();
        try (InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream("connection.properties")) {
            Log.topupInfo("Đọc ConfigUtil");
            prop.load(input);
            driverClassName = prop.getProperty("driverClassName");
            DB_URL = prop.getProperty("DB_URL");
            USERNAME = prop.getProperty("USERNAME");
            PASSWORD = prop.getProperty("PASSWORD");
            
        } catch (IOException ex) {
            Logger.getLogger(ConfigUtil.class
                    .getName()).log(Level.SEVERE, null, ex);
            Log.topupError("Đọc File *.properties ", ex, DB_URL);
        }
    }
}

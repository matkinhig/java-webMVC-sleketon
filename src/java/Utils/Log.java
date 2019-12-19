/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.apache.log4j.Logger;

/**
 *
 * @author Luc Nguyen by Matkinhig <lucnguyen.hcmut@gmail.com>
 */
public class Log {

    public static final Logger TOPUP = Logger.getLogger("TOPUP.LOGGER");

    public static void topupError(String name, Exception error, String data) {
        TOPUP.error(name + "[" + data + "]", error);
    }

    public static void topupInfo(String msg) {
        TOPUP.info(msg);
    }
}

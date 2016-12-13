package FBLT.utils;

/**
 * Created by tayfer01 on 11/22/2016.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    public static String PORT = System.getProperty("port");
    public static String URL = System.getProperty("ip");
    public static String PROTOCOL = "http";



}

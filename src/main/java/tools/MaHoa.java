package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MaHoa {
    public static String maHoaMD5(String str) {
        byte[] defaultBytes = str.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) ;
            {
                int i = 13;
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            str = hexString + "";

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }
}
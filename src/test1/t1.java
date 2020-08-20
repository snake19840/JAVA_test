package test1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class t1 {
    private static boolean snCheck(String paramString) {
        if (paramString.length() != 32)
            return false;
        if (paramString.toLowerCase().startsWith("27a3c22d01eb") && paramString.toLowerCase().endsWith("6ee8866aa5e5e7820"))
            try {
                return hash(paramString).equalsIgnoreCase("271373f323d9f76dc31204ff19823fdf");
            } catch (Exception e) {
                return false;
            }
        return false;
    }

    public static String hash(String paramString) {
        try {
            byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
            StringBuilder stringBuilder = new StringBuilder(40);
//            byte[] arrayOfByte=[39, 19, 115, 243, 35, 217, 247, 109, 195, 18, 4, 255, 25, 130, 63, 223];
            int i = arrayOfByte.length;
            for (byte b = 0;; b++) {
                if (b < i) {
                    byte b1 = arrayOfByte[b];
                    if ((b1 & 0xFF) >> 4 == 0) {
                        stringBuilder.append("0");
                        stringBuilder.append(Integer.toHexString(b1 & 0xFF));
                    } else {
                        stringBuilder.append(Integer.toHexString(b1 & 0xFF));
                    }
                } else {
                    return stringBuilder.toString();
                }
            }
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String par="27a3c22d01eb0996ee8866aa5e5e7820";
        System.out.println("271373f323d9f76dc31204ff19823fdf".length());
        System.out.println(Integer.toHexString(95 & 0xFF));
        boolean f=t1.snCheck(par);
        System.out.println(f);
//        System.out.println(par.toLowerCase().startsWith("27a3c22d01eb"));
        System.out.println(par.toLowerCase().startsWith("27a3c22d01eb"));
        System.out.println(par.toLowerCase().endsWith("6ee8866aa5e5e7820"));
        System.out.println("271373f323d9f76dc31204ff19823fdf".equalsIgnoreCase("271373f323d9f76dc31204ff19823fdf"));

//        String a="0";
//        MessageDigest md =MessageDigest.getInstance("MD5");
//        System.out.println(par.getBytes());
//        md.update(par.getBytes());
//        byte[] arrayOfByte=md.digest();

//        System.out.println(1);

    }
}

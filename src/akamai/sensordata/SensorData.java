package akamai.sensordata;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class SensorData {
    static long uptime = 0;
    static long startTime = System.currentTimeMillis();
    public DeviceInfo mDeviceInfo = new DeviceInfo();
    SecretKey aesKey = null;
    SecretKey hmacKey = null;
    String aesKeyEncrypted = null;
    String hmacKeyEncrypted = null;

    public SensorData() {
        uptime = getRandomNumber(0, 12) * 36L;
    }

    public static long getUptime() {
        return uptime + (System.currentTimeMillis() - startTime);
    }

    public String getSensorData() {
        this.mDeviceInfo = new DeviceInfo();
        String model = this.mDeviceInfo.model;
        String androidVersion = this.mDeviceInfo.androidVersion;
        String brand = this.mDeviceInfo.brand;
        String SDKINT = this.mDeviceInfo.SDKINT;
        String manufacturer = this.mDeviceInfo.manufacturer;
        String cputype = this.mDeviceInfo.cputype;
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("3.2.2-1,2,-94,-100,").append("-1,uaend,-1,").append(DeviceInfo.randomScreenSize()).append(",1,100,1,en,").append(androidVersion).append(",0,").append(model).append(",").append(manufacturer).append(",").append(cputype).append(",-1,").append("com.clairmail.fth").append(",-1,-1,").append(UUID.randomUUID()).append(",-1,1,0,REL,").append(getRandomNumber(0, 999999999)).append(",").append(SDKINT).append(",").append(brand).append(",").append(model).append(",release-keys,user,").append(brand).append(",").append(brand).append("-user/").append(androidVersion).append("/").append(getRandomNumber(0, 999999999)).append("/release-keys,").append("universal").append(getRandomNumber(0, 99999)).append(",").append(brand).append(",").append(model).append(",").append(brand).append("/").append(brand).append("/").append(model).append(":").append(androidVersion).append("/").append(getRandomNumber(0, 999999999)).append(":").append("user/release-keys,").append(getRandomNumber(0, 999999999)).append(",").append(model);
        int length = chrplus(stringBuilder6.toString());
        stringBuilder6.append(",").append(length - 907).append(",").append(getRandomNumber(1, 9999)).append(",").append(System.currentTimeMillis() / 2).append("-1,2,-94,-101,").append("do_unr,dm_en,t_en").append("-1,2,-94,-102,").append("-1,2,-94,-108,").append(randomEvent()).append("-1,2,-94,-117,").append(touchEvent()).append("-1,2,-94,-144,").append("-1,2,-94,-142,").append("-1,2,-94,-145,").append("-1,2,-94,-143,").append("-1,2,-94,-115,").append(randomPair()).append("-1,2,-94,-70,").append("-1,2,-94,-80,").append("-1,2,-94,-120,").append("-1,2,-94,-112,").append(randomActivity2()).append("-1,2,-94,-103,").append(activities());
        String sensor = encryptSensor(stringBuilder6.toString());
        return sensor + "|" + SDKINT + "|" + brand + "|" + model + "|" + androidVersion + "|";
    }

    public static String randomActivity2() {
        return getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000) + "," + getRandomNumber(0, 200000);
    }

    public static String activities() {
        StringBuilder sb = new StringBuilder();
        int cycleNum = getRandomNumber(10, 50);
        for (int i = 0; i < cycleNum; i++) {
            sb.append("2");
            sb.append(",");
            sb.append(System.currentTimeMillis() + getRandomNumber(0, 50000));
            sb.append(";");
            sb.append("3");
            sb.append(",");
            sb.append(System.currentTimeMillis() + getRandomNumber(50000, 1000000));
            sb.append(";");
        }
        return sb.toString();
    }

    public static String randomPair() {
        return randomEvent() + "," + touchEvent() + "," + getRandomNumber(0, 10000) + "," + getRandomNumber(0, 10000) + "," + getRandomLong(4294967295L, 999999999999999999L) + "," + System.currentTimeMillis() + ",0,0," + getRandomNumber(0, 10000) + "," + getRandomLong(4294967295L, 999999999999999999L) + "," + getRandomNumber(0, 1000000) + "," + getUptime() + "," + getRandomNumber(0, 10000) + "," + getRandomLong(4294967295L, 999999999999999999L) + "," + System.currentTimeMillis() + "," + getRandomNumber(0, 10000) + ",0";
    }

    public static String randomEvent() {
        StringBuilder sb = new StringBuilder();
        int maxScreenSize = getMaxScreenSize();
        int cycleNum = getRandomNumber(10, 50);
        for (int i = 0; i < cycleNum; i++) {
            sb.append("2");
            sb.append(",");
            sb.append(getRandomNumber(0, maxScreenSize));
            sb.append(",");
            sb.append(getRandomNumber(0, maxScreenSize));
            sb.append(";");
        }
        return sb.toString();
    }

    public static String touchEvent() {
        StringBuilder sb = new StringBuilder();
        int maxScreenSize = getMaxScreenSize();
        int cycleNum = getRandomNumber(10, 50);
        for (int i = 0; i < cycleNum; i++) {
            sb.append(getRandomNumber(2, 3));
            sb.append(",");
            sb.append(getRandomNumber(0, maxScreenSize));
            sb.append(",0,0,1,1,1,-1;");
        }
        return sb.toString();
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static long getRandomLong(long min, long max) {
        return (long) ((Math.random() * (max - min)) + min);
    }

    public static int getMaxScreenSize() {
        String[] screenInt = DeviceInfo.randomScreenSize().split(",");
        int b1 = Integer.parseInt(screenInt[0]);
        int b2 = Integer.parseInt(screenInt[1]);
        return Math.max(b1, b2);
    }

    public static int chrplus(String paramString) {
        if (paramString != null && !paramString.trim().equalsIgnoreCase("")) {
            char c = 0;
            for (int b = 0; b < paramString.length(); b++) {
                try {
                    char c2 = paramString.charAt(b);
                    if (c2 < 128) {
                        c += c2;
                    }
                } catch (Exception e) {
                    return -2;
                }
            }
            return c;
        }
        return -1;
    }

    public String encryptSensor(String str) {
        String result = null;
        try {
            initEncryptKey();
            long uptimeMillis = getUptime();
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, this.aesKey);
            byte[] doFinal = instance.doFinal(str.getBytes());
            long aesUptime = (getUptime() - uptimeMillis) * 1000;
            byte[] iv = instance.getIV();
            byte[] obj = new byte[doFinal.length + iv.length];
            System.arraycopy(iv, 0, obj, 0, iv.length);
            System.arraycopy(doFinal, 0, obj, iv.length, doFinal.length);
            long uptimeMillis2 = getUptime();
            Key secretKeySpec = new SecretKeySpec(this.hmacKey.getEncoded(), "HmacSHA256");
            Mac instance2 = Mac.getInstance("HmacSHA256");
            instance2.init(secretKeySpec);
            byte[] iv2 = instance2.doFinal(obj);
            byte[] doFinal2 = new byte[obj.length + iv2.length];
            long hmackUptime = (getUptime() - uptimeMillis2) * 1000;
            System.arraycopy(obj, 0, doFinal2, 0, obj.length);
            System.arraycopy(iv2, 0, doFinal2, obj.length, iv2.length);
            long uptimeMillis3 = getUptime();
            String encryptedData = Base64.getEncoder().encodeToString(doFinal2);
            long b64uptime = 1000 * (getUptime() - uptimeMillis3);
            StringBuilder sb = new StringBuilder();
            sb.append("2,a,");
            sb.append(this.aesKeyEncrypted);
            sb.append(",");
            sb.append(this.hmacKeyEncrypted);
            sb.append("$");
            sb.append(encryptedData);
            sb.append("$");
            sb.append(aesUptime).append(",").append(hmackUptime).append(",").append(b64uptime);
            sb.append("$$");
            result = sb.toString();
        } catch (Exception e) {
        }
        return result;
    }

    private void initEncryptKey() {
        if (this.aesKey != null) {
            return;
        }
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            this.aesKey = keyGen.generateKey();
            KeyGenerator hmacKeyGen = KeyGenerator.getInstance("HmacSHA256");
            this.hmacKey = hmacKeyGen.generateKey();
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4sA7vA7N/t1SRBS8tugM2X4bByl0jaCZLqxPOql+qZ3sP4UFayqJTvXjd7eTjMwg1T70PnmPWyh1hfQr4s12oSVphTKAjPiWmEBvcpnPPMjr5fGgv0w6+KM9DLTxcktThPZAGoVcoyM/cTO/YsAMIxlmTzpXBaxddHRwi8S2NvwIDAQAB"));
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey rsaKey = factory.generatePublic(keySpec);
            Cipher rsaInstance = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            rsaInstance.init(1, rsaKey);
            this.aesKeyEncrypted = Base64.getEncoder().encodeToString(rsaInstance.doFinal(this.aesKey.getEncoded()));
            this.hmacKeyEncrypted = Base64.getEncoder().encodeToString(rsaInstance.doFinal(this.hmacKey.getEncoded()));
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        System.out.println(new SensorData().getSensorData());
    }
}

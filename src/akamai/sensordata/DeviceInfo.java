package akamai.sensordata;

import java.util.HashMap;
import java.util.Map;

public class DeviceInfo {
    static final String[] ANDROID_SCREEN_SIZE = {"128,72", "256,144", "384,216", "512,288", "640,360", "768,432", "896,504", "1024,576", "1152,648", "1280,720", "1408,792", "1536,864", "1664,936", "1792,1008", "1920,1080", "2048,1152", "2176,1224", "2304,1296", "2432,1368", "2560,1440", "2688,1512", "2816,1584", "2944,1656", "3072,1728", "3200,1800", "3328,1872", "3456,1944", "3584,2016", "3712,2088", "3840,2160", "3968,2232", "4096,2304", "4224,2376", "4352,2448", "4480,2520", "4608,2592", "4736,2664", "4864,2736", "4992,2808", "5120,2880", "5248,2952", "5376,3024", "5504,3096", "5632,3168", "5760,3240", "5888,3312", "6016,3384", "6144,3456", "6272,3528", "6400,3600", "6528,3672", "6656,3744", "6784,3816", "6912,3888", "7040,3960", "7168,4032", "7296,4104", "7424,4176", "7552,4248", "7680,4320"};
    static final Map<String, String> ANDROID_VERSION = new HashMap<String, String>() {
        private static final long serialVersionUID = 1;

        {
            put("5.1", "22");
            put("6.0", "23");
            put("7.0", "24");
            put("7.1", "25");
            put("8.0.0", "26");
            put("8.1.0", "27");
            put("9.0", "28");
            put("10.0", "29");
            put("11.0", "30");
        }
    };
    static final String[] ANDROID_BRAND = {"Acer", "ARCHOS", "ASUS", "Casio", "Dell", "Garmin-ASUS", "HTC", "Huawei", "Kyocera", "Lenovo", "LG", "Motorola", "Panasonic", "Philips", "Samsung", "Sony", "Sony Ericsson", "Toshiba", "ZTE"};
    private static String[] ANDROID_MODEL = {"SCH-I535", "DROIDRAZR", "SAMSUNG-SGH-I747", "SGH-T999", "SPH-L710", "PC36100", "DROIDBIONIC", "ADR6400L", "SGH-T989", "SPH-D710", "ADR6300", "GT-I9300", "DROIDX", "ADR6350", "HTCOneX", "DROIDRAZRHD", "XT910", "Nexus4", "DROID4", "NexusS", "HTCVLE_U", "EVO", "SAMSUNG-SGH-I727", "SCH-I510", "Nexus7", "XT907", "PG86100", "HTCSensation4G", "NexusS4G", "SPH-D720", "HTCGlacier", "SCH-I500", "GT-I9100", "LG-P999", "ADR6425LVW", "SPH-D700", "SAMSUNG-SGH-I317", "SAMSUNG-SGH-I777", "SGH-T959V", "SCH-I405", "SCH-I415", "DROID2GLOBAL", "T-MobileG2", "DROIDPro", "SAMSUNG-SGH-I717", "SGH-I747M", "DROID3", "MB860", "ADR6410LVW", "NexusOne", "SGH-T769", "DROIDX2", "SAMSUNG-SGH-I997", "GT-I9100", "GT-I9001", "GT-I9000", "GT-I8150", "D700", "GT-S5660", "GT-5830L", "S5360", "GT-S5570", "I200", "XT894", "LG-P500", "GT-N7100", "Zio", "DesireHD", "HTCEVODesign4G", "5860E", "A100", "A200", "A500", "ADR6330VW", "ADR8995", "ADR910L", "HTCOneS", "GT-I9100P", "LG-E971", "GT-I9300T", "GT-N7000", "HTCDesireS", "HTCAmaze4G", "GT-I8190", "GT-I8190N", "GT-I9305", "SGH-I747", "HTCVision", "HTCDesire", "HTC6435LVW", "EK-GC100", "HTCIncredibleS", "HTCOneV", "GT-S5830", "SGH-T989D", "SGH-I717D", "GT-N7105", "GT-I9100M", "SGH-I317M", "XT615", "HTCChaChaA810e", "LG-E973", "ST26i", "LT26i", "GT-S5839i", "MT15i", "LG-E400", "GT-P1000", "HTCWildfireSA510e", "GT-I9100T", "LG-C555", "SAMSUNG-SGH-I896", "XT905", "HTCDesireHDA9191", "HTCDesireX", "GT-I9210T", "HTCLegend", "HTCSensationZ710e", "U9202L-1", "GT-P3100", "GT-P5100", "GT-P5110", "LT25i", "SGH-T959D", "DROIDPRO", "GT-I9305T", "HTCDesireC", "LG-P880", "LT30at", "XT603", "C5303", "GT-I9210", "GT-N7105T", "GT-N8000", "GT-P3110", "GT-P7500", "GT-S7560M", "Garmin-AsusA50", "LT29i", "MB525", "SCH-I605", "SGH-I717R", "SGH-T589W", "SGH-T999V", "T-MobileVivacity", "WIKO-CINKSLIM", "SHW-M250S1", "SHV-E250S1", "SHV-E210S", "SHV-E250K", "SHV-E210K", "SHV-E160K", "SHV-E160S", "SCH-I545", "SAMSUNG-SGH-I337", "HTCOne", "SGH-M919", "SPH-L720", "SCH-I605", "GT-I9505", "SGH-T889", "HTCONE", "HTC6435LVW", "SPH-L900", "SAMSUNG-SGH-I537", "GT-N7100", "HTC6500LVW", "LG-P769", "XT1080", "GT-I9305", "GT-I9505G", "GT-I9500", "SGH-I337M", "XT1058", "VS8404G", "GT-N7105", "C6603", "LG-MS770", "GT-N7000", "HTCOneX+", "DesireHD", "LG-LS970", "MB855", "XT1060", "MB886", "HTC_PN071", "SGH-T999L", "HTCEVOV4G", "MB865", "SCH-R530U", "SGH-T679", "SGH-T679", "HTCPH39100", "HTC_Amaze_4G", "myTouch_4G_Slide", "SPH-L300", "SCH-I200", "SPH-D710VMUB", "HTCOne801e", "SPH-D710BST", "LG-E970", "SHV-E250S", "SGH-T699", "SCH-R530M", "C6606", "XT897", "LG-E980", "LG-VM696", "PH44100", "VS9204G", "SM-N900V"};
    private static String[] CPU_MANUFACTURER = {"amd", "allwinner", "amlogic", "apple", "broadcom", "cyrix", "freescale", "fujitsu", "hisilicon", "hitachi", "hygon", "ibm", "intel", "mcst", "marvell", "mediatek", "motorola", "nexgen", "nvidia", "oracle", "qualcomm", "rise technology", "rockchip", "samsung", "sifive", "sigmatel", "texas instruments", "tilera", "transmeta", "via", "wave computing", "winchip", "zhaoxin"};
    private static String[] CPU_TYPE = {"qcom", "mtk", "intel", "amd", "exynos", "unisoc"};
    public String brand = randomANDROIDBRAND();
    public String model = randomANDROIDMODEL();
    public String androidVersion = randomANDROIDVERSION();
    public String manufacturer = randomMANUFACTURER();
    public String cputype = randomCPU();
    public String SDKINT = ANDROID_VERSION.get(this.androidVersion);

    public static String randomScreenSize() {
        return ANDROID_SCREEN_SIZE[(int) (Math.random() * ANDROID_SCREEN_SIZE.length)];
    }

    public static String randomANDROIDVERSION() {
        Object[] versions = ANDROID_VERSION.keySet().toArray();
        return versions[(int) (Math.random() * versions.length)].toString();
    }

    public static String randomANDROIDBRAND() {
        return ANDROID_BRAND[(int) (Math.random() * ANDROID_BRAND.length)];
    }

    public static String randomANDROIDMODEL() {
        return ANDROID_MODEL[(int) (Math.random() * ANDROID_MODEL.length)];
    }

    public static String randomMANUFACTURER() {
        return CPU_MANUFACTURER[(int) (Math.random() * CPU_MANUFACTURER.length)];
    }

    public static String randomCPU() {
        return CPU_TYPE[(int) (Math.random() * CPU_TYPE.length)];
    }
}
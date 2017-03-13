package de.dhbw.studienarbeit.hearItApp;

import java.util.LinkedHashMap;

/**
 * Created by mpressl on 3/6/2017.
 */

public class Constants {

    public static final int RESULT_SPEECH = 1;

    /** Factory options for speech recognition **/
    public static final int RECORDER_NATIVE_MIC = 0;
    public static final int RECORDER_ANDROID_VOICE_CLIENT = 1;
    public static final int RECORDER_TEXT_FIELD_CLIENT = 999;

    public static final String RECORDER_NATIVE_MIC_TEXT = "Google Cloud Recorder";
    public static final String RECORDER_ANDROID_VOICE_CLIENT_TEXT = "Android Voice Recorder";
    public static final String RECORDER_TEXT_FIELD_CLIENT_TEXT = "Text Field Recorder";

    public static final LinkedHashMap<String, Integer> RECORDER_MAP = createRecorderMap();

    private static LinkedHashMap<String, Integer> createRecorderMap()
    {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put(RECORDER_ANDROID_VOICE_CLIENT_TEXT, RECORDER_ANDROID_VOICE_CLIENT);
        map.put(RECORDER_NATIVE_MIC_TEXT, RECORDER_NATIVE_MIC);
        map.put(RECORDER_TEXT_FIELD_CLIENT_TEXT, RECORDER_TEXT_FIELD_CLIENT);
        return map;
    }

    /** Factory options for AR printer variants **/
    public static final int PRINTER_GLASSUP_AR = 0;
    public static final int PRINTER_TEXT_FILED = 1;

    public static final String PRINTER_TEXT_FIELD_TEXT = "Print To Local Text Field";
    public static final String PRINTER_GLASSUP_AR_TEXT = "GlassUp AR Glass Printer";

    public static final LinkedHashMap<String, Integer> PRINTER_MAP = createPrinterMap();

    private static LinkedHashMap<String, Integer> createPrinterMap()
    {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put(PRINTER_GLASSUP_AR_TEXT, PRINTER_GLASSUP_AR);
        map.put(PRINTER_TEXT_FIELD_TEXT, PRINTER_TEXT_FILED);
        return map;
    }

    public static final int REQUEST_APP_PERMISSIONS = 100;

}

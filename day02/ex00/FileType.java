package ex00;

import java.util.HashMap;
import java.util.Map;

public class FileType {
    public static Map<String, String> signal = new HashMap<>();
    public static void fillMap(String inputStream) throws Exception {
        String[] signalList = inputStream.split("\\,");
        signal.put(signalList[1].replace(" ", "").toLowerCase(), signalList[0]);
    }
}


package buylistapp.data.driver.deviceinfo;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeviceIDID {
    @SneakyThrows
    public static List<String> getUDIDs() {
        BufferedReader reader;
        Process process = Runtime.getRuntime().exec("adb devices");
        process.waitFor();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String allLines = reader.lines().collect(Collectors.toList()).stream().filter(str -> str.matches(".*\\d.*")).map(str -> str + " ").collect(Collectors.joining());
        String[] splitLines = allLines.replaceAll("device", "").split(" ");
        return Arrays.stream(splitLines).filter(str -> str.matches(".*\\d.*")).map(str -> str.replaceAll("\\s", "")).collect(Collectors.toList());
    }

    public static String getUDIDById(int id) {
        return getUDIDs().get(id);
    }
}

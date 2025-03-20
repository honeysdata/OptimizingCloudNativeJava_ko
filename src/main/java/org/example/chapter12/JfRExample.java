package org.example.chapter12;

import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class JfRExample {
    public static void main(String[] args) throws IOException {
        String fileName = "sample.jfr";
        var recording = new RecordingFile(Paths.get(fileName));
        while (recording.hasMoreEvents()) {
            RecordedEvent event = recording.readEvent();
            if (event != null) {
                var details = decodeEvent(event);
                if (details == null) {
                    System.err.println("Failed to recognize details");
                } else {
                    // We'd process details here, for now just log
                    System.out.println(details);
                }
            }
        }

    }
    public static Map<String, String> decodeEvent(final RecordedEvent e) {
        for (var ent : mappers.entrySet()) {
            if (ent.getKey().test(e)) {
                return ent.getValue().apply(e);
            }
        }
        return null;
    }

    private static Predicate<RecordedEvent> makePredicate(String s) {
        return e -> e.getEventType().getName().startsWith(s);
    }

    private static final Map<Predicate<RecordedEvent>,
            Function<RecordedEvent, Map<String, String>>> mappers =
            Map.of(makePredicate("jdk.CPULoad"),
                    ev -> Map.of("timestamp", ""+ ev.getStartTime(),
                            "user", ""+ ev.getDouble("jvmUser"),
                            "system", ""+ ev.getDouble("jvmSystem"),
                            "total", ""+ ev.getDouble("machineTotal")
                    ));

}

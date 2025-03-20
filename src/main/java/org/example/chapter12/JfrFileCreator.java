package org.example.chapter12;

import jdk.jfr.*;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class JfrFileCreator {
    public static void main(String[] args) throws IOException, InterruptedException {
        // JFR 레코딩 시작
        Recording recording = new Recording();
        recording.start();

        // CPU 사용량 샘플링
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        for (int i = 0; i < 5; i++) {
            // CPU 사용량 이벤트 기록 (jdk.CPULoad와 유사)
            JdkCPULoadEvent event = new JdkCPULoadEvent();
            event.jvmUser = Math.random() * 100; // JVM User CPU 사용량 (임의의 값)
            event.jvmSystem = Math.random() * 100; // JVM System CPU 사용량 (임의의 값)
            event.machineTotal = Math.random() * 100; // 전체 CPU 사용량 (임의의 값)
            event.commit();

            // 1초 대기
            TimeUnit.SECONDS.sleep(1);
        }

        // JFR 파일 저장
        Path jfrPath = Paths.get("sample.jfr");
        recording.dump(jfrPath);
        recording.stop();

        System.out.println("JFR 덤프 파일이 생성되었습니다: " + jfrPath.toAbsolutePath());
    }

    @Name("jdk.CPULoad")
    @Label("JDK CPU Load Event")
    @Category("System")
    @StackTrace(false)
    static class JdkCPULoadEvent extends Event {
        @Label("JVM User CPU Load")
        double jvmUser;

        @Label("JVM System CPU Load")
        double jvmSystem;

        @Label("Machine Total CPU Load")
        double machineTotal;
    }
}

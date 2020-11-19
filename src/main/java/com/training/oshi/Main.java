package com.training.oshi;

import org.hyperic.sigar.Sigar;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;

import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();

        Sigar sigar = new Sigar();

        while (true) {
//            System.out.println("CPU usage : " +
//                    (processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100));
            List<NetworkIF> networkIFs = hardware.getNetworkIFs();
            System.out.format("CPU load: %.1f%%\n", processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100);
            System.out.println("Network: " + networkIFs.get(2).getBytesRecv());
            sleep(1000);
        }
    }
}
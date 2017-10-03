package lesson4;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by entony on 31.07.17.
 */
public class GCMonitor {
    static long startTIme;
    static HashMap<String, ArrayList<Long>> logs = new HashMap<>();

    static void printLogs(){
        long lifeTime = System.currentTimeMillis() - startTIme;
        System.out.println("    ==============LOGS=============");
        for (String name : logs.keySet()) {
            ArrayList<Long> list = logs.get(name);
            long totalTime = list.stream().mapToLong(Long::longValue).sum();
            System.out.println("    GC name: " + name +
                    ", runs: " + list.size() +
                    ", total duration and lifetime: " + totalTime +
                    "ms/" + lifeTime + "ms");
        }
        System.out.println("    ==============END==============");
    }

    public void run(){
        startTIme = System.currentTimeMillis();
        List<GarbageCollectorMXBean> gcBeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();

        for (GarbageCollectorMXBean gcBean: gcBeans){
            NotificationEmitter emitter = (NotificationEmitter) gcBean;

            logs.put(gcBean.getName(),new ArrayList<>());

            NotificationListener listener = (notification, handback) -> {
                if (GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION.equals(notification.getType())){
                    GarbageCollectionNotificationInfo gcInfo = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
                    String name = gcInfo.getGcName();
                    long duration = gcInfo.getGcInfo().getDuration();
                    logs.get(name).add(duration);
                }
            };
            emitter.addNotificationListener(listener,null,null);
        }
    }
}

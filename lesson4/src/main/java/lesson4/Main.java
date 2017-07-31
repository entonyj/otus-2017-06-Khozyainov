package lesson4;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by entony on 29.07.17.
 *
 *  MEMORY="-Xms32m -Xmx32m"

        1)GC="-XX:+UseSerialGC"
            GC name: Copy,                runs: 6,  total duration and lifetime: 93ms/138843ms
            GC name: MarkSweepCompact,    runs: 12, total duration and lifetime: 1955ms/138843ms

        2)GC="-XX:+UseParallelGC"
            GC name: PS Scavenge,         runs: 4, total duration and lifetime:  87ms/130038ms
            GC name: PS MarkSweep,        runs: 7, total duration and lifetime:  2822ms/130038ms

        3)GC="-XX:+UseConcMarkSweepGC -XX:+UseParNewGC"
            GC name: ParNew,              runs: 6,  total duration and lifetime: 338ms/83042ms
            GC name: ConcurrentMarkSweep, runs: 29, total duration and lifetime: 26264ms/83042ms

        4)GC="-XX:+UseG1GC"
            GC name: G1 Young Generation, runs: 45, total duration and lifetime: 782ms/61864ms
            GC name: G1 Old Generation,   runs: 11, total duration and lifetime: 1299ms/61864ms
 *
 */
public class Main {
    public static void main(String[] args) {
        GCMonitor gcMonitor = new GCMonitor();
        Stand stand = new Stand(50000);
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                GCMonitor.printLogs();
            }
        }, 10000, 30000);

        gcMonitor.run();
        try {
            stand.run();
        } finally {
            GCMonitor.printLogs();
            timer.cancel();
        }
    }
}

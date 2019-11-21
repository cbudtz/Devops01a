package data;

import io.prometheus.client.Counter;
import io.prometheus.client.hotspot.*;

public class Metrics {
    public final static Counter attemptCounter = Counter.build().name("loginAttempts").help("Total Login Attempts").register();
    public final static Counter failCounter = Counter.build().name("loginFails").help("Total Failed Attempts").register();
    public final static StandardExports standardExports= new StandardExports().register();
    public final static MemoryPoolsExports memoryPoolsExports =  new MemoryPoolsExports().register();
    public final static MemoryAllocationExports memoryAlocationExports = new MemoryAllocationExports().register();
    public final static BufferPoolsExports bufferPoolsExports = new BufferPoolsExports().register();
    public final static GarbageCollectorExports garbageCollectorExports = new GarbageCollectorExports().register();
    public final static ThreadExports threadExports = new ThreadExports().register();
    public final static ClassLoadingExports classLoadingExports= new ClassLoadingExports().register();
    public final static VersionInfoExports versionInfoExports = new VersionInfoExports().register();
}

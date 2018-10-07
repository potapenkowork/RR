package utility;

public final class ResourcePoolFactory {

    public static <R> ResourcePool<R> getInstance() {
        return new ResourcePoolImpl<>();
    }

    /**
     * No instance expected.
     * Should be changed for DI.
     */
    private ResourcePoolFactory() {}
}

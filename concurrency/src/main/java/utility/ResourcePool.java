package utility;

import java.util.concurrent.TimeUnit;

/**
 * Thread-safe resource pool for generic types.
 * {@link #acquire()} allowed only for open pool {@link #isOpen()} = {@code true}).
 * Default state {@link #isOpen()} = {@code false}.
 *
 * @param <R> - type of the resource.
 */
public interface ResourcePool<R> {

    /**
     * Open pool for acquire operation.
     * Non blocking operation.
     */
    void open();

    /**
     * Check if pool is open.
     * Non blocking operation.
     *
     * @return {@code true} if open, otherwise {@code false}.
     */
    boolean isOpen();

    /**
     * Close pool for acquire operation.
     * Block thread of invocation, till all resources will be returned in pool.
     * After this close pool for acquire operation.
     */
    void close();

    /**
     * Acquire resource from pool.
     * Block thread of invocation, till resource will be gained.
     *
     * @return R.
     */
    R acquire();

    /**
     * Acquire resource from pool.
     * Block thread of invocation, till resource will be gained or timeout happen.
     *
     * @param timeout  long - amount of units before acquire timeout.
     * @param timeUnit {@link TimeUnit} units for timeout.
     * @return resource of type R.
     * @throws InterruptedException if resource wasn't acquire till timeout.
     */
    R acquire(long timeout, TimeUnit timeUnit)  throws InterruptedException;

    /**
     * Release resource in pool.
     * Non blocking operation.
     *
     * @param resource R.
     */
    void release(R resource);

    /**
     * Add resource to pool.
     * Non blocking operation.
     *
     * @param resource R.
     * @return {@code true} if pool was modified, otherwise {@code false}.
     */
    boolean add(R resource);

    /**
     * Remove resource from pool.
     * Block thread of invocation till resource will be {@link #release(Object)}.
     *
     * @param resource R.
     * @return {@code true} if pool was modified, otherwise {@code false}.
     */
    boolean remove(R resource);

    /**
     * Remove resource from pool.
     * Non blocking version.
     *
     * @param resource R.
     * @return {@code true} if pool was modified, otherwise {@code false}.
     */
    boolean removeNow(R resource);

    /**
     * Close pool for acquire operation.
     * Non blocking version.
     */
    void closeNow();
}

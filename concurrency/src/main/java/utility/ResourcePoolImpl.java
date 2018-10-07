package utility;

import java.util.concurrent.TimeUnit;

class ResourcePoolImpl<R> implements ResourcePool<R> {

    @Override
    public void open() {}

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void close() {}

    @Override
    public R acquire() {
        return null;
    }

    @Override
    public R acquire(long timeout, TimeUnit timeUnit) throws InterruptedException {
        return null;
    }

    @Override
    public void release(R resource) {}

    @Override
    public boolean add(R resource) {
        return false;
    }

    @Override
    public boolean remove(R resource) {
        return false;
    }

    @Override
    public boolean removeNow(R resource) {
        return false;
    }

    @Override
    public void closeNow() {}
}

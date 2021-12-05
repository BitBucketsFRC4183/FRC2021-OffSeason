package frc.robot.subsystems.vision.provider;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Vision decorator with caching functionality
 */
public class InvalidatableCachingVision implements Vision, Invalidatable {

    static class CoordsAndLastUpdate {
        final Coordinates coordinates;
        final long timestamp;

        CoordsAndLastUpdate(Coordinates coordinates, long timestamp) {
            this.coordinates = coordinates;
            this.timestamp = timestamp;
        }
    }

    private final Vision delegate;
    private final Duration timeBetweenInvalidation;
    private final AtomicReference<CoordsAndLastUpdate> last = new AtomicReference<>(); //basically a volatile coordinates + sugar

    public InvalidatableCachingVision(Vision delegate, Duration timeBetweenInvalidation) {

        this.delegate = delegate;
        this.timeBetweenInvalidation = timeBetweenInvalidation;
    }

    @Override
    public Coordinates getCoordinates() {
        var calu = last.updateAndGet(old -> {

            long now = System.currentTimeMillis();

            //FIXME someone please check the math here, i work with objects and traits not longs and millis
            if (old == null || now - old.timestamp > timeBetweenInvalidation.toMillis()) {
                return new CoordsAndLastUpdate(delegate.getCoordinates(), now);
            }

            return old;
        });

        return calu.coordinates; //"getters" are not encapsulation. Do not suggest them to me here or i will send you a yegor blogpost.
    }

    @Override
    public boolean hasValidTarget() {
        return delegate.hasValidTarget();
    }

    @Override
    public void setLights(boolean enabled) {
        delegate.setLights(enabled);
    }

    //manually invalidate, in case you need this functionality. Likely no one will/should
    @Override
    public void invalidate() {
        last.set(null); //TODO thread safety checks
    }
}

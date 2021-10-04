package frc.robot.subsystems.vision.provider;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Vision decorator with caching functionality (fixme requires implementation)
 */
public class CachingVision implements Vision{

    private final Vision delegate;
    private final AtomicReference<Coordinates> last = new AtomicReference<>(); //TODO

    public CachingVision(Vision delegate) {
        this.delegate = delegate;
    }

    @Override
    public Optional<Coordinates> getCoordinatesInstant() {
        return delegate.getCoordinatesInstant(); //TODO scalar cache to last, time based invalidation
    }

    @Override
    public boolean hasValidTarget() {
        return delegate.hasValidTarget();
    }

    @Override
    public void setLights(boolean enabled) {
        delegate.setLights(enabled);
    }
}

package com.example.taco;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.concurrent.atomic.AtomicLong;

@Service
@ManagedResource
public class TacoCounter2
        extends AbstractRepositoryEventListener<Taco>
        implements NotificationPublisherAware {
    private AtomicLong counter = new AtomicLong();
    private NotificationPublisher np;

    @Override
    public void setNotificationPublisher(NotificationPublisher np) {
        this.np = np;
    }

    @ManagedOperation
    public long increment(long delta) {
        long before = counter.get();
        long after = counter.addAndGet(delta);
        if ((after / 100) > (before / 100)) {
            Notification notification = new Notification(
                    "taco.count", this,
                    before, after + "th taco created!");
            np.sendNotification(notification);
        }
        return after;
    }
}
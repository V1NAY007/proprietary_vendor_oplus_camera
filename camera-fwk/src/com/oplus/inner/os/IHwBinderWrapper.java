package com.oplus.inner.os;

public class IHwBinderWrapper {
    public interface DeathRecipient {
        void serviceDied(long cookie);
    }

    public static class DeathRecipientWrapper {
        public DeathRecipientWrapper() {}
        public void serviceDied(long cookie) {}
    }
}

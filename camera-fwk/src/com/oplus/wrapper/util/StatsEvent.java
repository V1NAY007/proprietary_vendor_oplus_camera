package com.oplus.wrapper.util;

public class StatsEvent {
    private final android.util.StatsEvent mStatsEvent;

    public StatsEvent(android.util.StatsEvent statsEvent) {
        mStatsEvent = statsEvent;
    }

    public android.util.StatsEvent getStatsEvent() {
        return mStatsEvent;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final android.util.StatsEvent.Builder mBuilder;

        public Builder() {
            mBuilder = android.util.StatsEvent.newBuilder();
        }

        public Builder setAtomId(int atomId) {
            if (mBuilder != null) {
                mBuilder.setAtomId(atomId);
            }
            return this;
        }

        public Builder writeInt(int value) {
            if (mBuilder != null) {
                mBuilder.writeInt(value);
            }
            return this;
        }

        public Builder writeLong(long value) {
            if (mBuilder != null) {
                mBuilder.writeLong(value);
            }
            return this;
        }

        public Builder writeBoolean(boolean value) {
            if (mBuilder != null) {
                mBuilder.writeBoolean(value);
            }
            return this;
        }

        public Builder writeString(String value) {
            if (mBuilder != null) {
                mBuilder.writeString(value);
            }
            return this;
        }

        public Builder usePooledBuffer() {
            if (mBuilder != null) {
                mBuilder.usePooledBuffer();
            }
            return this;
        }

        public StatsEvent build() {
            return new StatsEvent(mBuilder != null ? mBuilder.build() : null);
        }
    }
}

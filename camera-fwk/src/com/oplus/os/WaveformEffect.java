package com.oplus.os;

public class WaveformEffect {
    public static class Builder {
        public Builder() {}
        public Builder setEffectType(int type) { return this; }
        public Builder setEffectStrength(int strength) { return this; }
        public Builder setAsynchronous(boolean async) { return this; }
        public Builder setStrengthSettingEnabled(boolean enabled) { return this; }
        public WaveformEffect build() { return new WaveformEffect(); }
    }
}

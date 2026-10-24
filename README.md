# OPlus Camera & Gallery Stack (`vendor/oplus/camera`)

Modular, self-contained stock OPlus Camera and Gallery stack for AOSP and LineageOS custom ROMs.

---

## Features
* **Stock OPlus Camera App**: Prebuilt `com.oplus.camera` with ColorOS imaging features, super night mode, portrait modes, super EIS video stabilization, multi-video, and pro mode.
* **Stock OnePlus Gallery App**: Prebuilt `OppoGallery2` (`com.oneplus.gallery`) providing full gallery viewing, editing, burst photos, live photos, and Google Lens OEM image integration.
* **Self-Contained Framework**: Built-in `oplus-camera-fwk` stub framework providing all necessary `IOplusCameraManager`, display, device state, and windowing interfaces required by the OPlus Camera unit SDK.
* **Automated SDK Patcher**: Automated smali and dex bytecode patching inside `extract-files.py` to ensure seamless AOSP compatibility without crashing on missing ColorOS system services.
* **Camera HAL & Composer Shims**: Built-in `libcamera_device_shim` and `libgui_shim_opluscamera` for backward-compatible HIDL CameraDevice constructors on Android 15+ and smooth preview callbacks without patching ROM frameworks.
* **Modular SELinux Policy**: Dedicated `opluscamera_app` domain with appropriate permissions, self-contained inside `sepolicy/` so device trees don't get polluted or conflict with default camera apps (e.g. Aperture).
* **Automatic VINTF Matrix**: Declares `vendor.oplus.hardware.virtual_device.camera.manager@1.0` directly via `opluscamera.mk` without device tree manual declarations.
* **Universal & Modular**: Zero patches required in ROM source trees (`hardware/interfaces` or `frameworks/base`). Can be included or omitted cleanly via a single `device.mk` line.

---

## How to Include in Device Tree

1. **Clone this repository to `vendor/oplus/camera`**:
   ```bash
   git clone https://gitlab.com/almightygodthor/proprietary_vendor_oplus_camera.git -b lineage-23.2 vendor/oplus/camera
   ```

2. **Inherit in your device's `device.mk`**:
   ```makefile
   # OPlus Camera & Gallery
   $(call inherit-product-if-exists, vendor/oplus/camera/opluscamera.mk)
   ```

* **Note**: That single line is all that's required! `opluscamera.mk` automatically declares its own VINTF compatibility matrix, SELinux policy directories, camera package configs, and default camera properties. No edits in `BoardConfig.mk`, device tree `sepolicy/`, or `device_framework_matrix.xml` are needed.

---

## Regenerating Blobs

To regenerate the prebuilt proprietary files from a stock firmware dump:
```bash
./extract-files.py /path/to/dump
```
* Note: `extract-files.py` safely isolates extraction to `proprietary/`, preserving all committed framework source, shims, overlays, and SELinux policies.

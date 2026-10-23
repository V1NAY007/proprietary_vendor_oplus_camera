# OPlus Camera Stack (vendor/oplus/camera)

Modular, prebuilt stock OPlus Camera stack for AOSP and LineageOS custom ROM builds.

---

## Features
* **Stock OPlus Camera App**: Prebuilt `com.oplus.camera` with ColorOS imaging features, portrait modes, night mode, and video stabilization.
* **Stock OnePlus Gallery App**: Prebuilt `OppoGallery2` (`com.oneplus.gallery`) providing full gallery, preview, editor, and Google Lens OEM image integration.
* **Self-Contained Framework**: Built-in `oplus-camera-fwk` stub framework providing all necessary `IOplusCameraManager`, display, and windowing interfaces required by the OPlus Camera unit SDK.
* **Surface Composer Shims**: Built-in `libgui_shim_opluscamera` for smooth preview and blur effects without patching ROM frameworks.
* **Clean SEPolicy**: Dedicated `opluscamera_app` domain with appropriate `privapp_data_file` and binder permissions.
* **Universal Build Support**: Uses standard AOSP Soong boolean configuration rules (`soong_config_set_bool`) with zero required patches in ROM source trees.

---

## How to Include in Device Tree

1. **Clone this repository to `vendor/oplus/camera`**:
   ```bash
   git clone <repo_url> vendor/oplus/camera
   ```

2. **Inherit in your device's `device.mk`**:
   ```makefile
   # OPlus Camera
   TARGET_DEVICE_HAS_OPLUS_CAMERA ?= true
   ifeq ($(TARGET_DEVICE_HAS_OPLUS_CAMERA),true)
   $(call inherit-product-if-exists, vendor/oplus/camera/opluscamera.mk)
   endif
   ```

3. **Required Device-Side Properties** (e.g. in `vendor.prop` or `system.prop`):
   ```properties
   # Camera package
   persist.vendor.camera.privapp.list=com.oplus.camera
   ro.com.google.lens.oem_camera_package=com.oplus.camera

   # Sensor resolutions (customize for your device)
   ro.vendor.oplus.camera.backCamSize=50MP+8MP+2MP
   ro.vendor.oplus.camera.frontCamSize=16MP

   # Cutout / holepunch offset (x1,y1:x2,y2)
   ro.oplus.display.screenhole.positon=511,33:569,91
   ```

4. **VINTF Matrix**:
   Ensure `device_framework_matrix.xml` contains the virtual camera manager interface:
   ```xml
   <hal format="hidl" optional="true">
       <name>vendor.oplus.hardware.virtual_device.camera.manager</name>
       <version>1.0</version>
       <interface>
           <name>IVirtualCameraManager</name>
           <instance>default</instance>
       </interface>
   </hal>
   ```

---

## Regenerating Blobs

To regenerate the prebuilt proprietary files from a stock firmware dump:
```bash
./extract-files.py <path_to_dump>
```
* Note: `extract-files.py` safely isolates extraction to `proprietary/`, preserving all committed framework source, shims, overlays, and SELinux policies.

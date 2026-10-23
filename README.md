# OPlus Camera & Gallery Stack (`vendor/oplus/camera`)

Modular, self-contained stock OPlus Camera and Gallery stack for AOSP and LineageOS custom ROMs.

---

## Features
* **Stock OPlus Camera App**: Prebuilt `com.oplus.camera` with ColorOS imaging features, super night mode, portrait modes, super EIS video stabilization, multi-video, and pro mode.
* **Stock OnePlus Gallery App**: Prebuilt `OppoGallery2` (`com.oneplus.gallery`) providing full gallery viewing, editing, burst photos, live photos, and Google Lens OEM image integration.
* **Self-Contained Framework**: Built-in `oplus-camera-fwk` stub framework providing all necessary `IOplusCameraManager`, display, device state, and windowing interfaces required by the OPlus Camera unit SDK.
* **Automated SDK Patcher**: Automated smali and dex bytecode patching inside `extract-files.py` to ensure seamless AOSP compatibility without crashing on missing ColorOS system services.
* **Surface Composer Shims**: Built-in `libgui_shim_opluscamera` for smooth preview and buffer detached callbacks without patching ROM frameworks.
* **Clean SELinux Policy**: Dedicated `opluscamera_app` domain with appropriate `privapp_data_file`, binder, HAL, and property permissions.
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

3. **Required Device-Side Properties** (e.g. in `vendor.prop` or `system.prop`):
   ```properties
   # Camera package
   persist.vendor.camera.privapp.list=com.oplus.camera
   ro.com.google.lens.oem_camera_package=com.oplus.camera
   ro.oplus.system.camera.name=com.oplus.camera
   ro.oplus.camera.speechassist=true
   ro.oplus.camera.defercap.support=true
   ro.oplus.camera.defercap.all.quick.visible.support=true
   ro.oplus.camera.quickshare.support=true

   # Sensor resolutions (customize for your device, e.g. GT Neo 3):
   ro.vendor.oplus.camera.backCamSize=50MP+8MP+2MP
   ro.vendor.oplus.camera.frontCamSize=16MP
   ro.vendor.oplus.camera.isSupportExplorer=0
   ro.vendor.oplus.camera.isHasselbladCamera=0
   oplus.software.camera.10bit=1
   ```

4. **VINTF Compatibility Matrix**:
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
./extract-files.py /path/to/dump
```
* Note: `extract-files.py` safely isolates extraction to `proprietary/`, preserving all committed framework source, shims, overlays, and SELinux policies.

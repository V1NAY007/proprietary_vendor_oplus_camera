# Inherit from camera-vendor.mk
$(call inherit-product, vendor/oplus/camera/camera-vendor.mk)

# Blob dependencies
PRODUCT_PACKAGES += \
    android.hardware.graphics.common-V3-ndk.vendor

# Packages
PRODUCT_PACKAGES += \
    OplusCameraOverlayIcon \
    libgui_shim_opluscamera \
    oplus-camera-fwk

# Init
PRODUCT_PACKAGES += \
    init.oplus.camera.rc

# Permissions
PRODUCT_COPY_FILES += \
    vendor/oplus/camera/configs/permissions/com.oplus.camera.unit.sdk.xml:$(TARGET_COPY_OUT_SYSTEM_EXT)/etc/permissions/com.oplus.camera.unit.sdk.xml \
    vendor/oplus/camera/configs/permissions/default-permissions-com.oplus.camera.xml:$(TARGET_COPY_OUT_SYSTEM_EXT)/etc/default-permissions/default-permissions-com.oplus.camera.xml \
    vendor/oplus/camera/configs/permissions/privapp-permissions-opluscamera.xml:$(TARGET_COPY_OUT_SYSTEM_EXT)/etc/permissions/privapp-permissions-opluscamera.xml \
    vendor/oplus/camera/configs/permissions/opluscamera-hiddenapi-package-allowlist.xml:$(TARGET_COPY_OUT_SYSTEM_EXT)/etc/sysconfig/opluscamera-hiddenapi-package-allowlist.xml \
    vendor/oplus/camera/configs/permissions/oplus_google_lens_config.xml:$(TARGET_COPY_OUT_SYSTEM_EXT)/etc/permissions/oplus_google_lens_config.xml \
    vendor/oplus/camera/configs/permissions/privapp-permissions-oplus.xml:$(TARGET_COPY_OUT_SYSTEM_EXT)/etc/permissions/privapp-permissions-oplus.xml \
    vendor/oplus/camera/configs/sysconfig/hiddenapi-package-oplus-whitelist.xml:$(TARGET_COPY_OUT_SYSTEM)/etc/sysconfig/hiddenapi-package-oplus-whitelist.xml

# Properties
PRODUCT_PRODUCT_PROPERTIES += \
    persist.vendor.camera.privapp.list=com.oplus.camera \
    ro.com.google.lens.oem_camera_package=com.oplus.camera \
    ro.com.google.lens.oem_image_package=com.oneplus.gallery

# Photo
$(call soong_config_set,camera,package_name,com.oplus.camera)

# Video
$(call soong_config_set_bool,camera,override_format_from_reserved,true)

# SEpolicy
include vendor/oplus/camera/sepolicy/SEPolicy.mk

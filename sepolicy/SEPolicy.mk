#
# Copyright (C) 2024 The Nameless-AOSP Project
#
# SPDX-License-Identifier: Apache-2.0
#

BOARD_VENDOR_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/vendor

# MediaTek platforms
ifneq ($(filter %zephyr %21861 %mt6895 mt% mt6895%,$(TARGET_PRODUCT) $(TARGET_BOARD_PLATFORM) $(BOARD_PLATFORM) $(TARGET_DEVICE) $(PRODUCT_DEVICE)),)
BOARD_VENDOR_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/vendor_mtk
endif

# Qualcomm platforms
ifneq ($(filter sm% qcom% lahaina% taroko% kalama% %taro %kalama %lahaina,$(TARGET_PRODUCT) $(TARGET_BOARD_PLATFORM) $(BOARD_PLATFORM)),)
BOARD_VENDOR_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/vendor_qcom
endif

SYSTEM_EXT_PRIVATE_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/private

SYSTEM_EXT_PUBLIC_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/public

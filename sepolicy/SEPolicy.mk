#
# Copyright (C) 2024 The Nameless-AOSP Project
#
# SPDX-License-Identifier: Apache-2.0
#

# Only include Qualcomm-specific fastrpc/dsp vendor rules on Qualcomm platforms
ifneq ($(filter qcom,$(TARGET_BOARD_PLATFORM) $(BOARD_USES_QCOM_HARDWARE)),)
BOARD_VENDOR_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/vendor
endif

SYSTEM_EXT_PRIVATE_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/private

SYSTEM_EXT_PUBLIC_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/public

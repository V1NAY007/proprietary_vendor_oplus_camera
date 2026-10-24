#
# Copyright (C) 2024 The Nameless-AOSP Project
#
# SPDX-License-Identifier: Apache-2.0
#

BOARD_VENDOR_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/vendor

ifneq ($(filter mt%,$(TARGET_BOARD_PLATFORM)),)
BOARD_VENDOR_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/vendor_mtk
endif

SYSTEM_EXT_PRIVATE_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/private

SYSTEM_EXT_PUBLIC_SEPOLICY_DIRS += \
    vendor/oplus/camera/sepolicy/public

#!/usr/bin/env -S PYTHONPATH=../../../tools/extract-utils python3
# SPDX-FileCopyrightText: 2024 The LineageOS Project
# SPDX-License-Identifier: Apache-2.0

import os
import shutil

from extract_utils.fixups_blob import (
    blob_fixup,
    blob_fixups_user_type,
)
from extract_utils.fixups_lib import (
    lib_fixups,
    lib_fixups_user_type,
)
from extract_utils.main import (
    ExtractUtils,
    ExtractUtilsModule,
)

namespace_imports = [
    'hardware/oplus',
    'vendor/oplus/camera',
]


def lib_fixup_system_ext_suffix(lib: str, partition: str, *args, **kwargs):
    return f'{lib}_{partition}' if partition == 'system_ext' else None


lib_fixups: lib_fixups_user_type = {
    **lib_fixups,
    (
        'libSuperTextWrapper',
        'libXDocProcessSDK',
        'libYTCommon',
        'libmpbase',
    ): lib_fixup_system_ext_suffix,
}

blob_fixups: blob_fixups_user_type = {
    (
        'system_ext/lib64/libAPSClient-cmd-jni.so',
        'system_ext/lib64/libHeifEncoderWrapper.so',
        'system_ext/lib64/libNativeWinBuffExchange.so',
        'system_ext/lib64/liboplusheifwriter.so',
    ): blob_fixup()
        .add_needed('libgui_shim_opluscamera.so'),
}


class CameraExtractUtilsModule(ExtractUtilsModule):
    """Custom module that only cleans the proprietary directory, preserving source files."""

    def cleanup(self):
        proprietary_dir = os.path.join(self.vendor_path, 'proprietary')
        if os.path.exists(proprietary_dir):
            shutil.rmtree(proprietary_dir)
        for proprietary_file in self.proprietary_files:
            vendor_path = self.proprietary_file_vendor_path(proprietary_file)
            os.makedirs(vendor_path, exist_ok=True)
        if self.rro_packages:
            os.makedirs(self.vendor_rro_path, exist_ok=True)


module = CameraExtractUtilsModule(
    'camera',
    'oplus',
    device_rel_path='vendor/oplus/camera',
    blob_fixups=blob_fixups,
    lib_fixups=lib_fixups,
    namespace_imports=namespace_imports,
    check_elf=False,
)

if __name__ == '__main__':
    utils = ExtractUtils.device(module)
    utils.run()

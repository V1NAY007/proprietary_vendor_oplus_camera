#!/usr/bin/env -S PYTHONPATH=../../../tools/extract-utils python3
# SPDX-FileCopyrightText: 2024 The LineageOS Project
# SPDX-License-Identifier: Apache-2.0

import os
import shutil
import subprocess
import tempfile
import zipfile

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


def patch_camera_unit_sdk(ctx, file, file_path, *args, **kwargs):
    with tempfile.TemporaryDirectory() as tmp_dir:
        classes_dex = os.path.join(tmp_dir, 'classes.dex')
        with zipfile.ZipFile(file_path, 'r') as zin:
            zin.extract('classes.dex', tmp_dir)
        smali_dir = os.path.join(tmp_dir, 'smali')
        subprocess.check_call(['baksmali', 'd', classes_dex, '-o', smali_dir])

        cui_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/appinterface/CameraUnitInterface.smali')
        if os.path.exists(cui_path):
            with open(cui_path, 'r') as f:
                cui = f.read()
            if 'initialize(Landroid/content/Context;Lcom/oplus/ocs/camera/appinterface/ApsStateCallback;)V' not in cui:
                cui += '\n.method public abstract initialize(Landroid/content/Context;Lcom/oplus/ocs/camera/appinterface/ApsStateCallback;)V\n.end method\n'
            cui_methods = [
                'updateRequestedDecisionResultLockState(Z)V',
                'addDeferJobParam(Landroid/media/ImageReader;Landroid/media/Image;Landroid/hardware/camera2/CaptureResult;Ljava/util/Map;)V',
                'addDeferJobParam(Landroid/media/ImageReader;Landroid/media/Image;Ljava/util/Map;)V',
                'addSnapShotBuffer(Ljava/util/Map;)V',
                'collectFluencyData()Ljava/lang/String;',
                'discardFreeBuffersImageReader()V',
                'getRequestedPreviewResult()Lcom/oplus/ocs/camera/appinterface/CameraPreviewCallbackAdapter$PreviewResult;',
            ]
            for m in cui_methods:
                if m not in cui:
                    cui += f'\n.method public abstract {m}\n.end method\n'
            with open(cui_path, 'w') as f:
                f.write(cui)

        cui_impl_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/CameraUnitImpl.smali')
        if os.path.exists(cui_impl_path):
            with open(cui_impl_path, 'r') as f:
                impl = f.read()
            if 'initialize(Landroid/content/Context;Lcom/oplus/ocs/camera/appinterface/ApsStateCallback;)V' not in impl:
                impl += '''
.method public initialize(Landroid/content/Context;Lcom/oplus/ocs/camera/appinterface/ApsStateCallback;)V
    .registers 3
    invoke-virtual {p0, p1}, Lcom/oplus/ocs/camera/CameraUnitImpl;->initialize(Landroid/content/Context;)V
    if-eqz p2, :cond_a
    invoke-interface {p2}, Lcom/oplus/ocs/camera/appinterface/ApsStateCallback;->onApsConnected()V
    :cond_a
    return-void
.end method
'''
            if 'updateRequestedDecisionResultLockState(Z)V' not in impl:
                impl += '''
.method public updateRequestedDecisionResultLockState(Z)V
    .registers 2

    return-void
.end method
'''
            if 'addDeferJobParam(Landroid/media/ImageReader;Landroid/media/Image;Landroid/hardware/camera2/CaptureResult;Ljava/util/Map;)V' not in impl:
                impl += '''
.method public addDeferJobParam(Landroid/media/ImageReader;Landroid/media/Image;Landroid/hardware/camera2/CaptureResult;Ljava/util/Map;)V
    .registers 5

    return-void
.end method
'''
            if 'addDeferJobParam(Landroid/media/ImageReader;Landroid/media/Image;Ljava/util/Map;)V' not in impl:
                impl += '''
.method public addDeferJobParam(Landroid/media/ImageReader;Landroid/media/Image;Ljava/util/Map;)V
    .registers 4

    return-void
.end method
'''
            if 'addSnapShotBuffer(Ljava/util/Map;)V' not in impl:
                impl += '''
.method public addSnapShotBuffer(Ljava/util/Map;)V
    .registers 2

    return-void
.end method
'''
            if 'collectFluencyData()Ljava/lang/String;' not in impl:
                impl += '''
.method public collectFluencyData()Ljava/lang/String;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method
'''
            if 'discardFreeBuffersImageReader()V' not in impl:
                impl += '''
.method public discardFreeBuffersImageReader()V
    .registers 1

    return-void
.end method
'''
            if 'getRequestedPreviewResult()Lcom/oplus/ocs/camera/appinterface/CameraPreviewCallbackAdapter$PreviewResult;' not in impl:
                impl += '''
.method public getRequestedPreviewResult()Lcom/oplus/ocs/camera/appinterface/CameraPreviewCallbackAdapter$PreviewResult;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method
'''
            with open(cui_impl_path, 'w') as f:
                f.write(impl)

        cdi_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/appinterface/CameraDeviceInterface.smali')
        if os.path.exists(cdi_path):
            with open(cdi_path, 'r') as f:
                cdi = f.read()
            if 'resumeRecordingToHal(Lcom/oplus/ocs/camera/appinterface/CameraRecordingCallbackAdapter;Landroid/os/Handler;)V' not in cdi:
                cdi += '\n.method public abstract resumeRecordingToHal(Lcom/oplus/ocs/camera/appinterface/CameraRecordingCallbackAdapter;Landroid/os/Handler;)V\n.end method\n'
                with open(cdi_path, 'w') as f:
                    f.write(cdi)

        pi_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/producer/ProducerImpl.smali')
        if os.path.exists(pi_path):
            with open(pi_path, 'r') as f:
                pi = f.read()
            if 'resumeRecordingToHal(Lcom/oplus/ocs/camera/appinterface/CameraRecordingCallbackAdapter;Landroid/os/Handler;)V' not in pi:
                pi += '''
.method public resumeRecordingToHal(Lcom/oplus/ocs/camera/appinterface/CameraRecordingCallbackAdapter;Landroid/os/Handler;)V
    .registers 3

    return-void
.end method
'''
                with open(pi_path, 'w') as f:
                    f.write(pi)

        cau_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/appinterface/adapter/CameraAdapterUtils.smali')
        if os.path.exists(cau_path):
            with open(cau_path, 'r') as f:
                cau = f.read()
            cau_modified = False
            if 'forceFlushALog()I' not in cau:
                cau += '''
.method public static forceFlushALog()I
    .registers 1

    const/4 v0, 0x0

    return v0
.end method
'''
                cau_modified = True
            if 'printPrivateLog(Ljava/lang/String;Ljava/lang/String;I)I' not in cau:
                cau += '''
.method public static printPrivateLog(Ljava/lang/String;Ljava/lang/String;I)I
    .registers 3

    const/4 v0, 0x0

    return v0
.end method
'''
                cau_modified = True
            if 'setEncryptEnable(Z)V' not in cau:
                cau += '''
.method public static setEncryptEnable(Z)V
    .registers 1

    return-void
.end method
'''
                cau_modified = True
            if 'setFluencySampling(Z)V' not in cau:
                cau += '''
.method public static setFluencySampling(Z)V
    .registers 1

    return-void
.end method
'''
                cau_modified = True
            if 'setPrivateLogEnable(Z)V' not in cau:
                cau += '''
.method public static setPrivateLogEnable(Z)V
    .registers 1

    return-void
.end method
'''
                cau_modified = True
            if cau_modified:
                with open(cau_path, 'w') as f:
                    f.write(cau)

        cb_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/appinterface/ApsStateCallback.smali')
        os.makedirs(os.path.dirname(cb_path), exist_ok=True)
        with open(cb_path, 'w') as f:
            f.write('.class public interface abstract Lcom/oplus/ocs/camera/appinterface/ApsStateCallback;\n.super Ljava/lang/Object;\n.source "ApsStateCallback.java"\n\n.method public abstract onApsConnected()V\n.end method\n')

        prev_res_path = os.path.join(smali_dir, 'com', 'oplus', 'ocs', 'camera', 'appinterface', 'CameraPreviewCallbackAdapter$PreviewResult.smali')
        if os.path.exists(prev_res_path):
            with open(prev_res_path, 'r') as f:
                prev_res = f.read()
            if 'getOplusCaptureResult()Lcom/oplus/hardware/camera2/OplusCaptureResult;' not in prev_res:
                prev_res += '''
.method public getOplusCaptureResult()Lcom/oplus/hardware/camera2/OplusCaptureResult;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method
'''
                with open(prev_res_path, 'w') as f:
                    f.write(prev_res)

        cpa_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/appinterface/CameraPreviewCallbackAdapter.smali')
        if os.path.exists(cpa_path):
            with open(cpa_path, 'r') as f:
                cpa = f.read()
            cpa_modified = False
            if 'notifyPreviewResultFromHal(Lcom/oplus/hardware/camera2/OplusCaptureResult;)V' not in cpa:
                cpa += '''
.method public notifyPreviewResultFromHal(Lcom/oplus/hardware/camera2/OplusCaptureResult;)V
    .registers 2

    return-void
.end method
'''
                cpa_modified = True
            if 'onPreviewCaptureProgressed(Landroid/hardware/camera2/CaptureRequest;Lcom/oplus/hardware/camera2/OplusCaptureResult;)V' not in cpa:
                cpa += '''
.method public onPreviewCaptureProgressed(Landroid/hardware/camera2/CaptureRequest;Lcom/oplus/hardware/camera2/OplusCaptureResult;)V
    .registers 3

    return-void
.end method
'''
                cpa_modified = True
            if cpa_modified:
                with open(cpa_path, 'w') as f:
                    f.write(cpa)

        pm_path = os.path.join(smali_dir, 'com/oplus/ocs/camera/producer/mode/PortraitMode.smali')
        if os.path.exists(pm_path):
            with open(pm_path, 'r') as f:
                pm = f.read()
            first = pm.find(':cond_132')
            if first != -1:
                second = pm.find(':cond_132', first + 1)
                end = pm.find(':cond_15b', second)
                if second != -1 and end != -1:
                    replacement = ''':cond_132
    invoke-super {p0, p1, p2, p3}, Lcom/oplus/ocs/camera/producer/mode/BaseMode;->getPhysicalId(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    return v2

    :cond_15a
    const/4 v0, -0x1

    if-ne v2, v0, :cond_safe

    invoke-super {p0, p1, p2, p3}, Lcom/oplus/ocs/camera/producer/mode/BaseMode;->getPhysicalId(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    :cond_safe
    return v2

    '''
                    pm = pm[:second] + replacement + pm[end:]
                    with open(pm_path, 'w') as f:
                        f.write(pm)

        camera_smali_dir = os.path.join(os.path.dirname(__file__), 'camera-smali')
        if os.path.exists(camera_smali_dir):
            shutil.copytree(camera_smali_dir, smali_dir, dirs_exist_ok=True)

        new_dex = os.path.join(tmp_dir, 'classes_new.dex')
        subprocess.check_call(['smali', 'a', smali_dir, '-o', new_dex])
        new_jar = os.path.join(tmp_dir, 'patched.jar')
        with zipfile.ZipFile(file_path, 'r') as zin, zipfile.ZipFile(new_jar, 'w') as zout:
            for item in zin.infolist():
                if item.filename == 'classes.dex':
                    with open(new_dex, 'rb') as f:
                        zout.writestr(item, f.read())
                else:
                    zout.writestr(item, zin.read(item.filename))
        shutil.move(new_jar, file_path)


blob_fixups: blob_fixups_user_type = {
    (
        'system_ext/lib64/libAPSClient-cmd-jni.so',
        'system_ext/lib64/libAPSClient-cmd-jni-extension.oplus.so',
        'system_ext/lib64/libHeifEncoderWrapper.so',
        'system_ext/lib64/libNativeWinBuffExchange.so',
        'system_ext/lib64/liboplusheifwriter.so',
        'system_ext/lib64/libsuperNight.oplus.so',
    ): blob_fixup()
        .add_needed('libgui_shim_opluscamera.so'),
    'system_ext/etc/permissions/com.oplus.camera.unit.sdk_product.xml': blob_fixup()
        .regex_replace(r'<\? xml.*?\?>', '<?xml version="1.0" encoding="utf-8"?>')
        .regex_replace(r'/system/system_ext/', '/system_ext/')
        .regex_replace(r'<permissions>', '<permissions>\n    <library name="oplus-camera-fwk"\n        file="/system_ext/framework/oplus-camera-fwk.jar" />')
        .regex_replace(r'(<library name\s*=\s*"com\.oplus\.camera\.unit\.sdk"\s+file\s*=\s*"[^"]+")\s*/>', r'\1\n        dependency="oplus-camera-fwk" />')
        .regex_replace(r'(<library name\s*=\s*"com\.oppo\.camera\.unit\.sdk"\s+file\s*=\s*"[^"]+")\s*/>', r'\1\n        dependency="oplus-camera-fwk" />')
        .regex_replace(r'(<library name\s*=\s*"com\.oplus\.camera\.unit\.sdk\.adapter"\s+file\s*=\s*"[^"]+")\s*/>', r'\1\n        dependency="oplus-camera-fwk" />'),
    'system_ext/framework/com.oplus.camera.unit.sdk.jar': blob_fixup()
        .call(patch_camera_unit_sdk),
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

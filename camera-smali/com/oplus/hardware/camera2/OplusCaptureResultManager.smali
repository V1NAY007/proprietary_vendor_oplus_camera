.class public abstract Lcom/oplus/hardware/camera2/OplusCaptureResultManager;
.super Ljava/lang/Object;
.source "OplusCaptureResultManager.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract addResultRefCount(Lcom/oplus/hardware/camera2/OplusCaptureResult;Ljava/lang/String;)Lcom/oplus/hardware/camera2/OplusCaptureResult$CloseHandle;
.end method

.method public abstract clearOplusCaptureResults()V
.end method

.method public abstract obtainOplusCaptureResult(Landroid/hardware/camera2/CaptureResult;I)Lcom/oplus/hardware/camera2/OplusCaptureResult;
.end method

.method public abstract reduceResultRefCount(Lcom/oplus/hardware/camera2/OplusCaptureResult$CloseHandle;)V
.end method

.method public abstract removeOplusCaptureResult(Lcom/oplus/hardware/camera2/OplusCaptureResult;)V
.end method

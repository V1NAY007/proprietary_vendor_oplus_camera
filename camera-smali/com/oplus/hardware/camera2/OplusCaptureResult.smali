.class public interface abstract Lcom/oplus/hardware/camera2/OplusCaptureResult;
.super Ljava/lang/Object;
.source "OplusCaptureResult.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/oplus/hardware/camera2/OplusCaptureResult$CloseHandle;,
        Lcom/oplus/hardware/camera2/OplusCaptureResult$CaptureResultType;
    }
.end annotation


# virtual methods
.method public abstract addResultRefCount(Ljava/lang/String;)Lcom/oplus/hardware/camera2/OplusCaptureResult$CloseHandle;
.end method

.method public abstract get(Landroid/hardware/camera2/CaptureResult$Key;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/hardware/camera2/CaptureResult$Key<",
            "TT;>;)TT;"
        }
    .end annotation
.end method

.method public abstract getCameraId()Ljava/lang/String;
.end method

.method public abstract getCaptureRequest()Landroid/hardware/camera2/CaptureRequest;
.end method

.method public abstract getCaptureResult()Landroid/hardware/camera2/CaptureResult;
.end method

.method public abstract getFrameNumber()J
.end method

.method public abstract getResultType()I
.end method

.method public abstract getTimestamp()J
.end method

.method public abstract isCloseable()Z
.end method

.method public abstract isClosed()Z
.end method

.method public abstract isPreviewResult()Z
.end method

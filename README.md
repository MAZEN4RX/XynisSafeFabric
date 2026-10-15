# Xynis Safe Client UI (Fabric 1.21.11)

This is a starter Fabric client mod scaffold inspired by the uploaded XynisClient source archive. It adds a small GUI opened with **Right Shift**.

The uploaded archive consists of standalone crash-method and exploit-method Java files, not a complete Fabric mod project. Those routines have not been ported. This project intentionally contains only harmless client-side UI scaffolding.

## Build

Requires JDK 21 and internet access for Gradle dependency downloads.

From this directory, run:

```sh
gradle build
```

The output JAR should appear under `build/libs/`. The Gradle/Loom and mapping versions may need adjustment if the upstream repositories have changed since this scaffold was written. The JAR has not been built or tested in this environment.

installation
===========

`sudo aptitude install clamav libclamav-dev`

then

```
sudo freshclam
ClamAV update process started at Sun Nov 22 17:06:29 2015
WARNING: getfile: main.cvd not found on remote server (IP: 185.100.64.62)
WARNING: Can't download main.cvd from db.local.clamav.net
Trying again in 5 secs...
ClamAV update process started at Sun Nov 22 17:06:46 2015
Trying host db.local.clamav.net (62.140.250.250)...
Downloading main.cvd [100%]
main.cvd updated (version: 55, sigs: 2424225, f-level: 60, builder: neo)
Downloading daily.cvd [100%]
daily.cvd updated (version: 18319, sigs: 636605, f-level: 63, builder: neo)
Downloading bytecode.cvd [100%]
bytecode.cvd updated (version: 235, sigs: 44, f-level: 63, builder: dgoddard)
[LibClamAV] **************************************************
[LibClamAV] ***  The virus database is older than 7 days!  ***
[LibClamAV] ***   Please update it as soon as possible.    ***
[LibClamAV] **************************************************
Database updated (3060874 signatures) from db.local.clamav.net (IP: 62.140.250.250)
ERROR: NotifyClamd: Can't find or parse configuration file /etc/clamav/clamd.conf

```

After executing `freshclam` virus db might not be get updated due to dns problems or not-up-to-date mirrors. Just retry after a few minutes again.

Compilation
===========

```bash
javac VirusScanner.java Main.java
javah VirusScanner
```

then create `VirusScannerImpl.c` and implement the header file created by `javah`

```bash
JAVA_HOME=/usr/lib/jvm/java-8-oracle
gcc -shared -fpic -o libvirscan.so -I$JAVA_HOME/include -I$JAVA_HOME/include/linux VirusScannerImpl.c scan.c -lclamav
java -Djava.library.path=. Main "/your/file/to/be/scanned"
```

**Note that** `-Djava.library.path=.` is only required if you use `System.loadLibrary` in `VirusScanner.java`
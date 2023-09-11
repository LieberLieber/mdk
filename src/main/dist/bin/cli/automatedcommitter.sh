#!/bin/sh

# Usage: gov.nasa.jpl.mbee.mdk.cli.AutomatedCommitter [options]
#   Options:
#     --help, -h
#
#   * --mmsPassword
#
#   * --mmsUsername
#
#     --timeout, -t
#       Specifies the number of seconds after which the execution will be
#       attempted to be stopped.
#       Default: 0
#     --twcBranchId
#
#   * --twcHost
#
#   * --twcPassword
#
#   * --twcPort
#
#   * --twcProjectId
#
#   * --twcUsername

# This script manages the settings and configuration options
# necessary to launch a MagicDraw CommandLine program in the OSGI framework.
# This tool must be launched with the associated shell script or a similar
# manual configuration; it will not run directly.

if [ -z "$MAGICDRAW_HOME" ]; then
    echo "ERROR: MAGICDRAW_HOME environment variable not set, script cannot proceed."
    echo "Please create the environment variable and set it to the MagicDraw installation folder."
    exit 1
fi

CP_DELIM=":"
if [ -f "$MAGICDRAW_HOME"/bin/magicdraw.properties ]; then
  PROPERTIES_FILE="$MAGICDRAW_HOME"/bin/magicdraw.properties
elif [ -f "$MAGICDRAW_HOME"/bin/csm.properties ]; then
  PROPERTIES_FILE="$MAGICDRAW_HOME"/bin/csm.properties
fi
MAGICDRAW_HOME=$(echo "$MAGICDRAW_HOME" | sed -e 's/ /%20/g')
MD_CP_URL=file:$PROPERTIES_FILE?base=$MAGICDRAW_HOME#CLASSPATH

OSGI_LAUNCHER=$MAGICDRAW_HOME/$(grep -o "^CLASSPATH=.*" "$PROPERTIES_FILE" | grep -o "[^:]*com\.nomagic\.osgi\.launcher-[^\\]*.jar")
OSGI_FRAMEWORK=$MAGICDRAW_HOME/$(grep -o "^CLASSPATH=.*" "$PROPERTIES_FILE" | grep -o "[^:]*org\.eclipse\.osgi_[^\\]*.jar")
MD_OSGI_FRAGMENT=$MAGICDRAW_HOME/$(grep -o "^CLASSPATH=.*" "$PROPERTIES_FILE" | grep -o "[^:]*com\.nomagic\.magicdraw\.osgi\.fragment_[^\\]*.jar")

CP="${OSGI_LAUNCHER}${CP_DELIM}${OSGI_FRAMEWORK}${CP_DELIM}${MD_OSGI_FRAGMENT}${CP_DELIM}\
`  `$MAGICDRAW_HOME/lib/md_api.jar${CP_DELIM}$MAGICDRAW_HOME/lib/md_common_api.jar${CP_DELIM}\
`  `$MAGICDRAW_HOME/lib/md.jar${CP_DELIM}$MAGICDRAW_HOME/lib/md_common.jar${CP_DELIM}\
`  `$MAGICDRAW_HOME/lib/jna.jar"

java -Xmx8192M -Xss1024M -DLOCALCONFIG=true -DWINCONFIG=true \
       -cp "$CP" \
       -Dmd.class.path=$MD_CP_URL \
       -Dcom.nomagic.osgi.config.dir="$MAGICDRAW_HOME/configuration" \
       -Desi.system.config="$MAGICDRAW_HOME/data/application.conf" \
       -Dlogback.configurationFile="$MAGICDRAW_HOME/data/logback.xml" \
       -noverify \
       -Djsse.enableSNIExtension=false \
       -Djava.net.preferIPv4Stack=true \
       -Dcom.sun.media.imageio.disableCodecLib=true \
       -Dsun.locale.formatasdefault=true \
       -Dcom.nomagic.magicdraw.launcher=com.nomagic.magicdraw.commandline.CommandLineActionLauncher \
       -Dcom.nomagic.magicdraw.commandline.action=org.openmbee.mdk.cli.AutomatedCommitter \
       com.nomagic.osgi.launcher.ProductionFrameworkLauncher -verbose "$@"

exit $?

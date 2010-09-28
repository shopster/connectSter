# Please note:
# 1. All JAR's should be in the library subfolder.
# 2. Define your own keys and setup install.properties before running.
# 3. Ensure "create-drop" is specified in the hibernate.cfg.xml file if you want a fresh database, and unset it for future invocations.

unset CLASSPATH
export CLASSPATH=./classes:$CLASSPATH
export CLASSPATH=./library/*:$CLASSPATH
java -Djava.endorsed.dirs="./library/endorsed" connectster.server.ServerConsole --install ./install.properties

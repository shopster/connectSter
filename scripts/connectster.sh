# Start connectster normally, assumes pre-installed setup
unset CLASSPATH
export CLASSPATH=./classes:$CLASSPATH
export CLASSPATH=./library/*:$CLASSPATH
java -Djava.endorsed.dirs="./library/endorsed" connectster.server.ServerConsole

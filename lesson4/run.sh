#!/bin/bash
#
MEMORY="-Xms32m -Xmx32m"
GC="-XX:+UseG1GC"
#
java $MEMORY $GC -jar $1

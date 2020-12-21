#!/bin/sh
mongoimport -d testdb -c chords --file "/docker-entrypoint-initdb.d/ChordLibInit2.csv" --type csv --headerline
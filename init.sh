#!/bin/sh
mongoimport -d testdb -c chords --file "/docker-entrypoint-initdb.d/ChordLibInit.csv" --type csv --fields root,chordType,structure,notes,frets --headerline
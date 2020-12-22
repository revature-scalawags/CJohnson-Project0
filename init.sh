#!/bin/sh
mongoimport -d chordlib -c chords --file "/docker-entrypoint-initdb.d/ChordLibInit.csv" --type csv --headerline --columnsHaveTypes
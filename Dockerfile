FROM mongo
COPY ChordLibInit.csv /docker-entrypoint-initdb.d
COPY init.sh /docker-entrypoint-initdb.d
EXPOSE 27017
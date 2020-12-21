FROM mongo
COPY ChordLibInit2.csv /docker-entrypoint-initdb.d
COPY init.sh /docker-entrypoint-initdb.d
EXPOSE 27017
FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB testdb
COPY script/schema.sql /docker-entrypoint-initdb.d/init.sql
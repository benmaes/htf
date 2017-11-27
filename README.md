# Hack The Future - Java Track

TODO's

- Show users on map (custom icons?)
- alert streaming

create table gebruiker(
    id INTEGER PRIMARY KEY ,
    name TEXT,
    last_latitude DECIMAL,
    last_longitude DECIMAL,
    username TEXT,
    password TEXT);

create table alert(
    id INTEGER PRIMARY KEY ,
    message TEXT,
    latitude DECIMAL,
    longitude DECIMAL,
    image bytea,
user_id INTEGER);

create SEQUENCE hibernate_sequence;
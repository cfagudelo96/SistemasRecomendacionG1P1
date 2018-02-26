# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table artist (
  id                            bigint auto_increment not null,
  musicbrainz_artist_id         varchar(255),
  artist_name                   varchar(255),
  constraint pk_artist primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  user_profile_id               varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists artist;

drop table if exists user;


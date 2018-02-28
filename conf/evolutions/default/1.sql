# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table artist (
  id                            bigserial not null,
  musicbrainz_artist_id         varchar(255),
  artist_name                   varchar(255),
  constraint uq_artist_musicbrainz_artist_id unique (musicbrainz_artist_id),
  constraint pk_artist primary key (id)
);

create table taste_preferences (
  id                            bigserial not null,
  user_id                       bigint,
  item_id                       bigint,
  preference                    float,
  constraint pk_taste_preferences primary key (id)
);

create table custom_user (
  id                            bigserial not null,
  user_profile_id               varchar(255),
  constraint uq_custom_user_user_profile_id unique (user_profile_id),
  constraint pk_custom_user primary key (id)
);


# --- !Downs

drop table if exists artist cascade;

drop table if exists taste_preferences cascade;

drop table if exists custom_user cascade;


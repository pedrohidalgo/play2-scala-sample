# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                        bigserial not null,
  name                      varchar(255) not null,
  description               varchar(255),
  constraint pk_category primary key (id))
;




# --- !Downs

drop table if exists category cascade;


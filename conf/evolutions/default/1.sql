# --- !Ups  

create table "CATEGORY" ("ID" BIGINT NOT NULL PRIMARY KEY,"NAME" VARCHAR NOT NULL,"DESCRIPTION" VARCHAR NOT NULL);


create table "ARTICLE" ("ID" BIGINT NOT NULL PRIMARY KEY,"title" VARCHAR NOT NULL,"CONTENT" VARCHAR NOT NULL,"CATEGORY_ID" BIGINT NOT NULL);
alter table "ARTICLE" add constraint "CAT_FK" foreign key("CATEGORY_ID") references "CATEGORY"("ID") on update NO ACTION on delete NO ACTION;


# --- !Downs

drop table "CATEGORY";


alter table "ARTICLE" drop constraint "CAT_FK";
drop table "ARTICLE";

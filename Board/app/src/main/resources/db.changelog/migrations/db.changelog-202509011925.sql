--liquibase formatted sql
--changeset joao.manoel:1202509011925
--comment Board table create
 
create table board (
    id bigint auto_increment primary key,
    name varchar(255) not null)
    engine=InnoDB;
 --rollback drop table board;
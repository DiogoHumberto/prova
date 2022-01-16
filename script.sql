-- Caso ao executar os comandos abaixo e aparecer a mensagem "ORA-01031: privilégios insuficientes", logue-se com o usário SYS e atribuição SYSDBA. Com isso deve resolver a questão do privilégio.

ALTER SESSION SET "_ORACLE_SCRIPT" = true;
CREATE USER prova IDENTIFIED BY prova;

GRANT create session,create table,create view TO prova WITH ADMIN OPTION;

CREATE TABLE "PROVA"."PROVA"(
"ID" NUMBER NOT NULL ENABLE, 
"NOME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"NOTA" NUMBER NOT NULL ENABLE, 
 CONSTRAINT "PROVA_PK" PRIMARY KEY ("ID"));

CREATE SEQUENCE  "PROVA"."SEQ_PROVA"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;
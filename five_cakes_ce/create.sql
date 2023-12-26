create sequence produto_seq start with 1 increment by 50;
create table produto (qt_estoque integer, valor numeric(38,0), data_validade timestamp(6), id bigint not null, codigo_barra varchar(255), nome_produto varchar(255), primary key (id));
create sequence produto_seq start with 1 increment by 50;
create table produto (qt_estoque integer, valor numeric(38,0), data_validade timestamp(6), id bigint not null, codigo_barra varchar(255), nome_produto varchar(255), primary key (id));

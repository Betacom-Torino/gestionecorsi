create table amministratore(
codadmin int,
nomeadmin varchar2(30) not null,
cognomeadmin varchar2(30) not null,
constraint p_codadmin primary key(codadmin));

create table docente(
coddocente int,
nomedocente varchar2(30) not null,
cognomedocente varchar2(30) not null,
cvdocente varchar2(20) not null,
constraint p_coddocente primary key(coddocente));

create table corso(
codcorso int,
coddocente int,
nomecorso varchar2(30) not null,
datainizio date not null,
datafine date not null,
costocorso number(5,2) not null,
commentocorso varchar2(200),
aulacorso varchar2(30) not null,
constraint p_codcorso primary key(codcorso),
constraint f_coddocente foreign key(coddocente) references docente(coddocente) on delete cascade);

create table corsista(
codcorsista int,
nomecorsista varchar2(30) not null,
cognomecorsista varchar2(30) not null,
precedentiformativi number(2) not null,
constraint p_codcorsista primary key(codcorsista));


create table corso_corsista(
codcorsista int,
codcorso int,
constraint f_codcorsista foreign key(codcorsista) references corsista(codcorsista) on delete cascade,
constraint f_codcorso foreign key(codcorso) references corso(codcorso) on delete cascade,
constraint p_cc primary key(codcorsista, codcorso));

create view numero_iscritti_corso as
Select c.codcorso, count(cc.codcorsista) as num_iscritti from corso c, corso_corsista cc where cc.codcorso(+)=c.codcorso group by c.nomecorso, c.codcorso;

-- sequenze

create sequence corso_seq;
create sequence corsista_seq;
create sequence docente_seq;
create sequence amministratore_seq;

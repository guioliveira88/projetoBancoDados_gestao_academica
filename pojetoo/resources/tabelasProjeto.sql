create database tabelasprojeto;

create table Aluno (
cpf varchar(14) NOT NULL,
nome varchar(30) NOT NULL,
matricula varchar(11) NOT NULL,
idade int,
primary key (matricula)
);
create table Professor(
cpf varchar(14) NOT NULL,
nome varchar(30) NOT NULL,
idade int,
identificador varchar(11) NOT NULL,
primary key (identificador)
);
create table Disciplina(
cargahoraria varchar(11),
nome varchar(30) NOT NULL,
id varchar(11) NOT NULL,
PRIMARY KEY (id)

);
create table Curso(
nome varchar(30) NOT NULL,
identificador varchar(11) NOT NULL,
primary key (identificador)
);
create table fazdisciplina(
notaAluno float,
matricula_aluno varchar(11),
id_disciplina varchar(11),
foreign key(matricula_aluno) references aluno(matricula),
foreign key(id_disciplina) references disciplina(id)
);
create table estuda(
Nota_para_aluno float,
Falta_para_aluno float,
aprovacao_de_aluno varchar(10),
id_professor varchar(11),
id_disciplina varchar(11),
foreign key(id_professor) references professor(id),
foreign key(id_disciplina) references disciplina(id)
);

alter table Aluno
add column id_curso varchar(11);
alter table Aluno
add foreign key(id_curso)
references curso(id);


alter table Professor
add column id_curso varchar(11);
alter table Professor
add foreign key(id_curso)
references curso(id);



alter table disciplina
add column id_professor varchar(11);
alter table disciplina
add foreign key(id_professor)
references professor(id);



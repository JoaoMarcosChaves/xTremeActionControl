create database xtremeControl

use xtremeControl

create table t_ususSis(
ususCod  bigint identity constraint codigoPerfilPK  primary key(ususCod)
,ususTipo varchar (20) not null
,ususLogin varchar (max) not null
,ususSenha varchar (max) not null
,ususEmail varchar (max) not null
)

create table t_ususCnx(

codCnx bigint identity constraint codCNX_PK primary key (codCNX)
,ususCodCnx bigint
,ususLoginCnx varchar(max)
,dtLoginCnx  datetime

)

create table t_ativ(
ativCod int identity constraint ativCod_PK primary key(ativCod)
,ativNome varchar(100)
,ativDescr varchar(max)
,ativValor float
,ativStatus varchar(10)

create table t_descVal(
descCod int identity constraint descCod_PK primary key (descCod)
,descVal float
,descQtdAtiv int 
,descStatus varchar(10)
)

create table t_alu(
aluCod int identity constraint aluCod_PK primary key (aluCod)
,aluNome varchar(100)
,aluCpf varchar(11)
,aluPeso float
,aluSexo varchar(9)
,aluIdade int
,aluDescVal int constraint aluDescVal_FK foreign key (aluDescVal) references t_descVal(descCod)
,aluCep varchar (8)
,aluNumResid int
)

create table t_telefAlu(
telefCod int identity constraint telefCod_FK primary key (telefCod)
,aluCod int constraint aluCodTelef_FK foreign key (aluCod) references t_alu (aluCod)
,telefNum varchar(11)
,telefTip varchar(3)
)

create table t_emailAlu(
emailCod int identity constraint emailCod_FK primary key (emailCod)
,aluCod int constraint aluCodEmail_FK foreign key (aluCod) references t_alu (aluCod)
,emailAlu varchar(200)
)

create table t_matrAlu(
matrCod int identity constraint matrCod_PK primary key(matrCod)
,aluCod int constraint aluCodMatr_FK foreign key (aluCod) references t_alu(aluCod)
,ativCod int constraint ativCodMatr_FK foreign key (ativCod) references t_ativ(ativCod)
,matrValMens float
,matrDt date
,matrStatus varchar(10)
)

create table t_mensali(

mensaliCodPag int identity constraint mensaliCodPag_PK primary key (mensaliCodPag)
,matrCod int constraint matrCodMensali_FK foreign key (matrCod) references  t_matrAlu (matrCod)
,mensaliStatusPag varchar (6) not null
,mensaliDtVenc date not null
,mensaliDtPag date
)
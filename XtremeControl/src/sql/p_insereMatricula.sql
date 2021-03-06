USE [xtremeControl]
GO
/****** Object:  StoredProcedure [dbo].[p_insereMatricula]    Script Date: 25/10/2016 15:52:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER proc [dbo].[p_insereMatricula](
        
		 @aluCod int
        ,@AtivCod int
        ,@MatrValMens float
        ,@MatrDtVenc date

)

WITH ENCRYPTION AS

declare @matrCod int
declare @totMatr int
declare @codDesc int
declare @codDescAtu int
declare @codDescNovo int
declare @valDesc float
declare @matrAluCursor int

BEGIN 

set @totMatr =  (select COUNT(matrCod)matrCod from t_matrAlu where aluCod = @aluCod)
set @codDescAtu = (select aluDescVal from t_alu where aluCod = @aluCod)

-- Abro o cursor de verificação da tabela de desconto.
declare descs CURSOR FOR

select descCod from t_descVal where descStatus = 'Ativo'

open descs

fetch next from descs
into @codDesc


while @@FETCH_STATUS = 0
begin 
             -- Caso o total de matriculas + 1 (que é a matricula que esta sendo realizada agora), resulte num desconto, ele aplica no cadastro do aluno.
             IF (@totMatr + 1) >= (select descQtdAtiv from t_descVal where descCod = @codDesc )
			 BEGIN 
			 
			 update t_alu set aluDescVal = (select descCod from t_descVal where descCod = @codDesc) where aluCod = @aluCod
			 set @valDesc = (select descVal from t_descVal where descCod = @codDesc)
			 set @codDescNovo = @codDesc

			 END
			 ELSE IF (@totMatr) = (select descQtdAtiv from t_descVal where descCod = @codDesc)
			 BEGIN
			 set @valDesc = (select descVal from t_descVal where descCod = @codDesc)
			 set @codDescNovo = @codDesc
			 END


fetch next from descs
into @codDesc
END

close descs
DEALLOCATE descs


-- Inicio o insert da matricula

if @valDesc is null
begin 
set @valDesc = 0
end

INSERT INTO [dbo].[t_matrAlu]
           ([aluCod]
           ,[ativCod]
           ,[matrValMens]
           ,[matrDt]
           ,[matrStatus])
           VALUES
           (@aluCod
           ,@AtivCod
           ,(@MatrValMens - ((@MatrValMens * @valDesc)/100))
           ,getdate()
           ,'Aberto')

-- Seto o código da matricula que acaba de ser realizada na variavel

set @matrCod = (select max(matrCod) from t_matrAlu)

-- Realizo o insert da mensalidade

INSERT INTO [dbo].[t_mensali]
           ([matrCod]
           ,[mensaliStatusPag]
           ,[mensaliDtVenc])
           VALUES
           (@matrCod
           ,'Aberta'
           ,@MatrDtVenc)


-- Alterando os valores de matriculas anteriores 

if @codDescAtu is null
begin set @codDescAtu = 0

end
IF @codDescNovo <> @codDescAtu
BEGIN

declare matrs CURSOR FOR

select matrCod from t_matrAlu where aluCod = @aluCod

open matrs

fetch next from matrs
into @matrAluCursor

while @@FETCH_STATUS = 0
begin 

update t_matrAlu set matrValMens  = 
((select ativValor from t_ativ where ativCod = (select ativCod from t_matrAlu where matrCod = @matrAluCursor))
- (((select ativValor from t_ativ where ativCod = (select ativCod from t_matrAlu where matrCod = @matrAluCursor)))*@valDesc)/100)
where matrCod = @matrAluCursor

fetch next from matrs
into @matrAluCursor

END -- end do while

close matrs
DEALLOCATE matrs

END -- end do if

END
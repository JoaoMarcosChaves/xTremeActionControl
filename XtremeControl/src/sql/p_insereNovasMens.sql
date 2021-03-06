USE [xtremeControl]
GO
/****** Object:  StoredProcedure [dbo].[p_insereNovasMens]    Script Date: 29/10/2016 17:12:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER proc [dbo].[p_insereNovasMens]

WITH ENCRYPTION AS 
declare @mensaliCodPag int
declare @matrCod int
BEGIN

DECLARE matrs CURSOR FOR

select matrCod from t_mensali group by matrCod


OPEN matrs

FETCH NEXT FROM matrs
INTO @matrCod

WHILE @@FETCH_STATUS = 0
BEGIN -- inicio do while matricula


DECLARE mens CURSOR FOR 
select max(mensaliCodPag) from t_mensali where matrCod = @matrCod
OPEN mens
FETCH NEXT FROM mens
INTO @mensaliCodPag

while @@FETCH_STATUS = 0
BEGIN -- Inicio do while mensali

                IF (select mensaliDtVenc from t_mensali where mensaliCodPag = @mensaliCodPag) < GETDATE()
				BEGIN

				INSERT INTO [dbo].[t_mensali]
           ([matrCod]
           ,[mensaliStatusPag]
           ,[mensaliDtVenc]
           ,[mensaliDtPag])
            VALUES
           ((select matrCod from t_mensali where mensaliCodPag = @mensaliCodPag)
           ,'Aberta'
           ,DATEADD(MONTH,1,(select mensaliDtVenc from t_mensali where mensaliCodPag = @mensaliCodPag))
           ,null)

				END

FETCH NEXT FROM mens
INTO @mensaliCodPag
END -- final do while mensali
CLOSE mens
DEALLOCATE mens


FETCH NEXT FROM matrs
INTO @matrCod
END -- final do while matricula
CLOSE matrs
DEALLOCATE matrs

END


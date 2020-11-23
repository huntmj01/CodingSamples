CREATE PROCEDURE [dbo].[usp_SSIS_StaggingTable_Truncate]
AS
BEGIN
	SET NOCOUNT ON;
	
    TRUNCATE TABLE dbo.StaggingTable;
    
END
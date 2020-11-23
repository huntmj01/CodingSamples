CREATE PROCEDURE [dbo].[usp_SSIS_StaggingTable_Load]
AS
BEGIN
	SET NOCOUNT ON;     

    INSERT INTO dbo.StaggingTable ( [ColumnPK], [Column1], [Column2], [Column3] )  
    SELECT                          [ColumnPK], [Column1], [Column2], [Column3] 
    FROM dbo.SourceTable;
    
END